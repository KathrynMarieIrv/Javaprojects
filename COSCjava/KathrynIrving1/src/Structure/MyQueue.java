package Structure;

/**
 * A singly linked list based queue structure.
 */

public class MyQueue {
	public SLListNode front;
	public SLListNode rear;
	
	/**
	 * Default constructor.
	 */
	public MyQueue()
	{
		front = rear = null;
	}
	
	/**
	 * Clears the queue.
	 */
	public void clear()
	{
		front = rear = null;
	}
	
	/**
	 * Check whether the queue is empty.
	 * @return	true if empty false otherwise.
	 */
	public boolean isEmpty()
	{
		return front == null;
	}
	
	/**
	 * Append a node, which will hold the element, at the rear side of the queue.
	 * @param element the data to be hold in the node.
	 */
	public void insertBack(Object element)
	{
		if(isEmpty())
		{
			front = rear = new SLListNode(element, null);
			return;
		}
		
		rear = rear.next = new SLListNode(element, null);
	}
	
	/**
	 * Removes the node in the front of the queue.
	 */
	public Object removeFront()
	{
		if(front == null)
			return null;
		
		Object temp = front.data;
		if(front == rear) //single node case
		{
			front = rear = null;
			return temp;
		}
		
		front = front.next;
		return temp;
	}
	
	/**
	 * Returns the element in the node at the front of the queue.
	 * @return data contained in the node.
	 */
	public Object front()
	{
		if(isEmpty())
		{
			return null;
		}
		return front.data;
	}
	
	/**
     * Converts the current queue into a string front to rear. 
     * @return the result string    
     */
	public String toString()
	{
		//String out = "The Queue contains:\n";
		String out = "\t";
		SLListNode ref = front;
		if(isEmpty())
			return "0 nodes.";
		else
			//out += "front ->\t";
			out += "\t";
		
		while(ref.next != null)
		{
			//out += ref.data + "\t->\t";
			out += ref.data + "\t";
			ref = ref.next;
		}
		
		//out += ref.data +"\t->null"; //Add the last node.
		out += ref.data + "\t";
		return out;
	}
}
