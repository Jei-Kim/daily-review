package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class App2practice {

  public static void main(String[] args) {
    System.out.println("[프로젝트]");

    Scanner keyboardScan = new Scanner(System.in);

    final int leng = 100;
    
    int[] no = new int[leng];
    String[] title = new String[leng];
    String[] content = new String[leng];
    Date[] startDate = new Date[leng];
    Date[] endDate = new Date[leng];
    String[] owner = new String[leng];
    String[] members = new String[leng];

    int size = 0; //대부분 count 아니고 size로 표현
    
    for (int i = 0; i < leng; i++) {
      System.out.print("번호? ");
      no[i] = Integer.valueOf(keyboardScan.nextLine());

      System.out.print("프로젝트명? ");
      title[i] = keyboardScan.nextLine();

      System.out.print("내용? ");
      content[i] = keyboardScan.nextLine();

      System.out.print("시작일? ");
      startDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("종료일? ");
      endDate[i] = Date.valueOf(keyboardScan.nextLine());

      System.out.print("만든이? ");
      owner[i] = keyboardScan.nextLine();

      System.out.print("팀원? ");
      members[i] = keyboardScan.nextLine();

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

    for (int i = 0; i < size; i++) {
      
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], title[i], startDate[i], endDate[i], owner[i]);
    }
  }
}
