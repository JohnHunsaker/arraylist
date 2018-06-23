
/**
 * Class to implement an ArrayList of NationalParks.
 */
public class ArrayList {

	private NationalPark[] mArrayList;
	private final int INITIAL_SIZE = 4;
	private int mCount = 0;
	
	/**
	 * Constructor.
	 */
	public ArrayList() {
		mArrayList = new NationalPark[INITIAL_SIZE];
	}
	
	/**
	 * Method to increase the size of the Data array
	 */
	private void resize() {
		if (mCount == mArrayList.length) {
			NationalPark[] newArray = new NationalPark[mArrayList.length * 2];
			
			for (int i = 0; i < mArrayList.length; i++) {
				newArray[i] = mArrayList[i];
			}
			mArrayList = newArray;
		}
	}
	
	/**
	 * Method to shift the elements of the Data array one position to the right,
	 *	starting at (and including) the index specified by the parameter.
	 * @param index 
	 */
	private void shiftRight(int index) {
		int i = mCount;
		while (i > index) {
			mArrayList[i] = mArrayList[i - 1];
			i--;
		}
	}
	
	/**
	 * Method to shift the elements of the Data array one position to the left,
	 * starting at (but not including) the index specified by the parameter.
	 * @param index 
	 */
	private void shiftLeft(int index) {
		int i = index;
		while (i < mCount - 1) {
			mArrayList[i] = mArrayList[i+1];
			i++;
		}
	}
	
	/**
	 * Method to add the data at index 0 in the array.
	 * @param data 
	 */
	public void addFirst(NationalPark data) {
		resize();
		shiftRight(0);
		mArrayList[0] = data;
		mCount++;
	}
	
	/**
	 * Method to add the data into the first empty index in the array.
	 * @param data 
	 */
	public void addLast(NationalPark data) {
		resize();
		mArrayList[mCount] = data;
		mCount++;
	}
	
	/**
	 * Method to add the data at the specified index in the list,
	 * shifting if necessary.
	 * @param index
	 * @param data 
	 */
	public void insert(int index, NationalPark data) {
		resize();
		shiftRight(index);
		mArrayList[index] = data;
		mCount++;
	}
	
	/**
	 * Method to remove and return the data at index 0.
	 * @return 
	 */
	public NationalPark removeFirst() {
		if (mCount == 0) {
			throw new NullPointerException("Cannot remove from an empty list.");
		}
		else {
			NationalPark toRemove = mArrayList[0];
			shiftLeft(0);
			mCount--;
			return toRemove;
		}
	}
	
	/**
	 * Method to remove and returns the last data from the list.
	 * @return 
	 */
	public NationalPark removeLast() {
		if (mCount == 0) {
			throw new NullPointerException("Cannot remove from an empty list.");
		}
		else {
			NationalPark toRemove = mArrayList[mCount];
			mCount--;
			return toRemove;
		}
	}
	
	/**
	 * Method to removes and returns the data at the specified index in the list,
	 * shifting if necessary.
	 * @param index
	 * @return 
	 */
	public NationalPark removeAt(int index) {
		NationalPark toRemove = mArrayList[index];
		shiftLeft(index);
		mCount--;
		return toRemove;
	}
	
	/**
	 * Method to find and remove the first occurrence of the specified data.
	 * @param data 
	 */
	public void remove(NationalPark data) {
		int i = indexOf(data);
		
		if (i > -1) {
			removeAt(i);
		}
		
		else{
			System.out.println("Data not in ArrayList");
		}
	}
	
	/**
	 * Method to return the data at the specified index.
	 * @param index
	 * @return 
	 */
	public NationalPark get(int index) {
		return mArrayList[index];
	}
	
	/**
	 * Method to clear the list so that it is empty.
	 */
	public void clear() {
		mCount = 0;
		System.out.println("List has been cleared.");
	}
	
	/**
	 * Method to return the integer index where the specified data first
	 * occurs in the list, or -1 if it is not found.
	 * @param data
	 * @return 
	 */
	public int indexOf(NationalPark data) {

		int i = 0;
		while (i < mCount && data != mArrayList[i]) {
			i++;
		}
		
		if (data == mArrayList[i]) {
			return i;
		}
		
		else {
			return -1;
		}
	}
	
	/**
	 * Method to provide the number of items in the data array.
	 * @return 
	 */
	public int getCount() {
		return mCount;
	}
	
	/**
	 * Method to (using a loop) print all the parks in the data array,
	 * one per line.
	 */
	public void printAll() {
		for (int i = 0; i < mCount; i++) {
			System.out.println(mArrayList[i]);
		}
	}
}
