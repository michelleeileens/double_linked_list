import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node head;
	protected Node tail;
	protected int size = 0;
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
	}
	
	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}
		return false;
	}
	
	public void addToEnd(T data){
		Node tempNode = new Node(data);
		BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();
		if(isEmpty()) {
			head = tempNode;	
		}
		else {
			tail.next = tempNode;
			tempNode.previous = tail;	
		}
		tail = tempNode;
		size++;
	}
	
	public void addToFront(T data){
		Node tempNode = new Node(data);
		BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();
		if(isEmpty()) {
			tail = tempNode;
		}
		else {
			tempNode.next = head;
			head.previous = tempNode;	
		}
		head = tempNode;
		size++;
	}
	
	public T getFirst() {
		if(isEmpty()) {
			return null;
		}
		return head.data;
	}
	
	public T getLast() {
		if(isEmpty()) {
			return null;
		}
		return tail.data;
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		Node current = head;
		Node previous = null;
		Node foundNode = null;
		BasicDoubleLinkedList<T> list1 = new BasicDoubleLinkedList<T>();
		
		while(!isEmpty()) {
			if(comparator.compare(targetData,current.data) == 0) {
				if(size == 1) {
					foundNode = head;
					head = null;
					tail = null;
					size--;
					break;
				}
				else if(current == head) {
					foundNode = current;
					head.next.previous = null;
					head = head.next;
					size--;
					break;
				}
				else if(current == tail){
					foundNode = current;
					tail.previous.next = null;
					tail = tail.previous;
					size--;
					break;
				}
				else {
					foundNode = current;
					current.previous.next = current.next;
					current.next.previous = current.previous;
					size--;
					break;
				}
			}
			previous = current;
			current = current.next;
		}
		return this;
	}

	public T retrieveFirstElement() {
		if(isEmpty()) {
			return null;
		}
		else if(size == 1) {
			T first = getFirst();
			head = null;
			tail = null;
			size--;
			return first;
		}
		else {
			T first = getFirst();
			head.next.previous = null;
			head = head.next;
			size--;
			return first;
		}	
	}

	public T retrieveLastElement() {
		if(isEmpty()) {
			return null;
		}
		else if(size == 1) {
			T last = getLast();
			head = null;
			tail = null;
			size--;
			return last;
		}
		else {
			T last = getLast();
			tail.previous.next = null;
			tail = tail.previous;
			size--;
			return last;
		}
	}
	

	public ArrayList<T> toArrayList(){
		ArrayList<T> list = new ArrayList<T>();
		ListIterator<T> it = iterator();
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		return new DoubleLinkedListIterator();
	}
	
	public class Node{
		public Node previous;
		public Node next;
		public T data;

		public Node(){
			previous = null;
			next = null;
			data = null;
		}
 
		public Node(T data){
			this.data = data;
		}
	}
	
	public class DoubleLinkedListIterator implements ListIterator<T> {
		private Node previousNode;
		private Node currentNode;
		
		DoubleLinkedListIterator(){
			previousNode = null;
			currentNode = head;
		}
		
		@Override
		public void add(T arg0) {
			throw new UnsupportedOperationException();
		}

		@Override
		public boolean hasNext() {	
			return currentNode != null;
		}
		
		@Override
		public boolean hasPrevious() {
			return previousNode != null;
		}
		
		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			else {
				previousNode = currentNode;
				currentNode = currentNode.next;
				return previousNode.data;
			}
		}

		@Override
		public T previous() {
			if(!hasPrevious()) {
				throw new NoSuchElementException();
			}
			else {
				currentNode = previousNode;
				previousNode = previousNode.previous;
				return currentNode.data;
			}
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T arg0) {
			throw new UnsupportedOperationException();
		}
	}
}