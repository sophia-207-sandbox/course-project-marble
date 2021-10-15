package entity;

public class Debt extends Equity {


    public Debt(String holdingName, double value) {
        super(holdingName, -value);
    }
}
