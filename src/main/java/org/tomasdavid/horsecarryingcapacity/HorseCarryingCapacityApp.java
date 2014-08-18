package org.tomasdavid.horsecarryingcapacity;


import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.impl.solver.DefaultSolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Application for solution of the horse carrying capacity problem.
 */
public class HorseCarryingCapacityApp {

    /**
     * Main method.
     * @param args No parameters are used.
     */
    public static void main(String[] args) {

        // Initializes horses and cargo
        List<Horse> horseList = new ArrayList<Horse>();
        List<Cargo> cargoList = new ArrayList<Cargo>();
        horseList.add(new Horse("Valach", 3));
        horseList.add(new Horse("Belous", 2));
        cargoList.add(new Cargo("Guns", 2));
        cargoList.add(new Cargo("Icecream", 1));
        cargoList.add(new Cargo("Swords", 2));

        // creates listener
        StepListener listener = new StepListener();

        // Creates solver factory by solver configuration
        SolverFactory solverFactory = SolverFactory.createFromXmlResource("org/tomasdavid/horsecarryingcapacity/horseCarryingCapacitySolverConfig.xml");

        // Builds solver with configuration
        Solver solver = solverFactory.buildSolver();

        // Creates solution and adds list to solution
        HorseCarryingCapacity horseCarryingCapacity = new HorseCarryingCapacity();
        horseCarryingCapacity.setCargoList(cargoList);
        horseCarryingCapacity.setHorseList(horseList);

        // Adds listener to solver
        ((DefaultSolver) solver).addPhaseLifecycleListener(listener);

        // Solves planning problem and finds best solution
        solver.solve(horseCarryingCapacity);
        HorseCarryingCapacity bestSolution = (HorseCarryingCapacity) solver.getBestSolution();

        // print content of listener
        List<List<String>> listOfStepConf = listener.getListOfStepConf();
        for (int i = 0; i < listOfStepConf.size(); i++) {

            System.out.println("Step number " + i);
            List<String> act = listOfStepConf.get(i);

            for (String anAct : act) {
                System.out.println("  " + anAct);
            }

            System.out.println();
        }

        // Prints results
        System.out.println("Best solution is:\n" + formatSolutionOutput(bestSolution));

        // Prints best score
        System.out.println("Score is:\n  " + bestSolution.getScore() + "\n");
    }

    /**
     * Prepare solution for printing.
     * @param solution Solution of problem.
     * @return String describing solution.
     */
    public static String formatSolutionOutput(HorseCarryingCapacity solution) {
        StringBuilder displayString = new StringBuilder();
        for (Cargo cargo : solution.getCargoList()) {
            Horse horse = cargo.getHorse();
            displayString.append("  ").append(cargo).append(" -> ").append(horse == null ? null : horse).append("\n");
        }
        return displayString.toString();
    }
}
