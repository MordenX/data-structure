/**
 * 
 */
package ADT.Stack;

/**
 * @ClassName: MyStack
 * @Function:Java采用数组实现栈
 * @author:Java青铜战士
 * @Time:2018年4月10日下午8:30:07
 */
public class MyStack <AnyType>{
	/**
	 * 定义基础变量：
	 * ARRAYLIST_SIAE为线性表初始长度
	 * theSize为标记线性表内存储数据
	 * theItems为实现数组，类型为AnyType
	 * */
	static final int ARRAYLIST_SIAE=10;
	int theTop,theFoot;
	AnyType[] theItems;
	
	/**
	 * 初始化创建栈
	 * */
	public void clear(){
		theTop=0;
		theFoot=0;
		Capacity(ARRAYLIST_SIAE);
	}

	/**
	 * 清空或扩展栈
	 */
	private void Capacity(int arraylistSiae) {
		if(arraylistSiae<ARRAYLIST_SIAE){
			System.out.println("输入大小有误！！！");
			return;
		}
		
		//开始对栈进行清空或者扩展
		AnyType[] old=theItems;
		theItems = (AnyType []) new Object[arraylistSiae];
		if(arraylistSiae==ARRAYLIST_SIAE) return;
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
		
	}

	/**
	 * 获取当前栈中元素个数
	 * @return
	 */
	public int size() {
		if(theTop==0) return 0; 
		return theTop-1;
	}
	
	/**
	 * 判断栈是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return theTop==0;
	}
	
	/**
	 * 正常入栈
	 * @return
	 */
	public boolean add(AnyType val){
		if(size()==theItems.length){
			Capacity(ARRAYLIST_SIAE*2+1);
		}
			theItems[theTop++]=val;
			return true;
	}

	/**
	 * 正常出栈
	 * @return
	 */
	public boolean remove(){
		if(size()==0){
			return false;
		}
		--theTop;
		return true;
	}
	
	public AnyType getTop(){
			return theItems[theTop-1];
		
	}
}
