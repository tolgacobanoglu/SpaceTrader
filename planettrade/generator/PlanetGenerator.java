package project.gameengine.planettrade.generator;

import project.gameengine.planettrade.model.Planet;
import project.gameengine.planettrade.util.random.Random;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlanetGenerator
{
    private static final List<String> names = List.of("Mars", "Venus", "Uranus", "Neptune", "Jupiter", "Saturn", "Earth");
    private static final List<String> createdNames = new ArrayList<>();
    private static final List<Integer> distanceToCenter = List.of(1,5,8,13,9,4,6);

    private static String randomName() {
        String generatedName = differenceList().get(Random.randomInteger(0, differenceList().size() - 1));
        createdNames.add(generatedName);
        return generatedName;
    }

    private static List<String> differenceList() {
        return names.stream().filter(string -> !createdNames.contains(string)).collect(Collectors.toList());
    }

    @Deprecated
    private static void resetLists(){
        createdNames.clear();
    }

    public static List<Planet> generator()
    {
        List<Planet> planets = new ArrayList<>();

        int upperLimit = 6;

        for (int i = 0; i < upperLimit; i++)
        {
            Planet planet = new Planet(randomName(),
                    Random.randomDouble(2,4 ),
                    Random.randomDouble(30, 50),distanceToCenter.get(i));

            planets.add(planet);
        }

        return planets;
    }
}
