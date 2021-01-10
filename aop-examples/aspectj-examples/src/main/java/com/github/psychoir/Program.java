package com.github.psychoir;

public class Program {

  public static void main(String[] args) throws InterruptedException {
    Calculator calculator = new Calculator();
    for (int i = 0; i < 1_000; i++) {
      System.out.println(calculator.add(1, 2));
      System.out.println(calculator.mul(1, 2));
    }
  }
}
