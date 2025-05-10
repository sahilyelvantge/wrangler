/*
 * Copyright ©️ 2025 Cask Data, Inc.
 * Licensed under the Apache License, Version 2.0
 */
package io.cdap.wrangler.api.parser;

public class TimeDuration extends Token {
    private final long nanos;

    public TimeDuration(String value) {
        super(value);
        this.nanos = parseDuration(value.trim().toLowerCase());
    }

    private long parseDuration(String val) {
        double num = Double.parseDouble(val.replaceAll("[a-z]+", ""));
        if (val.endsWith("ns")) return (long) num;
        if (val.endsWith("us")) return (long) (num * 1_000);
        if (val.endsWith("ms")) return (long) (num * 1_000_000);
        if (val.endsWith("s"))  return (long) (num * 1_000_000_000);
        if (val.endsWith("m"))  return (long) (num * 60 * 1_000_000_000L);
        if (val.endsWith("h"))  return (long) (num * 3600 * 1_000_000_000L);
        throw new IllegalArgumentException("Invalid duration unit: " + val);
    }

    public long getNanos() {
        return nanos;
    }
}
