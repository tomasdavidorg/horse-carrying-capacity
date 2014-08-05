package org.tomasdavid.horsecarryingcapacity;


import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

public class HorseCarryingCapacityApp {

    public static void main(String[] args) {

        SolverFactory solverFactory = SolverFactory.createFromXmlResource("org/tomasdavid/horsecarryingcapacity/horseCarryingCapacitySolverConfig.xml");

        Solver solver = solverFactory.buildSolver();

        HorseCarryingCapacity horseCarryingCapacity = new HorseCarryingCapacity();

        Generator g = new Generator();
        horseCarryingCapacity.setCargoList(g.getCargoList());
        horseCarryingCapacity.setHorseList(g.getHorseList());

        solver.solve(horseCarryingCapacity);

        HorseCarryingCapacity c = (HorseCarryingCapacity) solver.getBestSolution();

        System.out.println("Best solution is: " + toDisplayString(c));

        System.out.println("Score is:" + c.getScore());
    }

    public static String toDisplayString(HorseCarryingCapacity hcc) {
        StringBuilder displayString = new StringBuilder();
        for (Cargo process : hcc.getCargoList()) {
            Horse computer = process.getHorse();
            displayString.append("  ").append(process.getWeight()).append(" -> ")
                    .append(computer == null ? null : computer.getCarryingCapacity()).append("\n");
        }
        return displayString.toString();
    }
}
