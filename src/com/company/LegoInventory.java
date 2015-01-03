package com.company;

public class LegoInventory {

    public static final String VERSION = "0.1";

    static CommandLineInterface cli = new CommandLineInterface(System.out, System.in);
    static PartData data = DataFactory.getPartData();
    static boolean running = true;

    public static void main(String[] args) {

        cli.displayVersion();

         while (running)  {
             String command = cli.showPrompt();
             running = processCommand(command);
        }
    }

    private static boolean processCommand(String command) {

        String[] args = command.split(" ");

        if (args.length > 0 && args[0].equals("quit")) {
            return false;
        }

        else if (args.length > 0 && args[0].equals("new")) {
            Part p = cli.enterNewPart();
            data.savePart(p);
            cli.showPartSaved(p);
        }

        else if (args.length > 1 && args[0].equals("load")) {
            loadPart(args[1]);
        }

        else {
            cli.showInvalidCommand();
        }

        return true;
    }

    public static void loadPart(String partNumber) {
        Part p = data.loadPart(partNumber);
        if (p == null) {
            cli.showInvalidPart(partNumber);
        } else {
            cli.showPart(p);
        }
    }
}
