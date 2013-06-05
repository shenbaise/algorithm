/**
归并排序：里面是一个递归程序，深刻理解之。
*/
public class MergeSort {   
  
    /**  
     * 递归划分数组  
     * @param arr  
     * @param from  
     * @param end  
     * @param c void  
     */  
    public void partition(Integer[] arr, int from, int end) {   
        //划分到数组只有一个元素时才不进行再划分   
        if (from < end) {   
            //从中间划分成两个数组   
            int mid = (from + end) / 2;   
            partition(arr, from, mid);   
            partition(arr, mid + 1, end);   
            //合并划分后的两个数组   
            merge(arr, from, end, mid);   
        }   
    }   
  
    /**  
     * 数组合并，合并过程中对两部分数组进行排序  
     * 前后两部分数组里是有序的  
     * @param arr  
     * @param from  
     * @param end  
     * @param mid  
     * @param c void  
     */  
    public void merge(Integer[] arr, int from, int end, int mid) {   
        Integer[] tmpArr = new Integer[10];
        int tmpArrIndex = 0;//指向临时数组   
        int part1ArrIndex = from;//指向第一部分数组   
        int part2ArrIndex = mid + 1;//指向第二部分数组   
  
        //由于两部分数组里是有序的，所以每部分可以从第一个元素依次取到最后一个元素，再对两部分   
        //取出的元素进行比较。只要某部分数组元素取完后，退出循环   
        while ((part1ArrIndex <= mid) && (part2ArrIndex <= end)) {   
            //从两部分数组里各取一个进行比较，取最小一个并放入临时数组中   
            if (arr[part1ArrIndex] - arr[part2ArrIndex] < 0) {   
                //如果第一部分数组元素小，则将第一部分数组元素放入临时数组中，并且临时数组指针   
                //tmpArrIndex下移一个以做好下次存储位置准备，前部分数组指针part1ArrIndex   
                //也要下移一个以便下次取出下一个元素与后部分数组元素比较   
                tmpArr[tmpArrIndex++] = arr[part1ArrIndex++];   
            } else {   
                //如果第二部分数组元素小，则将第二部分数组元素放入临时数组中   
                tmpArr[tmpArrIndex++] = arr[part2ArrIndex++];   
            }   
        }   
        //由于退出循环后，两部分数组中可能有一个数组元素还未处理完，所以需要额外的处理，当然不可   
        //能两部分数组都有未处理完的元素，所以下面两个循环最多只有一个会执行，并且都是大于已放入   
        //临时数组中的元素   
        while (part1ArrIndex <= mid) {   
            tmpArr[tmpArrIndex++] = arr[part1ArrIndex++];   
        }   
        while (part2ArrIndex <= end) {   
            tmpArr[tmpArrIndex++] = arr[part2ArrIndex++];   
        }   
  
        //最后把临时数组拷贝到源数组相同的位置   
        System.arraycopy(tmpArr, 0, arr, from, end - from + 1);   
    }   
  
    /**  
     * 测试  
     * @param args  
     */  
    public static void main(String[] args) {   
        Integer[] intgArr = {5,9,1,4,2,6,3,8,0,7};   
        MergeSort insertSort = new MergeSort();   
  	insertSort.partition(intgArr,0,intgArr.length-1);
		for(Integer a:intgArr){
			System.out.print(a + " ");
		}
    }   
}   
