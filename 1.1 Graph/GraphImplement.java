


import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *  The {@code Graph} class represents an undirected graph of vertices
 *  named 0 through <em>V</em> – 1.
 *  It supports the following two primary operations: add an edge to the graph,
 *  iterate over all of the vertices adjacent to a vertex. It also provides
 *  methods for returning the number of vertices <em>V</em> and the number
 *  of edges <em>E</em>. Parallel edges and self-loops are permitted.
 *  By convention, a self-loop <em>v</em>-<em>v</em> appears in the
 *  adjacency list of <em>v</em> twice and contributes two to the degree
 *  of <em>v</em>.
 *  <p>
 *  This implementation uses an adjacency-lists representation, which 
 *  is a vertex-indexed array of {@link Bag} objects.
 *  All operations take constant time (in the worst case) except
 *  iterating over the vertices adjacent to a given vertex, which takes
 *  time proportional to the number of such vertices.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/41graph">Section 4.1</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class GraphImplement implements Graph
{
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    private String keys[];
    private int Matrix[][];
    private final String type;
    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
   /* public GraphImplement(int V) {
    	
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
        Matrix =new int[V][V];
        
    }*/

    /**  
     * Initializes a graph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    public GraphImplement(In in,String temp) {
    	 this.V = in.readInt();
    	 //int E = in.readInt();
    	 //keys=in.Strineline().split(",");
    	// String links[]=in.Strineline().split(" ");
    	 this.type=temp;
         // System.out.println("===>Edges "+E);
         
    	
    		//this.V = in.readInt();
        try {
            //this.V = in.readInt();
            //System.out.println("===>vertices "+this.V);
        	if(this.type.equals("List"))
        	{
        		 if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
                 adj = (Bag<Integer>[]) new Bag[V];
                 for (int v = 0; v < V; v++) {
                     adj[v] = new Bag<Integer>();
                 }
                 int E = in.readInt();
                
                keys=in.Strineline().split(",");
                 
                 if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
                 for (int i = 0; i < E; i++) {
                 	String links[]=in.Strineline().split(" ");
                     int v = Integer.parseInt(links[0]);
                     int w = Integer.parseInt(links[1]);
                   
                     validateVertex(v);
                     validateVertex(w);
                     addEdge(v, w); 
                 }
            }
        	else if(this.type.equals("Matrix")) {
        		 Matrix =new int[V][V];
        		 int E = in.readInt();
        		
                 keys=in.Strineline().split(",");
        		 if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
                 for (int i = 0; i < E; i++) {
                	String links[]=in.Strineline().split(" ");
                     int v = Integer.parseInt(links[0]);
                     int w = Integer.parseInt(links[1]);
                     validateVertex(v);
                     validateVertex(w);
                     addEdge(v, w); 
                 }
        	}
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
   
    	
    }


    
    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
       
        if(V>1 && this.type.equals("List")) 
        {
        adj[v].add(w);
        adj[w].add(v);
        E++;
        }
        
        else if(V>1 && this.type.equals("Matrix")) 
        {
        	//System.out.println("v"+v+": w"+w);
        	Matrix[v][w]=1;
        	Matrix[w][v]=1;
        	E++;
        }
        
    }


    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        //String keys[]=in.Strineline().split(",");
        if(V<=1) {
        	s.append(V + " vertices, " + E + " edges " + NEWLINE);	
        	s.append("No edges");
        	return s.toString();
        }else {
        	s.append(V + " vertices, " + E + " edges " + NEWLINE);
        }
        
        if(this.type.equals("List")) {
        for (int v = 0; v < V; v++) 
        {
            s.append(keys[v] + ": ");
            for (int w : adj[v]) {
                s.append(keys[w] + " ");
            }
            s.append(NEWLINE);
        }
        }
        else
        {
        	System.out.println("E--->"+E);
        	for (int v = 0; v < V; v++) 
            {
                //s.append(keys[v] + ": ");
                for (int e = 0; e < Matrix.length; e++) {
                    s.append(Matrix[v][e] + " ");
                }
                s.append(NEWLINE);
            }
        }
        
        return s.toString();
    }


    /**
     * Unit tests the {@code Graph} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	 String temp=sc.nextLine();
    	In in = new In(sc);
    	
    	   		
            GraphImplement G = new GraphImplement(in,temp);
            System.out.println(G);
    
    }

	@Override
	public boolean hasEdge(int v, int w) {
		// TODO Auto-generated method stub
		return false;
	}

}
