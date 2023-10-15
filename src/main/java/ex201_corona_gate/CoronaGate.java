package ex201_corona_gate;

public class CoronaGate {
    private final HeatSensor heatSensor;
    private final GateController gateController;

    public CoronaGate(HeatSensor heatSensor, GateController gateController) {
        this.heatSensor = heatSensor;
        this.gateController = gateController;
    }

    public void handlePersonAtTheGate() {
        if (heatSensor.feverDetected()) {
            gateController.blockPerson();
        }
        else {
            gateController.allowOnePersonThrough();
        }
    }
}
