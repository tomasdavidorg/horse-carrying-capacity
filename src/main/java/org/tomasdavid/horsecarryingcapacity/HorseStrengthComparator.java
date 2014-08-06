package org.tomasdavid.horsecarryingcapacity;

import org.apache.commons.lang.builder.CompareToBuilder;

import java.util.Comparator;

public class HorseStrengthComparator implements Comparator<Horse> {

    @Override
    public int compare(Horse a, Horse b) {
        return new CompareToBuilder().append(a.getCarryingCapacity(), b.getCarryingCapacity()).toComparison();
    }
}
