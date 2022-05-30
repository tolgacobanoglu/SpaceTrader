package project.gameengine.planettrade.action;

import project.gameengine.base.Action;
import project.gameengine.planettrade.gamechecker.GameChecker;
import project.gameengine.planettrade.model.Cargo;
import project.gameengine.planettrade.model.Player;
import project.gameengine.planettrade.model.Supply;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class MarketBuyAction implements Action
{
    public Action buySupplyAction(Player player, int index)
    {
        double price = 0;
        Supply selectedSupply = player.getCurrentPlanet().getMarket().getSupplies().get(index);
        if (GameChecker.availableAmount(player, index) >= 1)
        {
            int amount = GameChecker.availableAmount(player, index);
            price= selectedSupply.getBuyPrice() * amount;
            player.getCurrentPlanet().getMarket().getSupplies().get(index).setAmount(player.getCurrentPlanet().getMarket().getSupplies().get(index).getAmount() - amount);
            player.updateBalance(-price);
            player.getSpaceShip().addCargo(new Cargo(selectedSupply.getCommodity(), amount));
            System.out.println(buyText(player.getName() + " bought " + amount + " " + selectedSupply.getCommodity().getName() + " that costs " + price));
        }
        else
        {
            System.out.println(warningText("You can't buy,you have no available space in spaceship"));
        }
        player.getSpaceShip().getList().forEach(x -> System.out.println(blackText+x.toString()+normalText));
        player.updateXP(price*0.1);
        GameChecker.isXPAvailable(player);
        return new MarketBuyAction();
    }

    @Override
    public String toString() {
        return cyanText+"MarketBuyAction"+normalText;
    }
}