package project.gameengine.planettrade.model;

import project.gameengine.planettrade.generator.SpaceShipGenerator;

import java.util.List;

public class Hangar {

    private List<SpaceShip> spaceShips;

    public Hangar() {
        this.spaceShips = SpaceShipGenerator.generator();
    }

    List<SpaceShip> getSpaceShips()
    {
        return spaceShips;
    }

    @Override
    public String toString() {
        String x = "Hangar has...\n";

        for (int i = 0; i < spaceShips.size(); i++) {
            x += "["+i +"]"+ spaceShips.get(i).toString();
        }
        x+="-------------------------------------------------------------------------------------------------------";
        return  x;
    }

    public void buy(int index, Player player)
    {
        player.buySpaceShip(spaceShips.get(index));
    }

}
