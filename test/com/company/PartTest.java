package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartTest {

    @Test
    public void shouldBuildPart() {
        String description = "Large Part";
        String partNumber = "123XYZ";

        Part p = new Part.Builder()
                .withPartNumber(partNumber)
                .withDescription(description)
                .build();

        assertEquals(partNumber, p.getPartNumber());
        assertEquals(description, p.getDescription());
    }

}