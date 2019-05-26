package kursinis;

import jade.content.ContentElement;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.leap.Iterator;
import java.util.Set;
import darbdavys2.ontology.DarbdavysOntology;
import darbdavys2.ontology.Darbo_Info;
import darbdavys2.ontology.DarbuotojoPaieska_line;
import darbdavys2.ontology.Imones_Info;
import darbdavys2.ontology.Paieska_msg;
import darbdavys2.ontology.Paieska_pagal_darbdavi;
import darbdavys2.ontology.SimplePranesimas;
import darbuotojai.ontology.DarbuotojaiOntology;
import darbuotojai.ontology.Info_apie_save;
import darbuotojai.ontology.Info_apie_save_daug;
import darbuotojai.ontology.Info_apie_save_msg;
import jade.content.onto.OntologyException;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.util.leap.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DarbdavysAgent extends Agent {

    @Override
    public void setup() {
        System.out.println("Hello, I'm " + getLocalName() + " and I'm  living in " + this.getContainerController().getName());

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Darbdavys");
        sd.setName("Darbdavys");
        dfd.addServices(sd);

        addBehaviour(new WaitForMessages());

        try {
            DFService.register(this, dfd);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }

    }

    @Override
    public void takeDown() {
        System.out.println("A[" + getLocalName() + "] is being removed");
        System.out.println("Saving data to files\nBYE");

        try {
            DFService.deregister(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class WaitForMessages extends CyclicBehaviour {

        @Override
        public void action() {

            Ontology onto = DarbdavysOntology.getInstance();
            Ontology onto2 = DarbuotojaiOntology.getInstance();
            Codec codec = new SLCodec();
            ContentManager cm = getContentManager();
            ContentManager om = getContentManager();
            om.registerLanguage(codec);
            om.registerOntology(onto2);
            cm.registerLanguage(codec);
            cm.registerOntology(onto);

            Darbo_Info darb2 = new Darbo_Info();
            darb2.setPozicija("Inžinierius");
            darb2.setValandos(45);
            darb2.setMiestas("Marijampolė");
            darb2.setAtlyginimas(1850);
            darb2.setReikalingas_Stazas(2);
            darb2.setID(2);

            Imones_Info info = new Imones_Info();
            String param = "";
            Object[] args = getArguments();
            if ((args != null) && (args.length > 0)) {
                param = (String) args[0];
            }
            info.setPavadinimas(param);
            info.setVadovas("Giedrius Senkus");
            info.setGID(1);
            info.addDarbai(darb2);

            ACLMessage msg = myAgent.receive();

            if (msg != null) {
                try {
                    String pran = msg.getContent();
                    System.out.println("A[" + getLocalName() + "] Message received: " + pran);

                    ContentElement c = cm.extractContent(msg);
                    ContentElement h = om.extractContent(msg);
                    //System.out.println("Analyzing message ");

                    if (c instanceof Paieska_msg) {
                        Paieska_msg p = (Paieska_msg) c;
                        DarbuotojoPaieska_line l = null;
                        System.out.println("A[" + getLocalName() + "] Pranešimas gautas:");
                        System.out.println("");
                        Iterator i = p.getAllDarbuotojo_paieska_msg();

                        while (i.hasNext()) {
                            l = (DarbuotojoPaieska_line) i.next();
                            for (int j = 0; j < info.getDarbai().size(); j++) {
                                if (l.getReikalingas_stazas() >= ((Darbo_Info) info.getDarbai().get(j)).getReikalingas_Stazas() && l.getPozicija().equals(((Darbo_Info) info.getDarbai().get(j)).getPozicija())
                                        && l.getAtlyginimas() <= ((Darbo_Info) info.getDarbai().get(j)).getAtlyginimas()) {
                                    ACLMessage omsg = new ACLMessage(ACLMessage.INFORM);
                                    omsg.setLanguage(codec.getName());
                                    omsg.setOntology(onto.getName());
                                    omsg.setConversationId(msg.getConversationId());
                                    omsg.setInReplyTo(msg.getReplyWith());
                                    omsg.clearAllReceiver();
                                    omsg.addReceiver(msg.getSender());

                                    DarbuotojoPaieska_line s = new DarbuotojoPaieska_line();

                                    s.setReikalingas_stazas(((Darbo_Info) info.getDarbai().get(j)).getReikalingas_Stazas());
                                    s.setMiestas(((Darbo_Info) info.getDarbai().get(j)).getMiestas());
                                    s.setPozicija(((Darbo_Info) info.getDarbai().get(j)).getPozicija());

                                    Paieska_msg pr = new Paieska_msg();
                                    pr.addDarbuotojo_paieska_msg(s);

                                    try {
                                        cm.fillContent(omsg, pr);
                                        omsg.addUserDefinedParameter("klase", "Darbuotojo_paieska");
                                        send(omsg);
                                    } catch (Exception ex) {
                                        System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                                    }
                                }
                            }

                        }
                        //
                    } else if (c instanceof SimplePranesimas) {
                        ACLMessage omsg = new ACLMessage(ACLMessage.INFORM);
                        omsg.setLanguage(codec.getName());
                        omsg.setOntology(onto.getName());
                        omsg.setConversationId(msg.getConversationId());
                        omsg.setInReplyTo(msg.getReplyWith());
                        omsg.clearAllReceiver();
                        omsg.addReceiver(msg.getSender());

                        Paieska_pagal_darbdavi s = new Paieska_pagal_darbdavi();

                        s.addPaieskaPagalDarbdaviDaug(info);

                        try {
                            cm.fillContent(omsg, s);
                            omsg.addUserDefinedParameter("klase", "Paieska_pagal_darbdavi");
                            send(omsg);
                        } catch (Exception ex) {
                            System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                        }
                    } else if (h instanceof Info_apie_save_msg) {
                        Info_apie_save_msg p = (Info_apie_save_msg) c;
                        Info_apie_save l = null;
                        Iterator i = p.getAllInfo_apie_save_message();
                        Iterator o;

                        while (i.hasNext()) {
                            l = (Info_apie_save) i.next();
                            for (int j = 0; j < info.getDarbai().size(); j++) {
                                if (l.getStazas() >= ((Darbo_Info) info.getDarbai().get(j)).getReikalingas_Stazas()
                                        && l.getAtlyginimas() <= ((Darbo_Info) info.getDarbai().get(j)).getAtlyginimas()
                                        && l.getMiestas().equals(((Darbo_Info) info.getDarbai().get(j)).getMiestas())
                                        && l.getIeskoma_darbo_pozicija().equals(((Darbo_Info) info.getDarbai().get(j)).getPozicija())) {
                                    //
                                    System.out.println("A[" + getLocalName() + "] gali priimti i darba kandidatuojanti: " + l.getVardas() + " darbyuotoja \n");
                                    //                                    //                                    
                                    //Vietoj sito reiktu pasiusti pranesima atgal su info kad kandidatas yra tinkamas ir 
                                    //atspausdinus pranesima kad buvo priimtas nukilinti darbdavi ir darbuotoja
                                    //
                                    //ir reiktu pranesimo kad jei netinkamas kandidatas kad taip pat pasiustu pranesima atgal 
                                    //kad darbuotojas yra netinkamas
                                    //
                                }

                            }

                        }
                    } else {
                        block();
                    }
                } catch (Codec.CodecException ex) {
                    Logger.getLogger(DarbdavysAgent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (OntologyException ex) {
                    Logger.getLogger(DarbdavysAgent.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

}
