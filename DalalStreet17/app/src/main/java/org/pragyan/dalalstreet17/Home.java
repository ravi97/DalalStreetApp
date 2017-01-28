package org.pragyan.dalalstreet17;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    CompanyAdapter adapter;
    List<Company> companyList;

    TextView username,cashWorth,stockWorth;
    String cash,stock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        username=(TextView)findViewById(R.id.name_display);
        cashWorth=(TextView)findViewById(R.id.cash_worth);
        stockWorth=(TextView)findViewById(R.id.stock_worth);

        Intent i=getIntent();
        username.setText("Welcome "+i.getStringExtra("username")+" !");

        cash="500";  //hardcoded
        stock="250"; //hardcoded
        cashWorth.setText("Cash worth : "+cash);
        stockWorth.setText("Stock worth :"+stock);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        companyList=new ArrayList<>();
        prepareCompany();
        adapter= new CompanyAdapter(this,companyList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.action_help:
                help();
                return true;
            case R.id.action_logout:
                logout();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void help(){
        Toast.makeText(this, "you pressed help", Toast.LENGTH_SHORT).show();
        //show help here
    }

    public void logout(){
        Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_exchange:
                Toast.makeText(this, "stock exchange", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_mortgage:
                Toast.makeText(this, "Mortgage", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_transactions:
                Toast.makeText(this, "Transactions", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_portfolio:
                Toast.makeText(this, "Portfolio", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_news:
                Toast.makeText(this, "News", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_performance:
                Toast.makeText(this, "Performance", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.nav_depth:
                Toast.makeText(this, "Market depth", Toast.LENGTH_SHORT).show();
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
