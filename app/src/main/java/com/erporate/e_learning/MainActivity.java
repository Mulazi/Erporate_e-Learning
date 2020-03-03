package com.erporate.e_learning;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.erporate.e_learning.homepage.BookmarkActivity;
import com.erporate.e_learning.homepage.HomeActivity;
import com.erporate.e_learning.homepage.NotificationsActivity;
import com.erporate.e_learning.homepage.ProfilActivity;
import com.erporate.e_learning.homepage.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeActivity()).commit();

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeActivity();
                    break;

                case R.id.navigation_search:
                    selectedFragment = new SearchActivity();
                    break;


                case R.id.navigation_saved:
                    selectedFragment = new BookmarkActivity();
                    break;


                case R.id.navigation_notifications:
                    selectedFragment = new NotificationsActivity();
                    break;


                case R.id.navigation_profile:
                    selectedFragment = new ProfilActivity();
                    break;

            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }

            return true;

        }
    };

}
