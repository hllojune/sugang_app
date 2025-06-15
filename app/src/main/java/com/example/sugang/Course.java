package com.example.sugang;

import java.io.Serializable;

// Course.java

public class Course implements Serializable {
    private String courseCode;    // 과목코드 (예: "06263001")
    private String courseName;    // 과목명
    private String details;       // 세부 정보 (예: "전선 3학점...")
    private String professor;     // 교수명
    private String timeAndPlace;  // 시간/강의실
    private String target;        // 대상 학부(과)

    // 생성자
    public Course(String courseCode, String courseName, String details,String professor, String timeAndPlace, String target) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.details = details;
        this.professor = professor;
        this.timeAndPlace = timeAndPlace;
        this.target = target;
    }

    // 각 데이터에 접근하기 위한 Getter 메소드들
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public String getDetails() { return details; }
    public String getProfessor() { return professor; }
    public String getTimeAndPlace() { return timeAndPlace; }
    public String getTarget() { return target; }
}