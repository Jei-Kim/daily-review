package com.eomcs.algorithm.quiz;

// 출처: codefights.com
//
// 숫자 배열에서 각 이웃하는 숫자간의 차가 가장 큰 것을 알아내기
// 예)
// [2, 4, 1, 0] => 3
// 
// 한 줄에 버그가 있다. 고쳐라!

public class Test002 {

  static int maxDiff(int[] values) {
    int answer = 1;
    for (int i = 1; i < values.length; i++) { 
      // int i =1; 1부터 시작해야 두번째 숫자인 4부터 시작할 수 있음.
      // 0부터 시작하려면 for (int i =0; i < values.length-1, i++)
      
      if ((values[i] - values[i - 1]) > answer) {
        //answer = 1 , 1보다 뺀 간격 차이가 크면 실행
        //@정답: Math.abs(values[i] - values [i-1]) : 절대값으로 바꿔줌
        // 가장 큰 수를 찾는 게 아니라, 
        //가장 큰 간격을 찾는 것이기 때문에 양음수 무관하게 만드려고!
        
        answer = Math.abs(values[i] - values[i-1]);
      }
    }
    
    return answer;
  }
  
  public static void main(String[] args) {
    System.out.println(maxDiff(new int[]{2, 4, 1, 0})); 
    // 배열이 들어간 것이 아니라 arr배열의 주소가 넣어진것임!
    // int [] arr = new int[]{2, 4, 1, 0};
    // int result = maxDiff(arr);
    // System.out.println(result);
    // 이걸 한 줄로 표현한 것!!

  }

}
