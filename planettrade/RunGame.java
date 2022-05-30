package project.gameengine.planettrade;

import project.gameengine.TurnBasedGameEngine;
import project.gameengine.base.GameRenderer;
import project.gameengine.planettrade.game.MyGame;
import project.gameengine.planettrade.game.MyGameContext;
import project.gameengine.planettrade.model.*;
import project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer;
import project.gameengine.planettrade.util.random.Random;

import java.util.List;

public class RunGame
{
    public static void main(String[] args)
    {
        GameRenderer gameRenderer = new ColorfulGameRenderer();
        MyGameContext myGameContext = MyGameContext.getInstance();
        List<Planet> planets = myGameContext.getGalaxy().getPlanets();
        MyGame myGame = new MyGame();
        TurnBasedGameEngine turnBasedGameEngine = new TurnBasedGameEngine(myGame, gameRenderer);

        Player player1 = new Player("Bob",  planets.get(Random.randomInteger(0, planets.size())));
        player1.prepareForGame(myGameContext);
        Player player2 = new Player("Alice",  planets.get(Random.randomInteger(0, planets.size())));
        player2.prepareForGame(myGameContext);

        myGameContext.addPlayer(player1);
        myGameContext.addPlayer(player2);

        turnBasedGameEngine.addPlayer(player1);
        turnBasedGameEngine.addPlayer(player2);

        turnBasedGameEngine.playARound();
    }
}