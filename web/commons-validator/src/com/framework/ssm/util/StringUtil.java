package com.framework.ssm.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {
    
    public static List<String> string2List(String str) {
        List<String> list = new ArrayList<String>();
        String[] ids = str.split(",");
        if (ids != null && ids.length != 0) {
            list.addAll(Arrays.asList(ids));
        }
        return list;
    }
}
