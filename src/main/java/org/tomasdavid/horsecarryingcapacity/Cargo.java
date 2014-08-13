package org.tomasdavid.horsecarryingcapacity;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/**
 * Cargo class. Cargo has own label and certain weight and it should be loaded on a horse.
 */
@PlanningEntity(difficultyComparatorClass = CargoDifficultyComparator.class)
public class Cargo {

    /**
     * Label of cargo.
     */
    private String label;

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
     * @param label Label of cargo;
     * @param weight Weight of cargo.
     */
    public Cargo(String label, int weight) {
        this.label = label;
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

    /**
     * Get label of cargo;
     * @return Label of cargo.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets new label of cargo.
     * @param label New label.
     */
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Cargo-" + label + "=" + weight;
    }
}
