package com.example.sugang;

import java.util.ArrayList;

/**
 * 앱 전체에서 장바구니 데이터를 공유하기 위한 임시 저장소 클래스입니다.
 * static 변수를 사용하여, 어떤 액티비티에서든 동일한 장바구니 목록에 접근할 수 있도록 합니다.
 */
public class CartManager {

    // 장바구니에 담긴 Course 객체들을 저장할 리스트
    public static ArrayList<Course> cartItems = new ArrayList<>();

    // 이 클래스는 객체로 만들 필요 없이, 바로 CartManager.cartItems 형태로 사용하기 때문에
    // 다른 코드는 필요하지 않습니다.
}