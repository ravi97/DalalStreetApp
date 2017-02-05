package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class StockExchange extends Fragment {


    int github_value,apple_value,yahoo_value,hdfc_value,lg_value,sony_value,infosys_value;;


    public StockExchange() {


        github_value=50; //hardcoded
        apple_value=40; //hardcoded
        yahoo_value=30; //hardcoded
        hdfc_value=60; //hardcoded
        lg_value=70; //hardcoded
        sony_value=45; //hardcoded
        infosys_value=55; //hardcoded
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_stock_exchange, container, false);

        getActivity().setTitle("Stock Exchange");






        return rootView;
    }

}
