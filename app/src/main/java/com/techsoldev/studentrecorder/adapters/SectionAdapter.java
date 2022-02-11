package com.techsoldev.studentrecorder.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.techsoldev.studentrecorder.R;
import com.techsoldev.studentrecorder.models.Student;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.MyViewHolder> {


    private final ArrayList<Student> students;
    Context context;
    private int serialCount = 1;
    String  sectionName ="";


    public SectionAdapter(Context context, ArrayList<Student> students, String sectionName) {
        this.students = students;
        this.context = context;
        this.sectionName = sectionName;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_reyclerview_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }



    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       Student student = students.get(position);
       if(sectionName.equals(student.getSection())) {
           holder.serialNo.setText(String.valueOf(serialCount++));
           holder.name.setText(student.getName());
           holder.section.setText(student.getSection());
           holder.image.setImageResource(student.getImage());

           // implement setOnClickListener event on item view.
           holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {

               }
           });
       }

  else
           {
               holder.itemView.setVisibility(View.GONE);
               holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
           }

    }


    @Override
    public int getItemCount() {
        return students.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView serialNo, name, section;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            serialNo = (TextView) itemView.findViewById(R.id.student_serialno_id);
            name = (TextView) itemView.findViewById(R.id.student_text_id);
            section = (TextView) itemView.findViewById(R.id.student_section_id);
            image = (ImageView) itemView.findViewById(R.id.student_imageview_id);
        }

    }


}
