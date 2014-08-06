package org.tomasdavid.horsecarryingcapacity;

/**
 * Horse class. Horse has certain carrying capacity.
 */
public class Horse {

    /**
     * Horse carrying capacity.
     */
    private int carryingCapacity;

    /**
     * Horse constructor.
     * @param carryingCapacity Maximum carrying capacity.
     */
    public Horse(int carryingCapacity) {
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
}
