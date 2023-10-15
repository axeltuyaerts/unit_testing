package ex201_corona_gate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CoronaGateTest {
    @InjectMocks
    CoronaGate coronaGate;

    @Mock
    HeatSensor heatSensor;

    @Mock
    GateController gateController;

    @Test
    void handlePersonAtTheGate_personHasFever_GateLocked() {
        when(heatSensor.feverDetected()).thenReturn(true);

        coronaGate.handlePersonAtTheGate();

        verify(gateController).blockPerson();
        verify(gateController, never()).allowOnePersonThrough();
    }

    @Test
    void handlePersonAtTheGate_personHasNoFever_GateOpened() {
        when(heatSensor.feverDetected()).thenReturn(false);

        coronaGate.handlePersonAtTheGate();

        verify(gateController).allowOnePersonThrough();
        verify(gateController, never()).blockPerson();
    }
}
