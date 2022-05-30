package project.gameengine.planettrade.action;

import project.gameengine.base.Action;
import project.gameengine.planettrade.gamechecker.GameChecker;
import project.gameengine.planettrade.model.Player;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class MarketSellAction implements Action
{
    public Action sellCargoAction(Player player)
    {
        double totalPrice = 0;

        for (int marketIndex = 0; marketIndex < player.getCurrentPlanet().getMarket().getSupplies().size(); marketIndex++)
        {
            for (int cargoIndex = 0; cargoIndex < player.getSpaceShip().getList().size(); cargoIndex++)
            {
                if (player.getCurrentPlanet().getMarket().getSupplies().get(marketIndex).getCommodity().getName() == player.getSpaceShip().getList().get(cargoIndex).getCommodity().getName())
                {
                    totalPrice += player.getCurrentPlanet().getMarket().getSupplies().get(marketIndex).getSellPrice() * player.getSpaceShip().getList().get(cargoIndex).getQuantity();
                }
            }
        }

        player.getSpaceShip().dropCargo();
        player.updateBalance(totalPrice);
        player.updateXP(totalPrice*0.1);
        GameChecker.isXPAvailable(player);
        return new MarketSellAction();
    }

    @Override
    public String toString() {
        return cyanText+"Market Sell Action"+normalText;
    }
}