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



            Darbo_Info darb = new Darbo_Info();
            darb.setPozicija("Mobiliųjų įrenginių konfigūravimo ekspertas");
            darb.setValandos(40);
            darb.setMiestas("Alytus");
            darb.setAtlyginimas(1000);
            darb.setReikalingas_Stazas(1);
            darb.setID(1);

            Darbo_Info darb2 = new Darbo_Info();
            darb2.setPozicija("Inžinierius");
            darb2.setValandos(45);
            darb2.setMiestas("Druskininkai");
            darb2.setAtlyginimas(850);
            darb2.setReikalingas_Stazas(2);
            darb2.setID(2);

            Imones_Info info = new Imones_Info();
            info.setPavadinimas("Bite Lietuva");
//            info.setDarbas(darb);
//            info.setDarbas(darb2);
//            info.setDarbas(darb3);
            info.setVadovas("Giedrius Senkus");
            info.setGID(1);

            info.addDarbai(darb);
            info.addDarbai(darb2);

//            Imones_Info info2 = new Imones_Info();
//            info2.setPavadinimas("Telia");
//            info2.setDarbas(darb2);
//            info2.setVadovas("Rolandas Paksas");
//            info2.setGID(2);
//
//            Imones_Info info3 = new Imones_Info();
//            info3.setPavadinimas("Elektromarkt");
//            info3.setDarbas(darb3);
//            info3.setVadovas("Petras Petraitis");
//            info3.setGID(3);
            // imones.addImones_Info_Vienetas(info);
//            imones.addImones_Info_Vienetas(info2);
//            imones.addImones_Info_Vienetas(info3);
            ACLMessage msg = myAgent.receive();

            if (msg != null) {
                try {
                    String pran = msg.getContent();
                    System.out.println("Darbdavys[" + getLocalName() + "] Message received: " + pran);

                    ContentElement c = cm.extractContent(msg);
                    ContentElement h = om.extractContent(msg);
                    //System.out.println("Analyzing message ");

                    if (c instanceof Paieska_msg) {
                        Paieska_msg p = (Paieska_msg) c;
                        DarbuotojoPaieska_line l = null;
                        System.out.println("Darbdavys[" + getLocalName() + "] Pranešimas gautas:");
                        System.out.println("");
                        Iterator i = p.getAllDarbuotojo_paieska_msg();
                        int darbas1 = 0;
                        int darbas2 = 0;
                        int darbas3 = 0;
                        while (i.hasNext()) {
                            l = (DarbuotojoPaieska_line) i.next();
                            for (int j = 0; j <  info.getDarbai().size() ; j++) {
                                if (l.getReikalingas_stazas() <= ((Darbo_Info) info.getDarbai().get(j)).getReikalingas_Stazas()&& l.getPozicija().equals(((Darbo_Info) info.getDarbai().get(j)).getPozicija())
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
//                            System.out.println("Darbdavys[" + getLocalName() + "] Išvedami visi atitinkami darbai:");
//
//                            Iterator o = imones.getAllImones_Info_Vienetas();
//                            Imones_Info z = null;
//                            while (o.hasNext()) {
//                                z = (Imones_Info) o.next();
//                                if (l.getReikalingas_stazas() >= z.getDarbas().getReikalingas_Stazas() && l.getPozicija().equals(z.getDarbas().getPozicija()) && l.getAtlyginimas() <= z.getDarbas().getAtlyginimas()) {
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Pagal pasirinktus kriterijus surastas darbas: \n");
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Imones pavadinimas: " + z.getPavadinimas());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Imones vadovas: " + z.getVadovas());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Darbo pozicija: " + z.getDarbas().getPozicija());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Miestas: " + z.getDarbas().getMiestas());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Atlyginimas: " + z.getDarbas().getAtlyginimas());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Reikalingas stažas: " + z.getDarbas().getReikalingas_Stazas());
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Darbo valandos: " + z.getDarbas().getValandos());
//                                } else {
//                                    System.out.println("Darbdavys[" + getLocalName() + "] Pagal pasirinktus kriterijus darbo vietų nėra.\n");
//                                }
//                            }

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
                        Info_apie_save_daug l = null;
                        Iterator i = p.getAllInfo_apie_save_message();
                        Iterator o;
                        Info_apie_save u = null;
//                        while (i.hasNext()) {
//                            l = (Info_apie_save_daug) i.next();
//                            o = l.getAllInfo_apie_save_vienetas();
//                            while (o.hasNext()) {
//                                u = (Info_apie_save) o.next();
//                                Iterator y = imones.getAllImones_Info_Vienetas();
//                                Imones_Info z = null;
//                                while (y.hasNext()) {
//                                    z = (Imones_Info) y.next();
//                                    if (u.getStazas() >= z.getDarbas().getReikalingas_Stazas() && u.getMiestas().equals(z.getDarbas().getMiestas()) && u.getAtlyginimas() <= z.getDarbas().getAtlyginimas()) {
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Naujai užsiregistravęs darbuotojas " + u.getVardas() + " " + u.getPavarde() + " yra tinkamas šiam darbui:");
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Imones pavadinimas: " + z.getPavadinimas());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Imones vadovas: " + z.getVadovas());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Darbo pozicija: " + z.getDarbas().getPozicija());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Miestas: " + z.getDarbas().getMiestas());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Atlyginimas: " + z.getDarbas().getAtlyginimas());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Reikalingas stažas: " + z.getDarbas().getReikalingas_Stazas());
//                                        System.out.println("Darbdavys[" + getLocalName() + "] Darbo valandos: " + z.getDarbas().getValandos());
//                                    }
//                                }
//
//                            }
//
//                        }
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
