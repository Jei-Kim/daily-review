package com.eomcs.basic.ex10;

public class Exam0110 {

  public static void main(String[] args) {
    java.util.Date d = new java.util.Date(); // Date 객체를 만드는 순간의 시각을 저장해 둔다.
    System.out.println(d.toString());
    // 변환한 것을 콘솔에 문자열로 출력해라
    System.out.printf("%tY-%tm-%td\n", d, d, d);
    // 화면에 출력할 형식을 지정하고 싶으면 printf 사용
    System.out.printf("%tY-%1$tm-%1$td\n", d);
    //이렇게 d 하나만 입력해서 출력하고 싶으면 두번째 값부터 1$ 붙여줘야함
  }

}
