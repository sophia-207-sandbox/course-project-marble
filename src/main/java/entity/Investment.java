package entity;

public class Investment extends Equity{
    private final double yearlyGrowth;
    private int numShares;


    public Investment(String holdingName,  double value, double yearlyGrowth, int numShares) {
        super(holdingName, value);
        this.yearlyGrowth = yearlyGrowth;
        this.numShares = numShares;
    }


}
