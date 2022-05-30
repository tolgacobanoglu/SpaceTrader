package project.gameengine.planettrade.generator;

import project.gameengine.planettrade.model.Market;
import project.gameengine.planettrade.model.Supply;

import java.util.ArrayList;
import java.util.List;

public class MarketGenerator {

    public static Market generate()
    {
        List<Supply> supplies = new ArrayList<>();
        int limit = 7;

        for (int i = 0; i < limit-1 ; i++) {

           supplies.add(SupplyGenerator.generate());
        }
        CommodityGenerator.resetLists();
        return new Market(supplies);
    }
}
