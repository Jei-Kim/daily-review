// 다형성 - 다형적 변수의 활용
package com.eomcs.oop.ex06.a;

public class Exam0412 {

  // Sedan과 Truck의 모델명과 cc를 출력하라!

  // 다형적 변수를 사용하게 되면 동일한 코드를 갖고 있는 메서드를
  // 한 개의 메서드로 통합할 수 있다.
  // => 즉 Sedan 객체와 Truck 객체를 모두 가리킬 수 있는
  //    상위 클래스의 레퍼런스를 선언하면 된다.
  //
  public static void printCar(Car car) {
    // sedan으로 지정하는것보다 car라고 지정하면 sedan을 포함해 car의 모든 서브를 쓸 수 있어서 효율적임
    // 이렇게 적은 코드로 효율적인 사용을 할 수 있는 것이 다형적 변수..?
    System.out.printf("모델명: %s\n", car.model);
    System.out.printf("cc: %d\n", car.cc);
    System.out.println("-------------------------");
  }

  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    sedan.model = "티코";
    sedan.cc = 800;

    Truck truck = new Truck();
    truck.model = "타이탄II";
    truck.cc = 10000;

    // 또다른 해결책?
    // Sedan과 Truck을 모두 처리하는 메서드를 만들어 사용하라!
    printCar(sedan); // OK! 왜? Sedan은 Car의 일종이다.
    printCar(truck); // OK! 왜? Truck도 Car의 서브클래스이다.

  }

}




