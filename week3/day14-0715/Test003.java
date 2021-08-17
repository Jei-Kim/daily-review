package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 배열의 전체 길이를 L이라고 하자.
// 배열을 절반(L/2)으로 나눌 때, 앞쪽 부분과 뒤쪽 부분의 위치를 바꿔라.
// 예)[2, 4, 5, 6, 4, 3, 7, 8] => [4, 3, 7, 8, 2, 4, 5, 6]

// 한 줄에 버그가 있다. 고쳐라!

public class Test003 {

  static void changeValuePosition(int[] values) {
    int tmp;
    for (int i = 0; i < values.length / 2; i++) {
      // valuse.length >> 1; 비트연산자로 표현 가능, 같은 의미임
      
      tmp = values[i + values.length / 2];
      // @정답: values[i]로 수정
      // valuse[i]는 앞에 4개 숫자
      //values[i + values.length / 2]는 절반, values[i]와 대응되는 것(뒤에 4개 숫자)
      
      values[i] = values[i + values.length / 2];
      values[i + values.length / 2] = tmp;
    }
  }
  
  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 4, 3, 7, 8};
    changeValuePosition(values);
    
    for (int v : values) {
      // for(int a : arr) 여기서 사용되는 : 는 향상된 for문의 문법
      //arr의 배열에서 하나씩 꺼내서 a 변수에 담아 반환
      System.out.print(v + ",");
    }
  }

}
