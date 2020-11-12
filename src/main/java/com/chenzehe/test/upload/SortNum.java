package com.chenzehe.test.upload;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 任给一个数组，其中只有一个元素是单独出现，其他是成对出现，输出单独的元素
 * 例如：输入：{2，2，1，1，4，4，7} 输出：7
 *
 * @author hljuczh@163.com
 */
public class SortNum {
    public static void main(String[] args) {
        int[] sortNum = {2,2,1,1,4,4,7};
        printCountNum(sortNum,1);
    }

    /**
     *
     * @param sortNum
     * @param num 出次次数
     */
    public static void printCountNum(int[] sortNum, Integer num) {
        //1算出数组中每个元素在本数据中的出现次数放到map中保存起来 2输出出现num次数的数组
        Map<Integer, Integer> countNumMap = new ConcurrentHashMap<Integer, Integer>();
        Arrays.stream(sortNum).peek(x -> {
            Integer countNum = countNumMap.get(x);
            if (countNum == null) {
                countNumMap.put(x, 1);
            } else {
                countNumMap.put(x, countNum + 1);
            }
        }).count();
        countNumMap.forEach( (k,v) -> {
            if(num.equals(v)){
                System.out.println(k);
            }
        });
    }
}