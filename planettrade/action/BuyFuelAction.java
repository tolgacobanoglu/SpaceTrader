package project.gameengine.planettrade.action;

import project.gameengine.base.Action;
import project.gameengine.planettrade.gamechecker.GameChecker;
import project.gameengine.planettrade.model.Player;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class BuyFuelAction implements Action
{
    public Action buyFuelAction(Player player)
    {
        double sufficientFuel;
        sufficientFuel = player.getSpaceShip().getFuelCapacity() - player.getSpaceShip().getCurrentFuel();
        player.setCurrentMoney(player.getCurrentMoney() - (player.getCurrentPlanet().getUnitFuelPrice() * sufficientFuel));
        player.getSpaceShip().setCurrentFuel(player.getSpaceShip().getFuelCapacity());
        System.out.println(buyText(player.getName() + " has bought "+ sufficientFuel + "LT fuel"));
        player.updateXP(player.getCurrentPlanet().getUnitFuelPrice() * sufficientFuel * 0.1);
        GameChecker.isXPAvailable(player);
        return new BuyFuelAction();
    }

    @Override
    public String toString() {
        return cyanText+"Buy Fuel Action"+normalText;
    }
}
