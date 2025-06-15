package com.example.sugang; // 본인의 패키지 이름에 맞게 수정

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RetakeCourseAdapter extends RecyclerView.Adapter<RetakeCourseAdapter.RetakeViewHolder> {

    private final ArrayList<Course> courseList;

    public RetakeCourseAdapter(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    // ViewHolder: list_item_retake_course.xml의 뷰들을 모두 담는 그릇
    public static class RetakeViewHolder extends RecyclerView.ViewHolder {
        public TextView courseCode, courseName, yearInfo, gradeInfo;
        public ImageButton searchButton;

        public RetakeViewHolder(@NonNull View itemView) {
            super(itemView);
            // list_item_retake_course.xml에 정의된 ID와 일치해야 합니다.
            courseCode = itemView.findViewById(R.id.tv_retake_code);
            courseName = itemView.findViewById(R.id.tv_retake_name);
            yearInfo = itemView.findViewById(R.id.tv_retake_year_info);
            gradeInfo = itemView.findViewById(R.id.tv_retake_grade_info);
            searchButton = itemView.findViewById(R.id.btn_search_retake);
        }
    }

    @NonNull
    @Override
    public RetakeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_retake_course, parent, false);
        return new RetakeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RetakeViewHolder holder, int position) {
        Course currentCourse = courseList.get(position);

        // --- 1. 글씨가 보이도록 데이터 채우기 ---
        holder.courseCode.setText(currentCourse.getCourseCode());
        holder.courseName.setText(currentCourse.getCourseName().replace("(재이수)", "")); // "(재수강)" 텍스트 제거
        holder.yearInfo.setText(currentCourse.getDetails()); // 예시: "2021/10 | 전공 | ..."
        holder.gradeInfo.setText(currentCourse.getProfessor()); // 예시: "3학점 | 87점 | B+"

        // --- 2. 돋보기 버튼 클릭 시 다음 화면으로 이동 ---
        holder.searchButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), RetakeSearchResultActivity.class);
            // 선택한 과목의 정보를 다음 화면으로 전달
            intent.putExtra("COURSE_NAME", currentCourse.getCourseName());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
