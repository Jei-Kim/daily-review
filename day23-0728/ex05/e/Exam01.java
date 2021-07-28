// 상속의 실제적인 의미
package com.eomcs.oop.ex05.e;

public class Exam01 {

  public static void main(String[] args) {
    B obj = new B();

    // B 인스턴스를 이용하여 B가 사용권을 획득한 A 클래스의 메서드를 호출할 수 있다.
    obj.m1(); // A클래스의 m1 호출

    obj.m2(); // B클래스의 m2 호출

    // 실험:
    // bin/main/.../A.class 파일을 제거한 후 다시 실행하라!
    // => 결과는?
    //    A 클래스가 없다고 예외가 발생한다. ClassNotFoundException
    // => 의미?
    //    상속 받는다는 것은 수퍼 클래스의 코드를 그대로 복제해 온다는 것이 아니다.
    //    그냥 수퍼 클래스의 코드를 사용할 수 있는 권한을 획득한다는 것이다.
    //    그래서 서브 클래스를 사용하려면
    //    반드시 서브 클래스가 상속 받는 모든 조상 클래스가 있어야 한다.
    //

  }

}
