package com.eomcs.oop.ex05.a;

public class Car {

  public String model;
  public String maker;
  public int capacity;

  public Car() {} 
  //기본생성자 추가: 자동 x 우리가 생성 o 
  //-> 생성자가 하나라도 있으면 자동으로 생성해주지 않기 때문

  public Car(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


