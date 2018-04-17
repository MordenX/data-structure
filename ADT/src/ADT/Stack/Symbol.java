/**
 * 
 */
package ADT.Stack;
import java.util.Scanner;

/**
 * @ClassName: Symbol
 * @Function:ջ�жϷ���ƥ��
 * @author:Java��ͭսʿ
 * @Time:2018��4��10������9:53:19
 */
public class Symbol {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String str=in.next();
		if(judge(str)){
			System.out.println("����ƥ��ɹ�������");
		}else{
			System.out.println("����ƥ��ʧ�ܣ�����");
		}
	}

	/**
	 * 
	 * @param str
	 * @return 
	 */
	public static boolean judge(String str) {
		/**
		 * ʹ��֮ǰ��ʵ�ֵ�ջ
		 */
		MyStack<String> ms=new MyStack<>();
		ms.clear();
		/**
		 * Ϊʹ�������������ݣ�����������ջ���ź�+" "
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
		 * �ж��������Ƿ����
		 */
		if(ms.size()==0) return true;
		return false;
	}
}
