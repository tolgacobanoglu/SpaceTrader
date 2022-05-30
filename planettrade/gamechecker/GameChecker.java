package project.gameengine.planettrade.gamechecker;

import project.gameengine.planettrade.model.Galaxy;
import project.gameengine.planettrade.model.Player;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class GameChecker
{
    public static boolean validFuel(Player player, Galaxy galaxy,int index)
    {
        double cost = player.getSpaceShip().getFuelUsage() * Math.abs(galaxy.getPlanets().get(index).getDistanceToCenter() - player.getCurrentPlanet().getDistanceToCenter());

        return player.getSpaceShip().getCurrentFuel() > cost;
    }

    public static void playerMoneyStateChecker(Player player)
    {
        if (player.getCurrentMoney() < 0)
        {
            double newBalance = (-1 * player.getCurrentMoney()) * player.getCurrentPlanet().getInvestingRate();
            newBalance += -1 * player.getCurrentMoney();
            player.setCurrentMoney(-newBalance);
        }
    }

    public static int availableAmount(Player player,int index)
    {
        int amount;
        double availableSpace = player.getSpaceShip().availableCargoCapacity();
        double expectedSpace = player.getCurrentPlanet().getMarket().getSupplies().get(index).getSupplyCapacity();

        if (expectedSpace > availableSpace)
        {
            amount = (int) (availableSpace / player.getCurrentPlanet().getMarket().getSupplies().get(index).getCommodity().getUnitVolume());
        }
        else
        {
            amount = player.getCurrentPlanet().getMarket().getSupplies().get(index).getAmount();
        }

        return amount;
    }

    public static void isXPAvailable(Player player)
    {
        if (player.getXp() >= player.getLevel() * 75)
        {
            player.updateXP(-player.getLevel() * 75);
            player.updateLevel();
            player.getSpaceShip().updateCapacity();

            System.out.println(buyText("Congratulations !! " + player.getName() + " level up to " + player.getLevel()));
            System.out.println(buyText("Your spaceship's capacity is upgraded,buy more win more :)"));
        }
    }



}