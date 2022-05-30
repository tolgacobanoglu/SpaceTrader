package project.gameengine.planettrade.model;

public class Cargo
{
    private Commodity commodity;
    private double quantity;

    public Cargo(Commodity commodity, int quantity)
    {
        this.commodity = commodity;
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Cargo{" +
                "commodity=" + commodity.getName() +
                ", quantity=" + quantity +
                '}';
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void decayed()
    {
        quantity = quantity * (1 - commodity.getDecayRatio());
    }

}