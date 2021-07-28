// 스태틱 초기화 블록(static initializer) - 변수 초기화 문장(variable initializer)
package com.eomcs.oop.ex03;

public class Exam0670 {

  public static class A {
    static int a = 100; 
    //바로 이렇게 값을 할당해줘도 됨 근데 어차피 컴파일하면서 아래처럼 바뀜

    // 변수 초기화 문장(variable initializer)을 컴파일 할 때,
    // - 스태틱 초기화 블록이 없으면 컴파일러가 자동으로 삽입한다.
    // - 스태틱 초기화 블록에 a 에 100을 할당하는 문장을 삽입한다.
    // - 위의 문장은 다음 문장으로 바뀐다.
    //
    //    static int a;
    //    static {
    //      a = 100;
    //    }
    // - 바이트 코드(Exam0670$A.class)를 확인해 보라!
  }

  public static void main(String[] args) throws Exception {

    System.out.println(A.a);
  }
}


