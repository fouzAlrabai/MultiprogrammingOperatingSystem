package multiprogramingOS;

public class NodeHD<T> {
	
	public T data;
	public int priority; 
	public NodeHD<T> next;

	public NodeHD () {
		data = null;
		next = null;
		priority=0; 
	}

	public NodeHD (T val,int priority) {
		data = val;
		next = null;
		this.priority=priority;
		
	}

}
