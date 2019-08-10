/**
* This is the ADT booList to represent sequences of logical values
*
* @author Amelia Tran
* @version 08/01/2019
*/

public interface BoolList {
	int size(); 
	void insert(int i, boolean value);
	void remove(int i);
	boolean lookup(int i);
	void negateAll();
}
