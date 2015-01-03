package com.company;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.nio.file.StandardOpenOption.*;

public class PartDataFile implements PartData {

    private Path filePath = Paths.get("data/Part.lid");


    public PartDataFile(Path filePath) {
        this.filePath = filePath;
    }

    @Override
    public void savePart(Part p) {
        String s = p.getPartNumber() + "," + p.getDescription() + "\n";
        byte data[] = s.getBytes();

        OutputStream out = null;
        try {
            out = new BufferedOutputStream(
                Files.newOutputStream(filePath, CREATE, APPEND));

            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println("Error saving part - " + x);
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                System.err.println("Error closing file - " + e);
            }
        }
    }

    @Override
    public Part loadPart(String partNumber) {

        List<Part> parts = readParts();

        for(Part p: parts) {
            if (p.getPartNumber().equals(partNumber)) {
                return p;
            }
        }

        return null;
    }

    public List<Part> readParts() {
        BufferedReader in = null;
        List<Part> parts = new ArrayList<Part>();
        try {
            in = Files.newBufferedReader(filePath, Charset.forName("US-ASCII"));
            String line;

            while ((line = in.readLine()) != null) {

                StringTokenizer st = new StringTokenizer(line, ",");
                Part p = new Part.Builder()
                        .withPartNumber(st.nextToken())
                        .withDescription(st.nextToken())
                        .build();
                parts.add(p);
            }
        } catch (IOException e) {
            System.err.println("Error reading parts");
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                System.err.println("Error closing file - " + e);
            }
        }

        return parts;
    }
}
