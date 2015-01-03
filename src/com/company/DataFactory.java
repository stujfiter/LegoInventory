package com.company;

import java.nio.file.Paths;

public class DataFactory {

    public static PartData getPartData() {
        return new PartDataFile(Paths.get("data/Part.lid"));
    }
}
