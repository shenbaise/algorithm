/**
 * 快速排序算法
 **/
public class QuickSort{
    public static void main(String[] ary){
        int[] arry = {49, 38, 65, 97, 76, 13, 27};
        sort(arry, 0, arry.length - 1);
    }
    /**
    * 一次排序单元，完成此方法，key左边都比key小，key右边都比key大。
    * @param array 排序数组
    * @param low 排序起始位置
    * @param high 排序结束位置
    * @return 单元排序后的数组
    */
    private static int sortUnit(int[] array, int low, int high){
        int key = array[low];
        while (low < high){
            //从后向前搜索比key小的值
            while (array[high] >= key && high > low)
                --high;
            //比key小的放左边
            array[low] = array[high];
            //从前向后搜索比key大的值，比key大的放右边
            while (array[low] <= key && high > low)
                ++low;
            //比key大的放右边
            array[high] = array[low];
            System.out.println(low + "," + high);
        }
        //左边都比key小，右边都比key大。将key放在游标当前位置。此时low等于high
        array[high] = key;
        System.out.println(Arrays.toString(array));
        return high;
    }
    /**
    * 快速排序
    * @param arry
    * @return
    */
    public static void sort(int[] array, int low, int high){
        if (low >= high) return;
        //完成一次单元排序
        int index = sortUnit(array, low, high);
        //对左边单元进行排序
        sort(array, low, index - 1);
        //对右边单元进行排序
        sort(array, index + 1, high);
    }
}
