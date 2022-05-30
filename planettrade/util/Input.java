package project.gameengine.planettrade.util;

import java.util.NoSuchElementException;
import java.util.Scanner;
import static project.gameengine.planettrade.util.colorfuloutput.ColorfulGameRenderer.*;

public class Input
{
    private final Scanner scanner = new Scanner(System.in);

    public int getInput(int bound)
    {
        int choice ;
        try
        {
             choice = scanner.nextInt();
            if (choice > bound || choice < 0)
            {
                System.out.println(blackBackground+redText+"Please enter valid input"+normalBackground+normalText);
                getInput(bound);
            }
            return choice;
        }
        catch (NoSuchElementException e)
        {
            throw new IndexOutOfBoundsException("Over Bound: "+bound );
        }
    }

}