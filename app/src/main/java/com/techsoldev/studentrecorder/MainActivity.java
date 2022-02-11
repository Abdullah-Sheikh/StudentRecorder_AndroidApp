package com.techsoldev.studentrecorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Slide;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.techsoldev.studentrecorder.fragments.CoursesFragment;
import com.techsoldev.studentrecorder.fragments.SectionsFragment;
import com.techsoldev.studentrecorder.fragments.StudentsFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Methods.CHECK_THEME==-1) {
            switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                case Configuration.UI_MODE_NIGHT_YES:
                    setTheme(R.style.DarkTheme);
                    Methods.CHECK_THEME = 1;
                    break;
                case Configuration.UI_MODE_NIGHT_NO:
                    setTheme(R.style.LightTheme);
                    Methods.CHECK_THEME = 0;
                    break;
            }
        }
        else if(Methods.CHECK_THEME==0) {
            setTheme(R.style.LightTheme);

        }
        else  if(Methods.CHECK_THEME==1) {

            setTheme(R.style.DarkTheme);

        }
        // setTheme(R.style.DarkTheme);
        setContentView(R.layout.activity_main);

        setupWindowAnimations();


        BottomNavigationView navigationView = findViewById(R.id.navigation_view_id);
        navigationView.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new CoursesFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId())
                    {
                        case R.id.course_id:
                            Drawable unwrappedDrawable = AppCompatResources.getDrawable(MainActivity.this, R.drawable.ic_course);
                            Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
                            DrawableCompat.setTint(wrappedDrawable, Color.BLUE);
                            selectedFragment = new CoursesFragment();
                            break;
                        case R.id.student_id:
                            selectedFragment = new StudentsFragment();
                            break;
                        case R.id.section_id:
                            selectedFragment = new SectionsFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };



    private void setupWindowAnimations() {
        Slide slide = new Slide();

        slide.setDuration(1000);
        getWindow().setExitTransition(slide);
    }
}