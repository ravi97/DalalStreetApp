package org.pragyan.dalalstreet17;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

    TextView username;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headView=navigationView.inflateHeaderView(R.layout.nav_header_home);

        displaySelectedScreen(R.id.nav_home);

        name="username";

        username=(TextView)headView.findViewById(R.id.username);
        username.setText(name);
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



    public void logout(){
        Toast.makeText(this, "logged out", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
        finish();
    }

    public void displaySelectedScreen(int id){

        Fragment fragment=null;


        switch (id) {
            case R.id.nav_home:
                fragment=new Companies();
                break;
            case R.id.nav_exchange:
                fragment=new StockExchange();
                break;
            case R.id.nav_company_profile:
                fragment=new CompanyProfile();
                break;
            case R.id.nav_news:
                fragment=new News();
                break;
            case R.id.nav_buy_sell:
                fragment=new BuySell();
                break;
            case R.id.nav_mortgage:
                fragment=new Mortgage();
                break;
            case R.id.nav_my_orders:
                fragment=new MyOrders();
                break;
            case R.id.nav_transactions:
                fragment=new Transactions();
                break;
            case R.id.nav_portfolio:
                fragment=new Portfolio();
                break;
            case R.id.nav_leaderboard:
                fragment=new Leaderboard();
                break;

        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_home, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        displaySelectedScreen(item.getItemId());

        return true;
    }

    public void help(){
        LayoutInflater inflater= LayoutInflater.from(this);
        View view=inflater.inflate(R.layout.help_box, null);
        View view2=inflater.inflate(R.layout.help_title,null);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setCustomTitle(view2);
        alertDialog.setView(view);
        alertDialog.setCancelable(true);
        AlertDialog alert = alertDialog.create();
        alert.show();
    }




}
