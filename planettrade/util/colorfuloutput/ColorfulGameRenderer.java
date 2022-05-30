package project.gameengine.planettrade.util.colorfuloutput;

import project.gameengine.base.Game;
import project.gameengine.base.GameRenderer;

import java.util.List;

public class ColorfulGameRenderer implements GameRenderer {

        public ColorfulGameRenderer(){}

        //Output background colour codes
        public static final String normalBackground = "\u001B[0m";
        public static final String blackBackground = "\u001B[40m";
        public static final String redBackground = "\u001B[41m";
        public static final String greenBackground = "\u001B[42m";
        public static final String yellowBackground = "\u001B[43m";
        public static final String blueBackground = "\u001B[44m";
        public static final String purpleBackground = "\u001B[45m";
        public static final String cyanBackground = "\u001B[46m";
        public static final String whiteBackground = "\u001B[47m";

        //Text colour codes
        public static final String normalText = "\u001B[0m";
        public static final String blackText = "\u001B[30m";
        public static final String yellowText = "\u001B[33m";
        public static final String redText = "\u001B[31m";
        public static final String greenText = "\u001B[32m";
        public static final String whiteText = "\u001B[37m";
        public static final String blueText = "\u001B[34m";
        public static final String cyanText = "\u001B[36m";
        public static final String purpleText = "\u001B[35m";

        public static String buyText(String text)
        {
                return redText+text+normalText;
        }

        public static String sellText(String text)
        {
                return greenText+text+normalText;
        }

        public static String warningText(String text)
        {
                return blackBackground+redText+text+normalBackground+normalText;
        }

        public static String actionText(String text)
        {
                return purpleText+text+normalText;
        }

        public static String displayList(List<?> list)
        {
                return cyanText+list.toString()+normalText;
        }

        //It takes a parameter as list.toString
        public static String displayList(String text)
        {
                return cyanText+text+normalText;
        }

        @Override
        public void render(Game game) {
                System.out.println(blueText+game+normalText);
        }
}