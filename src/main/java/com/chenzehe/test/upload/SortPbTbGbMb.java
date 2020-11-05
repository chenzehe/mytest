package com.chenzehe.test.upload;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 任给一个数组，元素有20M，1T，300G之类的，其中1T=1024G，1G=1024M 按从小到大输出结果
 * 算法：1、使用位移运算把单位统一换成最小单位B 2、使用JDK8 Stream自带sorted排序输出
 * @author hljuczh@163.com
 */
public class SortPbTbGbMb {

    public static void main(String[] args) {

        System.out.println(bString2Bytes("900B"));
        System.out.println(bString2Bytes("1K"));
        System.out.println(bString2Bytes("10K"));
        System.out.println(bString2Bytes("3M"));
        System.out.println(bString2Bytes("999P"));

        String[] bytesStr = {"39K","200M","1P","10G"};
        Arrays.stream(bytesStr).sorted(Comparator.comparing(x -> bString2Bytes(x))).forEach(System.out::println);

    }

    /**
     * 把大单位全部转成B为单位
     * @param bString
     * @return
     */
    public static Long bString2Bytes(String bString){
        //1PB = 1024TB = 1024 * 1024 GB = 1024 * 1024 * 1024 MB = 1024 * 1024* 1024 * 1024 KB = 1024 * 1024* 1024 * 1024 * 1024 B
        //1024 = 2*2*2*2*2*2*2*2*2*2
        Long bResult = null;
        Long num = Long.valueOf(bString.substring(0,bString.length()-1));
        char endChar = bString.charAt(bString.length()-1);
        switch (endChar){
            case 'B':
                bResult = num;
                break;
            case 'K':
                bResult = num << 10;
                break;
            case 'M':
                bResult = num << 20;
                break;
            case 'G':
                bResult = num << 30;
                break;
            case 'T':
                bResult = num << 40;
                break;
            case 'P':
                bResult = num << 50;
                break;
            default:
                break;

        }

        return  bResult;
    }

    /**
     * 把小单位转成大单位
     * @param bBytes
     * @return
     */
    public static String bBytes2String(Long bBytes){
        int i = 0;
        String result = null;
        while (bBytes >= 1024){
            bBytes = bBytes >> 10;
            i++;
        }

        switch (i){
            case 0:
                result = bBytes.toString() + "B";
                break;
            case 1:
                result = bBytes.toString() + "K";
                break;
            case 2:
                result = bBytes.toString() + "M";
                break;
            case 3:
                result = bBytes.toString() + "B";
                break;
            case 4:
                result = bBytes.toString() + "T";
                break;
            case 5:
                result = bBytes.toString() + "P";
                break;
            default:
                break;

        }
        return result;
    }
}
