package com.example.soumit.profileapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FloatingActionButton fab;

    TabLayout tabLayout;
    ViewPager viewPager;

    NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nestedScrollView= (NestedScrollView) findViewById(R.id.nestedscrollview_id);
        nestedScrollView.setFillViewport(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.ic_star);

        fab = (FloatingActionButton) findViewById(R.id.fab_id);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello, Trump!", Snackbar.LENGTH_SHORT).show();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewpager_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new RecentsFragment(), "Recents");
        adapter.addFragment(new FavouritesFragment(), "Favourites");
        adapter.addFragment(new NearbyFragment(), "Nearby");

        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_recents);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favourites);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_account);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                Toast.makeText(this, "Settings clicked!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
