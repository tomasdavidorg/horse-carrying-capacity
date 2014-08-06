package org.tomasdavid.horsecarryingcapacity;


import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Application for solution of the horse carrying capacity problem.
 */
public class HorseCarryingCapacityApp {

    /**
     *  Main method.
     * @param args No parameters are used.
     */
    public static void main(String[] args) {

        // Initializes horses and cargo
        List<Horse> horseList = new ArrayList<Horse>();
        List<Cargo> cargoList = new ArrayList<Cargo>();
        horseList.add(new Horse(50));
        horseList.add(new Horse(30));
        horseList.add(new Horse(10));
        cargoList.add(new Cargo(20));
        cargoList.add(new Cargo(30));
        cargoList.add(new Cargo(10));
        cargoList.add(new Cargo(20));

        // Creates solver factory by solver configuration
        SolverFactory solverFactory = SolverFactory.createFromXmlResource("org/tomasdavid/horsecarryingcapacity/horseCarryingCapacitySolverConfig.xml");

        // Builds solver with configuration
        Solver solver = solverFactory.buildSolver();

        // Creates solution and adds list to solution
        HorseCarryingCapacity horseCarryingCapacity = new HorseCarryingCapacity();
        horseCarryingCapacity.setCargoList(cargoList);
        horseCarryingCapacity.setHorseList(horseList);

        // Solves planning problem and finds best solution
        solver.solve(horseCarryingCapacity);
        HorseCarryingCapacity bestSolution = (HorseCarryingCapacity) solver.getBestSolution();

        // Prints results
        System.out.println("Best solution is:\n" + formatSolutionOutput(bestSolution));

        System.out.println("Score is:\n  " + bestSolution.getScore());
    }

    /**
     * Prepare solution for printing.
     * @param solution Solution of problem.
     * @return String describing solution.
     */
    public static String formatSolutionOutput(HorseCarryingCapacity solution) {
        StringBuilder displayString = new StringBuilder();
        for (Cargo process : solution.getCargoList()) {
            Horse computer = process.getHorse();
            displayString.append("  ").append(process.getWeight()).append(" -> ")
                    .append(computer == null ? null : computer.getCarryingCapacity()).append("\n");
        }
        return displayString.toString();
    }
}
