package com.example.sugang;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CourseSearchAdapter extends RecyclerView.Adapter<CourseSearchAdapter.CourseViewHolder> {

    private final ArrayList<Course> courseList;

    public CourseSearchAdapter(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_course_for_search, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course currentCourse = courseList.get(position);
        holder.courseName.setText(currentCourse.getCourseName());
        holder.courseDetails.setText(currentCourse.getDetails());

        // '강의계획서' 버튼 클릭 이벤트
        holder.syllabusButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), SyllabusActivity.class);
            // 선택된 강의의 데이터를 Intent에 담아 다음 화면으로 전달
            intent.putExtra("COURSE_DATA", currentCourse);

            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView courseName;
        public TextView courseDetails;
        public ImageButton syllabusButton;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseName = itemView.findViewById(R.id.tv_course_name);
            courseDetails = itemView.findViewById(R.id.tv_course_details);
            syllabusButton = itemView.findViewById(R.id.btn_syllabus);
        }
    }
}
