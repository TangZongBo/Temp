

public class Demo {
      public static void main(String[] args) {
	       Sell t1=new Sell(true);
	       Sell t2=new Sell(false);
	       t1.setName("冒泡排序");
	       t2.setName("选择排序");
	       t1.start();
	       t2.start();
	}
}
