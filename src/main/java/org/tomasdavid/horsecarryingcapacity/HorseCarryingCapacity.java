package org.tomasdavid.horsecarryingcapacity;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Class of problem. Contains lists of horses a cargo and score.
 */
@PlanningSolution
public class HorseCarryingCapacity implements Solution<HardSoftScore> {

    /**
     * Score of solution.
     */
    private HardSoftScore score;

    /**
     * List of all cargo.
     */
    private List<Cargo> cargoList;

    /**
     * List of all horses.
     */
    private List<Horse> horseList;

    /**
     * Returns list of all cargo.
     * @return Cargo.
     */
    @PlanningEntityCollectionProperty
    public List<Cargo> getCargoList() {
        return cargoList;
    }

    /**
     * Sets new list of cargo.
     * @param cargoList New cargo list.
     */
    public void setCargoList(List<Cargo> cargoList) {
        this.cargoList = cargoList;
    }

    /**
     * Returns list of all horses.
     * @return List of all horses.
     */
    @ValueRangeProvider(id = "horseRange")
    public List<Horse> getHorseList() {
        return horseList;
    }

    /**
     * Sets new list of horses.
     * @param horseList New list of horses.
     */
    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }

    /**
     * Returns score of solution.
     * @return Solution score.
     */
    @Override
    public HardSoftScore getScore() {
        return score;
    }

    /**
     * Sets score of solution.
     * @param score New score.
     */
    @Override
    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    /**
     * Returns collection of horses.
     * @return Horses collection.
     */
    @Override
    public Collection<?> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(horseList);
        return facts;
    }
}
