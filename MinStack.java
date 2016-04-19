/*design a stack which, in addition to push and pop, also has a
function min which returns the minimum element. Push, pop and min should all
operate in 0(1) time.*/

import java.util.Stack;

public class MinStack extends Stack<StackNode>//this class inherits all of Stack's properties and methods, 
{											//and has it's own properties and methods as well
	
	public void push(int val)
	{
		StackNode item= new StackNode(val, Math.min(val, min()));
		super.push(item);
	}
		
	public int min()
	{
		if(super.isEmpty())
			return Integer.MAX_VALUE;
		else
			return peek().minVal;
	}
			
	public static void main(String args[])
	{
		MinStack st= new MinStack();
		System.out.println(st.min());		
		st.push(3);
		st.push(4);
		System.out.println(st.min());		
		st.push(2);
		System.out.println(st.min());
		st.push(1);
		System.out.println(st.min());
		st.pop();//need not override pop()
		System.out.println(st.min());
	}
}

class StackNode
{
	int val;
	int minVal;
	
	public StackNode(int val, int minVal)
	{
		this.val= val;
		this.minVal= minVal;
	}	
}

/*There's just one issue with this: if we have a large stack, we waste a lot of space by
keeping track of the min for every single element.
We can (maybe) do a bit better than this by using an additional stack which keeps track
of the mins. See MinStack2.java*/