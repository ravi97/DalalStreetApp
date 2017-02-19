package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Transactions extends Fragment {

    RecyclerView transactionView;
    TransactionAdapter adapter;
    List<TransactionDetails> transactionList;


    public Transactions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView=inflater.inflate(R.layout.fragment_transactions, container, false);

        getActivity().setTitle("Transactions");

        transactionView=(RecyclerView)rootView.findViewById(R.id.transactions_view);
        prepareTransactions();
        adapter=new TransactionAdapter(getActivity(),transactionList);
        transactionView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        transactionView.setItemAnimator(new DefaultItemAnimator());
        transactionView.setAdapter(adapter);

        return rootView;
    }


    public void prepareTransactions(){
        transactionList=new ArrayList<TransactionDetails>();
        transactionList.clear();

        transactionList.add(new TransactionDetails("10:00","Mortgage","Github",50,43));
        transactionList.add(new TransactionDetails("11:00","Exchange","Github",50,43));
        transactionList.add(new TransactionDetails("12:00","Mortgage","Github",50,43));
        transactionList.add(new TransactionDetails("12:01","Market","Github",50,43));
        transactionList.add(new TransactionDetails("12:02","Exchange","Github",50,43));

    }

}
