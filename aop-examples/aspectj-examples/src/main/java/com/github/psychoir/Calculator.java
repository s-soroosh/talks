package com.github.psychoir;

public class Calculator {

  public int add(int x, int y) throws InterruptedException {
    Thread.sleep(30);
    return x + y;
  }

  public long mul(int x, int y) throws InterruptedException {
    Thread.sleep(1);
    return x * y;
  }

}
