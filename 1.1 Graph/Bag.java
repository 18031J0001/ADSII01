import java.util.Iterator;
import java.util.NoSuchElementException;
public class Bag<Item> implements Iterable<Item> 
{
	int number; 
    Node first;  
    public Bag() 
    {
    	number = 0;
        first = null;
        
    }
    class Node
    {
      Node next;
      Item item;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    public int size() 
    {
        return number;
    }
    public void add(Item item) 
    {
        Node oldfirst=first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        number++;
    }
    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> 
    {
          Node current = first;
        public boolean hasNext()
        {
            return current != null;
        }
        public void remove() 
        {
            throw new UnsupportedOperationException();
        }

        public Item next() 
        {
            if(!hasNext()) 
            {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}