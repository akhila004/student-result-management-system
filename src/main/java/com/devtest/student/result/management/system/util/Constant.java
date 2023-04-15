package com.devtest.student.result.management.system.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public final class Constant {
    public static final List<String> studentTableHeaders = Arrays.asList("#","First Name","Family Name","Date of Birth");
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
}
