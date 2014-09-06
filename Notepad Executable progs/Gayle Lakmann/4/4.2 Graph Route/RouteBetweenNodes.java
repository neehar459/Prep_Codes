import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
public class RouteBetweenNodes{
	public static void main(String[] args){
		MyGraph dirGraph = new MyGraph();
		dirGraph.addEdge(1,2);
		dirGraph.addEdge(1,3);
		dirGraph.addEdge(2,4);
		dirGraph.addEdge(2,5);
		dirGraph.addEdge(3,6);
		dirGraph.addEdge(6,7);
		dirGraph.addEdge(8,9);
		dirGraph.displayGraph(dirGraph);
		int[] neighboursArray = dirGraph.getNeighbours(2);
		for(int i : neighboursArray){
			System.out.print(i+" , ");
		}
		System.out.println(" ");
		System.out.println("Does Route Exist between 5 and 7 : "+dirGraph.areNodesConnected(5,7));
	}
}


class MyGraph{
	
	int noOfEdges;
	int noOfVertices;
	Map<Integer, ArrayList> adjList = new HashMap<Integer, ArrayList>(); 
	
	// This will instantiate graph
	public MyGraph(){
	
	}
	
	// This will instantiate graph
	public MyGraph(int edges){
		this.noOfEdges = noOfEdges;
	}
	
	// This method tells if 2 nodes in dirGraph are connected. 
	// Solution : Use bfs and check if while doing bfs you encounter the destination node.
	public boolean areNodesConnected(int node1, int node2){
		boolean areNodesConnected = false;
		if(!this.adjList.containsKey(node1) || (!this.adjList.containsKey(node2))){
			return areNodesConnected; 
		}else{
			Map<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>(); 
			int[] verticesArray = new int[adjList.keySet().size()];
			int j=0;
			for (Integer val : adjList.keySet()){
				verticesArray[j++] = val;
			}
			for(int k : verticesArray){
				visitedMap.put(k,false);
			}
			// We do a breadth first Search starting from node 1 and if we can find node in the bfs. That means both nodes have a rpute between them.
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(node1);
			while(!q.isEmpty()){
				if(null!= getNeighbours(q.peek())){
					for(int i=0;i<getNeighbours(q.peek()).length;i++){
						if(node2 == getNeighbours(q.peek())[i]){
							areNodesConnected = true;
							return areNodesConnected;
						}else{
							if(visitedMap.get(getNeighbours(q.peek())[i]) == false){
								visitedMap.put(getNeighbours(q.peek())[i],true);
								q.add(getNeighbours(q.peek())[i]);
							}
						}
					}
				}
				q.remove();
			}
			return areNodesConnected;
		}
	}
	
	// This method returns  neighbours of a node in a graph
	public int[] getNeighbours(int source){
		if(!adjList.containsKey(source)){
			return null;
		}else{
			int[] neighboursArray = new int[adjList.get(source).size()];
			for(int i =0; i < adjList.get(source).size(); i++){
				neighboursArray[i] = ((ArrayList<Integer>)adjList.get(source)).get(i);
			}
			return neighboursArray;
		}
	}
	
	// This method adds and Edge to the graph
	public int addEdge(int vertex1, int vertex2){
		if(adjList.size() == 0){
			ArrayList list1 = new ArrayList();
			list1.add(vertex2);
			adjList.put(vertex1,list1);
			ArrayList list2 = new ArrayList();
			list2.add(vertex1);
			adjList.put(vertex2,list2);
			return 0;
		}else if(adjList.size() != 0){
			int flag =0;
			if(null == adjList.get(vertex1)){
				ArrayList list11 = new ArrayList();
				list11.add(vertex2);
				adjList.put(vertex1,list11);
				flag++;
			}
			if(flag==2){
				return 0;
			}
			if(adjList.get(vertex2) == null){
				ArrayList list12 = new ArrayList();
				list12.add(vertex1);
				adjList.put(vertex2,list12);
				flag++;
			}
			if(flag==2){
				return 0;
			}
			if(null != adjList.get(vertex1)){
				ArrayList list3 = adjList.get(vertex1);
				list3.add(vertex2);
				adjList.put(vertex1,list3);
				flag++;
			}
			if(flag==2){
				return 0;
			}
			if(null != adjList.get(vertex1)){
				ArrayList list4 = adjList.get(vertex2);
				list4.add(vertex1);
				adjList.put(vertex2,list4);
				flag++;
			}
			if(flag == 2){
				return 0;
			}
		}
		return 1; 
	}
	
	// This method displays the graph
	public void displayGraph(MyGraph graph){
		if(graph.adjList.size() != 0){
			int[] vertex1Array = new int[graph.adjList.keySet().size()];
			int i=0;
			for (Integer val : graph.adjList.keySet()){
				vertex1Array[i++] = val;
			}
			
			for(int j : vertex1Array){
				System.out.println(j + " ---> "); 
				displayList(graph.adjList.get(j));
				System.out.println(" ");
			}
		}
	}
	
	// This method displays the list
	public void displayList(ArrayList list){
		for(int i=0; i < list.size(); i++){
			System.out.print(" ---> " +list.get(i));
		}
	}
}
