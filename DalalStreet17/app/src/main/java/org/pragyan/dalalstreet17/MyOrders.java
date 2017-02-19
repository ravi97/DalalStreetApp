package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyOrders extends Fragment {

    RecyclerView orderView;
    OrdersAdapter adapter;


    ArrayList<Orders> orders;



    public MyOrders() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_my_orders, container, false);
        getActivity().setTitle("My Orders");

        orderView=(RecyclerView)rootView.findViewById(R.id.orders_list);
        prepareOrders();

        adapter=new OrdersAdapter(getActivity(),orders);
        orderView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        orderView.setItemAnimator(new DefaultItemAnimator());
        orderView.setAdapter(adapter);


        return rootView;
    }

    public void prepareOrders(){
        orders=new ArrayList<>();

        int[] noOfOrders={25,25,25,25};
        String[] orderPrice={"₹90","₹95","₹95","₹100"};

        orders.add(new Orders(getActivity(),"Stoploss Order",false,100,"Intel","Completed",noOfOrders,orderPrice));
        orders.add(new Orders(getActivity(),"Stoploss Order",false,100,"Intel","Completed",noOfOrders,orderPrice));


    }

}
