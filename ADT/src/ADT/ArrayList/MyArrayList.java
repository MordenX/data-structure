/**
 * 
 */
package ADT.ArrayList;
/**
 * @ClassName: MyArrayList
 * @Function:实现线性表的顺序存储
 * @author:Java青铜战士
 * @Time:2018年4月9日下午10:42:19
 */
public class MyArrayList <AnyType> {
	/**
	 * 定义基础变量：
	 * ARRAYLIST_SIAE为线性表初始长度
	 * theSize为标记线性表内存储数据
	 * theItems为实现数组，类型为AnyType
	 * */
	static final int ARRAYLIST_SIAE=10;
	int theSize;
	AnyType[] theItems;
	
	/**
	 *创建一个线性表 
	 */
	public void creatMyArrayList(){
		doClear();
	}
	
	/*
	 *清空当前线性表 
	 * */
	public void clear(){
		doClear();
	}
	
	/**
	 *执行具体的清空操作 
	 */
	private void doClear() {
		theSize=0;
		Capacity(ARRAYLIST_SIAE);
	}

	/**
	 * 扩展或者清空当前线性表
	 */
	private void Capacity(int arraylistSiae) {
		if(arraylistSiae<ARRAYLIST_SIAE){
			System.out.println("输入大小有误！！！");
			return;
		}
		
		//开始对线性表进行清空或者扩展
		AnyType[] old=theItems;
		theItems = (AnyType []) new Object[arraylistSiae];
		if(arraylistSiae==ARRAYLIST_SIAE) return;
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
	 }

	/**
	 * 获取线性表当前长度
	 */
	public int size() {
		return theSize;
	}
	
	/**
	 * 判断当前线性表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return theSize==0;
	}
	
	/**
	 * 
	 * 清理线性表中多余内存
	 * */
	public void trimeToSize(){
		Capacity(size());
	}
	
	public AnyType get(int index){
		if(index<0||index>=size()){
			System.out.println("输入有误！！！");	
			System.exit(0);//改为抛异常
		}
		return theItems[index];
	}
	
	/**
	 * 修改线性表中数据
	 * @param index
	 * @param newValue
	 * @return
	 */
	public boolean set(int index,AnyType newValue){
		if(index<0||index>=size()){
			System.out.println("输入有误！！！");	
			return false;
		}
		theItems[index]=newValue;
		return true;
	}
	/**
	 * 正常插入数据
	 * @return
	 */
	public boolean add(AnyType val){
		add(size(),val);
		return true;
	}
	
	/**
	 * 指定位置插入数据
	 * @param size
	 * @param val
	 */
	public boolean add(int size, AnyType val) {
		if(size<0||size>size()){
			return false;
		}
		if(theItems.length==size()){
			Capacity(ARRAYLIST_SIAE*2+1);
		}
		for (int i = theSize; i >size; i--) {
			theItems[i]=theItems[i-1];
		}
		theItems[size]=val;
		theSize++;
		return true;
	}
	/**
	 * 移除数据
	 * @param index
	 * @return
	 */
	public boolean remove(int index){
		if(index<0||index>=size()){
			return false;
		}
		for(int i=index;i<size()-1;i++){
			theItems[i]=theItems[i+1];
		}
		theSize--;
		return true;
	}
}
