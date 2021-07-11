package com.eomcs.pms;

import java.sql.Date;
import java.util.Scanner;

public class AppPracice {

  public static void main(String[] args) {
    System.out.println("[회원]");

    Scanner keyboardScan = new Scanner(System.in);

    final int leng = 100;

    int[] no = new int[leng];
    String[] name = new String[leng];
    String[] email = new String[leng];
    String[] password = new String[leng];
    String[] photo = new String[leng];
    String[] tel = new String[leng];
    Date[] registeredDate = new Date[leng];

    int size = 0;

    for (int i = 0; i < leng; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyboardScan.nextLine());

      System.out.print("이름? ");
      name[i] = keyboardScan.nextLine();

      System.out.print("이메일? ");
      email[i] = keyboardScan.nextLine();

      System.out.print("암호? ");
      password[i] = keyboardScan.nextLine();

      System.out.print("사진? ");
      photo[i] = keyboardScan.nextLine();

      System.out.print("전화? ");
      tel[i] = keyboardScan.nextLine();

      registeredDate[i] = new java.sql.Date(System.currentTimeMillis());

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
    
      System.out.printf("%d, %s, %s, %s, %s\n", no[i], name[i], email[i], tel[i], registeredDate[i]);
    }
  }
}
