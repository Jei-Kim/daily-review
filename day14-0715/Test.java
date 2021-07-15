package com.eomcs.algorithm.quiz;

public class Test {

  public static int divisorsPairs(int[] sequence) {

    int result = 0;

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i; j < sequence.length; j++) {
        if (sequence[i] % sequence[i] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;

  }

  public static void main(String[] args) {
    int[] values = {2,4,8};
    System.out.println(divisorsPairs(values));
  }
}
