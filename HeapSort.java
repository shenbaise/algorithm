/**
* 选择排序之堆排序：
*/
public class HeapSort {   
  
    /**  
     * 排序算法的实现，对数组中指定的元素进行排序  
     * @param array 待排序的数组  
     * @param from 从哪里开始排序  
     * @param end 排到哪里  
     * @param c 比较器  
     */  
    public void sort(Integer[] array, int from, int end) {   
        //创建初始堆   
        initialHeap(array, from, end);   
  
        /*  
         * 对初始堆进行循环，且从最后一个节点开始，直接树只有两个节点止  
         * 每轮循环后丢弃最后一个叶子节点，再看作一个新的树  
         */  
        for (int i = end - from + 1; i >= 2; i--) {   
            //根节点与最后一个叶子节点交换位置，即数组中的第一个元素与最后一个元素互换   
            swap(array, from, i - 1);   
            //交换后需要重新调整堆   
            adjustNote(array, 1, i - 1);   
        }   
  
    }   
  
    /**  
     * 初始化堆  
     * 比如原序列为：7,2,4,3,12,1,9,6,8,5,10,11  
     * 则初始堆为：1,2,4,3,5,7,9,6,8,12,10,11  
     * @param arr 排序数组  
     * @param from 从哪  
     * @param end 到哪  
     * @param c 比较器  
     */  
    private void initialHeap(Integer[] arr, int from, int end) {   
        int lastBranchIndex = (end - from + 1) / 2;//最后一个非叶子节点   
        //对所有的非叶子节点进行循环 ，且从最一个非叶子节点开始   
        for (int i = lastBranchIndex; i >= 1; i--) {   
            adjustNote(arr, i, end - from + 1);   
        }   
    }   
  
    /**  
     * 调整节点顺序，从父、左右子节点三个节点中选择一个最大节点与父节点转换  
     * @param arr 待排序数组  
     * @param parentNodeIndex 要调整的节点，与它的子节点一起进行调整  
     * @param len 树的节点数  
     * @param c 比较器  
     */  
    private void adjustNote(Integer[] arr, int parentNodeIndex, int len) {   
        int minNodeIndex = parentNodeIndex;   
        //如果有左子树，i * 2为左子节点索引    
        if (parentNodeIndex * 2 <= len) {   
            //如果父节点小于左子树时    
            if ((arr[parentNodeIndex - 1].compareTo(arr[parentNodeIndex * 2 - 1])) < 0) {   
                minNodeIndex = parentNodeIndex * 2;//记录最大索引为左子节点索引    
            }   
  
            // 只有在有或子树的前提下才可能有右子树，再进一步断判是否有右子树    
            if (parentNodeIndex * 2 + 1 <= len) {   
                //如果右子树比最大节点更大    
                if ((arr[minNodeIndex - 1].compareTo(arr[(parentNodeIndex * 2 + 1) - 1])) < 0) {   
                    minNodeIndex = parentNodeIndex * 2 + 1;//记录最大索引为右子节点索引    
                }   
            }   
        }   
  
        //如果在父节点、左、右子节点三都中，最大节点不是父节点时需交换，把最大的与父节点交换，创建大顶堆   
        if (minNodeIndex != parentNodeIndex) {   
            swap(arr, parentNodeIndex - 1, minNodeIndex - 1);   
            //交换后可能需要重建堆，原父节点可能需要继续下沉   
            if (minNodeIndex * 2 <= len) {//是否有子节点，注，只需判断是否有左子树即可知道   
                adjustNote(arr, minNodeIndex, len);   
            }   
        }   
    }   
  
			/**  
     * 交换数组中的两个元素的位置  
     * @param array 待交换的数组  
     * @param i 第一个元素  
     * @param j 第二个元素  
     */  
    public void swap(Integer[] array, int i, int j) {   
        if (i != j) {//只有不是同一位置时才需交换   
            Integer tmp = array[i];   
            array[i] = array[j];   
            array[j] = tmp;   
        }   
    } 
	
    /**   
    * 测试   
    * @param args   
    */  
    public static void main(String[] args) {   
        Integer[] intgArr = { 5, 9, 1, 4, 2, 6, 3, 8, 0, 7 };  
        HeapSort heapsort = new HeapSort();   
        heapsort.sort(intgArr,0,intgArr.length-1);
        for(Integer intObj:intgArr){
			System.out.print(intObj + " ");
        }
    }   
  
}  
