package project.gameengine.planettrade.util.gameConstraints;

public enum Constraints
{
    AMOUNT_CONSTRAINTS(5, 10),
    UNIT_VOLUME_CONSTRAINTS(1, 3),
    BUY_PRICE_CONSTRAINTS(5, 10),
    SELL_PRICE_CONSTRAINTS(BUY_PRICE_CONSTRAINTS.MAX - 3, BUY_PRICE_CONSTRAINTS.getMAX() + 2);

    private final int MIN;
    private final int MAX;

    Constraints(int MIN, int MAX)
    {
        this.MIN = MIN;
        this.MAX = MAX;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }
}