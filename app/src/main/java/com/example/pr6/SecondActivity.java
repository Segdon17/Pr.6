package com.example.pr6;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.tab1) {
                loadFragment(new Tab1Fragment());
                getSupportActionBar().setTitle("Room");
            } else if (id == R.id.tab2) {
                loadFragment(new Tab2Fragment());
                getSupportActionBar().setTitle("Field");
            } else if (id == R.id.tab3) {
                loadFragment(new Tab3Fragment());
                getSupportActionBar().setTitle("Bush");
            }
            return true;

        });

        // Fragment inicial
        if (savedInstanceState == null) {
            loadFragment(new Tab1Fragment());
            getSupportActionBar().setTitle("Room");
        }
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }

}
