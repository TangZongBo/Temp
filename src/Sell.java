import java.util.Date;
import java.util.Random;

import javax.naming.InitialContext;


public class Sell extends Thread {
  private static int [] arr=new int[1000000];
  private boolean flag;
  public Sell(boolean flag){
	  this.flag=flag;
  }
	@Override
	public void run() {
			 init();
       if(flag){
    	   System.out.println(getName()+"开始时间："+new Date());
    	   bubble_sort();
    	   System.out.println(getName()+"结束时间："+new Date());
       }
       else {
    	   System.out.println(getName()+"开始时间："+new Date());
    	   selection_sort();
    	   System.out.println(getName()+"结束时间："+new Date());
	}
	}
	private void selection_sort() {
		long start = System.currentTimeMillis(); 
		/*int i,j,temp;
		for(j=0;j<arr.length;j++){
			for(i=0;i<arr.length-1-j;i++){
				if(arr[i]>arr[i+1]){
					temp=arr[i];
					arr[i]=arr[i+1];
					arr[i+1]=temp;
				}
			}
		}*/
		  quicksort(arr,0,arr.length-1);
		long end = System.currentTimeMillis();
		System.out.print(getName()+"花费时间：");
		System.out.println(end-start);
	}

	
	private void quicksort(int n[], int left, int right) {
		int dp;
        if (left < right) {
            dp = partition(n, left, right);
            quicksort(n, left, dp - 1);
            quicksort(n, dp + 1, right);
        }
		
	}
	
	private int partition(int[] n, int left, int right) {
		int pivot = n[left];
        while (left < right) {
            while (left < right && n[right] >= pivot)
                right--;
            if (left < right)
                n[left++] = n[right];
            while (left < right && n[left] <= pivot)
                left++;
            if (left < right)
                n[right--] = n[left];
        }
        n[left] = pivot;
        return left;
	}
	private void bubble_sort() {
		long start = System.currentTimeMillis();
		int i,j;
		for(i=0;i<arr.length;i++){
			int max=arr[i],maxid=i;
			for(j=i;j<arr.length;j++){
				if(max<arr[j])
				{
					max=arr[i];
					maxid=j;
				}
			}
			int t;
			t=arr[i];
			arr[i]=arr[maxid];
			arr[maxid]=t;
		}
		long end = System.currentTimeMillis();  
		System.out.print(getName()+"花费时间：");
		System.out.println(end-start);
	}
	private void init() {
		Random r=new Random();
		for(int i=0;i<arr.length;i++){
			arr[i]=r.nextInt(100000)+1;
		}
	}

}
