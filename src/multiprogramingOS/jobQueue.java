package multiprogramingOS;

public class jobQueue<PCB> {
	
	private NodeHD<PCB> head;
	private NodeHD<PCB> current;
	int size;
	
	public jobQueue() {
		head = current = null;
		size=0;
	}
	
	public boolean empty () {
		return head == null;
	}
	
	public boolean last () {
		return current.next == null;
	}
	
	public NodeHD<PCB> retrieve () {
		//current=head;
		return current;
	}
	
	public void update (PCB val) {
		current.data = val;
	}
	
	public NodeHD<PCB> insert (PCB val,int EMR) {
		NodeHD<PCB> tmp = new NodeHD<PCB>(val, EMR);
		if ((size == 0) || (EMR < head.priority)) {
			tmp.next = head;
			head = tmp;
			size++;
		} else {

			NodeHD<PCB> p = head;
			NodeHD<PCB> q = null;
			while ((p != null) && (EMR >= p.priority)) {
				q = p;
				p = p.next;
			}
			tmp.next = p;
			q.next = tmp;
			size++;
		}
		
		return tmp;
	}
	
	public NodeHD<PCB> remove () {
		NodeHD<PCB> tmp=head;
		if(head!= null)
		head = head.next;
		size--;
		return tmp;
	}

}
