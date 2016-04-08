import java.util.Stack;

public class BalancedParentheses {

	public boolean matchParentheses(String s)
	{
		if(s!=null)
		{		
			if(s.trim().length()==0)
			{
				System.out.println("Empty string or spaces only.");
				return true;
			}
			if(!s.contains("(") && !s.contains(")"))
			{
				System.out.println("No parentheses in string.");
				return true;
			}

			Stack<Character> st= new Stack<>();
			for(int i=0; i< s.length(); i++)
			{
				if(s.charAt(i)=='(')
				{
					st.push('(');
				}
				else if(s.charAt(i)==')')
				{
					if(!st.isEmpty())
						st.pop();
					else
					{
						System.out.println("Extra \")\" encountered in string. \")\" must have a preceding\"(\".");
						return false;
					}
				}
			}
			if(!st.isEmpty())
			{
				System.out.println("Extra \"(\" encountered in string. \"(\" must have a following \")\".");
				return false;
			}					
			else
			{
				System.out.println("Parentheses match.");
				return true;
			}					
		}
		System.out.println("null string.");
		return false;
	}

	public static void main(String args[])
	{
		BalancedParentheses ob= new BalancedParentheses();

		System.out.println(ob.matchParentheses("()()()()")+"\n");
		System.out.println(ob.matchParentheses("(((()))")+"\n");
		System.out.println(ob.matchParentheses("((())))")+"\n");
		System.out.println(ob.matchParentheses("     ")+"\n");
		System.out.println(ob.matchParentheses(null)+"\n");
		System.out.println(ob.matchParentheses(")))))")+"\n");
		System.out.println(ob.matchParentheses("((((((")+"\n");
		System.out.println(ob.matchParentheses("))(")+"\n");
		System.out.println(ob.matchParentheses("a+b^c*d"));
	}
}
