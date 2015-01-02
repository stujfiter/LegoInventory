package com.company;

public class Main {

    public static final String VERSION = "0.1";

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface(System.out, System.in);
        cli.displayVersion();
        Part p = cli.enterNewPart();
    }
}
