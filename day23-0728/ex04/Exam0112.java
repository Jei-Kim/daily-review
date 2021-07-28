// 생성자 활용 예 - 자바에서 제공하는 클래스 사용을 통해 생성자 활용을 익혀보자!
package com.eomcs.oop.ex04;

import java.nio.charset.Charset;

public class Exam0112 {

  public static void main(String[] args) throws Exception {
    System.out.println(Charset.defaultCharset());

    // 한글 문자 코드의 바이트 배열을 가지고 String 인스턴스 초기화시키기.
    byte[] bytes = {
        (byte)0xb0, (byte)0xa1, // 가
        (byte)0xb0, (byte)0xa2, // 각
        (byte)0xb6, (byte)0xca, // 똘
        (byte)0xb6, (byte)0xcb  // 똥
    };
    String s1 = new String(bytes);
    System.out.println(s1);
    // 결과: 
    // => 한글 출력이 깨진다.
    //
    // 이유?
    // => String 클래스는 파라미터로 넘겨 받은 바이트 배열을 가지고
    //    유니코드(UCS2) 문자열로 변환할 때
    //    바이트 배열이 OS의 기본 문자 코드로 되어 있다고 간주한다.
    // => OS 마다 기본으로 사용하는 문자 코드표(Character Set)가 다르다.
    //    Windows : MS949
    //    Unix/Linux/macOS : UTF-8
    // => 그런데 위 예제의 바이트 배열은 EUC-KR 코드이다.
    //    그래서 String 클래스는 바이트 배열을 제대로 해석하지 못한 것이다.
    //
    // 해결책?
    // => String 클래스의 생성자를 호출할 때
    //    바이트 배열과 인코딩 정보를 함께 받는 생성자를 사용하라!
    // => 즉 bytes 배열에 EUC-KR의 코드 값이 들어 있다고 알려준다.
    //    그러면 JVM은 바이트 배열에 들어 있는 값을 제대로 유니코드 바꿀 것이다.
    // 
    String s2 = new String(bytes, "EUC-KR");
    System.out.println(s2);
   
  }
}

/*
// 인스턴스를 만들지 않고도 사용할 수 있는 경우
Integer.parseInt("123");

// 인스턴스를 만들어야 사용할 수 있는 경우 -> 생성자 만들어주어야 함
java.util.Date d = new java.util.Date(); //기본 생성자 호출 가능
java.sql.Date d2 = new java.sql.Date(); // 기본 생성자 호출 불가함. 파라미터 넣어줘야됨
// java.sql.Date d2 = new java.sql.Date(System.currentmilliTimeMillis());
// java.sql.Date d2 = new java.sql.Date(2021,07,28);
d.getHours();
// 결론: 남이 만든 생성자를 사용할 때는 매뉴얼을 보고 적절하게 생성자 문법을 사용해주자.















