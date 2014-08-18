package org.tomasdavid.horsecarryingcapacity;

import org.optaplanner.core.impl.phase.event.PhaseLifecycleListener;
import org.optaplanner.core.impl.phase.scope.AbstractPhaseScope;
import org.optaplanner.core.impl.phase.scope.AbstractStepScope;
import org.optaplanner.core.impl.solver.scope.DefaultSolverScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Listener for recording step configuration.
 */
public class StepListener implements PhaseLifecycleListener {

    /**
     * All staps cargo on horses configurations.
     */
    private List<List<String>> listOfStepConf = new ArrayList<List<String>>();

    @Override
    public void phaseStarted(AbstractPhaseScope phaseScope) {
    }

    @Override
    public void stepStarted(AbstractStepScope stepScope) {
    }

    /**
     * After every step record actual configuration cargo on horses.
     * @param stepScope Step scope.
     */
    @Override
    public void stepEnded(AbstractStepScope stepScope) {

        List<String> stepConf = new ArrayList<String>();

        HorseCarryingCapacity workingSolution = (HorseCarryingCapacity)stepScope.getWorkingSolution();

        List<Cargo> cargoList = workingSolution.getCargoList();

        for (Cargo c : cargoList) {
            stepConf.add(c.getLabel() + "(" + c.getWeight() + ")" + " on " + ((c.getHorse() == null) ? "null" :
                    c.getHorse().getName() + "(" + c.getHorse().getCarryingCapacity() + ")"));
        }

        listOfStepConf.add(stepConf);

    }

    @Override
    public void phaseEnded(AbstractPhaseScope phaseScope) {
    }

    @Override
    public void solvingStarted(DefaultSolverScope solverScope) {
    }

    @Override
    public void solvingEnded(DefaultSolverScope solverScope) {
    }

    /**
     * Returns cargo on horses configurations of all steps.
     * @return All staps cargo on horses configurations.
     */
    public List<List<String>> getListOfStepConf() {
        return listOfStepConf;
    }
}
