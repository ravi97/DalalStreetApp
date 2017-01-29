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

    MaterialBetterSpinner materialBetterSpinner;
    TextView stockPrice;
    RadioButton defultButton;
    TextInputLayout noOfStocksInput,minimumInput,stoplossInput;
    EditText noOfStocks,minimum,stoploss;
    Button bidOrAsk;

    int github_value,apple_value,yahoo_value,hdfc_value,lg_value,sony_value,infosys_value;;

    int stockNumber,stoplossNumber,minOrMax;

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


        materialBetterSpinner=(MaterialBetterSpinner)rootView.findViewById(R.id.stock_exchange_spinner);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.companies));
        materialBetterSpinner.setAdapter(arrayAdapter);

        bidOrAsk=(Button)rootView.findViewById(R.id.bid_ask);

        noOfStocks=(EditText)rootView.findViewById(R.id.no_of_stocks);
        minimum=(EditText)rootView.findViewById(R.id.minimum);
        stoploss=(EditText)rootView.findViewById(R.id.stoploss);

        noOfStocksInput=(TextInputLayout)rootView.findViewById(R.id.no_of_stocks_input);
        minimumInput=(TextInputLayout)rootView.findViewById(R.id.minimum_input);
        stoplossInput=(TextInputLayout)rootView.findViewById(R.id.stoploss_input);

        defultButton=(RadioButton)rootView.findViewById(R.id.radioButton_bid);
        defultButton.setChecked(true);

        defultButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    bidOrAsk.setText("Bid");
                }
                else{
                    bidOrAsk.setText("Ask");

                }
            }
        });



        bidOrAsk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(materialBetterSpinner.getText().toString().trim().isEmpty()){
                    Toast.makeText(getActivity(), "select a company", Toast.LENGTH_SHORT).show();
                }
                else if(noOfStocks.getText().toString().trim().isEmpty()){
                    noOfStocksInput.setError("enter the number of stocks");
                }
                else if (minimum.getText().toString().trim().isEmpty()){
                    noOfStocksInput.setErrorEnabled(false);
                    if(defultButton.isChecked())
                        minimumInput.setError("enter the bid value");
                    else
                        minimumInput.setError("enter the ask value");
                }
                else if(stoploss.getText().toString().trim().isEmpty()){
                    minimumInput.setErrorEnabled(false);
                    stoplossInput.setError("enter the stoploss order");
                }
                else{
                    stoplossInput.setErrorEnabled(false);
                    Toast.makeText(getActivity(), "transaction added", Toast.LENGTH_SHORT).show();
                }


            }
        });

        return rootView;
    }

}
