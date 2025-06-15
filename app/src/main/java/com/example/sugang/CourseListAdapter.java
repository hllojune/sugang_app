package com.example.sugang;

// CourseListAdapter.java

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseViewHolder> {

    private ArrayList<Course> courseList;
    private String adapterType; // "search", "cart", "registration" 등을 받음

    // ViewHolder: list_item_course.xml의 뷰들을 담는 그릇
    // 이 부분이 어댑터의 필수 구성 요소입니다.
    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        public TextView courseCode, courseName, details, professor, timeAndPlace, target;
        public ImageButton actionButton;

        @SuppressLint("WrongViewCast")
        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            // list_item_course.xml 파일에 정의된 ID와 일치해야 합니다.
            // (ID가 다르다면 이 부분을 수정해주세요)
            courseCode = itemView.findViewById(R.id.tv_course_code);
            courseName = itemView.findViewById(R.id.tv_course_name);
            details = itemView.findViewById(R.id.tv_course_details);
            professor = itemView.findViewById(R.id.tv_course_professor);
            timeAndPlace = itemView.findViewById(R.id.tv_course_time_place);
            target = itemView.findViewById(R.id.tv_course_target);
            actionButton = itemView.findViewById(R.id.btn_action);
        }
    }

    // 생성자에서 데이터와 함께 타입도 전달받음
    public CourseListAdapter(ArrayList<Course> courseList, String type) {
        this.courseList = courseList;
        this.adapterType = type;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // list_item_course.xml 레이아웃을 가져와서 ViewHolder를 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_course, parent, false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        // 현재 위치(position)에 해당하는 Course 데이터를 가져온다.
        Course currentCourse = courseList.get(position);

        // --- 이 부분이 '// ... (나머지 데이터 바인딩)'에 해당합니다 ---
        // 가져온 데이터로 ViewHolder 안의 뷰들을 모두 채운다.
        holder.courseCode.setText(currentCourse.getCourseCode());
        holder.courseName.setText(currentCourse.getCourseName());
        holder.details.setText(currentCourse.getDetails());
        holder.professor.setText(currentCourse.getDetails());
        holder.timeAndPlace.setText(currentCourse.getTimeAndPlace());
        holder.target.setText(currentCourse.getTarget());

        // 타입에 따라 다른 아이콘을 설정
        switch (adapterType) {
            case "search":
                holder.actionButton.setImageResource(R.drawable.btn_sinchung); // '담기' 아이콘
                holder.actionButton.setOnClickListener(v -> {
                    Toast.makeText(v.getContext(), currentCourse.getCourseName() + " 담기", Toast.LENGTH_SHORT).show();
                    // 담기 기능 구현
                });
                break;
            case "cart":
                holder.actionButton.setImageResource(R.drawable.btn_delete); // '삭제' 아이콘
                holder.actionButton.setOnClickListener(v -> {
                    Toast.makeText(v.getContext(), currentCourse.getCourseName() + " 삭제", Toast.LENGTH_SHORT).show();
                    // 삭제 기능 구현
                });
                break;
            case "registration":
                holder.actionButton.setImageResource(R.drawable.btn_sinchung); // '신청' 아이콘
                holder.actionButton.setOnClickListener(v -> {
                    Toast.makeText(v.getContext(), currentCourse.getCourseName() + " 신청", Toast.LENGTH_SHORT).show();
                    // 신청 기능 구현
                });
                break;
        }
    }

    @Override
    public int getItemCount() {
        // 전체 아이템 개수를 반환
        return courseList.size();
    }
}