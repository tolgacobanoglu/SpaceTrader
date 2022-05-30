package project.gameengine.planettrade.model;

import java.util.Comparator;
import java.util.List;

public class Market {

    private final List<Supply> supplies;

    public Market(List<Supply> supplies) {
        this.supplies = supplies;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }

    @Override
    public String toString() {
        String x = "Market has...\n";

        for (int i = 0; i < supplies.size(); i++) {
            x += "["+i +"] "+ supplies.get(i).getCommodity().getName()+" amount = "+ supplies.get(i).getAmount()+ " buyPrice = "+ supplies.get(i).getBuyPrice()+" sellPrice = "+ supplies.get(i).getSellPrice()+"\n";
        }
        x+="-------------------------------------------------------------------------------------------------------";
        return  x;
    }

    public void displaySupplies(){
        supplies.stream().sorted(Comparator.comparingDouble(Supply::getAmount).reversed()).forEach(System.out::println);
    }

}