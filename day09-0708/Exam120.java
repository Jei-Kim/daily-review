package com.eomcs.basic.ex10;

public class Exam120 {

  public static void main(String[] args) {
    long millis = System.currentTimeMillis(); // 날짜의 재료
    System.out.println(millis);

    java.util.Date d = new java.util.Date(millis); 
    // java의 util이라는 도구 사용해서 날짜를 내가 원하는 형태로 변환
    System.out.println(d.toString());
    // 변환한 것을 화면에 보여주되, 문자열로 출력해라

    java.sql.Date d2 = new java.sql.Date(millis); 
    //java의 sql이라는 도구 사용 날짜를 내가 원하는 형태로 변환
    System.out.println(d2.toString());
    // 변환한 것을 화면에 보여주되, 문자열로 출력해라
  }

}
