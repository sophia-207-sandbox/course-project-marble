package entity;

import java.util.ArrayList;

public class Portfolio {

    private final ArrayList<Investment> investmentList;
    private final ArrayList<Equity> equityList;
    private String portfolioName;

    public Portfolio(String portfolioName){
        this.investmentList = new ArrayList<Investment>();
        this.equityList = new ArrayList<Equity>();
        this.portfolioName = portfolioName;
    }

    public boolean addEquity(Equity newEquity){
        this.equityList.add(newEquity);
        return true;
    }

    public boolean removeEquity(Equity equity){
        this.equityList.remove(equity);
        return true;
    }

    public boolean addInvestment(Investment newinvestment){
        this.investmentList.add(newinvestment);
        return true;
    }

    public boolean removeInvestment(Investment investment){
        this.investmentList.remove(investment);
        return true;
    }

    public ArrayList<Equity> getEquityList(){return this.equityList;}

    public ArrayList<Investment> getInvestmentList(){return this.investmentList;}

}
