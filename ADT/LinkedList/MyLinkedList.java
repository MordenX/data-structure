/**
 * 
 */
package ADT.LinkedList;

/**
 * @ClassName: MyLinkedList
 * @Function:˫�����ʵ��
 * @author:Java��ͭսʿ
 * @Time:2018��4��10������10:40:50
 */
public class MyLinkedList <AnyType>{
	/**
	 * @ClassName: Node
	 * @Function:�ڲ��࣬ʹ�ö����ʾ���
	 * ����data����������prev����ǰ����ַ��next�����̵�ַ
	 * @author:Java��ͭսʿ
	 * @Time:2018��4��10������10:45:30
	 *@param <AnyType>
	 */
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		/**
		 * �������ʱ����ͨ���˷�������ȷ��ǰ��ָ��
		 * @param d
		 * @param p
		 * @param n
		 */
		public Node(AnyType d,Node<AnyType> p, Node<AnyType> n){
			data=d;
			prev=p;
			next=n;
		}
	}
	
	/**
	 * �����������
	 */
	private int theSize;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	/**
	 * ����˫������
	 */
	public MyLinkedList(){
		doclear();
	}
	/**
	 * ���˫������
	 */
	public void clear(){
		doclear();
	}
	
	/**
	 * ִ�о�����գ���������
	 */
	private void doclear() {
		beginMarker=new Node<AnyType>(null, null, null);
		endMarker=new Node<AnyType>(null, beginMarker, null);
		beginMarker.next=endMarker;
		theSize=0;
	}

	/**
	 * ��ȡ������
	 * @return
	 */
	public int size(){
		return theSize;
	}
	
	/**
	 * �ж������Ƿ�Ϊ��
	 * @return
	 */
	public boolean isEmpty(){
		return theSize==0;
	}
	/**
	 * ��ȡ������ݣ������岻�ڴ�ִ����Ӳ���
	 * @param val
	 * @return
	 */
	public boolean add(AnyType val){
		add(size(),val);
		return true;
	}
	
	/**
	 * �˴���getNode()�������صĽ�����������ȫ���ύ������ִ����ӷ���
	 * @param size
	 * @param val
	 */
	public void add(int size, AnyType val) {
		addBefore(getNode(size,0,size()),val);
	}
	/**
	 * ִ�о�����Ӳ���
	 * @param node
	 * @param val 
	 */
	private void addBefore(Node<AnyType> p, AnyType val) {
		//��β���ǰ��ָ���Լ�������ݸ����½��
		Node<AnyType> newNode=new Node<>(val,p.prev,p);
		newNode.prev.next=newNode;
		p.prev=newNode;
		theSize++;
	}
	
	/**
	 * ��ȡ����
	 * @param idx
	 * @return
	 */
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	
	/**
	 * ��������
	 * @param idx
	 * @param val
	 * @return
	 */
	public boolean set(int idx,AnyType val){
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=val;
		return true;
	}
	
	/**
	 * ɾ������
	 * @param idx
	 * @return
	 */
	public boolean remove(int idx){
		return remove(getNode(idx));
	}
	
	/**
	 * ͨ��getNode()������ȡ��Ҫɾ���Ľ��ǰһ�����ߺ�һ�����
	 * @param node
	 * @return
	 */
	private boolean remove(Node<AnyType> node) {
		node.next.prev=node.prev;
		node.prev.next=node.next;
		theSize--;
		return true;
	}
	/**
	 * �˴�Ϊֻ����һ��������getNode()������ȫ������Ϣ
	 * @param size
	 * @param i
	 * @param size2
	 * @param val
	 * @return
	 */
	private Node<AnyType> getNode(int size) {

		return getNode(size,0,size()-1);
	}
	/**
	 * �˴������ṩɾ�����������Ӳ���ʱ����Ҫ�Ľ��
	 * ������λ��С���������峤�ȵ�һ����ӱ�ͷ��ʼ���Ҳ���λ��
	 * ������λ�ô����������峤�ȵ�һ����ӱ�β��ʼ���Ҳ���λ��
	 * @param size
	 * @param i
	 * @param j
	 * @return
	 */
	private Node<AnyType> getNode(int size, int lower, int upper) {
		Node<AnyType> p;
		if(size<lower || size>upper)
			throw new IndexOutOfBoundsException();
		if(size<size()/2){
			p=beginMarker.next;
			for (int i = 0; i < size; i++) {
				p=p.next;
			}
		}else{
			p=endMarker;
			for (int i = size(); i >size; i--) {
				p=p.prev;
			}
		}
 		return p;
	}
	
}
