// 스태틱 초기화 블록(static initializer) - Class.forName()
package com.eomcs.oop.ex03;

public class Exam0650 {

  public static class A {
    static int a;

    static void m() {}

    // 클래스가 로딩될 때 스태틱 초기화 블록은 실행된다.
    // 여러 개의 스태틱 블록이 있을 때, 컴파일러는 한 개의 블록으로 합친다.
    // - 바이트코드(Exam0650$A.class)를 확인해 보라.
    //
    static {
      System.out.println("Static{} 11111");
    }

    static {
      System.out.println("Static{} 22222");
    }
  }

  public static void main(String[] args) throws Exception {

    // 클래스가 로딩되는 경우
    // 4) 자바에서 제공하는 도구를 사용하여 클래스를 로딩할 때,
    // - 이미 클래스가 로딩되어 있다면 다시 로딩하지 않는다.
    // - 메모리 절약을 위해, 자바는 중복해서 클래스를 메모리에 로딩하지 않는다.
    //
    Class.forName("com.eomcs.oop.ex03.Exam0650$A"); //Exam0650.A라 하면 중첩클래스를 가리킴
    
    //클래스의 정보를 다루는 클래스: Class의 forName이라는 스태틱 메서드
    // 클래스 네임으로 호출하니까 스태틱 메서드라는 걸 알 수 있음
    System.out.println("종료!");
  }
}


