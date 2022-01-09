package com.telia.uniservice.exception;

public enum DownstreamApi {
	SERVICE_TWO("http://localhost:8091/servicetwo"),
    STRING_N("TWO")
    ;

    private final String text;
    DownstreamApi(final String text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return text;
    }
}
