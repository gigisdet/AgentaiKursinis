package kursinis;

import darbuotojai.ontology.DarbuotojaiOntology;
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

import darbuotojai.ontology.Info_apie_save;
import darbuotojai.ontology.Info_apie_save_daug;
import darbuotojai.ontology.Info_apie_save_msg;
import darbuotojai.ontology.SimplePranesimas;
import darbuotojai.ontology.SimplePranesimasDarbuotojas;
import jade.content.ContentElement;
import jade.content.onto.OntologyException;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DarbuotojasAgent extends Agent {

    Info_apie_save info = new Info_apie_save();

    @Override
    public void setup() {
        System.out.println("Hello, I'm " + getLocalName() + " and I'm  living in " + this.getContainerController().getName());

        info.setVardas("Karolis");
        info.setPavarde("Poga");
        info.setIeskoma_darbo_pozicija("Inžinierius");
        info.setAtlyginimas(1000);
        info.setMiestas("Marijampolė");
        info.setStazas(1);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Darbuotojas");
        sd.setName("Darbuotojas");
        dfd.addServices(sd);

        addBehaviour(new darPalauk());

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

            Ontology ontoDarbuotojas = DarbuotojaiOntology.getInstance();
            Codec codec = new SLCodec();
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(ontoDarbuotojas);

            Info_apie_save in = new Info_apie_save();
            Info_apie_save_daug s = new Info_apie_save_daug();
            Info_apie_save_msg m = new Info_apie_save_msg();

            ACLMessage msg = myAgent.receive();
            if (msg != null) {

                try {
                    String pran = msg.getContent();
                    System.out.println("Darbuotojas[" + getLocalName() + "] Message received: " + pran);

                    ContentElement c = cm.extractContent(msg);
                    ContentElement k = cm.extractContent(msg);

                    if (k instanceof SimplePranesimas) {
//                        Info_apie_save_msg p = (Info_apie_save_msg) c;
//                        Info_apie_save_daug l = null;
//                        System.out.println("A[" + getLocalName() + "] Pranešimas simple gautas gautas:");
//                        System.out.println("");
//                        Iterator i = p.getAllInfo_apie_save_message();
//                        Iterator o;
//                        Info_apie_save u = null;
//                        while (i.hasNext()) {
//                            l = (Info_apie_save_daug) i.next();
//                            o = l.getAllInfo_apie_save_vienetas();
//                            while (o.hasNext()) {
//                                u = (Info_apie_save) o.next();
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gautas vardas " + u.getVardas() + "");
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gauta pavarde " + u.getPavarde() + "");
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gautas miestas " + u.getMiestas() + "");
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gauta pozicija " + u.getIeskoma_darbo_pozicija() + "");
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gautas stazas " + u.getStazas() + "");
//                                System.out.println("Darbuotojas[" + getLocalName() + "] Gautas atlyginimas " + u.getAtlyginimas() + "\n");
//                                in.setVardas(u.getVardas());
//                                in.setPavarde(u.getPavarde());
//                                in.setMiestas(u.getMiestas());
//                                in.setIeskoma_darbo_pozicija(u.getIeskoma_darbo_pozicija());
//                                in.setStazas(u.getStazas());
//                                in.setAtlyginimas(u.getAtlyginimas());
//                                s.addInfo_apie_save_vienetas(in);
//                                m.addInfo_apie_save_message(s);
//                            }
//
//                            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
//                            req.setLanguage(codec.getName());
//                            req.setOntology(onto.getName());
//                            ContentManager om = getContentManager();
//                            cm.registerLanguage(codec);
//                            cm.registerOntology(onto);
//                            AID a = new AID("Darbdavys", AID.ISLOCALNAME);
//                            req.clearAllReceiver();     //Resyveriai cikle "dasideda"
//                            req.addReceiver(a);
//
//                            try {
//                                om.fillContent(req, m);
//                                req.addUserDefinedParameter("klase", "SimpleMessage");
//                                send(req);
//                            } catch (Exception ex) {
//                                System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
//                            } 

                        System.out.println("Gautas simple pranesimas VISI");

                        ACLMessage omsg = new ACLMessage(ACLMessage.INFORM);
                        omsg.setLanguage(codec.getName());
                        omsg.setOntology(ontoDarbuotojas.getName());
                        omsg.setConversationId(msg.getConversationId());
                        omsg.setInReplyTo(msg.getReplyWith());
                        omsg.clearAllReceiver();
                        omsg.addReceiver(msg.getSender());

                        // darbdavys2.ontology.Paieska_pagal_darbdavi s = new darbdavys2.ontology.Paieska_pagal_darbdavi();
                        //   s.addInfo_apie_save_vienetas(info);
                        //  m.addInfo_apie_save_message(s);
                        SimplePranesimas kaka = new SimplePranesimas();
                        kaka.setPranesimas("ka nori");

                        // s.addInfo_apie_save_vienetas(info);
                        //s.addPaieskaPagalDarbdaviDaug(info);
                        try {
                            cm.fillContent(omsg, kaka);
                            omsg.addUserDefinedParameter("klase", "SimplePranesimas");
                            send(omsg);
                        } catch (Exception ex) {
                            System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());

                        }
                    } else {
                        block();
                    }
                } catch (Codec.CodecException ex) {
                    Logger.getLogger(DarbuotojasAgent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (OntologyException ex) {
                    Logger.getLogger(DarbuotojasAgent.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
    }

    private class darPalauk extends CyclicBehaviour {

        @Override
        public void action() {

            Ontology onto2 = DarbuotojaiOntology.getInstance();
            Codec codec = new SLCodec();
            ContentManager om = getContentManager();
            om.registerLanguage(codec);
            om.registerOntology(onto2);

            ACLMessage msg = myAgent.receive();

            if (msg != null) {
                try {
                    String pran = msg.getContent();
                    System.out.println("A[" + getLocalName() + "] Message received: " + pran);

                    ContentElement h = om.extractContent(msg);
                    //System.out.println("Analyzing message ");

                    if (h instanceof SimplePranesimasDarbuotojas) {
                        System.out.println("Ar tai yra gautasw simple pranesimas");
                        ACLMessage omsg = new ACLMessage(ACLMessage.INFORM);
                        omsg.setLanguage(codec.getName());
                        omsg.setOntology(onto2.getName());
                        omsg.setConversationId(msg.getConversationId());
                        omsg.setInReplyTo(msg.getReplyWith());
                        omsg.clearAllReceiver();
                        omsg.addReceiver(msg.getSender());

                        SimplePranesimasDarbuotojas kaka = new SimplePranesimasDarbuotojas();
                        kaka.setPranesimas("ka nori");

                        try {
                            om.fillContent(omsg, kaka);
                            omsg.addUserDefinedParameter("klase", "SimpleMessage");
                            send(omsg);
                        } catch (Exception ex) {
                            System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
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
