package kursinis;

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
import darbuotojai.ontology.SimplePranesimasDarbuotojas;

import jade.gui.GuiAgent;
import jade.gui.GuiEvent;

import jade.content.ContentElement;
import jade.content.ContentManager;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ContainerID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.WakerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.util.leap.ArrayList;
import jade.util.leap.Iterator;
import jade.util.leap.List;
import jade.wrapper.ControllerException;
import static java.lang.Thread.sleep;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiAgenta extends GuiAgent {

    Ontology onto = DarbdavysOntology.getInstance();
    Ontology onto2 = DarbuotojaiOntology.getInstance();
    //Ontology onto = new CdsOntology();
    Codec codec = new SLCodec();

    public static final int SEARCH = 1;
    public static final int SEARCHPROV = 2;
    public static final int SEARCHSarasas = 3;
    public static final int IVESTI = 4;
    public static final int SEARCHPROV2 = 5;
    public static final int SearchAllDarbdv = 6;
    public static final int GautiVisusDarbuotojus = 7;
    public static final int SearcAllDarbuotojai = 8;
    public static final int KandidatuotiDarbas = 9;
    ACLMessage sub;

    GUI myGui = null; // Reference to the gui
    

    Info_apie_save[] darbuotojai = new Info_apie_save[3];
    
    Darbo_Info[] darbai = new Darbo_Info[6];
    Imones_Info[] imones = new Imones_Info[6];
    int darbaisk = 0;
    int z = 0;
    

    @Override
    public void setup() {
        //Instanciate the gui
        myGui = new GUI(this);
        myGui.setVisible(true);
        addBehaviour(new WaitForMessages());

    }

    protected void onGuiEvent(GuiEvent ge) {
        String Pozicija = "";
        String Miestas = "";
        String Stazas = "";
        String Agent_name = "";
        String Vardas = "";
        String Pavarde = "";
        String Miestas2 = "";
        String Pozicija2 = "";
        String Stazas2 = "";
        String Atlyginimas2 = "";
        String Agent_name2 = "";
        String Atlyginimas = "";
        String darbuotojas = "";
        String darbdavys = "";

        int cmd = ge.getType();

        if (cmd == GuiAgenta.SEARCH) {
            if (ge.getParameter(3) instanceof String) {
                Pozicija = (String) ge.getParameter(0);
                Miestas = (String) ge.getParameter(1);
                Stazas = (String) ge.getParameter(2);
                // Agent_name = (String) ge.getParameter(3);
                Atlyginimas = (String) ge.getParameter(3);
            }

            myGui.addLine("A[" + getLocalName() + "] Paspaustas paieškos mygtukas\n");
            myGui.addLine("A[" + getLocalName() + "] Ieškoma darbo pozicija: " + Pozicija + " pozicijoje " + Stazas + "metų(-us)\n");
            myGui.addLine("A[" + getLocalName() + "] Miestas: " + Miestas + "\n");

            int StazasInt = Integer.parseInt(Stazas);
            int AtlyginimasInt = Integer.parseInt(Atlyginimas);

            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
            req.setLanguage(codec.getName());
            req.setOntology(onto.getName());
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto);

            AID a;
            for (int i = 0; i < myGui.getComboLinesCount(); i++) {
                a = new AID(myGui.getComboItem(i), AID.ISLOCALNAME);
                req.clearAllReceiver();     //Resyveriai cikle "dasideda"
                req.addReceiver(a);

                DarbuotojoPaieska_line s = new DarbuotojoPaieska_line();

                s.setReikalingas_stazas(StazasInt);
                s.setMiestas(Miestas);
                s.setPozicija(Pozicija);
                s.setAtlyginimas(AtlyginimasInt);

                Paieska_msg pr = new Paieska_msg();
                pr.addDarbuotojo_paieska_msg(s);

                try {
                    cm.fillContent(req, pr);
                    req.addUserDefinedParameter("klase", "Darbuotojo_paieska");
                    send(req);
                } catch (Exception ex) {
                    System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                }

            }
        }
        if (cmd == GuiAgenta.SEARCHPROV) {
            addBehaviour(new MyOneShot());
            myGui.addLine("A[" + getLocalName() + "] paspaustas mygtukas ieskoti darbdaviu saraso \n");
            myGui.resetComboLines();
        }
        if (cmd == GuiAgenta.GautiVisusDarbuotojus) {
            addBehaviour(new MyOneShot2());
            myGui.addLine("A[" + getLocalName() + "] paspaustas mygtukas ieskoti darbuotoju saraso \n");
            myGui.resetCombo2Lines();
            myGui.resetCombo3Lines();
            myGui.resetCombo4Lines();
        }

        if (cmd == GuiAgenta.SEARCHPROV2) {
            addBehaviour(new MyOneShot2());
            myGui.resetCombo2Lines();

        }

        if (cmd == GuiAgenta.SEARCHSarasas) {
            addBehaviour(new WaitForMessages());

            if (ge.getParameter(0) instanceof String) {
                Agent_name = (String) ge.getParameter(0);
            }

            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
            req.setLanguage(codec.getName());
            req.setOntology(onto.getName());
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto);

            AID a = new AID(Agent_name, AID.ISLOCALNAME);
            req.clearAllReceiver();     //Resyveriai cikle "dasideda"
            req.addReceiver(a);

            SimplePranesimas s = new SimplePranesimas();
            s.setPranesimas("VISI");

            try {
                cm.fillContent(req, s);
                req.addUserDefinedParameter("klase", "SimpleMessage");
                send(req);
            } catch (Exception ex) {
                System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
            }
        }
        if (cmd == GuiAgenta.IVESTI) {
            if (ge.getParameter(6) instanceof String) {
                Vardas = (String) ge.getParameter(0);
                Pavarde = (String) ge.getParameter(1);
                Miestas2 = (String) ge.getParameter(2);
                Pozicija2 = (String) ge.getParameter(3);
                Stazas2 = (String) ge.getParameter(4);
                Atlyginimas2 = (String) ge.getParameter(5);
                Agent_name2 = (String) ge.getParameter(6);
                //addBehaviour(new WaitForMessages());

                int Stazas2Int = Integer.parseInt(Stazas2);
                int Atlyginimas2Int = Integer.parseInt(Atlyginimas2);

                ACLMessage req = new ACLMessage(ACLMessage.INFORM);
                req.setLanguage(codec.getName());
                req.setOntology(onto2.getName());
                ContentManager cm = getContentManager();
                cm.registerLanguage(codec);
                cm.registerOntology(onto2);

                AID a = new AID(Agent_name2, AID.ISLOCALNAME);
                req.clearAllReceiver();     //Resyveriai cikle "dasideda"
                req.addReceiver(a);

//                Info_apie_save_msg s = new Info_apie_save_msg();
//                Info_apie_save_daug i = new Info_apie_save_daug();
//                Info_apie_save in = new Info_apie_save();
//                in.setVardas(Vardas);
//                in.setPavarde(Pavarde);
//                in.setMiestas(Miestas2);
//                in.setIeskoma_darbo_pozicija(Pozicija2);
//                in.setStazas(Stazas2Int);
//                in.setAtlyginimas(Atlyginimas2Int);
//                i.addInfo_apie_save_vienetas(in);
//                s.addInfo_apie_save_message(i);
                SimplePranesimas s = new SimplePranesimas();
                s.setPranesimas("VISI");

                try {
                    cm.fillContent(req, s);
                    req.addUserDefinedParameter("klase", "SimplePranesimas");
                    send(req);
                } catch (Exception ex) {
                    System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                }
            }
        }
        if (cmd == GuiAgenta.SearchAllDarbdv) {
            // addBehaviour(new WaitForMessages());
            myGui.addLine("A[" + getLocalName() + "] paspaustas mygtukas ieskoti visu siulomu darbu");
            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
            req.setLanguage(codec.getName());
            req.setOntology(onto.getName());
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto);

            AID a;
            for (int i = 0; i < myGui.getComboLinesCount(); i++) {
                a = new AID(myGui.getComboItem(i), AID.ISLOCALNAME);
                req.clearAllReceiver();     //Resyveriai cikle "dasideda"
                req.addReceiver(a);

                SimplePranesimas s = new SimplePranesimas();
                s.setPranesimas("VISI");

                try {
                    cm.fillContent(req, s);
                    req.addUserDefinedParameter("klase", "SimpleMessage");
                    send(req);
                } catch (Exception ex) {
                    System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                }

            }
        }
        if (cmd == GuiAgenta.SearcAllDarbuotojai) {

            // addBehaviour(new WaitForMessages());
            myGui.addLine("A[" + getLocalName() + "] paspaustas mygtukas ieskoti visu darbuootju \n");
            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
            req.setLanguage(codec.getName());
            req.setOntology(onto2.getName());
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto2);

            AID a;
            for (int i = 0; i < myGui.getCombo2LinesCount(); i++) {
                a = new AID(myGui.getCombo2Item(i), AID.ISLOCALNAME);
                req.clearAllReceiver();     //Resyveriai cikle "dasideda"
                req.addReceiver(a);

                SimplePranesimasDarbuotojas s = new SimplePranesimasDarbuotojas();
                s.setPranesimas("VISI");

                try {
                    cm.fillContent(req, s);
                    req.addUserDefinedParameter("klase", "SimpleMessage");
                    send(req);
                } catch (Exception ex) {
                    System.out.println("A[" + getLocalName() + "] Error while building message: " + ex.getMessage());
                }

            }
        }

        if (cmd == GuiAgenta.KandidatuotiDarbas) {

            if (ge.getParameter(1) instanceof String) {

                darbuotojas = (String) ge.getParameter(0).toString();
                darbdavys = (String) ge.getParameter(1).toString();
            }

            int darbuotojasInt = Integer.parseInt(darbuotojas);
            int darbdavysInt = Integer.parseInt(darbdavys);

            // addBehaviour(new WaitForMessages());
            myGui.addLine("A[" + getLocalName() + "] paspaustas mygtukas kandidatuoti  i darba \n");

            ACLMessage req = new ACLMessage(ACLMessage.INFORM);
            req.setLanguage(codec.getName());
            req.setOntology(onto2.getName());
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto2);

            AID a;
            //for (int i = 0; i < myGui.getCombo2LinesCount(); i++) {
            a = new AID(imones[darbdavysInt].getPavadinimas(), AID.ISLOCALNAME);
            req.clearAllReceiver();     //Resyveriai cikle "dasideda"
            req.addReceiver(a);

            //SimplePranesimas s = new SimplePranesimas();
            //s.setPranesimas("Kandidatuoja "+ darbuotojai[darbuotojasInt].getVardas() +" i pozicija " + darbai[darbdavysInt].getPozicija());
            Info_apie_save infoapiesave = new Info_apie_save();
            infoapiesave.setVardas( darbuotojai[darbuotojasInt].getVardas());
            infoapiesave.setPavarde(darbuotojai[darbuotojasInt].getPavarde());
            infoapiesave.setAtlyginimas(darbuotojai[darbuotojasInt].getAtlyginimas());
            infoapiesave.setIeskoma_darbo_pozicija(darbuotojai[darbuotojasInt].getIeskoma_darbo_pozicija());
            infoapiesave.setAtlyginimas(darbuotojai[darbuotojasInt].getAtlyginimas());
            infoapiesave.setMiestas(darbuotojai[darbuotojasInt].getMiestas());
            infoapiesave.setStazas(darbuotojai[darbuotojasInt].getStazas());
            
            System.out.println("Spausdinam formuojama message "+ infoapiesave.getVardas());
            
            Info_apie_save_msg msg = new Info_apie_save_msg();
            
            msg.addInfo_apie_save_message(infoapiesave);
            
            try {
                cm.fillContent(req, msg);
                req.addUserDefinedParameter("klase", "SimpleMessage");
                send(req);
            } catch (Exception ex) {
                System.out.println("A[" + getLocalName() + "] Error while building messag info apie savee: " + ex.getMessage());
            }

            //}
        }
    }

    @Override
    public void takeDown() {
        System.out.println("A[" + getLocalName() + "] is being removed");
        if (myGui != null) {
            myGui.setVisible(false);
            myGui.dispose();

        }
    }

    private class MyOneShot extends OneShotBehaviour {

        @Override
        public void action() {
            System.out.println("A[" + this.myAgent.getLocalName() + "] Requesting service providers");
            DFAgentDescription dfd = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("Darbdavys");
            dfd.addServices(sd);
            SearchConstraints sc = new SearchConstraints();
            sc.setMaxResults(Long.MAX_VALUE);

            sub = DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc);
            send(DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc));
            //addBehaviour(new MyWaker(myAgent, 3000));
        }
    }

    private class MyOneShot2 extends OneShotBehaviour {

        @Override
        public void action() {
            System.out.println("A[" + this.myAgent.getLocalName() + "] Requesting service providers");
            DFAgentDescription dfd = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("Darbuotojas");
            dfd.addServices(sd);
            SearchConstraints sc = new SearchConstraints();
            sc.setMaxResults(Long.MAX_VALUE);

            sub = DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc);
            send(DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc));
            //addBehaviour(new MyWaker(myAgent, 3000));
        }
    }

    private class GautiVisusDarboPasiulymus extends OneShotBehaviour {

        @Override
        public void action() {
            System.out.println("A[" + this.myAgent.getLocalName() + "] Requesting service providers");
            DFAgentDescription dfd = new DFAgentDescription();
            ServiceDescription sd = new ServiceDescription();
            sd.setType("Darbuotojai");
            dfd.addServices(sd);
            SearchConstraints sc = new SearchConstraints();
            sc.setMaxResults(Long.MAX_VALUE);

            sub = DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc);
            send(DFService.createSubscriptionMessage(this.myAgent, getDefaultDF(), dfd, sc));
            //addBehaviour(new MyWaker(myAgent, 3000));

        }
    }

    private class MyWaker extends WakerBehaviour {

        public MyWaker(Agent a, long timeout) {
            super(a, timeout);
        }

        @Override
        protected void onWake() {
            send(DFService.createCancelMessage(this.myAgent, getDefaultDF(), sub));
        }
    }

    private class MatchDarbdavysOntology implements MessageTemplate.MatchExpression {

        public boolean match(ACLMessage msg) {
            String ontology = msg.getOntology();
            return (ontology != null && msg.getContent().contains("Darbdavys"));
        }
    } // END of inner class MatchXOntology

    private class MatchDarbuotojasOntology implements MessageTemplate.MatchExpression {

        public boolean match(ACLMessage msg) {
            String ontology = msg.getOntology();
            return (ontology != null && msg.getContent().contains("Darbuotojas"));
        }
    } // END of inner class MatchXOntology
    AID df = new AID("df", AID.ISLOCALNAME);
    private MessageTemplate templateDarbdavys = MessageTemplate.and(
            MessageTemplate.MatchSender(df),
            new MessageTemplate(new MatchDarbdavysOntology()));

    private MessageTemplate templateDarbuotojas = MessageTemplate.and(
            MessageTemplate.MatchSender(df),
            new MessageTemplate(new MatchDarbuotojasOntology()));

    private class WaitForMessages extends CyclicBehaviour {

        @Override
        public void action() {
            Ontology onto = DarbdavysOntology.getInstance();
            Ontology onto2 = DarbuotojaiOntology.getInstance();
            Codec codec = new SLCodec();
            ContentManager cm = getContentManager();
            ContentManager cm2 = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(onto);
            cm2.registerLanguage(codec);
            cm2.registerOntology(onto2);

            ACLMessage msgDarbdavys = myAgent.receive(templateDarbdavys);
            ACLMessage msgDarbuotojas = myAgent.receive(templateDarbuotojas);
            ACLMessage msg = myAgent.receive();
            if (msgDarbdavys != null) {
                myGui.addLine("Gauta darbdavys zinuyte is df");
                try {
                    DFAgentDescription[] dfds = DFService.decodeNotification(msgDarbdavys.getContent());
                    // for (int i = 0; i < dfds.length; i++) {
                    int check = 0;
                    for (int i = 0; i < myGui.getComboLinesCount(); i++) {
                        if (dfds[0].getName().getLocalName().equals(myGui.getComboItem(i))) {
                            myGui.removeComboLine(dfds[0].getName().getLocalName());
                            check = 1;
                            
                        }
                    }
                    if (check == 0) {
                        myGui.addLine("Rastas darbdaviu sarasas: \n");
                        for (int i = 0; i < dfds.length; i++) {
                            myGui.addComboLine(dfds[i].getName().getLocalName());
                            myGui.addLine(dfds[i].getName().getLocalName() + "\n");
                        }
                    }
                    // }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (msgDarbuotojas != null) {
                try {
                    DFAgentDescription[] dfds = DFService.decodeNotification(msgDarbuotojas.getContent());
                    // for (int i = 0; i < dfds.length; i++) {
                    int check = 0;
                    for (int i = 0; i < myGui.getCombo2LinesCount(); i++) {
                        if (dfds[0].getName().getLocalName().equals(myGui.getCombo2Item(i))) {
                            myGui.removeCombo2Line(dfds[0].getName().getLocalName());
                            check = 1;
                        }
                    }
                    if (check == 0) {
                        myGui.addLine("Rastas darbuotoju sarasas: \n");
                        for (int i = 0; i < dfds.length; i++) {
                            myGui.addCombo2Line(dfds[i].getName().getLocalName());
                            myGui.addLine(dfds[i].getName().getLocalName() + "\n");

                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            if (msg != null) {
                try {
                    ContentElement c = cm.extractContent(msg);
                    ContentElement c2 = cm2.extractContent(msg);

                    if (c instanceof Paieska_msg) {
                        myGui.addLine("A[" + getLocalName() + "] rastas tinkamas darbas pas " + msg.getSender().getLocalName() + " darbdavi \n");
                        Paieska_msg p = (Paieska_msg) c;
                        DarbuotojoPaieska_line l = null;

                        Iterator i = p.getAllDarbuotojo_paieska_msg();
                        while (i.hasNext()) {
                            l = (DarbuotojoPaieska_line) i.next();
                            myGui.addLine(l.getMiestas() + l.getPozicija());

                        }
                    } else if (c instanceof Paieska_pagal_darbdavi) {

                        Paieska_pagal_darbdavi p = (Paieska_pagal_darbdavi) c;
                        Darbo_Info u = null;
                        Iterator i = p.getAllPaieskaPagalDarbdaviDaug();
                        Iterator o;
                        Imones_Info l = null;
                        myGui.addLine("Spausdinamas siulomu darbu sąrašas " + msg.getSender().getLocalName() + " imoneje:\n");

                        while (i.hasNext()) {
                            l = (Imones_Info) i.next();
                            o = l.getAllDarbai();
                            while (o.hasNext()) {
                                u = (Darbo_Info) o.next();
                                myGui.addLine("Darbo id: " + u.getID() + " Pozicija: " + u.getPozicija() + " Miestas: " + u.getMiestas() + " Atlyginimas: " + u.getAtlyginimas() + " Stazas: " + u.getReikalingas_Stazas() + " Darbo valandos: " + u.getValandos());
                                darbai[darbaisk] = u;
                                imones[darbaisk] = l;
                                myGui.addLine("\n");

                                myGui.addCombo4Line(imones[darbaisk].getPavadinimas() + darbai[darbaisk].getPozicija());
                                myGui.addLine("A["+getLocalName()+"] Darbo id: " + darbaisk + "Darbo info "+darbai[darbaisk].getPozicija());
                                darbaisk++;

                            }
                            myGui.addLine("\n");
                        }
                    } else if (c2 instanceof Info_apie_save_msg) {

                        myGui.addLine("A[" + getLocalName() + "] gauta informacija apie " + msg.getSender().getLocalName() + " darbuotoja \n");

                        Info_apie_save_msg p = (Info_apie_save_msg) c;

                        Info_apie_save l = null;

                        Iterator i = p.getAllInfo_apie_save_message();
                        while (i.hasNext()) {
                            l = (Info_apie_save) i.next();
                            myGui.addLine("Vardas: " + l.getVardas() + ", pavarde: " + l.getPavarde() + " , ieskoma pozicija: " + l.getIeskoma_darbo_pozicija() + " ,miestas: " + l.getMiestas() + " norimas atlyginimas: " + l.getAtlyginimas() + " , stazas: " + l.getStazas() + "\n");
                            darbuotojai[z] = l;
                            myGui.addCombo3Line(darbuotojai[z].getVardas());
                            myGui.addLine("A["+getLocalName()+"] darbuotojo id: "+z + " darbuootjo vardas: "+darbuotojai[z].getVardas());
                            z++;

                        }
                    } else {
                        block();
                    }
                } catch (Exception ex) {
                    System.out.println("A[" + myAgent.getName() + "] Ontology parsing error info apie save msg: " + ex.getMessage());
                }

            }

        }
    }
}
