package com.bw.util;

import java.text.SimpleDateFormat;

public class IntergetUtil {
    public static SimpleDateFormat StringToDate(String birthday){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format;
    }
}
