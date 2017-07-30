package com.tcs.cmslogin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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
    user users;
    String name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);

        users= new user();

        users.setName(getIntent().getStringExtra("name"));
        users.setPassword(getIntent().getStringExtra("pass"));
        Intent i = this.getIntent();
        name1= i.getStringExtra("name");
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        OutputScreen(R.id.nav_prof);
        getFragmentManager().beginTransaction().replace(R.id.content_frame,new com.tcs.cmslogin.Show_Profile1()).commit();



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

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
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
        int id = item.getItemId();

        if (id == R.id.nav_prof) {

            getFragmentManager().beginTransaction().replace(R.id.content_frame,new com.tcs.cmslogin.Show_Profile1()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_add) {
            if(!loginDataBaseAdapter.inComplaint(name1)){
                getFragmentManager().beginTransaction().replace(R.id.content_frame,new Add_Comp()).commit();

            }else{
                    Toast.makeText(this,"You already have a pending complaint",Toast.LENGTH_LONG).show();
                }

        } else if (id == R.id.nav_view) {
            if(loginDataBaseAdapter.inComplaint(name1)){
//
                getFragmentManager().beginTransaction().replace(R.id.content_frame,new View_Comp()).commit();

                } else{
                    Toast.makeText(this,"You have not added a complaint yet!",Toast.LENGTH_LONG).show();
                }
        }


        else if (id == R.id.nav_change) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new Chane_password1()).commit();
        }
        else if (id == R.id.nav_logout) {

            getFragmentManager().beginTransaction().replace(R.id.content_frame,new Logout1()).commit();

//            logout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
//


//        return true;
    }

//    private void OutputScreen(int ID)
//    {
//        Fragment fragment=null;
//
//        switch(ID){
//
//            case R.id.nav_prof:
//                fragment=new Show_Profile1();
//
////                String name2= getIntent().getStringExtra("name");
////                Intent i3=new Intent(this,Show_Profile1.class);
////                i3.putExtra("name",name2);
////                startActivity(i3);
//
//                break;
//            case R.id.nav_add:
//                String name1= getIntent().getStringExtra("name");
//                if(!loginDataBaseAdapter.inComplaint(name1)){
//                    Intent i=new Intent(this,Add_Complaint.class);
//                    i.putExtra("name",name1);
//                    startActivity(i);
//                }
//                else{
//                    Toast.makeText(this,"You already have a pending complaint",Toast.LENGTH_LONG).show();
//                }
//
//                break;
//            case R.id.nav_view:
//                String name= getIntent().getStringExtra("name");
//                if(loginDataBaseAdapter.inComplaint(name)){
//                    Intent i1 = new Intent(this,ViewComp.class);
//                    i1.putExtra("name",name);
//                    startActivity(i1);
//                } else{
//                    Toast.makeText(this,"You have not added a complaint yet!",Toast.LENGTH_LONG).show();
//                }
//
//                break;
//
//            case R.id.nav_change:
////                getFragmentManager().beginTransaction().replace(R.id.content_frame,new Chane_Password()).commit();
////                fragment=new Chane_Password();
//                Intent i4 = new Intent(this,Chane_Password.class);
//                i4.putExtra("name",users.getName());
//                i4.putExtra("pass",users.getPassword());
////                Log.d("AAA",users.getName());
////                Log.d("AAA",users.getPassword());
//
//                startActivity(i4);
//                break;
//            case R.id.nav_logout:
//                logout();
//                break;
//
//
//        }
//        if(fragment!=null){
//            FragmentTransaction ftrans= getSupportFragmentManager().beginTransaction();
//            ftrans.replace(R.id.content_frame,fragment);
//            ftrans.commit();
//        }
//
//    }

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

