package com.tcs.cmslogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
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

public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView name;
    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        OutputScreen(R.id.nav_prof);


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
        getMenuInflater().inflate(R.menu.user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        OutputScreen(item.getItemId());

        return true;
    }



    private void OutputScreen(int ID)
    {
        Fragment fragment=null;

        switch(ID){

            case R.id.nav_prof:
//                fragment=new Show_Profile();
//                String name2= getIntent().getStringExtra("name");

                Intent i3=new Intent(this,Show_Profile.class);
//                i3.putExtra("name",name2);
                startActivity(i3);
                break;
            case R.id.nav_add:
                String name1= getIntent().getStringExtra("name");
                if(!loginDataBaseAdapter.inComplaint(name1)){
                    Intent i=new Intent(this,Add_Complaint.class);
                    i.putExtra("name",name1);
                    startActivity(i);
                }
                else{
                    Toast.makeText(this,"You already have a pending complaint",Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.nav_view:
                String name= getIntent().getStringExtra("name");
                if(loginDataBaseAdapter.inComplaint(name)){
                    Intent i1 = new Intent(this,ViewComp.class);
                    i1.putExtra("name",name);
                    startActivity(i1);
                } else{
                    Toast.makeText(this,"You have not added a complaint yet!",Toast.LENGTH_LONG).show();
                }

                break;

            case R.id.nav_change:
                fragment=new Chane_Password();
                break;
            case R.id.nav_logout:
                logout();
                break;


        }
        if(fragment!=null){
            FragmentTransaction ftrans= getSupportFragmentManager().beginTransaction();
            ftrans.replace(R.id.content_frame,fragment);
            ftrans.commit();
        }

    }

    void logout(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(UserActivity.this);
        builder.setTitle("Confirm");
        builder.setMessage("LogOut??");
        builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(UserActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

