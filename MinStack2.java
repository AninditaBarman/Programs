import java.util.Stack;

public class MinStack2 extends Stack<Integer>{

	Stack<Integer> min= null;

	public void push(int val)
	{
		super.push(val);
		if(min==null)
		{
			min= new Stack<Integer>();
			min.push(val);
		}			
		else if(val<=min.peek())
			min.push(val);
	}

	public Integer pop()
	{
		if(super.isEmpty())
			return Integer.MAX_VALUE;
		Integer val= super.pop();		
		if(val==min.peek())
			return min.pop();
		return val;
	}

	public Integer min() 
	{
		if(min.isEmpty())
			return Integer.MAX_VALUE;
		return min.peek();
	}

	public static void main(String args[])
	{
		MinStack2 st= new MinStack2();
		System.out.println(st.pop());
		st.push(5);
		System.out.println(st.min());
		st.push(4);
		st.push(2);
		st.push(2);
		System.out.println(st.min());
		System.out.println(st.pop());
		System.out.println(st.min());
	}	
}
