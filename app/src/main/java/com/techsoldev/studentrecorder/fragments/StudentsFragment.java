package com.techsoldev.studentrecorder.fragments;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techsoldev.studentrecorder.R;
import com.techsoldev.studentrecorder.adapters.CourseAdapter;
import com.techsoldev.studentrecorder.adapters.StudentAdapter;
import com.techsoldev.studentrecorder.models.Course;
import com.techsoldev.studentrecorder.models.Student;

import java.util.ArrayList;

public class StudentsFragment extends  Fragment {

    ArrayList<Student> students = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_students,container,false);

        students.add(new Student("Harry","Section A", R.drawable.student_1_img));
        students.add(new Student("Amelia","Section A", R.drawable.student_2_img));
        students.add(new Student("Muhammad","Section B", R.drawable.student_3_img));
        students.add(new Student("Olivia","Section C", R.drawable.student_4_img));
        students.add(new Student("George","Section C", R.drawable.student_5_img));
        students.add(new Student("Lily","Section B", R.drawable.student_6_img));
        students.add(new Student("Jacob","Section A", R.drawable.student_7_img));

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.students_recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        StudentAdapter customAdapter = new StudentAdapter(getContext(),students);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
        return v;
    }
}

