package project.gameengine.planettrade.action;

import project.gameengine.base.Action;
import project.gameengine.planettrade.gamechecker.GameChecker;
import project.gameengine.planettrade.game.MyGameContext;
import project.gameengine.planettrade.model.*;
import project.gameengine.planettrade.util.Input;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class TravelAction implements Action
{
    public Action travelAction(Player player)
    {
        Galaxy galaxy = MyGameContext.getInstance().getGalaxy();
        System.out.println(displayList(available(player,galaxy)));
        System.out.println(actionText("!!Please enter index to travel another planet."));
        System.out.print(buyText(">>"));
        Input input = new Input();
        int index = input.getInput(galaxy.getPlanets().size()-1);
        double cost = player.getSpaceShip().getFuelUsage() * Math.abs(galaxy.getPlanets().get(index).getDistanceToCenter() - player.getCurrentPlanet().getDistanceToCenter());
        if (!GameChecker.validFuel(player,galaxy,index))
        {
            System.out.println(warningText("You have not enough fuel to travel and you are taken to the gas station"));
            return new NoAction().noAction(player);
        }
        player.getSpaceShip().setCurrentFuel(player.getSpaceShip().getCurrentFuel() - cost);
        System.out.println(actionText("Cost of the travel ")+buyText(String.valueOf(cost)));
        System.out.println(actionText(player.getName() + " gone to "+galaxy.getPlanets().get(index).getName()));
        player.setCurrentPlanet(galaxy.getPlanets().get(index));
        return new TravelAction();
    }

    private String available(Player player,Galaxy galaxy)
    {
        String content = "";
        int counter = 0;
//        for (int i = 0; i < galaxy.getPlanets().size(); i++)
//        {
//            if (!player.getCurrentPlanet().getName().equals(galaxy.getPlanets().get(i).getName()))
//            {
//                content += "[" + counter +"]";
//                content += galaxy.getPlanets().get(i).getName();
//                content += "\n";
//                counter++;
//            }
//        }

        for (Planet planet: galaxy.getPlanets())
        {
            if (!player.getCurrentPlanet().getName().equals(planet.getName()))
            {
                content += "[" + counter +"]";
                content += planet.getName();
                content += "\n";
                counter++;
            }
        }
        return content;
    }

    @Override
    public String toString()
    {
        return cyanText+"Travel Action"+normalText;
    }
}