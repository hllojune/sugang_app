package com.example.sugang;

// MenuItem.java

public class MenuItem {
    private int iconResId;    // 아이콘 이미지 리소스 ID (예: R.drawable.ic_notice)
    private String title;     // 메뉴 제목 (예: "공지사항")
    private String subtitle;  // 메뉴 부제목 (예: "모바일 수강신청 사용 유의사항")

    // 생성자
    public MenuItem(int iconResId, String title, String subtitle) {
        this.iconResId = iconResId;
        this.title = title;
        this.subtitle = subtitle;
    }

    // 각 데이터에 접근하기 위한 Getter 메소드
    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}