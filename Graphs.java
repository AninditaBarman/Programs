import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
	
	public void bfs(GraphNode one)//visit all your neighbors before visiting your neighbor's neighbors
	{
		if(one!=null)
		{
			GraphNode node= null;
			Queue<GraphNode> q= new LinkedList<GraphNode>();
			one.setVisited(true);
			q.add(one);
			while(!q.isEmpty())
			{
				node= q.remove();			
				System.out.println(node.getData());
				
				for(GraphNode n: node.getAdjacentNodes())
				{
					if(n.isVisited()==false)
					{
						n.setVisited(true);//this order is important. Set visited to true first, and then add to queue
						q.add(n);
					}						
				}				
			}			
		}
	}
	
	//visit a node, visit it's child, visit the child's child.. go on until you reach a leaf. 
	//Trace back and visit any unvisited child.
	//Repeat procedure
	public void dfs(GraphNode one)
	{
		if(one!=null)
		{
			Stack<GraphNode> st= new Stack<GraphNode>();
			one.setVisited(true);
			System.out.println(one.getData());
			st.push(one);
			GraphNode node= null;
			int i;
			while(!st.isEmpty())
			{
				node= st.peek();
				i=0;
				for(GraphNode n: node.getAdjacentNodes())
				{
					i++;
					if(!n.isVisited())
					{
						n.setVisited(true);
						System.out.println(n.getData());
						st.push(n);
						break;
					}
					if(i==node.getAdjacentNodes().size())
					{
						st.pop();				
					}
				}				
			}
		}
	}
	
	public boolean pathExists(GraphNode n1, GraphNode n2)//use bfs to see if n2 is reached from n1, simple!
	{
		if(n1!=null && n2!=null)
		{
			Queue<GraphNode> q= new LinkedList<GraphNode>();
			n1.setVisited(true);
			q.add(n1);
			GraphNode node;
			while(!q.isEmpty())
			{
				node= q.remove();
				for(GraphNode n: node.getAdjacentNodes())
				{
					if(n==n2)
						return true;
					else
					{
						if(n.isVisited()==false)
						{
							n.setVisited(true);
							q.add(n);
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String args[])
	{
		Graphs g= new Graphs();
		
		GraphNode one= new GraphNode(1);
		GraphNode two= new GraphNode(2);
		GraphNode three= new GraphNode(3);
		GraphNode four= new GraphNode(4);
		GraphNode five= new GraphNode(5);
		GraphNode six= new GraphNode(6);
		GraphNode seven= new GraphNode(7);
		GraphNode eight= new GraphNode(8);
		
		List<GraphNode> l1= new ArrayList<GraphNode>();		
		l1.add(two);
		l1.add(three);
		l1.add(four);
		one.setAdjacentNodes(l1);
		
		List<GraphNode> l2= new ArrayList<GraphNode>();
		l2.add(one);
		two.setAdjacentNodes(l2);
		
		List<GraphNode> l3= new ArrayList<GraphNode>();
		l3.add(one);
		l3.add(five);
		l3.add(four);
		three.setAdjacentNodes(l3);
		
		List<GraphNode> l4= new ArrayList<GraphNode>();
		l4.add(one);
		l4.add(three);
		l4.add(six);
		four.setAdjacentNodes(l4);
		
		List<GraphNode> l5= new ArrayList<GraphNode>();
		l5.add(three);
		l5.add(seven);
		five.setAdjacentNodes(l5);
		
		List<GraphNode> l6= new ArrayList<GraphNode>();
		l6.add(four);
		six.setAdjacentNodes(l6);
		
		List<GraphNode> l7= new ArrayList<GraphNode>();
		l7.add(five);
		seven.setAdjacentNodes(l7);
		
		//g.bfs(one);
		//g.dfs(one);
		
		System.out.println(g.pathExists(one, seven));
		//System.out.println(g.pathExists(one, six));
		//System.out.println(g.pathExists(one, eight));
		
	}
	
}
