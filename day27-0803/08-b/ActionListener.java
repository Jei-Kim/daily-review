package com.eomcs.pms.menu;
//MenuItem이 리스너 객체를 실행할 때 호출할 메서드의 규칙이다.
public interface ActionListener {
 void doAction(); // public abstract 써줘도되고 안써줘도 됨.
 //인터페이스의 메서드는 규칙을 표현하는 것이다.
 // 그래서 추상 메서드이다.
 // 그리고 모두의 접근을 허용하는 public 이다.
}
