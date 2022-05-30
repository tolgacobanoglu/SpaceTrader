package project.gameengine.planettrade.model;

public class Commodity {
    private final String name;
    private final double unitVolume;
    private final double decayRatio;

    public Commodity(String name, double unitVolume, double decayRatio)
    {
        this.name = name;
        this.unitVolume = unitVolume;
        this.decayRatio = decayRatio;
    }

    public String getName()
    {
        return name;
    }

    public double getUnitVolume()
    {
        return unitVolume;
    }

    public double getDecayRatio()
    {
        return decayRatio;
    }


    @Override
    public String toString()
    {
        return "Commodity [name="+name+",unit volume="+unitVolume+",decay ratio="+decayRatio+"]";
    }
}
