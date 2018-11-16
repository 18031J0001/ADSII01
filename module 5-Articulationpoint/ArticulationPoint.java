
import java.io.*; 
import java.util.*;
import java.util.LinkedList;
class Graph 
{ 
	private int V; 
	private LinkedList<Integer> adj[]; 
	int time = 0; 
	static final int NIL = -1;
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); 
		adj[w].add(v);  
	}
	void APUtil(int u, boolean visited[], int disc[], 
				int low[], int parent[], boolean ap[]) 
	{
		int children = 0;
		visited[u] = true;
		disc[u] = low[u] = ++time;  
		Iterator<Integer> i = adj[u].iterator(); 
		while (i.hasNext()) 
		{ 
			int v = i.next();
			if (!visited[v]) 
			{ 
				children++; 
				parent[v] = u; 
				APUtil(v, visited, disc, low, parent, ap);
				low[u] = Math.min(low[u], low[v]);  
				if (parent[u] == NIL && children > 1) 
					ap[u] = true;
				if (parent[u] != NIL && low[v] >= disc[u]) 
					ap[u] = true; 
			} 
			else if (v != parent[u]) 
				low[u] = Math.min(low[u], disc[v]); 
		} 
	}
	void Articulation() 
	{
		boolean visited[] = new boolean[V]; 
		int disc[] = new int[V]; 
		int low[] = new int[V]; 
		int parent[] = new int[V]; 
		boolean ap[] = new boolean[V];
		for (int i = 0; i < V; i++) 
		{ 
			parent[i] = NIL; 
			visited[i] = false; 
			ap[i] = false; 
		}
		for (int i = 0; i < V; i++) 
			if (visited[i] == false) 
				APUtil(i, visited, disc, low, parent, ap); 
          int c=0;
	   for (int i = 0; i < V; i++) 
			if (ap[i] == true) 
			 c++;
		System.out.println(c);
	}
}
public class ArticulationPoint
{
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		String[] a=s.split(" ");
		Graph g = new Graph(Integer.parseInt(a[0])+1); 
		for(int i=0;i<Integer.parseInt(a[1]);i++)
		{
			String k1=sc.nextLine();
			String[] k =k1.split(" ");
		g.addEdge(Integer.parseInt(k[0]), Integer.parseInt(k[1])); 
		}
		g.Articulation(); 
	} 
} 


