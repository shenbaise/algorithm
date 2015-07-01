/**
* 插入排序----希尔排序：我们选择步长为：15,7,3,1
* 我们选择步长公式为：2^k-1,2^(k-1)-1,……,15,7,3,1  	(2^4-1,2^3-1,2^2-1,2^1-1)
* 注意所有排序都是从小到大排。
*/
public class ShellSort {   
  
    /**  
     * 排序算法的实现，对数组中指定的元素进行排序  
     * @param array 待排序的数组  
     * @param from 从哪里开始排序  
     * @param end 排到哪里  
     * @param c 比较器  
     */  
    public void sort(Integer[] array, int from, int end) {   
        //初始步长，实质为每轮的分组数   
        int step = initialStep(end - from + 1);   
  
        //第一层循环是对排序轮次进行循环。(step + 1) / 2 - 1 为下一轮步长值   
        for (; step >= 1; step = (step + 1) / 2 - 1) {   
            //对每轮里的每个分组进行循环   
            for (int groupIndex = 0; groupIndex < step; groupIndex++) { 
                //对每组进行直接插入排序   
                insertSort(array, groupIndex, step, end);   
            }   
        }   
    }   
  
    /**  
     * 直接插入排序实现  
     * @param array 待排序数组  
     * @param groupIndex 对每轮的哪一组进行排序  
     * @param step 步长  
     * @param end 整个数组要排哪个元素止  
     * @param c 比较器  
     */  
    public void insertSort(Integer[] array, int groupIndex, int step, int end) {   
        int startIndex = groupIndex;//从哪里开始排序   
        int endIndex = startIndex;//排到哪里   
        /*  
         * 排到哪里需要计算得到，从开始排序元素开始，以step步长，可求得下元素是否在数组范围内，  
         * 如果在数组范围内，则继续循环，直到索引超现数组范围  
         */  
        while ((endIndex + step) <= end) {   
            endIndex += step;   
        }   
  
        // i为每小组里的第二个元素开始   
        for (int i = groupIndex + step; i <= end; i += step) {   
            for (int j = groupIndex; j < i; j += step) {   
                Integer insertedElem = array[i];   
                //从有序数组中最一个元素开始查找第一个大于待插入的元素   
                if ((array[j].compareTo(insertedElem)) >= 0) {   
                    //找到插入点后，从插入点开始向后所有元素后移一位   
                    move(array, j, i - step, step);   
                    array[j] = insertedElem;   
                    break;   
                }   
            }   
        }   
    }   
  
    /**  
     * 根据数组长度求初始步长  
     *   
     * 我们选择步长的公式为：2^k-1,2^(k-1)-1,...,15,7,3,1 ，其中2^k 减一即为该步长序列，k  
     * 为排序轮次  
     *   
     * 初始步长：step = 2^k-1   
     * 初始步长约束条件：step < len - 1 初始步长的值要小于数组长度还要减一的值（因  
     * 为第一轮分组时尽量不要分为一组，除非数组本身的长度就小于等于4）  
     *   
     * 由上面两个关系试可以得知：2^k - 1 < len - 1 关系式，其中k为轮次，如果把 2^k 表 达式  
     * 转换成 step 表达式，则 2^k-1 可使用 (step + 1)*2-1 替换（因为 step+1 相当于第k-1  
     * 轮的步长，所以在 step+1 基础上乘以 2 就相当于 2^k 了），即步长与数组长度的关系不等式为  
     * (step + 1)*2 - 1 < len -1  
     *   
     * @param len 数组长度  
     * @return  
     */  
    public static int initialStep(int len) {   
        /*  
         * 初始值设置为步长公式中的最小步长，从最小步长推导出最长初始步长值，即按照以下公式来推:  
         * 1,3,7,15,...,2^(k-1)-1,2^k-1  
         * 如果数组长度小于等于4时，步长为1，即长度小于等于4的数组不用分组，此时直接退化为直接插入排序  
         */  
        int step = 1;   
  
        //试探下一个步长是否满足条件，如果满足条件，则步长置为下一步长   
        while ((step + 1) * 2 - 1 < len - 1) {   
            step = (step + 1) * 2 - 1;   
        }   
  
        System.out.println("初始步长 : " + step);   
        return step;   
    }   
	
	/**  
	 * 以指定的步长将数组元素后移，步长指定每个元素间的间隔  
	 * @param array 待排序数组  
	 * @param startIndex 从哪里开始移  
	 * @param endIndex 到哪个元素止  
	 * @param step 步长  
	 */  
	protected final void move(Integer[] array, int startIndex, int endIndex, int step) 	{   
		for (int i = endIndex; i >= startIndex; i -= step) {   
			array[i + step] = array[i];   
		}   
	}   

	
    /**  
     * 测试  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 8, 2, 6, 3, 7, 0 };   
        ShellSort shellSort = new ShellSort();   
        shellSort.sort(intgArr,0,intgArr.length-1);
        for(Integer intObj:intgArr){
			System.out.print(intObj + " ");
        }
    }   
}   
