package confess;

public class Queue<E> {
    public java.util.LinkedList <E> list = new java.util.LinkedList<>();
   
    public Queue(E[] e){
	for(int i=0; i<e.length;i++)
	    list.addLast(e[i]);
    }
    
    public Queue(){};
    
    public void enqueue(E e){
	list.addLast(e);
    }
    
    public E dequeue(){
	return list.removeFirst();
    }
    
    public E getElement(int i){
	if(i<0 || i>=list.size())
	    return null;
	return list.get(i);
    }
    
    public E peek(){
	return list.peek();
    }
    
    public int getSize(){
	return list.size();
    }
    
    public boolean contains(E e){
	return list.contains(e);
    }
    
    public boolean isEmpty(){
	return list.isEmpty();
    }
    
    public String toString(){
	return "Queue: " + list.toString();
    }
    
}