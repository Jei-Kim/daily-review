package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 주어진 숫자에 짝수가 몇 개인지 세어라.
// 예) 
// 1010 => 2
// 123 => 1
//
//한 줄에 버그가 있다. 고쳐라!
public class Test001 {

  static int countEventNumber(int value) {
    int result = 0; //몇 개인지 카운트하는 변수
    int n = value;
    while(n != 0) { //n이 0이 아닐 때
      if ((n % 2) == 0) { // if((n & 1) == 0 
        //n을 2로 나눈 나머지가 0일때(=짝수 찾기에 많이 사용되는 코드)
        result++; // 참이면 int result = 0이 하나씩 증가
      }
      n %= 10; // @정답 /= 로 수정
      // 1238694636를 일의자릿수를 반복해서 날림-> 순서대로 짝수의 개수를 알아냄
    }
    return result; // 결과값 반환
  }

  public static void main(String[] args) {
    System.out.println(countEventNumber(1238694636));

  }

}
