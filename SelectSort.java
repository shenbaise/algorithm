/**
 * 简单选择排序：执行完一次内for循环后最小的一个数放在了数组的最前面。
 */
public class SelectSort {   
  
    /**  
     * 排序算法的实现，对数组中指定的元素进行排序  
     * @param array 待排序的数组  
     * @param from 从哪里开始排序  
     * @param end 排到哪里  
     * @param c 比较器  
     */  
    public void select(Integer[] array) {   
        int minIndex;//最小索引   
        /*  
         * 循环整个数组（其实这里的上界为 array.length - 1 即可，因为当 i= array.length-1  
         * 时，最后一个元素就已是最大的了，如果为array.length时，内层循环将不再循环），每轮假设  
         * 第一个元素为最小元素，如果从第一元素后能选出比第一个元素更小元素，则让让最小元素与第一  
         * 个元素交换   
         */  
        for (int i=0; i<array.length; i++) {   
            minIndex = i;//假设每轮第一个元素为最小元素   
            //从假设的最小元素的下一元素开始循环   
            for (int j=i+1;j<array.length; j++) {   
                //如果发现有比当前array[smallIndex]更小元素，则记下该元素的索引于smallIndex中   
                if ((array[j].compareTo(array[minIndex])) < 0) {   
                    minIndex = j;   
                }   
            }   
  
            //先前只是记录最小元素索引，当最小元素索引确定后，再与每轮的第一个元素交换   
            swap(array, i, minIndex);   
        }   
    }   
  
	public static void swap(Integer[] intgArr,int x,int y){
		//Integer temp; //这个也行
		int temp;
		temp=intgArr[x];
		intgArr[x]=intgArr[y];
		intgArr[y]=temp;
	}
	
    /**  
     * 测试  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 2, 6, 3, 8, 0, 7 };   
        SelectSort insertSort = new SelectSort();
        insertSort.select(intgArr);
        for(Integer intObj:intgArr){
			System.out.print(intObj + " ");
        }  
        
    }   
}   
