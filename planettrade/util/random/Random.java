package project.gameengine.planettrade.util.random;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;

public class Random
{
    public static int randomInteger(int min, int limit)
    {
        SecureRandom secureRandom = new SecureRandom();
        int randInteger = secureRandom.nextInt(limit-min) + min;

        return randInteger;
    }

    public static double randomDouble(double min,double limit)
    {
        SecureRandom secureRandom = new SecureRandom();
        double randDouble = secureRandom.nextDouble(limit -min) + min;
        BigDecimal randomNumber=new BigDecimal(randDouble).setScale(2, RoundingMode.HALF_UP);
        randDouble = randomNumber.doubleValue();
        return randDouble;
    }

    public static double secureRandomDouble(int min,int limit,double defaultValue)
    {
        SecureRandom secureRandom = new SecureRandom();
        double randDouble = secureRandom.nextDouble(limit-min-defaultValue) + min + defaultValue;
        BigDecimal randomNumber=new BigDecimal(randDouble).setScale(2, RoundingMode.HALF_UP);
        randDouble = randomNumber.doubleValue();
        return randDouble;
    }

}
