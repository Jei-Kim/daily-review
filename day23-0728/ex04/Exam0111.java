// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

public class Exam0111 {

  public static void main(String[] args) throws Exception {
    // 생성자를 호출하여 문자열 인스턴스를 초기화시킨다.

    // => 문자열 리터럴을 사용하여 String 인스턴스를 초기화시키기.
    String s1 = new String("Hello"); // String(스트링 리터럴) 생성자를 호출하여 인스턴스 초기화

    // => char[] 을 사용하여 String 인스턴스 초기화시키기.
    char[] chars = new char[] {'H', 'e', 'l', 'l', 'o'};
    String s2 = new String(chars); // String(char[]) 생성자를 호출하여 인스턴스 초기화
    
    //## 주의: 인스턴스는 값을 저장할 변수들의 묶음이다! 인스턴스 안에는 메서드가 없음
    // 클래스코드는 모두 메서드 에리아(스태틱/인스턴스 모두)
    // It means 인스턴스 메서드가 힙에 있지 않음!!주의

    // => 바이트 배열을 가지고 String 인스턴스 초기화시키기
    byte[] bytes = {
        
        
        (byte)0x48, // H 
        (byte)0x65, // e
        (byte)0x6c, // l
        (byte)0x6c, // l
        (byte)0x6f  // o 
    };
    String s3 = new String(bytes);

    System.out.printf("%s, %s, %s\n", s1, s2, s3);
  }
}

// 생성자의 활용
// => 인스턴스 변수를 초기화시키기 위해 여러 개의 생성자를 만들어 제공할 수 있다.
// => 자신에게 맞는 적절한 생성자를 호출하여 인스턴스를 초기화시킨 후 사용하면 된다. 

/* 생성자란? 인스턴스를 생성한 후, 그 인스턴스를 제대로 쓸 수 있도록 유효한 값으로 초기화시키는 것
 - ProjectHandler참조

 */















