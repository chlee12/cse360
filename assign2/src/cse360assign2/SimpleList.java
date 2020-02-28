package cse360assign2;

/**
 * Author: Cameron Lee 
 * Class ID: 128
 * Assignment #2
 * This class includes methods to initialize and manipulate an array of
 * integers. 
 * Github link: https://github.com/chlee12/cse360/tree/master/assign2/src/cse360assign2
 * Methods: constructor, add(int), append(int), first(int), size(int), remove(int), int count(), String toString(), and int search(int)
 */
public class SimpleList {
	
	private int[] list;
	private int count;
	
	/**
	 * This class constructor creates a new integer array to hold 10 integers 
	 * and sets count to 0.
	 */
	SimpleList()
	{
		this.list = new int[10];
		this.count = 0;
	}
	
	/**
	 * Adds a specified integer to the list array at position 0 and moves the 
	 * other elements to the right. If the list is full, then the list's size
	 * is increased by 50%, and count is incremented. If the list is not full,
	 * count is incremented. 
	 *  
	 * @param toAdd		an integer to add to the array
	 */
	public void add(int toAdd)
	{
		int[] newList = new int[this.size()];
		
		if(! (this.count < this.list.length - 1))
		{
			int newListSize = (int) (Math.floor(this.list.length*1.5));
			newList = new int[newListSize];	// make array's size increase by 50%
		}
		
		for(int index = 0; index < this.count; index ++) 
		{
			newList[index + 1] = this.list[index]; // copy old array contents to new array
		}
		newList[0] = toAdd;
		this.list = newList; 	// replace old list with newList with new integer
		this.count++;
	}
	
	/**
	 * Removes a specified integer from the array list if it exists in the 
	 * array, then moves the other values in the list array. Also decrements
	 * count. If the list has more than 25% empty spaces, we decrease the
	 * size of the list.
	 * 
	 * @param toRemove	the integer to remove from the list array
	 */
	public void remove(int toRemove)
	{
		if(this.search(toRemove) != -1)
		{
			for(int indexInside = this.search(toRemove) + 1; indexInside 
					< this.count(); indexInside ++)
			{
				this.list[indexInside - 1] = this.list[indexInside];
			}
			count --;
		}
		
		if(((double)(this.list.length - count()/this.list.length)) > 0.25 && 
				this.list.length > 1)		// check to decrease the list size
		{
			int newSize = (int) (Math.floor(0.75*this.list.length));
			int[] newList = new int[newSize];
			
			for(int index = 0; index < newList.length; index ++) 
			{
				newList[index] = this.list[index]; // copy old array contents to new array
			}
			this.list = newList; 	// replace old list with newList with new integer
		}
		
	}
	
	/**
	 * Returns the number of elements in the list.
	 * 
	 * @return			the number of elements in the list.
	 */
	public int count()
	{
		return this.count;
	}
	
	/**
	 * Returns the list as a string, elements separated by a space.
	 *
	 * @return 		the list as a string.	
	 */
	public String toString()
	{
		String listString = "";
		for(int index = 0; index < this.count - 1; index ++)
		{
			listString += this.list[index] + " "; 	// add elements up to second-to-last element
		}
		listString += this.list[this.count - 1];	// add last element without space
		
		return listString;
	}
	
	/**
	 * Attempts to find location of argument toFind. It will return the first
	 * instance of the integer. If not found, function will return -1.
	 *
	 * @param toFind	integer to find
	 * @return			location of parameter in list
	 */
	public int search(int toFind)
	{
		int foundIndex = -1;
		for(int index = this.count - 1; index >= 0; index --)
		{
			if(this.list[index] == toFind)
			{
				foundIndex = index;
			}
		}
		
		return foundIndex;
	}
	
	/**
	 * Appends parameter to the end of the list. If the list is full, then the
	 * size is increased by 50% so there will be room. Count is incremented.
	 * 
	 * @param toAppend	integer to append to the end of the list
	 */
	public void append(int toAppend)
	{
		int[] newList = new int[10];
		
		if(this.count < this.list.length)		// increment count if count is not the length of the array
		{
			this.count++;		
		}
		else
		{
			newList = new int[(int) (Math.floor(this.list.length*0.5))];	// make array's size increase by 50%
			this.count++;
		}
		
		for(int index = 0; index <= this.count; index ++) 
		{
			if(index < this.count)
			{
				newList[index] = this.list[index]; // copy old array contents to new array
			}
			else
			{
				newList[index] = toAppend;
			}
		}
		this.list = newList; 	// replace old list with newList with new integer
	}
	
	/**
	 * Returns the first element in the list.
	 * 
	 * @return			the first element in the list.
	 */
	public int first()
	{
		return this.list[0];
	}
	
	
	/**
	 * Returns the current number of possible locations in the list.
	 * 
	 * @return			the number of possible locations in the list.
	 */
	public int size()
	{
		return this.list.length;
	}
}
