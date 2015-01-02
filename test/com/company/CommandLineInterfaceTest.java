package com.company;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.NullOutputStream;
import org.junit.Test;

import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CommandLineInterfaceTest {

    @Test
    public void shouldReturnPartSpecifiedByInputStream() {
        String partNumber = "123XYZ";
        String description = "Big Part";

        InputStream fakeIn = IOUtils.toInputStream(partNumber + "\n" + description + "\n");

        PrintStream out = new PrintStream(new NullOutputStream());

        Part p = new CommandLineInterface(out, fakeIn).enterNewPart();

        assertEquals(partNumber, p.getPartNumber());
        assertEquals(description, p.getDescription());

    }
}