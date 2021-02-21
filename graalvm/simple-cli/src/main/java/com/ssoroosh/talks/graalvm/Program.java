package com.ssoroosh.talks.graalvm;

public class Program {

  public static void main(String[] args) throws InterruptedException {
    if (args.length > 0) {
      final var sleepSeconds = Integer.parseInt(args[0]);
      Thread.sleep(sleepSeconds * 1_000L);
    }
    System.out.println("Hello world!");
  }
}
