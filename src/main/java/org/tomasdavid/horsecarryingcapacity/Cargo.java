package org.tomasdavid.horsecarryingcapacity;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * Cargo class. Cargo has certain weight and it should be loaded on a horse.
 */
@PlanningEntity(difficultyComparatorClass = CargoDifficultyComparator.class)
public class Cargo {

    /**
     * Weight of cargo.
     */
    private int weight;

    /**
     * Horse for carrying cargo.
     */
    private Horse horse;

    /**
     * Cargo constructor.
     * @param weight Weight of cargo.
     */
    public Cargo(int weight) {
        this.weight = weight;
    }

    /**
     * Cargo constructor with zero weight.
     */
    public Cargo() {
        this.weight = 0;
    }

    /**
     * Returns weight of cargo
     * @return Weight of cargo.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets new weight of cargo.
     * @param weight New weight.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Returns horse which carry the cargo.
     * @return Loaded horse.
     */
    @PlanningVariable(valueRangeProviderRefs = {"horseRange"})
    public Horse getHorse() {
        return horse;
    }

    /**
     * Sets horse for carrying cargo.
     * @param horse Horse for cargo.
     */
    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
