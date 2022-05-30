package project.gameengine.planettrade.model;

import project.gameengine.planettrade.generator.PlanetGenerator;

import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class BlackHole
{
        public Galaxy explode()
        {
            System.out.println(blackBackground+redText+"BlackHole is exploding !!!"+normalBackground+normalText);
            Galaxy galaxy = new Galaxy();
            galaxy.setPlanets(PlanetGenerator.generator());

            return galaxy;
        }
}