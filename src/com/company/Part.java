package com.company;

public class Part {
    private String partNumber;
    private String description;

    private Part(Builder builder) {
        partNumber = builder.partNumber;
        description = builder.description;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String description = "";
        private String partNumber = "";

        public Part build() {
           return new Part(this);
        }

        public Builder withPartNumber(String partNumber) {
            this.partNumber = partNumber;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }
    }
}
