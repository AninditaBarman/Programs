import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this.
 */

public class SetOfStacks {

	List<Stack<Integer>> setOfStacks= null;//= new ArrayList<Stack<Integer>>();
	Stack<Integer> stack= null;
	int maxSize= 10;

	public void push(int val)
	{
		if(setOfStacks==null)// no stack so far
		{
			setOfStacks= new ArrayList<Stack<Integer>>();
			stack= new Stack<Integer>();
			stack.add(val);
			setOfStacks.add(stack);
		}
		else
		{
			stack= setOfStacks.get(setOfStacks.size()-1);
			if(stack.size()==maxSize)
			{
				stack= new Stack<Integer>();
				stack.push(val);
				setOfStacks.add(stack);
			}
			else
				stack.push(val);
		}			
	}

	public int pop()
	{
		if(setOfStacks==null || setOfStacks.size()==0)
			return Integer.MAX_VALUE;
		return setOfStacks.get(setOfStacks.size()-1).pop();
	}

	public Integer peek()
	{
		if(setOfStacks==null || setOfStacks.size()==0)
			return Integer.MAX_VALUE;
		return setOfStacks.get(setOfStacks.size()-1).peek();
	}

	public static void main(String[] args)
	{
		SetOfStacks ob= new SetOfStacks();
		System.out.println(ob.peek());
		System.out.println(ob.pop());
		ob.push(1);
		ob.push(2);
		ob.push(3);
		ob.push(4);
		System.out.println(ob.peek());
		ob.push(5);
		ob.push(6);
		ob.push(7);
		ob.push(8);
		ob.push(9);
		ob.push(10);
		ob.push(11);
		ob.push(12);
		ob.push(13);
		System.out.println(ob.peek());
		ob.pop();
		ob.pop();
		System.out.println(ob.peek());
		ob.push(14);
		ob.push(15);
		ob.push(16);
		ob.push(17);
		ob.push(18);
		ob.push(19);
		ob.push(20);
		ob.push(21);
		ob.push(22);
		System.out.println(ob.peek());
		
	}
}
