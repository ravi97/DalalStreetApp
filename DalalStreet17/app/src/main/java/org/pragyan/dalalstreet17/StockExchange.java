package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

    MaterialBetterSpinner companySpinner;

    TextInputLayout noOfStocksInput;
    EditText noOfStocks;

    TextView stockValue;

    Button buy;

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

        companySpinner=(MaterialBetterSpinner)rootView.findViewById(R.id.company_spinner_exchange);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,getResources().getStringArray(R.array.companies));
        companySpinner.setAdapter(arrayAdapter);
        companySpinner.setSelection(0);

        buy=(Button)rootView.findViewById(R.id.buy_exchange);
        stockValue=(TextView)rootView.findViewById(R.id.stock_price_current);

        noOfStocks=(EditText)rootView.findViewById(R.id.stocks_exchange);
        noOfStocksInput=(TextInputLayout)rootView.findViewById(R.id.stocks_exchange_input);

        final String stock_price="Stock price : ";

        companySpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (adapterView.getItemAtPosition(i).toString()){
                    case "Github":
                        stockValue.setText(stock_price+String.valueOf(github_value));
                        break;
                    case "Apple":
                        stockValue.setText(stock_price+String.valueOf(apple_value));
                        break;
                    case "Yahoo":
                        stockValue.setText(stock_price+String.valueOf(yahoo_value));
                        break;
                    case "HDFC":
                        stockValue.setText(stock_price+String.valueOf(hdfc_value));
                        break;
                    case "LG":
                        stockValue.setText(stock_price+String.valueOf(lg_value));
                        break;
                    case "Sony":
                        stockValue.setText(stock_price+String.valueOf(sony_value));
                        break;
                    case "Infosys":
                        stockValue.setText(stock_price+String.valueOf(infosys_value));
                        break;

                }
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(companySpinner.getText().toString().trim().isEmpty()){
                    Toast.makeText(getActivity(), "Select a company", Toast.LENGTH_SHORT).show();
                    noOfStocksInput.setErrorEnabled(false);
                }
                else if(noOfStocks.getText().toString().trim().isEmpty()){
                    noOfStocksInput.setError("enter the number of stocks");
                }
                else {
                    noOfStocksInput.setErrorEnabled(false);
                    Toast.makeText(getActivity(), "stocks bought", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return rootView;
    }

}
