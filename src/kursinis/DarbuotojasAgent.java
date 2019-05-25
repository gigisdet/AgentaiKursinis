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
        String param = "";
        Object[] args = getArguments();
        if ((args != null) && (args.length > 0)) {
            param = (String) args[0];
        }
        info.setVardas(param);
        info.setPavarde("Poga");
        info.setIeskoma_darbo_pozicija("Inžinierius");
        info.setAtlyginimas(1000);
        info.setMiestas("Marijampolė");
        info.setStazas(10);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Darbuotojas");
        sd.setName("Darbuotojas");
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

            Ontology ontoDarbuotojas = DarbuotojaiOntology.getInstance();
            Codec codec = new SLCodec();
            ContentManager cm = getContentManager();
            cm.registerLanguage(codec);
            cm.registerOntology(ontoDarbuotojas);

            Info_apie_save in = new Info_apie_save();
            Info_apie_save s = new Info_apie_save();
            Info_apie_save_msg m = new Info_apie_save_msg();

            ACLMessage msg = myAgent.receive();
            if (msg != null) {

                try {
                    String pran = msg.getContent();
                    System.out.println("Darbuotojas[" + getLocalName() + "] Message received: " + pran);

                    ContentElement c = cm.extractContent(msg);

                    if (c instanceof SimplePranesimasDarbuotojas) {
                        System.out.println("Gautas simple pranesimas VISI");

                        ACLMessage omsg = new ACLMessage(ACLMessage.INFORM);
                        omsg.setLanguage(codec.getName());
                        omsg.setOntology(ontoDarbuotojas.getName());
                        omsg.setConversationId(msg.getConversationId());
                        omsg.setInReplyTo(msg.getReplyWith());
                        omsg.clearAllReceiver();
                        omsg.addReceiver(msg.getSender());

                        s.setVardas(info.getVardas());
                        s.setPavarde(info.getPavarde());
                        s.setAtlyginimas(info.getAtlyginimas());
                        s.setIeskoma_darbo_pozicija(info.getIeskoma_darbo_pozicija());
                        s.setMiestas(info.getMiestas());
                        s.setStazas(info.getStazas());

                        m.addInfo_apie_save_message(s);

                        try {
                            cm.fillContent(omsg, m);
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
}
