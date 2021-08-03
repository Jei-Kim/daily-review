package com.eomcs.pms.menu;
// 게시글 등록 메뉴를 선택했을 때 작업을 수행할 객체를 정의한다.
// 단 ActionListener 규칙에 따라 메서드를 정의한다.
// 그래야만 MenuItem에 이 객체를 등록할 수 있다.
// 그리고 MenuItem도 이 규칙에 따라 호출할 수 있다.
//
public class MemberDeleteMenu extends Menu {
MemberHandler memeberHandler;
  
  pulbic MemberDeleteMenu(MemberHandler memeberHandler) {
    super("목록");
    this.memberHandler = memberHandler;
  }

   @Override 
  public void execute() {
    memberHandler.delete(); 
  } 
}
