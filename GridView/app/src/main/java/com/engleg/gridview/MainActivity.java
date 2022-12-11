package com.engleg.gridview;

import android.os.Bundle;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coursesGV = findViewById(R.id.idGVcourses);

        ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.img5));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.img5));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.img5));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.img5));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.img5));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.img5));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        coursesGV.setAdapter(adapter);
    }
}
