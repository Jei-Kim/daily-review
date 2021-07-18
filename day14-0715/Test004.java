package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 숫자 배열이 있다.
// 나누어 0이 떨어지는 수가 몇 쌍이 있는지 구하라!
//
// 한 줄에 버그가 있다. 고쳐라! 

// 숫자 배열: 정수로 이루어진 int[] values
// => divisorPairs(values) => divisorsPairs(int[] sequence) {}
// int[i]sequence i 배열과 int[i] sequence j 배열 두 개를 선언함
// 나누어 0이 되는 수 = 나머지가 0이 되려면 (x % y == 0)
public class Test004 {

  public static int divisorsPairs(int[] sequence) {

    int result = 0; //나누어 0이 되는 수 결과값을 카운트해주는 변수

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i; j < sequence.length; j++) { // @정답: j = i를 j = 1로 바꿔줌, 
          // i번째는 여러줄일때 사용
          if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] values = {2, 4, 8};
    System.out.println(divisorsPairs(values));

  }

}
