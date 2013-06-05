/**
* 基数排序：
*/
import java.util.Arrays; 
public class RadixSort {   
  
    /**  
     * 取数x上的第d位数字  
     * @param x 数  
     * @param d 第几位，从低位到高位  
     * @return  
     */  
    public int digit(long x, long d) {   
  
        long pow = 1;   
        while (--d > 0) {   
            pow *= 10;   
        }   
        return (int) (x / pow % 10);   
    }   
  
    /**  
     * 基数排序实现，以升序排序（下面程序中的位记录器count中，从第0个元素到第9个元素依次用来  
     * 记录当前比较位是0的有多少个..是9的有多少个数，而降序时则从第0个元素到第9个元素依次用来  
     * 记录当前比较位是9的有多少个..是0的有多少个数）  
     * @param arr 待排序数组  
     * @param digit 数组中最大数的位数  
     * @return  
     */  
    public long[] radixSortAsc(long[] arr) {   
        //从低位往高位循环   
        for (int d = 1; d <= getMax(arr); d++) {   
            //临时数组，用来存放排序过程中的数据   
            long[] tmpArray = new long[arr.length];   
            //位记数器，从第0个元素到第9个元素依次用来记录当前比较位是0的有多少个..是9的有多少个数   
            int[] count = new int[10];   
            //开始统计0有多少个，并存储在第0位，再统计1有多少个，并存储在第1位..依次统计到9有多少个   
            for (int i = 0; i < arr.length; i++) {   
                count[digit(arr[i], d)] += 1;   
            }   
            /*  
             * 比如某次经过上面统计后结果为：[0, 2, 3, 3, 0, 0, 0, 0, 0, 0]则经过下面计算后 结果为：  
             * [0, 2, 5, 8, 8, 8, 8, 8, 8, 8]但实质上只有如下[0, 2, 5, 8, 0, 0, 0, 0, 0, 0]中  
             * 非零数才用到，因为其他位不存在，它们分别表示如下：2表示比较位为1的元素可以存放在索引为1、0的  
             * 位置，5表示比较位为2的元素可以存放在4、3、2三个(5-2=3)位置，8表示比较位为3的元素可以存放在  
             * 7、6、5三个(8-5=3)位置  
             */  
            for (int i = 1; i < 10; i++) {   
                count[i] += count[i - 1];   
            }   
  
            /*  
             * 注，这里只能从数组后往前循环，因为排序时还需保持以前的已排序好的 顺序，不应该打  
             * 乱原来已排好的序，如果从前往后处理，则会把原来在前面会摆到后面去，因为在处理某个  
             * 元素的位置时，位记数器是从大到到小（count[digit(arr[i], d)]--）的方式来处  
             * 理的，即先存放索引大的元素，再存放索引小的元素，所以需从最后一个元素开始处理。  
             * 如有这样的一个序列[212,213,312]，如果按照从第一个元素开始循环的话，经过第一轮  
             * 后（个位）排序后，得到这样一个序列[312,212,213]，第一次好像没什么问题，但问题会  
             * 从第二轮开始出现，第二轮排序后，会得到[213,212,312]，这样个位为3的元素本应该  
             * 放在最后，但经过第二轮后却排在了前面了，所以出现了问题  
             */  
            for (int i = arr.length - 1; i >= 0; i--) {//只能从最后一个元素往前处理   
                //for (int i = 0; i < arr.length; i++) {//不能从第一个元素开始循环   
                tmpArray[count[digit(arr[i], d)] - 1] = arr[i];   
                count[digit(arr[i], d)]--;   
            }   
  
            System.arraycopy(tmpArray, 0, arr, 0, tmpArray.length);   
        }   
        return arr;   
    }   
  
    /**  
     * 基数排序实现，以降序排序（下面程序中的位记录器count中，从第0个元素到第9个元素依次用来  
     * 记录当前比较位是0的有多少个..是9的有多少个数，而降序时则从第0个元素到第9个元素依次用来  
     * 记录当前比较位是9的有多少个..是0的有多少个数）  
     * @param arr 待排序数组  
     * @return  
     */  
    public long[] radixSortDesc(long[] arr) {   
        for (int d = 1; d <= getMax(arr); d++) {   
            long[] tmpArray = new long[arr.length];   
            //位记数器，从第0个元素到第9个元素依次用来记录当前比较位是9的有多少个..是0的有多少个数   
            int[] count = new int[10];   
            //开始统计0有多少个，并存储在第9位，再统计1有多少个，并存储在第8位..依次统计   
            //到9有多少个，并存储在第0位   
            for (int i = 0; i < arr.length; i++) {   
                count[9 - digit(arr[i], d)] += 1;   
            }   
  
            for (int i = 1; i < 10; i++) {   
                count[i] += count[i - 1];   
            }   
  
            for (int i = arr.length - 1; i >= 0; i--) {   
                tmpArray[count[9 - digit(arr[i], d)] - 1] = arr[i];   
                count[9 - digit(arr[i], d)]--;   
            }   
  
            System.arraycopy(tmpArray, 0, arr, 0, tmpArray.length);   
        }   
        return arr;   
    }   
  
    private int getMax(long[] array) {   
        int maxlIndex = 0;   
        for (int j = 1; j < array.length; j++) {   
            if (array[j] > array[maxlIndex]) {   
                maxlIndex = j;   
            }   
        }   
        return String.valueOf(array[maxlIndex]).length();   
    }   
  
    public static void main(String[] args) {   
        long[] ary = new long[] { 123, 321, 132, 212, 213, 312, 21, 223 };   
        RadixSort rs = new RadixSort();   
        System.out.println("升 - " + Arrays.toString(rs.radixSortAsc(ary)));   
  
        ary = new long[] { 123, 321, 132, 212, 213, 312, 21, 223 };   
        System.out.println("降 - " + Arrays.toString(rs.radixSortDesc(ary)));   
    }   
}  
