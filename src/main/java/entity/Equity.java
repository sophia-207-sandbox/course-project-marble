package entity;

public class Equity {

    private String holdingName;
    private final double value;

    public Equity(String holdingName, double value){
        this.holdingName = holdingName;
        this.value = value;
    }

    public double getValue(){return this.value;}


}
