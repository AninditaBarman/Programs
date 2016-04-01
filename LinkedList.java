
public class LinkedList {

	public void insertNode(LinkedListNode head, LinkedListNode node, int pos)//given linked list head, node to insert, and position to insert
	{
		if(head!=null && node!=null)
		{
			if(pos==1)//assuming head's position is 1
			{
				node.setNext(head);
				head= node;
			}
			else
			{
				LinkedListNode n= head;
				int i=1;
				while(n!=null)
				{
					i++;
					if(i==pos)
					{
						node.setNext(n.getNext());
						n.setNext(node);
						n=node;
						break;
					}
					n= n.getNext();
				}
			}			
		}		
	}
	
	public void appendNode(LinkedListNode head, LinkedListNode node)//append node at the end of linked list
	{
		if(head==null)
			head= node;
		else
		{
			LinkedListNode n= head;
			if(n.getNext()==null)
				n.setNext(node);
			else			
			{
				while(n.getNext()!=null)
					n=n.getNext();
				n.setNext(node);
			}			
		}
	}
	
	public void deleteNode(LinkedListNode head, int pos)//given linked list head and position to delete from
	{
		if(head!=null)
		{
			LinkedListNode n= head;
			if(pos==1)
			{
				head= n.getNext();
				n.setNext(null);
			}				
			else
			{				
				int i=1;
				while(n!=null)
				{		
					i++;
					if(i==pos)
					{
						n.setNext(n.getNext().getNext());
						break;
					}
					n=n.getNext();
				}
			}
		}
	}
	
	public void reverse(LinkedListNode head)
	{
		if(head!=null && head.getNext()!=null)//because, to reverse, you should have at least two nodes.  
		{
			LinkedListNode p= head;
			LinkedListNode q= head.getNext();
			head.setNext(null);//since, the original list's head becomes the last node in the reversed list
			LinkedListNode t;
			
			while(p!=null && q!=null)
			{
				t= q.getNext();
				q.setNext(p);
				p=q;
				
				if(t!=null)
				{
					q=t;
				}
				else
				{
					head= p;
					break;
				}
			}			
		}
	}
	
	public static void main(String args[])
	{
		LinkedList ll= new LinkedList();
		LinkedListNode n0= new LinkedListNode(0);
		LinkedListNode n1= new LinkedListNode(1);
		LinkedListNode n2= new LinkedListNode(2);
		LinkedListNode n3= new LinkedListNode(3);
		LinkedListNode n4= new LinkedListNode(4);
		LinkedListNode n5= new LinkedListNode(5);
		LinkedListNode n6= new LinkedListNode(6);
		
		ll.appendNode(null, n1);
		ll.appendNode(n1, n2);
		ll.appendNode(n1, n3);
		ll.appendNode(n1, n4);
		ll.appendNode(n1, n6);
		
		ll.insertNode(n1, n5, 5);
		ll.insertNode(n1, n0, 1);
		ll.deleteNode(n0, 1);
		ll.deleteNode(n1, 4);
		ll.reverse(n1);
		
	}
	
}
