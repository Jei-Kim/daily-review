package com.eomcs.pms;

import com.eomcs.pms.handler.BoardHandler;
import com.eomcs.pms.handler.MemberHandler;
import com.eomcs.pms.handler.ProjectHandler;
import com.eomcs.pms.handler.TaskHandler;
import com.eomcs.pms.menu.BoardAddMenu;
import com.eomcs.pms.menu.BoardDeleteMenu;
import com.eomcs.pms.menu.BoardDetailMenu;
import com.eomcs.pms.menu.BoardListMenu;
import com.eomcs.pms.menu.BoardUpdateMenu;
import com.eomcs.pms.menu.Menu;
import com.eomcs.pms.menu.MenuGroup;
import com.eomcs.util.Prompt;

// 1) 메인 메뉴를 출력하고 번호를 입력 받는다.(App.java.01)
//    - 0 번을 입력하면 프로그램을 종료한다.
// 2) 게시판 메뉴를 출력하고 번호를 입력 받는다.
//    - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 3) 회원/프로젝트/작업 메뉴를 출력하고 번호를 입력 받는다.
//    - 사용자가 입력한 메뉴 번호에 따라 실행할 명령어를 설정한다.
// 4) 메뉴 번호를 입력했을 때 해당 기능을 바로 실행하게 한다.
// 5) 각각의 메인 메뉴를 다루는 코드를 별도의 메서드로 추출한다.
//    - doBoardMenu() 메서드 정의
//    - doMemberMenu() 메서드 정의
//    - doProjectMenu() 메서드 정의
//    - doTaskMenu() 메서드 정의
//    - doMainMenu() 메서드 정의
// 
public class App {

  // main() 메서드와 doXxxMenu() 메서드가 공유하는 변수는 
  // 같은 스태틱 멤버로 만든다.
  BoardHandler boardHandler = new BoardHandler();
  MemberHandler memberHandler = new MemberHandler();
  ProjectHandler projectHandler = new ProjectHandler(memberHandler);
  TaskHandler taskHandler = new TaskHandler(memberHandler);

  public static void main(String[] args) {
  App app = new App();
  app.service();  
  }

void service(){
  //  Menu mainMenu = createMenu();
  //  mainMenu.execute();
    createMenu().execuse();
    Prompt.close();
}

  static Menu createMenu() {
    MenuGroup mainMenuGroup = new MenuGroup("메인");
    mainMenuGroup.setPrevMenuTitle("종료");

    MenuGroup boardMenu = new MenuGroup("게시판");
    mainMenuGroup.add(boardMenu);
/*
 * 1. 긁어와서 파라미터를 지움
 * 2. 중첩일 경우에 이름이 필요 x 지우고 익명클래스라서 ? 이름 지우면서 앞에 붙은거 다 지움
 * 3. new
 * 
 */
    /// 패키지 멤버 클래스는 생성자 or 세터 메서드 파라미터로 받아 객체를 사용할 수 있음.
    /// but 중첩클래스는 바깥 클래스의 멤버를 마치 그 클래스의 멤버인것처럼 그대로 쓸 수 있다는 장점이 있음.
    /// so 파라미터로 받을 필요 없어짐 
    
    //로컬 클래스(별도의 클래스를 가져와서 createMenu안에 뒀음)
    
    /// 아래는 익명클래스를 만드는 거임(한번만 쓰고 말 거라면 익명클래스 만드셈)
    ///  - 이름이 없기 때문에 정의하는 즉시 인스턴스를 생성해주어야함. 
    /// - 인스턴스를 바로 생성해주기 때문에 인스턴스를 여러 개 생성 못함
    
    
    //Menu menu = new (); /// tico는 car /// 클래스 이름 필요x but 위에 new 바로 적어주기
    
    boardMenu.add(new Menu("등록") ///수퍼클래스 Menu의 문자열을 받는 생성자 호출 {
        public void execute() {
      boardHandler.add(); 
    } });
     boardMenu.add(new Menu("목록") {
      public void execute() {
        boardHandler.list(); 
      }});
    boardMenu.add(new Menu("상세보기") {
      public void execute() {
        boardHandler.detail(); 
      }});
    boardMenu.add(new Menu("변경") {
      public void execute() {
        boardHandler.update(); 
      }});
    boardMenu.add(new Menu("삭제") {
      public void execute() {
        boardHandler.delete(); 
      }});
  
MenuGroup memberMenu = new MenuGroup("회원");
    mainMenuGroup.add(memberMenu);

    memberMenu.add(new Menu("등록") {
      public void execute() {
        memberHandler.add(); 
      }});
    memberMenu.add(new Menu("목록") {
      public void execute() {
        memberHandler.list(); 
      }});
    memberMenu.add(new Menu("상세보기") {
      public void execute() {
        memberHandler.detail(); 
      }});
    memberMenu.add(new Menu("변경") {
      public void execute() {
        memberHandler.update(); 
      }});
    memberMenu.add(new Menu("삭제") {
      public void execute() {
        memberHandler.delete(); 
      }});

MenuGroup projectMenu = new MenuGroup("프로젝트");
    mainMenuGroup.add(projectMenu);

    projectMenu.add(new Menu("등록") {
      public void execute() {
        projectHandler.add(); 
      }});
    projectMenu.add(new Menu("목록") {
      public void execute() {
        projectHandler.list(); 
      }});
    projectMenu.add(new Menu("상세보기") {
      public void execute() {
        projectHandler.detail(); 
      }});
    projectMenu.add(new Menu("변경") {
      public void execute() {
        projectHandler.update(); 
      }});
    projectMenu.add(new Menu("삭제") {
      public void execute() {
        projectHandler.delete(); 
      }});


      MenuGroup taskMenu = new MenuGroup("작업");
    mainMenuGroup.add(taskMenu);

    taskMenu.add(new Menu("등록") {
      public void execute() {
        taskHandler.add(); 
      }});
    taskMenu.add(new Menu("목록") {
      public void execute() {
        taskHandler.list(); 
      }});
    taskMenu.add(new Menu("상세보기") {
      public void execute() {
        taskHandler.detail(); 
      }});
    taskMenu.add(new Menu("변경") {
      public void execute() {
        taskHandler.update(); 
      }});
    taskMenu.add(new Menu("삭제") {
      public void execute() {
        taskHandler.delete(); 
      }});

return mainMenuGroup;

}

/*

* 익명클래스 만들기 연습 
* 08/03 App

로컬클래스로 만들어
로컬클래스는 접근제어자 못 적음 -> 지우기

중첩클래스는 바깥클래스의 멤버에 마음대로 접근할 수 있음. 파라미터로 줄 필요 ㄴㄴ 

클래스 이름이 없으면 바로 인스턴스를 만들어줘야하고, 생성자가 존재할 수 없음.
수퍼클래스 바로 옆에 어떤 생성자를 생성할지 바로 적어 -> super 필요없음 삭제

아무 레퍼런스 준비해서 담아주기, 인스턴스 생성이기 때문에 끝에 세미콜론
Menu m = memberMenu.add(m)

근데 한 번만 쓰고 말거라면 굳이 임시변수 생성 ㄴㄴ 걍 생성한 코드 복사해서 직접 넣어주기
(세미콜론 지워야됨)

memberMenu.add()

*/







