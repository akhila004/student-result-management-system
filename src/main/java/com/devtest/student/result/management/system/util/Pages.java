package com.devtest.student.result.management.system.util;

public enum Pages {
    HOME("HOME"),
    STUDENTS("STUDENTS"),
    COURSES("COURSES"),
    RESULTS("RESULTS");

    public final String label;

    private Pages(String label) {
        this.label = label;
    }
}
