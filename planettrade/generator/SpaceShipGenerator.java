package project.gameengine.planettrade.generator;

import project.gameengine.planettrade.model.SpaceShip;
import project.gameengine.planettrade.util.random.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceShipGenerator {

    private static final List<String> names = List.of("Velkoz", "Karma", "Zed", "Vayne", "Lee Sin",  "BigO", "Sigma");
    private static final List<String> createdNames = new ArrayList<>();

    private static String randomName() {
        String generatedName = differenceList().get(Random.randomInteger(0, differenceList().size()));
        createdNames.add(generatedName);
        return generatedName;
    }

    private static List<String> differenceList() {
        return names.stream().filter(string -> !createdNames.contains(string)).collect(Collectors.toList());
    }

    @Deprecated
    public static void resetLists(){
        createdNames.clear();
    }

    public static List<SpaceShip> generator()
    {
        List<SpaceShip> spaceShips = new ArrayList<>();
        int upperLimit = 5;

        for (int i = 0; i < upperLimit; i++) {

            double speed = Random.randomDouble(1,3);

            SpaceShip spaceShip = new SpaceShip(
                    randomName(),
                    Random.randomDouble(100,150),
                    30,
                    speed,
                    Random.randomDouble(100, 150),
                    Random.randomDouble(speed*1.5, speed*1.8)


                    );

            spaceShips.add(spaceShip);
        }

        return spaceShips;
    }
}

