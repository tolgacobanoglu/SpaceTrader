package project.gameengine.planettrade.game;

import project.gameengine.base.GameContext;
import project.gameengine.planettrade.model.BlackHole;
import project.gameengine.planettrade.model.Galaxy;
import project.gameengine.planettrade.model.Player;
import project.gameengine.planettrade.util.Input;
import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

import java.util.ArrayList;
import java.util.List;



public class MyGameContext implements GameContext {

    BlackHole blackHole;
    Galaxy galaxy;
    private static MyGameContext instance = null;
    Input input = new Input();
    private List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    private MyGameContext(){
        init();
    }

    public int getInput(int bound)
    {
        return input.getInput( bound);
    }

    public static  MyGameContext getInstance()
    {
        if (instance == null)
             instance = new MyGameContext();

        return instance;
    }

    private void init()
    {
        blackHole = new BlackHole();
        galaxy = blackHole.explode();
    }

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void printMoves()
    {
        System.out.println(yellowText+"0 -> Skip\n1 -> Buy\n2 -> Sell\n3 -> Buy Fuel\n4 -> Travel"+normalText);
    }

}
