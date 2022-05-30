package project.gameengine.planettrade.model;

import project.gameengine.NullAction;
import project.gameengine.base.Action;
import project.gameengine.base.GameContext;
import project.gameengine.planettrade.action.BuyFuelAction;
import project.gameengine.planettrade.action.MarketBuyAction;
import project.gameengine.planettrade.action.MarketSellAction;
import project.gameengine.planettrade.action.TravelAction;
import project.gameengine.planettrade.action.NoAction;
import project.gameengine.planettrade.gamechecker.GameChecker;
import project.gameengine.planettrade.game.MyGameContext;
import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class Player implements project.gameengine.base.Player
{
    private final String name;
    private double currentMoney;
    private SpaceShip spaceShip = null;
    private Planet currentPlanet;
    private int level = 0;
    private double xp = 0;


    public Player(String name, Planet currentPlanet)
    {
        this.name = name;
        this.currentMoney = 500;
        this.currentPlanet = currentPlanet;
    }

    public void updateXP(double value)
    {
        xp += value;
    }

    public void updateLevel()
    {
        level += 1;
    }

    public int getLevel() {
        return level;
    }

    public double getXp() {
        return xp;
    }

    public void payPlanetParkPrice()
    {
        updateBalance(-currentPlanet.getPerTurnParkingPrice());
    }

    public void updateBalance(double amount)
    {
        currentMoney += amount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Action play(GameContext context)
    {
        System.out.println(blackText+redBackground+name+"'s turn"+normalText+normalBackground);
        GameChecker.playerMoneyStateChecker(this);
        spaceShip.decayedList();
        MyGameContext myGameContext = (MyGameContext) context;
        myGameContext.printMoves();

        int input = myGameContext.getInput(4);
        if (input == 0)
        {
            return new NoAction().noAction(this);
        }
        else if (input == 1)
        {
            System.out.println(actionText(getCurrentPlanet().getMarket().toString()));
            System.out.println(buyText("Which commodity will you buy?"));
            input = myGameContext.getInput(getCurrentPlanet().getMarket().getSupplies().size()-1);

            return new MarketBuyAction().buySupplyAction(this,input);
        }
        else if(input == 2)
        {
            return new MarketSellAction().sellCargoAction(this);
        }
        else if(input == 3)
        {
          return new BuyFuelAction().buyFuelAction(this);
        }
        else if(input == 4)
        {
            return new TravelAction().travelAction(this);
        }
        return new NullAction();
    }

    @Override
    public void prepareForGame(GameContext context)
    {
        System.out.println(blueText+name+"'s turn"+normalText);
        MyGameContext myGameContext = (MyGameContext) context;
        Hangar hangar =  myGameContext.getGalaxy().getHangar();
        System.out.println(actionText("!!Please enter  index to buy a spaceship."));
        System.out.println(displayList(hangar.toString()));
        int input = myGameContext.getInput(hangar.getSpaceShips().size()-1);
        hangar.buy(input,this);
        hangar.getSpaceShips().remove(input);
    }

    @Override
    public String toString() {
        String spaceshipName;
            if (spaceShip == null){
                spaceshipName = "No SpaceShip";
                return "Player{" +
                        "name='" + name + '\'' +
                        ", currentMoney=" + currentMoney +
                        ", spaceShip=" + spaceshipName+
                        ", currentPlanet=" + currentPlanet .getName()+
                        '}';
            }
            else
            {
                return "Player{" +
                        "name='" + name + '\'' +
                        ", currentMoney=" + currentMoney +
                        ", spaceShip=" + spaceShip.getName()+
                        ", currentPlanet=" + currentPlanet .getName()+
                        '}';
            }
    }

    public SpaceShip getSpaceShip() {
        return spaceShip;
    }

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public double getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(double currentMoney) {
        this.currentMoney = currentMoney;
    }

    public void buySpaceShip(SpaceShip spaceShip){
        this.spaceShip = spaceShip;
        this.setCurrentMoney(getCurrentMoney()- spaceShip.getBuyPrice());
        System.out.println(buyText("Spaceship "+ spaceShip.getName() + " has  been sold for " + spaceShip.getBuyPrice() + " to "+ getName()));
    }

}