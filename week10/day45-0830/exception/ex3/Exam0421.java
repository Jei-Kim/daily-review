// 던지는 예외 받기 - 예외 처리 책임을 상위 호출자에게 위임
package com.eomcs.exception.ex3;

import java.io.IOException;
import java.sql.SQLException;

public class Exam0421 {

  static void m(int i) throws Exception, RuntimeException, SQLException, IOException {
    if (i == 0)
      throw new Exception();
    else if (i == 1)
      throw new RuntimeException();
    else if (i == 2)
      throw new SQLException();
    else
      throw new IOException();
  }

  // 메서드 안에서 발생하는 예외에 대해 
  // 메서드 선언부에 모두 적지 않고, 
  // 그 예외들의 공통 분모에 해당하는 수퍼 클래스만 적어도 된다. 
  /// 어떤 방법이 더 좋은지? -> 개발자가 결정하면 됨. 예외별로 따로 처리할 필요 없으면 그냥 이렇게 하삼

  public static void main(String[] args) throws Exception {
    m(1);
  }

}
