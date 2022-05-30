package project.gameengine.planettrade.generator;

import project.gameengine.planettrade.model.Commodity;
import project.gameengine.planettrade.util.gameConstraints.Constraints;
import project.gameengine.planettrade.util.random.Random;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommodityGenerator {

    private static final List<String> names = List.of("Apple", "Pineapple", "Lemon", "Cucumber", "Potato", "Garlic", "Melon", "Banana");

    private static final List<String> marketList = new ArrayList<>();


    private static String randomName() {
        String generatedName = differenceList().get(Random.randomInteger(1, differenceList().size() - 1));
        marketList.add(generatedName);
        return generatedName;
    }

    private static List<String> differenceList()
    {
        return names.stream().filter(string -> !marketList.contains(string)).collect(Collectors.toList());
    }

    public static void resetLists(){
        marketList.clear();
    }

    public static Commodity generate() {
        return new Commodity(
                randomName(),
                Random.randomDouble(Constraints.UNIT_VOLUME_CONSTRAINTS.getMIN(), Constraints.UNIT_VOLUME_CONSTRAINTS.getMAX()),
                Random.randomDouble(0.05, 0.15)
        );
    }
}
