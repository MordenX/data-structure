/**
 * 
 */
package ADT.Stack;

/**
 * @ClassName: MyStack
 * @Function:Java��������ʵ��ջ
 * @author:Java��ͭսʿ
 * @Time:2018��4��10������8:30:07
 */
public class MyStack <AnyType>{
	/**
	 * �������������
	 * ARRAYLIST_SIAEΪ���Ա��ʼ����
	 * theSizeΪ������Ա��ڴ洢����
	 * theItemsΪʵ�����飬����ΪAnyType
	 * */
	static final int ARRAYLIST_SIAE=10;
	int theTop,theFoot;
	AnyType[] theItems;
	
	/**
	 * ��ʼ������ջ
	 * */
	public void clear(){
		theTop=0;
		theFoot=0;
		Capacity(ARRAYLIST_SIAE);
	}

	/**
	 * ��ջ���չջ
	 */
	private void Capacity(int arraylistSiae) {
		if(arraylistSiae<ARRAYLIST_SIAE){
			System.out.println("�����С���󣡣���");
			return;
		}
		
		//��ʼ��ջ������ջ�����չ
		AnyType[] old=theItems;
		theItems = (AnyType []) new Object[arraylistSiae];
		if(arraylistSiae==ARRAYLIST_SIAE) return;
		for(int i=0;i<size();i++){
			theItems[i]=old[i];
		}
		
	}

	/**
	 * ��ȡ��ǰջ��Ԫ�ظ���
	 * @return
	 */
	public int size() {
		if(theTop==0) return 0; 
		return theTop-1;
	}
	
	/**
	 * �ж�ջ�Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return theTop==0;
	}
	
	/**
	 * ������ջ
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
	 * ������ջ
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
