package project.gameengine.planettrade.model;


import project.gameengine.planettrade.generator.MarketGenerator;
import project.gameengine.planettrade.util.random.Random;

public class Planet
{
    private final String name;
    private Market market;
    private final double unitFuelPrice;
    private final double perTurnParkingPrice;
    private final int distanceToCenter;

    public Planet(String name, double unitFuelPrice, double perTurnParkingPrice,int distanceToCenter) {
        this.name = name;
        this.market = MarketGenerator.generate();
        this.unitFuelPrice = unitFuelPrice;
        this.perTurnParkingPrice = perTurnParkingPrice;
        this.distanceToCenter = distanceToCenter;
    }

    public double getInvestingRate()
    {
        return Random.randomDouble(0.05,0.3);
    }

    public int getDistanceToCenter()
    {
        return distanceToCenter;
    }

    public String getName() {
        return name;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }

    public double getUnitFuelPrice() {
        return unitFuelPrice;
    }

    public double getPerTurnParkingPrice() {
        return perTurnParkingPrice;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", market=" + market +
                ", unitFuelPrice=" + unitFuelPrice +
                ", perTurnParkingPrice=" + perTurnParkingPrice +
                '}';
    }
}
