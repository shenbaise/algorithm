/**
* 直接插入排序：
* 注意所有排序都是从小到大排。
*/

public class InsertSort {   
  
    /**  
     * 排序算法的实现，对数组中指定的元素进行排序  
     * @param array 待排序的数组  
     * @param from 从哪里开始排序  
     * @param end 排到哪里  
     * @param c 比较器  
     */  
    public void insert(Integer[] array, int from, int end) {   
  
        /*  
         * 第一层循环：对待插入（排序）的元素进行循环  
         * 从待排序数组断的第二个元素开始循环，到最后一个元素（包括）止  
         */  
        for (int i=from+1; i<=end; i++) {   
            /*  
             * 第二层循环：对有序数组进行循环，且从有序数组最第一个元素开始向后循环  
             * 找到第一个大于待插入的元素  
             * 有序数组初始元素只有一个，且为源数组的第一个元素，一个元素数组总是有序的  
             */  
            for (int j = 0; j < i; j++) {   
                Integer insertedElem = array[i];//待插入到有序数组的元素   
                //从有序数组中最一个元素开始查找第一个大于待插入的元素   
                if ((array[j].compareTo(insertedElem)) > 0) {   
                    //找到插入点后，从插入点开始向后所有元素后移一位   
                    move(array, j, i - 1);   
                    //将待排序元素插入到有序数组中   
                    array[j] = insertedElem;   
                    break;   
                }   
            }   
        }
        
        //=======以下是java.util.Arrays的插入排序算法的实现   
        /*  
         * 该算法看起来比较简洁一j点，有点像冒泡算法。  
         * 将数组逻辑上分成前后两个集合，前面的集合是已经排序好序的元素，而后面集合为待排序的  
         * 集合，每次内层循从后面集合中拿出一个元素，通过冒泡的形式，从前面集合最后一个元素开  
         * 始往前比较，如果发现前面元素大于后面元素，则交换，否则循环退出  
         *   
         * 总感觉这种算术有点怪怪，既然是插入排序，应该是先找到插入点，而后再将待排序的元素插  
         * 入到的插入点上，那么其他元素就必然向后移，感觉算法与排序名称不匹，但返过来与上面实  
         * 现比，其实是一样的，只是上面先找插入点，待找到后一次性将大的元素向后移，而该算法却  
         * 是走一步看一步，一步一步将待排序元素往前移  
         */  
        /*  
        for (int i = from; i <= end; i++) {  
            for (int j = i; j > from && c.compare(array[j - 1], array[j]) > 0; j--) {  
                swap(array, j, j - 1);  
            }  
        }  
        */  
    }   
  
	
	 /**  
	 * 数组元素后移  
	 * @param array 待移动的数组  
	 * @param startIndex 从哪个开始移  
	 * @param endIndex 到哪个元素止  
	 */  
	public void move(Integer[] array, int startIndex, int endIndex) {   
		for (int i = endIndex; i >= startIndex; i--) {   
			array[i+1] = array[i];   
		}   
	}   

	
    /**  
     * 测试  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 2, 6, 3, 8, 0, 7 };   
        InsertSort insertSort = new InsertSort();   
        insertSort.insert(intgArr,0,intgArr.length-1);
        for(Integer intObj:intgArr){
			System.out.print(intObj + " ");
        }
    }   
}  
