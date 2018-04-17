/**
 * 
 */
package ADT.ArrayList;
/**
 * @ClassName: MyArrayList
 * @Function:ʵ�����Ա��˳��洢
 * @author:Java��ͭսʿ
 * @Time:2018��4��9������10:42:19
 */
public class MyArrayList <AnyType> {
	/**
	 * �������������
	 * ARRAYLIST_SIAEΪ���Ա��ʼ����
	 * theSizeΪ������Ա��ڴ洢����
	 * theItemsΪʵ�����飬����ΪAnyType
	 * */
	static final int ARRAYLIST_SIAE=10;
	int theSize;
	AnyType[] theItems;
	
	/**
	 *����һ�����Ա� 
	 */
	public void creatMyArrayList(){
		doClear();
	}
	
	/*
	 *��յ�ǰ���Ա� 
	 * */
	public void clear(){
		doClear();
	}
	
	/**
	 *ִ�о������ղ��� 
	 */
	private void doClear() {
		theSize=0;
		Capacity(ARRAYLIST_SIAE);
	}

	/**
	 * ��չ������յ�ǰ���Ա�
	 */
	private void Capacity(int arraylistSiae) {
		if(arraylistSiae<ARRAYLIST_SIAE){
			System.out.println("�����С���󣡣���");
			return;
		}
		
		//��ʼ�����Ա������ջ�����չ
		AnyType[] old=theItems;
		theItems = (AnyType []) new Object[arraylistSiae];
		if(arraylistSiae==ARRAYLIST_SIAE) return;
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
	 }

	/**
	 * ��ȡ���Ա�ǰ����
	 */
	public int size() {
		return theSize;
	}
	
	/**
	 * �жϵ�ǰ���Ա��Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return theSize==0;
	}
	
	/**
	 * 
	 * �������Ա��ж����ڴ�
	 * */
	public void trimeToSize(){
		Capacity(size());
	}
	
	public AnyType get(int index){
		if(index<0||index>=size()){
			System.out.println("�������󣡣���");	
			System.exit(0);//��Ϊ���쳣
		}
		return theItems[index];
	}
	
	/**
	 * �޸����Ա�������
	 * @param index
	 * @param newValue
	 * @return
	 */
	public boolean set(int index,AnyType newValue){
		if(index<0||index>=size()){
			System.out.println("�������󣡣���");	
			return false;
		}
		theItems[index]=newValue;
		return true;
	}
	/**
	 * ������������
	 * @return
	 */
	public boolean add(AnyType val){
		add(size(),val);
		return true;
	}
	
	/**
	 * ָ��λ�ò�������
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
	 * �Ƴ�����
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
