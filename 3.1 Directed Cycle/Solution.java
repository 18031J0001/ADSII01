import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

 class Graph {
int V;
int E;
Bag<Integer>[] adj;
public Graph(int v)
{
	this.V=v;
	adj=(Bag<Integer>[])new Bag[v];
	for(int i=0;i<v;i++)
	{
		adj[i]=new Bag<Integer>();
	}
}
public Graph(BufferedReader in) throws NumberFormatException, IOException
{
	this(Integer.parseInt(in.readLine()));
	int E=Integer.parseInt(in.readLine());
	
	for(int v=0;v<E;v++)
	{
		String r=in.readLine();
		String[] z=r.split(" ");
		int k=Integer.parseInt(z[0]);
		int w=Integer.parseInt(z[1]);
		addEdge(k,w);
	}
}
private boolean duplicate(int v2,int w) {
	 for (int w1 : adj[v2]) {
	        if(w1==w)
	        {
	        	return true;
	        }
       }
	return false;
}
public void addEdge(int v,int w)
{
	if(!duplicate(v,w))
	{
	E++;
	adj[v].add(w);
	}
}
int V()
{
	return V;
}
int E()
{
	return E;
}
Iterable<Integer> adj(int v)
{
	return adj[v];
}
}


 class Directeddfs {
boolean[] marked;

public Directeddfs(Graph g) {
	marked=new boolean[g.V()];
	for(int i=0;i<g.V();i++){
		if(!marked[i])
		{
			dfs(g,i);
			//System.out.println(i);
		}
	}
}
void dfs(Graph g,int v)
{
	marked[v]=true;
	for(int w:g.adj(v))
	{
		//System.out.println(w);
		if(!marked[w])
		{
			dfs(g,w);
			//System.out.println(marked[w]);
       }
		else
		{
			System.out.println("Cycle exists.");
		    System.exit(0);
		}
	}
	marked[v]=false;
	
}	
boolean Visited(int v)
{
	return marked[v];
}
void  display()
{
	System.out.println("Cycle doesn't exists.");
}
}

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Graph g=new Graph(br);
      Directeddfs d=new Directeddfs(g);
      d.display();
	}

}
