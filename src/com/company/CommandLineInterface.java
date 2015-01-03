package com.company;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class CommandLineInterface {

    private PrintStream out;
    private InputStream in;

    public CommandLineInterface(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public Part enterNewPart() {
        Scanner input = new Scanner(in);

        out.print("Enter a new Part Number: ");
        String partNumber = input.nextLine();

        out.print("Enter a Description: ");
        String description = input.nextLine();

        return new Part.Builder()
                .withPartNumber(partNumber)
                .withDescription(description)
                .build();
    }

    public void showPartSaved(Part part) {
        out.println("New Part Created.\n");
        showPart(part);
    }


    public void displayVersion() {
        out.println("Lego Inventory " + LegoInventory.VERSION + "\n");
    }

    public void showInvalidPart(String partNumber) {
        out.println("Part " + partNumber + " does not exist.");
    }

    public void showPart(Part p) {
        out.println("Part Number: " + p.getPartNumber() + "\tDescription: " + p.getDescription());
    }

    public String showPrompt() {
        out.print("legoi# ");
        Scanner input = new Scanner(in);
        return input.nextLine();
    }

    public void showInvalidCommand() {
        out.println("Invalid Command");
    }
}
