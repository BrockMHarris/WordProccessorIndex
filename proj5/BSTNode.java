package proj5;
/** This is a node that is inserted into a BST. It holds an element and 2 pointers to other BST nodes
 * 
 * @author Chris Fernandes
 * @version 5/24/17
 */
public class BSTNode<E extends Comparable<E>>{

	public E key;
	public BSTNode llink;
	public BSTNode rlink;
	
	/**
	 * non-default constructor
	 * @param newKey string that node will hold
	 */
	public BSTNode(E newKey)
	{
		key = newKey;
		llink = null;
		rlink = null;
	}
	
	/**
	 * returns key as printable string
	 */
	public String toString()
	{
		return key.toString();
	}
}
