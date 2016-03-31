import java.util.List;


public class GraphNode {

	private int data;
	private List<GraphNode> adjacentNodes;
	private boolean visited;
	
	public GraphNode(int data)
	{
		this.data= data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public List<GraphNode> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(List<GraphNode> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
}
