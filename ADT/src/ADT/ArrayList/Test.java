/**
 * 
 */
package ADT.ArrayList;

/**
 * @ClassName: Test
 * @Function:
 * @author:Java��ͭսʿ
 * @Time:2018��4��9������11:40:16
 */
public class Test {
public static void main(String[] args) {
	MyArrayList<Integer> sl=new MyArrayList<>();
	sl.creatMyArrayList();
	sl.add(15);
	sl.clear();
	sl.add(100);
	sl.add(0,20);
	System.out.println(sl.remove(0));
	System.out.println(sl.get(0));
 }
}
