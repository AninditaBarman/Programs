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
	
	public LinkedListNode addTwoNumbers(LinkedListNode n1, LinkedListNode n2, int carry)//recursive
	{
		if(n1==null && n2==null && carry==0)
			return null;
		
		int data= (n1==null? 0: n1.getData())+(n2==null? 0: n2.getData())+carry;
		LinkedListNode result= new LinkedListNode(data%10);
		LinkedListNode more= addTwoNumbers((n1!=null? n1.getNext(): null), (n2!=null? n2.getNext(): null), data/10);
		result.setNext(more);
		
		return result;		
	}
	
	public void detectLoop(LinkedListNode head)
	{
		if(head!=null)
		{
			LinkedListNode slow= head;
			LinkedListNode fast= head;
			boolean loopExists=false;
			while(slow!=null && slow.getNext()!=null)
			{
				slow= slow.getNext();
				fast= fast.getNext().getNext();
				if(slow==fast)
				{
					System.out.println("Loop detected");
					loopExists= true;
					break;
				}
			}
			if(loopExists)
			{				
				slow=head;
				while(slow!=fast)
				{
					slow= slow.getNext();
					fast=fast.getNext();					
				}	
				System.out.println("Loop starts at this node: "+slow.getData());
			}
			else
				System.out.println("Loop doesnt exist");
		}
	}
	
	public boolean isPalindrome(LinkedListNode head)
	{
		if(head!=null)
		{
			if(head.getNext()==null)//just one digit=>palindrome
				return true;
			//now we will reverse the list and check if the number is palindrome
			LinkedListNode p1=head;
			LinkedListNode p2=head.getNext();
			LinkedListNode t;
			head.setNext(null);
			LinkedListNode reversedHead=null;
			while(p1!=null && p2!=null)
			{
				t= p2.getNext();
				p2.setNext(p1);
				p1= p2;
				
				if(t==null)
				{
					reversedHead=p1;
					break;//V V I
				}
				else
				{
					p2= t;
				}
			}
			while(head!=null && reversedHead!=null)
			{
				if(head.getData()!=reversedHead.getData())
					return false;
				head= head.getNext();
				reversedHead= reversedHead.getNext();
			}
			return true;
		}
		return false;
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
		
		ll.appendNode(n1, n8);
		ll.appendNode(n1, n7);
		System.out.println(ll.isPalindrome(n1));
		System.out.println();
		
		
		
		
	}

}
