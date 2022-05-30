package project.gameengine.planettrade.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpaceShip{


    private final String name;
    private final double buyPrice;
    private List<Cargo> list = Collections.emptyList();
    private double capacity;  //In terms of volume
    private final double speed;     //In terms of light year per TURN
    private double currentFuel = 100;
    private final double fuelCapacity;
    private final double fuelUsage;   //Per light year

    public SpaceShip(String name, double buyPrice, double capacity, double speed, double fuelCapacity, double fuelUsage)
    {
        this.name = name;
        this.buyPrice = buyPrice;
        this.capacity = capacity;
        this.speed = speed;
        this.fuelCapacity = fuelCapacity;
        this.fuelUsage = fuelUsage;
    }

    public void decayedList()
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).decayed();
        }
    }

    public void updateCapacity()
    {
        capacity += capacity * 0.1;
    }

    @Override
    public String toString() {
        return " SpaceShip{" +
                "name='" + name + '\'' +
                ", buyPrice=" + buyPrice +
                ", capacity=" + capacity +
                ", speed=" + speed +
                ", fuelCapacity=" + fuelCapacity +
                ", fuelUsage=" + fuelUsage +
                "}\n";
    }

    public void addCargo(Cargo cargo)
    {
        List<Cargo> newList = new ArrayList<>();
        newList.add(cargo);
        newList.addAll(list);
        list = newList;
    }

    public void dropCargo()
    {
        list = Collections.emptyList();
    }

    public String getName() {
        return name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public List<Cargo> getList() {
        return list;
    }

    public void setList(List<Cargo> list) {
        this.list = list;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCurrentFuel() {
        return currentFuel;
    }

    public void setCurrentFuel(double currentFuel) {
        this.currentFuel = currentFuel;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getFuelUsage() {
        return fuelUsage;
    }

    public double availableCargoCapacity()
    {
        double currentCapacity = 0;
        for (int i = 0; i < list.size(); i++)
        {
            currentCapacity += list.get(i).getQuantity() * list.get(i).getCommodity().getUnitVolume();
        }

        return capacity - currentCapacity;
    }
}
