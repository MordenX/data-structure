/**
 * 
 */
package ADT.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;


/**
 * @ClassName: SymbolChange
 * @Function:中缀表达式转换后缀
 * @author:Java青铜战士
 * @Time:2018年4月11日下午11:47:28
 */
public class SymbolChange {	
	
	public static void main(String[] args) {
		Map<Character, Integer> beforemap =
	            new HashMap<Character, Integer>();
		Map<Character, Integer> lastmap =
	            new HashMap<Character, Integer>();
		beforemap.put('(', 4);
		beforemap.put('*', 2);
		beforemap.put('#', 0);
		beforemap.put('/', 2);
		beforemap.put('+', 1);
		beforemap.put('-', 1);
		beforemap.put(')', -1);
		lastmap.put('(', -1);
		lastmap.put('*', 2);
		lastmap.put('/', 2);
		lastmap.put('+', 1);
		lastmap.put('-', 1);
		Scanner in=new Scanner(System.in);
		String str=in.next();
		Stack1 s=new Stack1();
		for (int i = 0; i < str.length(); ) {
			if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
				System.out.print(str.charAt(i));
			}else{
				if(s.isEmpty() ){
					s.input(str.charAt(i));
				}
				else if( beforemap.get(str.charAt(i))>lastmap.get(s.getTop()) ){
					s.input(str.charAt(i));
				}else{
					if(s.getTop()!='('){
						System.out.print(s.getTop());
					}else{
						i++;
					}
					i--;
					s.out();
				}
			}
			i++;
		}
		int l=s.size();
		if(!s.isEmpty()){
			for(int i=0;i<l;i++){
				System.out.print(s.getTop());
				s.out();
			}
		}
	}
	
	
	
	
	static class Stack1{
		char[] sta;
		 int theTop;
		public Stack1(){
			sta=new char[20];
			this.theTop=0;
		}
		
	public int size(){
		return theTop;
	}
		
	public char getTop(){
		return sta[theTop-1];
	}
	public boolean isEmpty(){
		return theTop==0;
	}
		public void input(char c){
			sta[theTop]=c;
			theTop++;
		}
		
		public char out(){
			return sta[theTop--];
		}
		
	
	}
}

