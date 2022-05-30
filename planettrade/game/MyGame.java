package project.gameengine.planettrade.game;

import project.gameengine.base.Action;
import project.gameengine.base.Game;
import project.gameengine.base.GameContext;
import project.gameengine.base.Player;
import project.gameengine.planettrade.action.NoAction;
import project.gameengine.planettrade.generator.MarketGenerator;
import project.gameengine.planettrade.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyGame implements Game
{

    private MyGameContext gameContext;
    private boolean isOver = false;
    private List<Player> players = new ArrayList<>();


    @Override
    public String toString()
    {
        gameContext =  MyGameContext.getInstance();

        return "MyGame{" +
                players +
                '}';
    }

    public MyGame() {
        gameContext = MyGameContext.getInstance();
    }

    @Override
    public boolean isOver()
    {
        return getIsOver();
    }

    @Override
    public void init(List<Player> players) {
        this.players = players;

        players.forEach(System.out::println);
    }

    @Override
    public GameContext getContext() {
        return gameContext;
    }

    @Override
    public void update(Action action)
    {
        NoAction noAction = new NoAction();
        if (!Objects.equals(action, noAction))
        {
            MyGameContext myGameContext = gameContext;
            List<Planet> planetList = myGameContext.galaxy.getPlanets();
            planetList.forEach(x -> x.setMarket(MarketGenerator.generate()));
        }
    }

    @Override
    public int minimumPlayerCount() {
        return 2;
    }

    @Override
    public int maximumPlayerCount() {
        return 4;
    }

    public boolean getIsOver()
    {
        return isOver;
    }

    public void setOver(boolean over)
    {
        isOver = over;
    }
}