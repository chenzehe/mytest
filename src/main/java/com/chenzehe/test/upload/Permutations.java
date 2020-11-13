package com.chenzehe.test.upload;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * 类 描 述
 * 排列：
 *   从n个数中选取m（m<=n）个数按照一定的顺序进行排成一个列，叫作从n个元素中取m个元素的一个排列。不同的顺序是一个不同的排列。从n个元素中取m个元素的所有排列的个数，称为排列数。
 *
 * 全排列：
 *   从n个元素取出n个元素的一个排列，称为一个全排列。全排列的排列数公式为
 *
 * 时间复杂度：
 *   n个数的全排列有n!种，每一个排列都有n个数据，所以输出的时间复杂度为O(n*n!)，呈指数级，无法处理大型数据。
 *
 * 二、递归的全排列算法
 * 算法思路：
 * 假设我们要对1，2，3，4四个数进行全排列，过程如下：
 *   (a)首先保持1不变，对2，3，4全排列；
 *   (b)保持2不变，对3，4全排列；
 *   (c)保持3不变，对4全排列，4的排列只有一种。得到1，2，3，4
 *   (d)然后3不能不变了，继续保持2不变，3，4互换得到1，2，4，3
 *   (e)以1，2打头的排列完成，接下来把3换到2的位置，继续(c)、(d)的操作
 *   ……
 *  得到1，3，2，4
 *    1，3，4，2
 *    1，4，3，2
 *    1，4，2，3
 *   因此得到以1打头的全部排序，以此类推，得到以2，3，4打头的排序，得到全排序。
 *
 * 将以上过程总结成一个递归算法：
 *   任取一个数打头，对后面n-1个数进行全排序，要求n-1个数的全排序，则要求n-2个数的全排序……直到要求的全排序只有一个数，找到出口。
 *
 * 链接：https://www.jianshu.com/p/50a27d7d2972
 *
 * 创 建 人：hljuczh@163.com
 * 创建时间：2020/11/13 11:46
 */
public class Permutations {

    public static void main(String[] args) {
        int[] array = {1,2,3};
        permutation(array,0,array.length-1);
    }

    public static void permutation(int[] array, int index, int end){
        if(index == end){
            System.out.println(Arrays.toString(array));
        }else{
            for (int i = index; i <= end; i++) {
                ArrayUtils.swap(array,index,i);
                permutation(array,index+1,end);
                ArrayUtils.swap(array,index,i);
            }
        }

    }

}
