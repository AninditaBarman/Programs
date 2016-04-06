import java.util.HashMap;


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

			while(n.getNext()!=null)
				n=n.getNext();
			n.setNext(node);

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

	public LinkedListNode removeDuplicates(LinkedListNode head)//removes duplicate data. Uses HashMap as a buffer
	{															//runs in O(n) time, where n is the number of elements
		if(head!=null)
		{
			LinkedListNode node= head;
			LinkedListNode prev= null;
			HashMap<Integer, Boolean> map= new HashMap<>();
			while(node!=null)
			{
				if(!map.containsKey(node.getData()))
				{
					map.put(node.getData(), true);
					prev= node;					
				}
				else
				{
					prev.setNext(node.getNext());
				}		
				node= node.getNext();
			}
			return head;
		}
		return null;
	}

	public LinkedListNode deleteDuplicatesWithoutBuffer(LinkedListNode head)//removes duplicates in O(1) space but O(n2) time. Doesn't use buffer
	{
		if(head!=null)
		{
			LinkedListNode node= head;
			LinkedListNode secondPtr= null, prev;
			while(node!=null)//loop that iterates over each node
			{
				prev= node;
				secondPtr= node.getNext();
				while(secondPtr!=null)//for each node, iterates over the rest of the list
				{					
					if(node.getData()==secondPtr.getData())
					{
						prev.setNext(secondPtr.getNext());
					}						
					else
					{
						prev= secondPtr;
					}
					secondPtr= secondPtr.getNext();
				}
				node= node.getNext();
			}
			return head;
		}
		return null;
	}

	public int kthToLast(LinkedListNode head, int k)//recursive. Returns the data in the kth node to the last node (first from the last being the last node itself)
	{												//note that this returns only the data in the kth to last node, and not the node itself
		if(head==null)//base case
			return 0;
		int i= kthToLast(head.getNext(), k)+1;
		if(i==k)
			System.out.println(head.getData());
		return i;
	}

	public LinkedListNode kthToLastIterative(LinkedListNode head, int k)//iterative. returns kth node to the last node. O(n) time, O(1) space
	{
		if(head!=null && k>0)
		{
			LinkedListNode p1= head, p2= head;
			int i=0;
			while(p2!=null && i!=k)//using p2, traverse past the kth node from the first
			{
				i++;
				p2=p2.getNext();
			}
			while(p2!=null)//advance both p1 and p2, until p2 becomes null. p1 is then the kth from last node. This is because, p2 is k nodes ahead of p1.
			{																								//So, when p2 is null, p1 is kth from last! :)
				p1=p1.getNext();
				p2=p2.getNext();
			}
			return p1;
		}
		return null;
	}

	public void deleteGivenNode(LinkedListNode node)//note that we are not given the head but only the node to be deleted
	{
		if(node!=null)
		{
			if(node.getNext()!=null)
			{
				node.setData(node.getNext().getData());
				node.setNext(node.getNext().getNext());
			}
			else //if next node is null
				node= null;
		}
	}

	public LinkedListNode partitionRearrange(LinkedListNode head, int x)//rearrange linked list such that all elements less than value x appear before all elements greater than or equal to x
	{
		if(head!=null)
		{
			LinkedListNode node= head;
			LinkedListNode list1Head= null, list2Head= null, list1Rear= null, list2Rear= null;

			while(node!=null)
			{
				if(node.getData()<x)
				{
					if(list1Head==null)
					{
						list1Head=node;
						list1Rear= node;
					}
					else
					{
						list1Rear.setNext(node);
						list1Rear= node;
					}						
				}					
				else
				{
					if(list2Head==null)
					{
						list2Head= node;
						list2Rear=node;
					}
					else
					{
						list2Rear.setNext(node);
						list2Rear= node;
					}
				}
				node= node.getNext();				
			}	
			list1Rear.setNext(list2Head);
			return list1Head;
		}
		return null;
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
		LinkedListNode n7= new LinkedListNode(1);
		LinkedListNode n8= new LinkedListNode(2);
		LinkedListNode n9= new LinkedListNode(6);

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

		ll.appendNode(n6, n7);//n6 becomes head after reversal
		ll.appendNode(n6, n8);
		ll.appendNode(n6, n9);
		
		//ll.partitionRearrange(n6, 4);
		//ll.removeDuplicates(n6);
		//ll.deleteDuplicatesWithoutBuffer(n6);
		ll.kthToLast(n6, 1);
		ll.kthToLast(n6, 8);
		ll.partitionRearrange(n6, 4);
		ll.deleteGivenNode(n6);
		ll.deleteGivenNode(n1);
	}

}
