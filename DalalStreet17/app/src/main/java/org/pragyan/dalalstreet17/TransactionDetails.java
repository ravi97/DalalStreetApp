package org.pragyan.dalalstreet17;


public class TransactionDetails {

    private String type;
    private String company;
    private int noOfStocks;
    private float stockPrice;
    private String time;

    public TransactionDetails(String time, String type, String company, int noOfStocks, float stockPrice) {
        this.time = time;
        this.type = type;
        this.company = company;
        this.noOfStocks = noOfStocks;
        this.stockPrice = stockPrice;
    }

    public TransactionDetails() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getNoOfStocks() {
        return noOfStocks;
    }

    public void setNoOfStocks(int noOfStocks) {
        this.noOfStocks = noOfStocks;
    }

    public float getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
