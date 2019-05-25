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
            sleep(1000);
            AgentController actr2 = mc.createNewAgent("Telia", "kursinis.DarbdavysAgent", args);
            actr2.start();
            sleep(1000);
            actr2 = mc.createNewAgent("Hella", "kursinis.DarbdavysAgent", args);
            actr2.start();
            sleep(1000);
            actr2 = mc.createNewAgent("Sony", "kursinis.DarbdavysAgent", args);
            actr2.start();
            AgentController actr3 = mc.createNewAgent("Darbuotoju_srautas_1", "kursinis.DarbuotojasAgent", args);           
            actr3.start();
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
