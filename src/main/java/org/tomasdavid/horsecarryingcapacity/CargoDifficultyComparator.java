package org.tomasdavid.horsecarryingcapacity;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.util.Comparator;

public class CargoDifficultyComparator implements Comparator<Cargo> {

    @Override
    public int compare(Cargo a, Cargo b) {
        return new CompareToBuilder().append(a.getWeight(), b.getWeight()).toComparison();
    }
}
