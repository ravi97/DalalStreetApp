package org.pragyan.dalalstreet17;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ravi on 11/2/17.
 */

public class LeaderboardAdapter extends BaseAdapter {

    ArrayList<LeaderboardDetails> leaderboardDetails;
    Context context;
    LayoutInflater inflater=null;

    public LeaderboardAdapter(ArrayList<LeaderboardDetails> leaderboardDetails, Context context) {
        this.leaderboardDetails = leaderboardDetails;
        this.context = context;
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return leaderboardDetails.size();
    }

    @Override
    public Object getItem(int i) {
        return leaderboardDetails.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class RowData{
        TextView rank;
        TextView name;
        TextView wealth;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RowData data=new RowData();
        View rowView;
        rowView=inflater.inflate(R.layout.leaderboard_list,null);

        data.name=(TextView)rowView.findViewById(R.id.name_list);
        data.name.setText(leaderboardDetails.get(i).getName());
        data.rank=(TextView)rowView.findViewById(R.id.rank_list);
        data.rank.setText(String.valueOf(leaderboardDetails.get(i).getRank()));
        data.wealth=(TextView)rowView.findViewById(R.id.wealth_list);
        data.wealth.setText(String.valueOf(leaderboardDetails.get(i).getTotal_wealth()));



        return rowView;
    }
}
