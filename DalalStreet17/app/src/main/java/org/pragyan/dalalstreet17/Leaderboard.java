package org.pragyan.dalalstreet17;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Leaderboard extends Fragment {

    ListView listView;
    ArrayList<LeaderboardDetails> details;
    LeaderboardAdapter leaderboardAdapter;


    TextView name,rank,wealth;


    public Leaderboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_leaderboard, container, false);
        getActivity().setTitle("Leaderboard");

        listView=(ListView) rootView.findViewById(R.id.leaderboard_display);
        populateLeaderboard();
        leaderboardAdapter=new LeaderboardAdapter(details,getActivity());
        listView.setAdapter(leaderboardAdapter);

        name=(TextView)rootView.findViewById(R.id.name_list);
        rank=(TextView)rootView.findViewById(R.id.rank_list);
        wealth=(TextView)rootView.findViewById(R.id.wealth_list);
        name.setText("your name");
        rank.setText("8");
        wealth.setText("3500");

        return rootView;
    }

    public void populateLeaderboard(){
        details=new ArrayList<>();

        details.add(new LeaderboardDetails(1,"aaa",5000));
        details.add(new LeaderboardDetails(2,"bbb",4500));
        details.add(new LeaderboardDetails(3,"ccc",4400));
        details.add(new LeaderboardDetails(4,"ddd",4300));
        details.add(new LeaderboardDetails(5,"eee",4200));
        details.add(new LeaderboardDetails(6,"fff",4200));
        details.add(new LeaderboardDetails(7,"ggg",4200));
        details.add(new LeaderboardDetails(8,"hhh",4200));
        details.add(new LeaderboardDetails(9,"iii",4200));
        details.add(new LeaderboardDetails(10,"jjj",4200));




    }

}
