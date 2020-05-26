package multiprogramingOS;

public class readyQueue<PCB> {
	private Node<PCB> head;
	private Node<PCB> current;
	int size;
	
	public readyQueue () {
		head = current = null;
		size=0;
	}
	
	public boolean empty () {
		return head == null;
	}
	
	public boolean last () {
		return current.next == null;
	}
	
	public PCB retrieve () {
		return current.data;
	}
	
	public void update (PCB val) {
		current.data = val;
	}
	
	public Node<PCB> insert (PCB val) {
		Node<PCB> tmp;
		if (empty()) {
			current = head = new Node<PCB> (val);
			size++;
		}
		else {
			tmp = current.next;
			current.next = new Node<PCB> (val);
			current = current.next;
			current.next = tmp;
			size++;
		}
		return current;
	}
	
	public Node<PCB> remove () {
		Node<PCB> tmp=head;
		if(head!= null)
		head = head.next;
		size--;
		return tmp;
	}
	
	public int size() {
	return size;	
	}
}
