/**
 * 
 */
package ADT.Stack;
import java.util.Scanner;

/**
 * @ClassName: Symbol
 * @Function:栈判断符号匹配
 * @author:Java青铜战士
 * @Time:2018年4月10日下午9:53:19
 */
public class Symbol {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.next();
		if(judge(str)){
			System.out.println("括号匹配成功！！！");
		}else{
			System.out.println("括号匹配失败！！！");
		}
	}

	/**
	 * 
	 * @param str
	 * @return 
	 */
	public static boolean judge(String str) {
		/**
		 * 使用之前所实现的栈
		 */
		MyStack<String> ms=new MyStack<>();
		ms.clear();
		/**
		 * 为使用引用类型数据，故在所有入栈符号后+" "
		 */
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='[' || str.charAt(i)=='{' || str.charAt(i)=='('){
				ms.add(str.charAt(i)+" ");
			}else if(str.charAt(i)==']'){
				if(ms.getTop().equals("[ ")&&ms.size()!=0){
					ms.remove();
				}else{
					return false;
				}
			}else if(str.charAt(i)=='}'){
				if(ms.getTop().equals("{ ")&&ms.size()!=0){
					ms.remove();
				}else{
					return false;
				}
			}else if(str.charAt(i)==')'){
				if(ms.getTop().equals(") ")&&ms.size()!=0){
					ms.remove();
				}else{
					return false;
				}
			}
		}
		/**
		 * 判断左括号是否多余
		 */
		if(ms.size()==0) return true;
		return false;
	}
}
