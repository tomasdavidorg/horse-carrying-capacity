package org.tomasdavid.horsecarryingcapacity;

/**
 * Horse class. Horse has name and certain carrying capacity.
 */
public class Horse {

    /**
     * Name of horse.
     */
    private String name;

    /**
     * Horse carrying capacity.
     */
    private int carryingCapacity;

    /**
     * Horse constructor.
     * @param name Name of horse.
     * @param carryingCapacity Maximum carrying capacity.
     */
    public Horse(String name, int carryingCapacity) {
        this.name = name;
        this.carryingCapacity = carryingCapacity;
    }

    /**
     * Get horse carrying capacity.
     * @return Carrying capacity.
     */
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    /**
     * Change horse strength.
     * @param carryingCapacity New horse carrying capacity.
     */
    public void setCarryingCapacity(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    /**
     * Get horse name.
     * @return Name of horse.
     */
    public String getName() {
        return name;
    }

    /**
     * Change horse name.
     * @param name New name of horse.
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Horse-" + this.name + "=" + this.carryingCapacity;
    }
}
