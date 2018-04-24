/**
 * 
 */
package ADT.LinkedList;

/**
 * @ClassName: MyLinkedList
 * @Function:双链表的实现
 * @author:Java青铜战士
 * @Time:2018年4月10日下午10:40:50
 */
public class MyLinkedList <AnyType>{
	/**
	 * @ClassName: Node
	 * @Function:内部类，使用对象表示结点
	 * 其中data代表数据域，prev代表前驱地址，next代表后继地址
	 * @author:Java青铜战士
	 * @Time:2018年4月10日下午10:45:30
	 *@param <AnyType>
	 */
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		/**
		 * 创建结点时可以通过此方法帮结点确定前后指向
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
	 * 定义基础变量
	 */
	private int theSize;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	/**
	 * 创建双向链表
	 */
	public MyLinkedList(){
		doclear();
	}
	/**
	 * 清空双向链表
	 */
	public void clear(){
		doclear();
	}
	
	/**
	 * 执行具体清空，创建操作
	 */
	private void doclear() {
		beginMarker=new Node<AnyType>(null, null, null);
		endMarker=new Node<AnyType>(null, beginMarker, null);
		beginMarker.next=endMarker;
		theSize=0;
	}

	/**
	 * 获取链表长度
	 * @return
	 */
	public int size(){
		return theSize;
	}
	
	/**
	 * 判断链表是否为空
	 * @return
	 */
	public boolean isEmpty(){
		return theSize==0;
	}
	/**
	 * 获取添加数据，但具体不在此执行添加操作
	 * @param val
	 * @return
	 */
	public boolean add(AnyType val){
		add(size(),val);
		return true;
	}
	
	/**
	 * 此处将getNode()方法返回的结果与添加数据全部提交给具体执行添加方法
	 * @param size
	 * @param val
	 */
	public void add(int size, AnyType val) {
		addBefore(getNode(size,0,size()),val);
	}
	/**
	 * 执行具体添加操作
	 * @param node
	 * @param val 
	 */
	private void addBefore(Node<AnyType> p, AnyType val) {
		//将尾结点前后指向以及添加数据赋给新结点
		Node<AnyType> newNode=new Node<>(val,p.prev,p);
		newNode.prev.next=newNode;
		p.prev=newNode;
		theSize++;
	}
	
	/**
	 * 获取数据
	 * @param idx
	 * @return
	 */
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	
	/**
	 * 插入数据
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
	 * 删除数据
	 * @param idx
	 * @return
	 */
	public boolean remove(int idx){
		return remove(getNode(idx));
	}
	
	/**
	 * 通过getNode()方法获取到要删除的结点前一个或者后一个结点
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
	 * 此处为只传入一个参数的getNode()方法补全其它信息
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
	 * 此处用来提供删除，插入和添加操作时所需要的结点
	 * 若插入位置小于链表整体长度的一半则从表头开始查找插入位置
	 * 若插入位置大于链表整体长度的一半则从表尾开始查找插入位置
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
