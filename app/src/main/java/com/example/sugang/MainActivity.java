package com.example.sugang;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.MaterialToolbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainMenuAdapter mainMenuAdapter;
    private ArrayList<MenuItem> menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. 툴바(상단 바) 설정
        MaterialToolbar toolbar = findViewById(R.id.toolbar_main);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_item_settings) {
                // 설정 아이콘 클릭 시 동작
                // Toast.makeText(this, "설정 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        // 2. RecyclerView 초기화
        recyclerView = findViewById(R.id.recycler_view_main_menu);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. 메뉴 목록에 표시할 데이터 생성
        menuList = new ArrayList<>();
        menuList.add(new MenuItem(R.drawable.ic_main_notice, "공지사항", "모바일 수강신청 사용 유의사항"));
        menuList.add(new MenuItem(R.drawable.ic_main_search, "조회", "개설강좌/강의계획서, 장바구니내역, 수강신청내역"));
        menuList.add(new MenuItem(R.drawable.ic_main_cart, "장바구니", "장바구니 신청/조회/취소"));
        menuList.add(new MenuItem(R.drawable.ic_main_registration, "수강신청", "장바구니에서 신청, 개설강좌 조회/신청,\n 수강신청 조회/삭제"));

        // 4. 어댑터 생성 및 RecyclerView에 연결
        mainMenuAdapter = new MainMenuAdapter(menuList);
        recyclerView.setAdapter(mainMenuAdapter);

        // 5. (선택사항) 어댑터에 클릭 리스너 설정
        // 어댑터 내에서 직접 이벤트를 처리하도록 만들었기 때문에, MainActivity에서는 별도 설정이 필요 없을 수 있습니다.
        // 만약 Activity에서 직접 제어하고 싶다면 어댑터에 리스너 인터페이스를 만들어서 연결할 수 있습니다.
    }
}