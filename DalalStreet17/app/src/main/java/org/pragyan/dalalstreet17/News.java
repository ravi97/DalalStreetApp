package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
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
public class News extends Fragment {

    RecyclerView recyclerView;
    NewsAdapter adapter;
    List<NewsDetails> newsList;


    public News() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView=inflater.inflate(R.layout.fragment_news, container, false);

        getActivity().setTitle("News");

        recyclerView=(RecyclerView)rootView.findViewById(R.id.news_view);
        prepareNews();
        adapter=new NewsAdapter(getActivity(),newsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


        return rootView;
    }

    public void prepareNews(){
        newsList=new ArrayList<>();
        newsList.clear();

        newsList.add(new NewsDetails("aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("bbbbb","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb"));
        newsList.add(new NewsDetails("ccccc","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("ddddd","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("eeeee","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("fffff","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("ggggg","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("hhhhh","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("iiiii","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        newsList.add(new NewsDetails("jjjjj","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
