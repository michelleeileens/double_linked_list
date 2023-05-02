
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T>{
	
	private Comparator comp;

	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		comp=comparator2;
	}
	
	public SortedDoubleLinkedList<T> add(T data){
 		Node tempNode=new Node(data);
		Node current=head;
		Node previous;
		if(size == 0) {
			head = tempNode;
			tail = tempNode;
			size++;
			return this;
		}
		if(size == 1) {
			if(comp.compare(data,current.data)<0 || comp.compare(data,current.data)==0){
				super.addToFront(data);
				return this;
			}
			else {
				super.addToEnd(data);
				return this;
			}
		}
		else {
			while(comp.compare(current.data,data)<0) {
				previous = current;
				current = current.next;
				if(current == null) {
					current = tempNode;
					tempNode.previous = previous;
					previous.next = tempNode;
					tail = tempNode;
					size++;
					return this;
				}
			}
			if(current==head) {
				if(comp.compare(data,current.data)<0) {
					super.addToFront(data);
				}
			}
			else if(current == tail) {
				current.previous.next = tempNode;
				tempNode.next = current;
				tempNode.previous = current.previous;
				current.previous = tempNode;
				size++;
			}
			else {
				current.previous.next = tempNode;
				tempNode.next = current;
				tempNode.previous = current.previous;
				current.previous = tempNode;
				size++;
			}
		return this;
		}
	}
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void addToFront(T data){
		throw new UnsupportedOperationException();
	}
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	@Override
	public SortedDoubleLinkedList<T> remove(T targetData, Comparator<T>comparator){
		super.remove(targetData, comparator);
		return this;
	}
}