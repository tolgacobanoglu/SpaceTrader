package project.gameengine.planettrade.model;

public class Supply {
     private final Commodity commodity;
     private int amount;
     private final double  buyPrice;
     private final double sellPrice;

     public Supply(Commodity commodity, int amount, double buyPrice, double sellPrice) {
          this.commodity = commodity;
          this.amount = amount;
          this.buyPrice = buyPrice;
          this.sellPrice = sellPrice;
     }

     @Override
     public String toString() {
          return "Supply{" +
                  "commodity=" + commodity +
                  ", amount=" + amount +
                  ", buyPrice=" + buyPrice +
                  ", sellPrice=" + sellPrice +
                  '}';
     }

     public Commodity getCommodity() {
          return commodity;
     }

     public int getAmount() {
          return amount;
     }

     public double getBuyPrice() {
          return buyPrice;
     }

     public double getSellPrice() {
          return sellPrice;
     }

     public void setAmount(int amount) {
          this.amount = amount;
     }

     public double getSupplyCapacity()
     {
          return commodity.getUnitVolume() * getAmount();
     }
}
