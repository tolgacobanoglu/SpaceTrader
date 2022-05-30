package project.gameengine.planettrade.generator;

import project.gameengine.planettrade.model.Supply;
import project.gameengine.planettrade.util.gameConstraints.Constraints;
import project.gameengine.planettrade.util.random.Random;

public class SupplyGenerator{

    public static Supply generate()
    {
        return new Supply(
                CommodityGenerator.generate(),
                Random.randomInteger(Constraints.AMOUNT_CONSTRAINTS.getMIN(), Constraints.AMOUNT_CONSTRAINTS.getMAX()),
                Random.randomDouble(Constraints.BUY_PRICE_CONSTRAINTS.getMIN(),  Constraints.SELL_PRICE_CONSTRAINTS.getMIN()),
                Random.randomDouble(Constraints.SELL_PRICE_CONSTRAINTS.getMIN(), Constraints.SELL_PRICE_CONSTRAINTS.getMAX())
        );
    }

}
