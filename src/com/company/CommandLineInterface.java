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

        out.print("Enter A new Part Number: ");
        String partNumber = input.nextLine();

        out.print("Enter A Description: ");
        String description = input.nextLine();

        Part part = new Part.Builder()
                .withPartNumber(partNumber)
                .withDescription(description)
                .build();

        out.println("New Part Created: " + partNumber + "|" + description);

        return part;
    }

    public void displayVersion() {
        out.println("Lego Inventory " + Main.VERSION + "\n");
    }
}
