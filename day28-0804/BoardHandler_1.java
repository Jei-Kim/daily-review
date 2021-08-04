package com.eomcs.pms.handler;

import java.sql.Date;
import com.eomcs.pms.domain.Board;
import com.eomcs.util.Prompt;

public class BoardHandler {

  /// 배열의 크기를 초과했을 경우 에러남 - > 해결방법?
  static final int MAX_LENGTH = 5;

  
  Board[] boards = new Board[MAX_LENGTH];
  int size = 0;

  public void add() {
    System.out.println("[새 게시글]");

    Board board = new Board();

    board.no = Prompt.inputInt("번호? ");
    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.registeredDate = new Date(System.currentTimeMillis());
    
    //로컬변수에 같은 이름이 없을 경우 this. 생략 가능
    //(생략하면 컴파일러가 자동 생성해줌)
    
    if (this.size == this.boards.length) { //배열의 크기가 같아진다면(꽉 찬다면)
      
      // 기존 배열보다 50% 더 큰 배열을 만들자
      //Board[] arr = new Board[this.boards.length + this.boards.length / 2];
      //5나누기2는 2(정수값이라서)  --> so 5 + 2 = 7
      Board[] arr = new Board[this.boards.length + (this.boards.length) >> 1];
      //위와 동일함 but 비트연산자 사용 ( >>1은 /2와 같다. )
      
      //기존 배열의 값을 새 배열로 복사한다.
      for (int i = 0; i < this.size; i++) {
        arr[i] = this.boards[i];
      }
      
    //기존 배열 대신 새 배열 주소를 저장한다.
    //=> 물론 이렇게 함으로써 기존 배열은 가비지가 될 것이다. 
   this.boards = arr;
   System.out.println("새 Board[] 객체를 만듦!");
  }
   this.boards[this.size++] = board;
  }

  public void list() {
    System.out.println("[게시글 목록]");
    for (int i = 0; i < this.size; i++) {
      System.out.printf("%d, %s, %s, %s, %d, %d\n", 
          this.boards[i].no, 
          this.boards[i].title, 
          this.boards[i].writer,
          this.boards[i].registeredDate,
          this.boards[i].viewCount, 
          this.boards[i].like);
    }
  }

  public void detail() {
    System.out.println("[게시글 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("작성자: %s\n", board.writer);
    System.out.printf("등록일: %s\n", board.registeredDate);
    System.out.printf("조회수: %d\n", ++board.viewCount);
  }

  public void update() {
    System.out.println("[게시글 변경]");
    int no = Prompt.inputInt("번호? ");

    Board board = findByNo(no);

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String title = Prompt.inputString(String.format("제목(%s)? ", board.title));
    String content = Prompt.inputString(String.format("내용(%s)? ", board.content));

    String input = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 변경을 취소하였습니다.");
      return;
    }

    board.title = title;
    board.content = content;
    System.out.println("게시글을 변경하였습니다.");
  }

  public void delete() {
    System.out.println("[게시글 삭제]");
    int no = Prompt.inputInt("번호? ");

    int index = indexOf(no);

    if (index == -1) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    String input = Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("게시글 삭제를 취소하였습니다.");
      return;
    }

    for (int i = index + 1; i < this.size; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");
  }

  private Board findByNo(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  private int indexOf(int no) {
    for (int i = 0; i < this.size; i++) {
      if (this.boards[i].no == no) {
        return i;
      }
    }
    return -1;
  }


}







