package org.tomasdavid.horsecarryingcapacity;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity(difficultyComparatorClass = CargoDifficultyComparator.class)
public class Cargo {

    private int weight;

    private Horse horse;

    public Cargo(int weight) {
        this.weight = weight;
    }

    public Cargo() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @PlanningVariable(valueRangeProviderRefs = {"horseRange"}, strengthComparatorClass = HorseStrengthComparator.class)
    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }
}
