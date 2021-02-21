package com.ssoroosh.talks.graalvm;

import picocli.CommandLine.Command;

@Command(
    name = "hello",
    description = "Says hello"
)
public class HelloWorldCommand implements Runnable {

  @Override
  public void run() {
    System.out.println("Hello world");
  }
}
