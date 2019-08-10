/**
* This is the Demo class to utilize the ADT
*
* @author Amelia Tran
* @version 08/01/2019
*/

public class BoolListDemo {
	public static void main(String[] args) {
		BoolArrayList myList = new BoolArrayList();
		myList.insert(0, true);
		myList.insert(3, false);
		myList.insert(2, true);
		myList.insert(1, true);
		myList.insert(5, false);
		myList.insert(4, false);
		myList.insert(7, true);
		myList.insert(6, true);
		myList.insert(9, false);
		myList.insert(10, true);

		System.out.println(boolToSigned(myList));

	}

	public static int boolToSigned( BoolList list) {
		int total = 0;
		for (int i=0; i < list.size(); i++) {
			if (i==list.size()-1 && list.lookup(i) == true) {
				total = total - (int)Math.pow(2,i); 
			} else {
				if (list.lookup(i)) {
					total = total + (int)Math.pow(2,i);
				} 
			}
		}
		return total;
	}
}