package com.eomcs.pms.menu;
public class BoardAddMenu extends Menu {

  BoardHandler boradHandler;
  
  pulbic BoardAddMenu(BoardHandler boradHandler) {
    super("등록");
    this.boardHandler = boardHandler;
  }

  @Override 
  public void execute() {
    boardHandler.add(); 
  } 
}
