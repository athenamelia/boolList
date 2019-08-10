import java.util.Arrays;

/**
* This is the boolArrayList
*
* @author Amelia Tran
* @version 08/01/2019
*/

public class BoolArrayList implements BoolList {
	private int capacity = 10;
	private int size = 0;
	private boolean[] elements;

	public BoolArrayList() {
		elements = new boolean[capacity];
	}

	public int size() {
		return size;
	}

	public void insert(int index, boolean value) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		resizeArray();

		if (size == 0 || size < index+1) {
			elements[size++] = value;
		} 
		
		else {	
			for (int i = size; i > index; i--) {
				elements[i] = elements[i-1]; 
			}			
			elements[index] = value;
			size++;
		}
	}

	private void resizeArray() {
		if (size == capacity) {
			capacity = capacity *2;
		}

		boolean[] newArray = new boolean[capacity];
		newArray = Arrays.copyOf(elements, capacity);
		elements = newArray;
	}

	public void remove(int index) {
		if (index < 0) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if (size < index+1) {
			return;
		}
			
		for (int i = index; i < size-1; i++) {
			elements[i] = elements[i+1];
		}
		size--;
	}
	
	public boolean lookup(int index){
		if (index < 0 || index >= size){
			throw new ArrayIndexOutOfBoundsException();
		}
		return elements[index];
	}

	public void negateAll() {
		if (size ==0) {
			throw new ArrayIndexOutOfBoundsException();
		}

		for (int i=0; i<size; i++){
			elements[i] = !elements[i];
		}
	}
}