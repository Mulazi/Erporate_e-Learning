package com.erporate.e_learning;

import android.os.Bundle;
import android.view.MenuItem;

import com.erporate.e_learning.homepage.bookmark.BookmarkFragment;
import com.erporate.e_learning.homepage.home.HomeFragment;
import com.erporate.e_learning.homepage.notifications.NotificationsFragment;
import com.erporate.e_learning.homepage.profil.ProfilFragment;
import com.erporate.e_learning.homepage.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private  BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


            switch (menuItem.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = new HomeFragment();
                    break;

                case R.id.navigation_search:
                    selectedFragment = new SearchFragment();
                    break;


                case R.id.navigation_saved:
                    selectedFragment = new BookmarkFragment();
                    break;


                case R.id.navigation_notifications:
                    selectedFragment = new NotificationsFragment();
                    break;


                case R.id.navigation_profile:
                    selectedFragment = new ProfilFragment();
                    break;

            }
            if (selectedFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }

            return true;

        }
    };

}
