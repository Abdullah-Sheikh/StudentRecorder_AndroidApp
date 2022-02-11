package com.techsoldev.studentrecorder.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techsoldev.studentrecorder.Methods;
import com.techsoldev.studentrecorder.R;
import com.techsoldev.studentrecorder.adapters.CourseAdapter;
import com.techsoldev.studentrecorder.models.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class CoursesFragment  extends Fragment {

    private LinearLayout Theme_layer ;

    private ImageView sun_moonImg;
    private View beforeImg , afterImg;
    public static final int STARTUP_DELAY = 300;
    public static final int ANIM_ITEM_DURATION = 1000;
    public static final int ITEM_DELAY = 300;
    TextView text_input_end;

    ArrayList<Course> courses = new ArrayList<>();




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // check the Theme of App-------------------------!!!!!!!!!!!!
        if(Methods.CHECK_THEME==-1) {
            switch (getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) {
                case Configuration.UI_MODE_NIGHT_YES:
                    getActivity().setTheme(R.style.DarkTheme);
                    Methods.CHECK_THEME = 1;
                    break;
                case Configuration.UI_MODE_NIGHT_NO:
                    getActivity().setTheme(R.style.LightTheme);
                    Methods.CHECK_THEME = 0;
                    break;
            }
        }
        /*
        if(Methods.CHECK_THEME==0) {
            getActivity().setTheme(R.style.LightTheme);
        }
        else  if(Methods.CHECK_THEME==1) {
            getActivity().setTheme(R.style.DarkTheme);
        }

         */
        // end check the Theme of App-------------------------!!!!!!!!!!!!



        View v = inflater.inflate(R.layout.fragment_courses,container,false);
        Theme_layer = (LinearLayout) v.findViewById(R.id.theme_layout);
        sun_moonImg = (ImageView) v.findViewById(R.id.sun_moon_img);
        beforeImg = (View) v.findViewById(R.id.before_moon_sun_img);
        afterImg = (View) v.findViewById(R.id.after_moon_sun_img);

        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int color = typedValue.data;



        if(Methods.CHECK_THEME==0) {
            afterImg.setVisibility(View.GONE);
            beforeImg.setVisibility(View.VISIBLE);
            sun_moonImg.setImageResource(R.drawable.img_sun);
            Theme_layer.setBackgroundResource(R.drawable.day_background);
        }
        else  if(Methods.CHECK_THEME==1) {
            afterImg.setVisibility(View.VISIBLE);
            beforeImg.setVisibility(View.GONE);
            sun_moonImg.setImageResource(R.drawable.img_moon);
            Theme_layer.setBackgroundResource(R.drawable.dark_background);
        }

        Theme_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Methods.CHECK_THEME ==0)
                {
                    changeThemeDaytoNigth();
                }
                else if(Methods.CHECK_THEME ==1)
                {
                    changeThemeNigthtoDay();
                }
            }
        });

        courses.add(new Course("Mathematics", R.drawable.ic_math));
        courses.add(new Course("Chemistry", R.drawable.ic_chemistry));
        courses.add(new Course("Computer Science", R.drawable.ic_computer));
        courses.add(new Course("Science & Arts ", R.drawable.ic_arts));
        courses.add(new Course("Physics", R.drawable.ic_physics));
        courses.add(new Course("Biology", R.drawable.ic_biology));
        courses.add(new Course("General Science", R.drawable.ic_general_science));


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.courses_recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        CourseAdapter customAdapter = new CourseAdapter(getContext(),courses);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView



        return v;
    }


    private void changeThemeDaytoNigth()
    {

        View view = sun_moonImg;
        ViewPropertyAnimatorCompat viewAnimator;
        viewAnimator = ViewCompat.animate(view)
                .translationX(-50).alpha(1)
                .setStartDelay((ITEM_DELAY ) + 500)
                .setDuration(1000);
        afterImg.setVisibility(View.VISIBLE);
        beforeImg.setVisibility(View.GONE);
        sun_moonImg.setImageResource(R.drawable.img_moon);
        Theme_layer.setBackgroundResource(R.drawable.dark_background);
        Methods.CHECK_THEME =1;
        getActivity().recreate();

    }

    private void changeThemeNigthtoDay()
    {
        View view = sun_moonImg;
        ViewPropertyAnimatorCompat viewAnimator;
        viewAnimator = ViewCompat.animate(view)
                .translationX(50).alpha(1)
                .setStartDelay((ITEM_DELAY ) + 500)
                .setDuration(1000);
        beforeImg.setVisibility(View.VISIBLE);
        afterImg.setVisibility(View.GONE);

        sun_moonImg.setImageResource(R.drawable.img_sun);
        Theme_layer.setBackgroundResource(R.drawable.day_background);
        Methods.CHECK_THEME =0;
        // getActivity().overridePendingTransition(R.anim.transition_for_incoming_activity, R.anim.transition_for_outgoing_activity);
        getActivity().recreate();



    }

}