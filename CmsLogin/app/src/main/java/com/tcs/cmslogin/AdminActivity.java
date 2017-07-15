package com.tcs.cmslogin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class AdminActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
=======
<<<<<<< HEAD
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
=======
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
<<<<<<< HEAD
        });
=======
<<<<<<< HEAD
        });*/
=======
        });
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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
        getMenuInflater().inflate(R.menu.admin, menu);
        return true;
    }

<<<<<<< HEAD
=======
<<<<<<< HEAD
    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
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
        int id = item.getItemId();

        if (id == R.id.nav_view_complaints) {

            getFragmentManager().beginTransaction().replace(R.id.content_frame,new ViewComplaints()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_edit_engineer_details) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new EditEngineerDetails()).commit();

<<<<<<< HEAD
=======
<<<<<<< HEAD
        } else if (id == R.id.nav_add_engineer_details) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new AddEngineerDetails()).commit();
        }

        else if (id == R.id.nav_assign_complaints) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new AssignComplaints()).commit();
        }
         else if (id == R.id.nav_change_password) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new ChangePassword()).commit();
        }
        else if (id == R.id.nav_logout) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new Logout()).commit();
       }
=======
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60
        } else if (id == R.id.nav_assign_complaints) {
            getFragmentManager().beginTransaction().replace(R.id.content_frame,new AssignComplaints()).commit();
        }
         else if (id == R.id.nav_change_password) {

        } //else if (id == R.id.nav_send) {

       // }
<<<<<<< HEAD
=======
>>>>>>> 98b49386e5af71666507a0a2b6b99263b99d4c7b
>>>>>>> 8af09e25c21a0eeb51c1f2e971df6bb50bfa8f60

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
