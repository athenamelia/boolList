/**
* This is the boolLinkedList
*
* @author Amelia Tran
* @version 08/01/2019
*/

public class BoolLinkedList implements BoolList {

	private class boolNode{
		private boolean data;
		private boolNode next, prev;

		private boolNode(boolean d, boolNode p, boolNode n) {
			d = data;
			n = next;
			p = prev;
		}

		private boolean getData() {
			return data;
		}

		private void setData(boolean newData) {
			data = newData;
		}

		private boolNode getNext() {
			return next;
		}

		private void setNext(boolNode newNext) {
			next = newNext;
		}

		private boolNode getPrev() {
			return prev;
		}

		private void setPrev(boolNode newPrev) {
			prev = newPrev;
		}
	}

	private int size;
	private boolNode head, tail;

	public int size() {
		return size;
	}

	public void insert(int index, boolean value) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		if (size == 0 || size < index+1) {
			index = size;
		}

		if (index == 0) {		
			boolNode current = new boolNode(value, null, head);
			if (size > 0) {
				head.setPrev(current);
			}
			head = current;
		} 

		if (index == size) {
			boolNode current = new boolNode(value, tail, null);			
			if (size > 0) {
				tail.setNext(current);
			}
			tail = current;
		}

		if (index < size && index > 0) {
			boolNode temp = head;
			for (int i=0; i<index-1; i++) {
				temp = temp.getNext();
			}
			boolNode next = temp.getNext();
			boolNode current = new boolNode(value, temp, next);
			next.setPrev(current);
			temp.setNext(current);
		}
		size++;
	}

	public void remove(int index) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}

		if (size < index+1 || size == 0) {
			return;
		}

		if (index == 0) {		
			head = head.getNext();
		} 

		if (index == size) {
			tail = tail.getPrev();
		}

		if (index < size && index > 0) {		
			boolNode temp = head;
			for (int i=0; i<index-1; i++) {
				temp = temp.getNext();
			}
			boolNode next = temp.getNext().getNext();
			temp.setNext(next);
			next.setPrev(temp);
		}
		size--;

	}

	public boolean lookup(int index) {
		if (index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		boolNode temp = head;
		for (int i=0; i<index; i++) {
			temp = temp.getNext();
		} 
		return temp.getData();
	}

	public void negateAll() {
		if (size == 0) {
			throw new IndexOutOfBoundsException();
		}

		boolNode temp = head;
		for (int i=0; i<size-1; i++) {
			temp.setData(!temp.getData());
			temp = temp.getNext();
		}
	}
}
















