// 스태틱 초기화 블록(static initializer) - 활용 II : 클래스 로딩과 스태틱 블록 실행
package com.eomcs.oop.ex03;

public class Exam0691 {

  static class A {
    static int a = 7;

    static {

      //a = 7; 이렇게 들어감
      System.out.println("A.static{}");
      a += B.b; // 엥 B클래스의 b값을 가져와야 하는데 클래스가 없네? B클래스를 로딩하러 감!
      // 아래 B 클래스의 static block을 실행하고나서 b값은 22+7 = 29가 되어있음
      // 이제 그걸 쓸 수 있음 -> 7+29로 a는 26이 되어버림.

      ///클래스를 로딩할 때 스태틱 블록이 실행된다는 것을 보여주기 위한 예제인듯?
    }
  }

  static class B {
    static int b = 22;

    static {
      //b = 22; 이렇게 스태틱 블록 안으로 들어가는겨
      System.out.println("B.static{}");
      b += A.a; 
      // 이 때 A클래스의 a값이 필요한데, A클래스는 로딩되어있기 때문에 a값을 바로 가져올 수 있음!
    }
  }

  public static void main(String[] args) {
    System.out.println(A.a); // ? a값 출력 -> 36
    System.out.println(B.b); // ? b값 출력 -> 29

    // 클래스 로딩 절차
    // 1) 클래스를 Method Area에 로딩한다.
    // 2) 스태틱 변수를 만든다.
    // 3) 스태틱 블록을 실행한다.
    //

    // 클래스 로딩
    // => 클래스 멤버(변수, 메서드)를 사용할 때
    // => Class.forName("클래스명") 을 통해 임의로 로딩할 때
    // => 단 한 번 로딩된 클래스는 다시 로딩하지 않는다.
    //

    // 스태틱 블록의 목적
    // => 클래스 멤버(스태틱 변수, 스태틱 메서드)를 사용하기 전에 유효한 값으로 초기화 시키는 것이다.
  }
}


