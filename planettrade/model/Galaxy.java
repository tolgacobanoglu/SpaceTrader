package project.gameengine.planettrade.model;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {

        private List<Planet> planets = new ArrayList<>();
        private final Hangar hangar = new Hangar();

        public void displayPlanets(){
                planets.forEach(System.out::println);
        }

        public List<Planet> getPlanets() {
                return planets;
        }

        public String getPlanetsName()
        {
                String content = "";
                for (int i = 0; i < planets.size(); i++)
                {
                        content+="["+(i+1)+"] ";
                        content+=planets.get(i).getName();
                        content+="\n";
                }
                return content;
        }

        public void setPlanets(List<Planet> planets) {
                this.planets = planets;
        }

        public Hangar getHangar() {
                return hangar;
        }
}
