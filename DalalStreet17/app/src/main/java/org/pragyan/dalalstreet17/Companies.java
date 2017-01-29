package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.sax.RootElement;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Companies extends Fragment {


    RecyclerView recyclerView;
    CompanyAdapter adapter;
    List<Company> companyList;

    TextView username,cashWorth,stockWorth;
    String cash,stock,name;


    public Companies() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView=inflater.inflate(R.layout.fragment_companies, container, false);

        username=(TextView) rootView.findViewById(R.id.name_display);
        cashWorth=(TextView)rootView.findViewById(R.id.cash_worth);
        stockWorth=(TextView)rootView.findViewById(R.id.stock_worth);

        name="abc"; //hardcoded
        cash="500";  //hardcoded
        stock="250"; //hardcoded

        username.setText("Welcome "+name+ "!");
        cashWorth.setText("Cash worth : "+cash);
        stockWorth.setText("Stock worth :"+stock);

        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        companyList=new ArrayList<>();
        prepareCompany();
        adapter= new CompanyAdapter(getActivity(),companyList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        getActivity().setTitle("Home");

        return rootView;
    }

    public void prepareCompany(){
        companyList.add(new Company("Github",String.valueOf(50),R.drawable.github2,R.drawable.down_arrow));
        companyList.add(new Company("Apple",String.valueOf(100),R.drawable.apple,R.drawable.up_arrow));
        companyList.add(new Company("Yahoo",String.valueOf(125),R.drawable.yahoo2,R.drawable.down_arrow));
        companyList.add(new Company("HDFC",String.valueOf(95),R.drawable.hdfc3,R.drawable.down_arrow));
        companyList.add(new Company("lg",String.valueOf(110),R.drawable.lg2,R.drawable.up_arrow));
        companyList.add(new Company("Sony",String.valueOf(50),R.drawable.sony,R.drawable.down_arrow));
        companyList.add(new Company("Infosys",String.valueOf(50),R.drawable.infosys,R.drawable.down_arrow));
    }

}
