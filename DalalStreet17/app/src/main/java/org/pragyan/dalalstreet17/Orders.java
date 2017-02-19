package org.pragyan.dalalstreet17;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi on 18/2/17.
 */

public class Orders {

    private Context context;

    private String orderType;
    private boolean bid;
    private int orderPrice;
    private String company;
    private String status;

    private int[] noOfStocks;
    private String[] price;


    public Orders(Context context, String orderType, boolean bid, int orderPrice, String company, String status, int[] noOfStocks, String[] price) {
        this.context = context;
        this.orderType = orderType;
        this.bid = bid;
        this.orderPrice = orderPrice;
        this.company = company;
        this.status = status;
        this.noOfStocks = noOfStocks;
        this.price = price;

        //createChart();
    }

    public Orders() {
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public boolean isBid() {
        return bid;
    }

    public void setBid(boolean bid) {
        this.bid = bid;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public int[] getNoOfStocks() {
        return noOfStocks;
    }

    public void setNoOfStocks(int[] noOfStocks) {
        this.noOfStocks = noOfStocks;
    }

    public String[] getPrice() {
        return price;
    }

    public void setPrice(String[] price) {
        this.price = price;
    }


}
