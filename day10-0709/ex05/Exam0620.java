package com.eomcs.lang.ex05;

//# 증감 연산자 : 후위(post-fix) 감소 연산자
//
public class Exam0620 {
  public static void main(String[] args) {
    int i = 7;
// int temp = i
// i = i + 1
    i--;
    // 컴파일러는 위의 문장을 다음과 같이 바꾼다.
    // int temp = i;
    // i = i - 1;

    System.out.println(i); // 5

    System.out.println(i--);  //5
    // 위의 문장을 컴파일하면 다음과 같이 바뀐다.
    // int temp = i;
    // i = i - 1;
    // System.out.println(temp);
    System.out.println(i); //4

  }
}
