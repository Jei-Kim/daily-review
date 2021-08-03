package com.eomcs.pms.menu;

import com.eomcs.pms.handler.BoardHandler;

// Composite 패턴에서 Leaf 역할을 할 메뉴 항목을 정의한다.

public class BoardUpdateMenu extends Menu {

  BoardHandler boradHandler;
  
  pulbic BoardAddMenu(BoardHandler boradHandler) {
    super("변경");
    this.boardHandler = boardHandler;
  }

   @Override 
  public void execute() {
    boardHandler.update(); 
  } 
}
