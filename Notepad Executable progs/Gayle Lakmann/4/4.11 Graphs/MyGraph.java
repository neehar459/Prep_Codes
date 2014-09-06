import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class MyGraph{
	
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
	
	public static void main(String[] args){
		MyGraph dirGraph = new MyGraph();
		dirGraph.addEdge(1,2);
		dirGraph.addEdge(1,3);
		dirGraph.addEdge(2,4);
		dirGraph.addEdge(2,5);
		dirGraph.addEdge(3,6);
		dirGraph.addEdge(6,7);
		dirGraph.displayGraph(dirGraph);
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
