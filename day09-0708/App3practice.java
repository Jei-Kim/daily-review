package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App3practice {

  public static void main(String[] args) {
    System.out.println("[작업]");

    Scanner keyboardScan = new Scanner(System.in);

    final int LENGTH = 100;
    
    int[] no = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date[] deadline = new Date[LENGTH];
    String[] owner = new String[LENGTH];
    int[] status = new int[LENGTH];

    System.out.print("프로젝트? ");
    String project = keyboardScan.nextLine();
    System.out.println();

    int size = 0;

    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("마감일? ");
      deadline[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.println("상태?");
      System.out.println("0: 신규");
      System.out.println("1: 진행중");
      System.out.println("2: 완료");
      System.out.print("> ");
      status[i] = Integer.valueOf(keyboardScan.nextLine());

      System.out.print("담당자? ");
      owner[i] = keyboardScan.nextLine();

      size++;
      System.out.println(); 

      System.out.print("계속 입력하시겠습니까?(y/N) ");
      String str = keyboardScan.nextLine();
      if (str.equalsIgnoreCase("y")) {
        break;
      }
      System.out.println(); 
    }

    keyboardScan.close();

    System.out.println("--------------------------------");

    System.out.printf("[%s]\n", project);

    for (int i = 0; i < size; i++) {
      String state = null;
      switch (status[i]) {
        case 1:
          state = "진행중";
          break;
        case 2:
          state = "완료";
          break;
        default:
          state = "신규";
      }
      
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], content[i], deadline[i], stateLabel, owner[i]);
    }
  }
}
