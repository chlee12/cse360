package cse360assign2;
// package assign2;
/**
 * Author: Cameron Lee 
 * Class ID: 128
 * Assignment #1
 * This class includes methods to initialize and manipulate an array of
 * integers. 
 * Methods: constructor, add(int), remove(int), int count(), String toString(), and int search(int)
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
	 * other elements to the right. If the list is full, then the last element
	 * "falls off" the list. If the list is not full, count is incremented. 
	 * Otherwise, count stays at 10.
	 * 
	 * @param toAdd		an integer to add to the array
	 */
	public void add(int toAdd)
	{
		int[] newList = new int[10];
		
		for(int index = 0; index < 9; index ++) 
		{
			newList[index + 1] = this.list[index]; // copy old array contents to new array
		}
		newList[0] = toAdd;
		this.list = newList; 	// replace old list with newList with new integer
		if(this.count < 10)		// increment count if count is not 10
		{
			this.count++;
		}
	}
	
	/**
	 * Removes a specified integer from the array list if it exists in the 
	 * array, then moves the other values in the list array. Also decrements
	 * count.
	 * 
	 * @param toRemove	the integer to remove from the list array
	 */
	public void remove(int toRemove)
	{
		if(this.search(toRemove) != -1)
		{
			for(int indexInside = this.search(toRemove) + 1; indexInside < 10; indexInside ++)
			{
				this.list[indexInside - 1] = this.list[indexInside];
			}
			count --;
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
}
