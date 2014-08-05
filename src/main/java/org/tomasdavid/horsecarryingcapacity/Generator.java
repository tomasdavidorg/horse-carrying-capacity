package org.tomasdavid.horsecarryingcapacity;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    private List<Horse> horseList;

    private List<Cargo> cargoList;

    public Generator() {

        horseList = new ArrayList<Horse>();
        cargoList = new ArrayList<Cargo>();

        horseList.add(new Horse(50));
        horseList.add(new Horse(30));
        horseList.add(new Horse(10));

        cargoList.add(new Cargo(10));
        cargoList.add(new Cargo(20));
        cargoList.add(new Cargo(30));
        cargoList.add(new Cargo(20));
    }

    public List<Horse> getHorseList() {
        return horseList;
    }

    public List<Cargo> getCargoList() {
        return cargoList;
    }
}
