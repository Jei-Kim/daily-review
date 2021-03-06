package com.eomcs.pms.handler;

import com.eomcs.pms.domain.Task;
import com.eomcs.util.Prompt;

public class TaskHandler {

  static final int MAX_LENGTH = 5;

  Task[] tasks = new Task[MAX_LENGTH];
  int size = 0;

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void add(MemberHandler memberHandler) {
    System.out.println("[작업 등록]");

    Task task = new Task();

    task.no = Prompt.inputInt("번호? ");
    task.content = Prompt.inputString("내용? ");
    task.deadline = Prompt.inputDate("마감일? ");

    System.out.println("상태?");
    System.out.println("0: 신규");
    System.out.println("1: 진행중");
    System.out.println("2: 완료");
    task.status = Prompt.inputInt("> ");

    while (true) {
      String owner = Prompt.inputString("담당자?(취소: 빈 문자열) ");
      if (owner.length() == 0) {
        System.out.println("작업 등록을 취소합니다.");
        return; // 현재 메서드의 실행을 멈추고 리턴한다.
      } else if (memberHandler.exist(owner)) {
        task.owner = owner;
        break;
      }
      System.out.println("등록된 회원이 아닙니다.");
    }

    this.tasks[this.size++] = task;
  }

  // 다른 패키지에 있는 App 클래스가 다음 메서드를 호출할 수 있도록 공개한다.
  public void list() {
    System.out.println("[작업 목록]");

    for (int i = 0; i < this.size; i++) {
      String stateLabel = null;
      switch (tasks[i].status) {
        case 1:
          stateLabel = "진행중";
          break;
        case 2:
          stateLabel = "완료";
          break;
        default:
          stateLabel = "신규";
      }

      System.out.printf("%d, %s, %s, %s, %s\n", this.tasks[i].no, this.tasks[i].content,
          this.tasks[i].deadline, stateLabel, this.tasks[i].owner);
    }
  }

  public void detail() {
    System.out.println("[작업 상세보기]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        task = this.tasks[i];
        break;
      }
    }

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    System.out.printf("번호: %d\n", task.title);
    System.out.printf("내용: %s\n", task.content);
    System.out.printf("마감일: %s\n", task.deadline);
    System.out.printf("담당자: %s\n", task.owner);
    System.out.printf("상태: %d\n", task.status);
  }

  public void update() {
    System.out.println("[작업 변경]");
    int no = Prompt.inputInt("번호? ");

    Task task = null;

    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no == no) {
        task = this.tasks[i];
        break;
      }
    }

    if (task == null) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }


    String content = Prompt.inputString(String.format("내용(%s)? ", task.content));
    String deadline = Prompt.inputString(String.format("마감일(%s)? ", task.deadline));
    String owner = Prompt.inputString(String.format("담당자(%s)? ", task.owner));
    String status = Prompt.inputString(String.format("상태(%s)? ", task.status));



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

    System.out.println("[작업 삭제]");
    int no = Prompt.inputInt("번호? ");

    int taskIndex = -1;

    for (int i = 0; i < this.size; i++) {
      if (this.tasks[i].no = no) {
        taskIndex = i;
        break;
      }
    }

    if (taskIndex == -1) {
      System.out.println("해당 번호의 작업이 없습니다.");
      return;
    }

    Prompt.inputString("정말 삭제하시겠습니까?(y/N) ");
    if (input.equalsIgnoreCase("n") || input.length() == 0) {
      System.out.println("작업 삭제를 취소하였습니다.");
      return;
    }

    for (int i = taskIndex + 1; i < this.size; i++) {
      this.tasks[i - 1] = this.tasks[i];
    }

    this.tasks[--this.size] = null;

    System.out.println("게시글을 삭제하였습니다.");

  }
}
