package project.gameengine.planettrade.action;

import project.gameengine.base.Action;
import project.gameengine.planettrade.model.Player;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class NoAction implements Action
{
    public Action noAction(Player player)
    {
        System.out.println(actionText("No action,")+buyText(String.valueOf(player.getCurrentPlanet().getPerTurnParkingPrice()))+actionText(" paid parking price"));
        player.payPlanetParkPrice();
        return new NoAction();
    }

    @Override
    public String toString()
    {
        return cyanText+super.toString()+normalText;
    }
}
