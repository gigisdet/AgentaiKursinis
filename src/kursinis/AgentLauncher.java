package kursinis;

import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.AgentContainer;
import static java.lang.Thread.sleep;

public class AgentLauncher extends Agent {

    @Override
    public void setup() {
        System.out.println("A[" + getLocalName() + "] is starting");

        System.out.println("A[" + getLocalName() + "] Launching simple agents");

        try {
            AgentContainer mc = this.getContainerController();
            String[] args = {""};
            AgentController actrl = mc.createNewAgent("GUI", "kursinis.GuiAgenta", args);
            actrl.start();
            String[] argsT = {"Telia"};
            AgentController actr2 = mc.createNewAgent("Telia", "kursinis.DarbdavysAgent", argsT);
            actr2.start();
            String[] argsH = {"Hella"};
            actr2 = mc.createNewAgent("Hella", "kursinis.DarbdavysAgent", argsH);
            actr2.start();
            String[] argsS = {"Sony"};
            actr2 = mc.createNewAgent("Sony", "kursinis.DarbdavysAgent", argsS);
            actr2.start();
            String[] argsP = {"Petras"};
            AgentController actr3 = mc.createNewAgent("Petras", "kursinis.DarbuotojasAgent", argsP);
            actr3.start();
            String[] argsJ = {"Juozas"};
            AgentController actr4 = mc.createNewAgent("Juozas", "kursinis.DarbuotojasAgent", argsJ);
            actr4.start();
            String[] argsA = {"Aloyzas"};
            AgentController actr5 = mc.createNewAgent("Aloyzas", "kursinis.DarbuotojasAgent", argsA);
            actr5.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);     // sleep 5 s
        } catch (InterruptedException e) {
        }
        this.doDelete();
    }

    public void shutdownJadePlatform() {
        try {
            System.out.println("A[" + getLocalName() + "] Shut down Jade Platform");
            this.getContainerController().kill();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
