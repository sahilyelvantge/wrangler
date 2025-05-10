/*
 * Copyright ©️ 2025 Cask Data, Inc.
 * Licensed under the Apache License, Version 2.0
 */
package io.cdap.wrangler.api.parser;

public class ByteSize extends Token {
    private final long bytes;

    public ByteSize(String value) {
        super(value);
        this.bytes = parseBytes(value.trim().toUpperCase());
    }

    private long parseBytes(String val) {
        double num = Double.parseDouble(val.replaceAll("[A-Z]+", ""));
        if (val.endsWith("KB")) return (long) (num * 1024);
        if (val.endsWith("MB")) return (long) (num * 1024 * 1024);
        if (val.endsWith("GB")) return (long) (num * 1024 * 1024 * 1024);
        if (val.endsWith("TB")) return (long) (num * 1024L * 1024 * 1024 * 1024);
        if (val.endsWith("B"))  return (long) num;
        throw new IllegalArgumentException("Invalid byte unit: " + val);
    }

    public long getBytes() {
        return bytes;
    }
}
