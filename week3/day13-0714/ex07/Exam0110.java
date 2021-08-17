package com.eomcs.lang.ex07;

import java.util.Scanner;

// eomcs.java Exam 0110~0114 참고해서 4단계로 연습

public class Exam0110 {
 
 static void printSpaces(int len) {
   
  for(int i = 0; i < len; i++;) {
  System.out.print(" ");
  
  }
 }

  static void printStars(int len){
      for(int i = 0; i < len; i++;) {
        System.out.print("*");
      }
 }
  
  static int getSpaceLength(int totalStar, int displayStar) {
    return (totalStar - displayStar) / 2;
  }
  
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    System.out.print("밑변의 길이? ");
    int len = keyScan.nextInt();
    keyScan.close();

    
    for (int starLen = 1; starLen <= len; starLen += 2) {
      printSpces(getSpaceLength(len, starLen));
      // 별 출력
      printStars(starLen);
      // 출력 줄 바꾸기
      System.out.println();
      
    }
  }
}