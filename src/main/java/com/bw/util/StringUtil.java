package com.bw.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static boolean isEmpty(String str){
        return str == null || str.length()<1;
    }

    public static boolean isPhone(String str){
        String regex = "1[3|5|8|9]\\d{9}";
        return str.matches(regex);
    }

    public static boolean isEmail(String str){
        String regex = "\\w+@\\w+(.com|.cn|.com.cn)";
        return str.matches(regex);
    }

    public static boolean isString(String str){
        String regex = "[a-zA-Z]+";
        return str.matches(regex);
    }

    public static String getRandomString(int length){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < length; i++){
            //获取随机字符串
            //65-90 A-Z
            //97-122 a-z
            int num = (int) (Math.random()*123);
            if ((num >= 65 && num <=90) || (num >= 97 && num <= 122) ){
                char c = (char) num;
                stringBuffer.append(c);
            }else {
                i--;
            }
        }
        return stringBuffer.toString();
    }

    public static boolean isNumber(String str){
        boolean empty = StringUtil.isEmpty(str);
        if(empty){
            Pattern compile = Pattern.compile("^\\d*$");
            Matcher matcher = compile.matcher(str);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }
    }

    public static String getAChinese(int length) {
        StringBuilder str = new StringBuilder();
        int hs = 0 ;
        int ls = 0;
        Random random = new Random();
        for(int i = 0 ; i < length ; i++){
            hs = (176 + Math.abs(random.nextInt(39)));
            ls = (161 + Math.abs(random.nextInt(93)));
            byte[] b = new byte[2];
            b[0] = (new Integer(hs).byteValue());
            b[1] = (new Integer(ls).byteValue());
            try {
                str.append(new String(b, "GBk"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str.toString();
    }

    @Test
    public static void main(String[] args){
        String str = null;
        System.out.println("==1001==>"+isEmpty(str));
        System.out.println("==1002==>"+isPhone("15052748094"));
        System.out.println("==1003==>"+isEmail("906282226@qq.cn"));
        System.out.println("==1004==>"+isString("asdwqnSDsad"));
        System.out.println("==1005==>"+getRandomString(10));
        System.out.println("==1006==>"+getAChinese(10));
    }
}
