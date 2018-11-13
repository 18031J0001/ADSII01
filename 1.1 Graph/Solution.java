import java.util.Scanner;
interface Graph 
{
    int vertices();
    int edges();
    void addEdge(int v, int w);
    boolean hasEdge(int v, int w);
}
class Graphlist implements Graph
{
    
    int vertex,edge;
    String city[];
    Bag<Integer> adjacent[];
    Graphlist(int ve,int ed,String[] c) 
    {
        this.edge = 0;
        this.vertex = ve;
        city = c;
        adjacent=(Bag<Integer>[]) new Bag[ve];
        for(int i=0;i<ve;i++)
        {
            adjacent[i] = new Bag<Integer>();
        }
    }

    public void addEdge(int first,int last)
    {
        if(first==last || hasEdge(first,last))
        {
            return;
        }
        adjacent[first].add(last);
        adjacent[last].add(first);
        edge++;
    }
    public Iterable<Integer> adj(final int v) 
    {
        return adjacent[v];
    }
    public int vertices() 
    {
        return this.vertex;
    }
    public int edges() 
    {
        return this.edge;
    }
   public boolean hasEdge(int v,int w)
    {
        for(int each:adjacent[v])
        {
            if(each==w)
            {
                return true;
            }
        }
        return false;
    }
    public void display()
    {
        if(edge == 0) 
        {
            System.out.println("No edges");
        }
        else 
        {
            for (int i=0;i<vertex-1;i++)
            {
                String str = "";
                str=str+city[i] + ": ";
                for (int each:adjacent[i]) 
                {
                    str=str+city[each] + " ";
                }
                System.out.println(str);
            }
            String str = "";
            str=str+city[vertex - 1] + ": ";
            for (int each:adjacent[vertex-1])
            {
                str=str+city[each] + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));

        }

    }

}
class Graphmatrix implements Graph
{
	int vertex,edge;
	int[][] matrix;
	String city[];

    Graphmatrix(int ve,int ed,String[] c)
    {
        city= c;
        matrix = new int[ve][ve];
        this.vertex = ve;
        this.edge = 0;
        for(int i=0;i<ve;i++) 
        {
            for(int j=0;j<ve;j++)
            {
                matrix[i][j] = 0;
            }
        }
    }
    public void addEdge(int first,int last)
    {
        if(first==last || hasEdge(first,last))
        {
            return;
        }
        matrix[first][last] = 1;
        matrix[last][first] = 1;
        edge++;
    }
    public int[] adj(final int v) 
    {
        return matrix[v];
    }
    public int vertices() 
    {
        return this.vertex;
    }
    public int edges()
    {
        return this.edge;
    }
    public boolean hasEdge(int first,int last) 
    {
        return matrix[first][last] == 1;
    }
    public void print() 
    {
        if(edge == 0)
        {
            System.out.println("No edges");
        } 
        else
        {
            for(int i=0;i<vertex-1;i++)
            {
                String s="";
                for(int each : matrix[i])
                {
                    s=s+each + " ";
                }
                System.out.println(s);
            }
            String s = "";
            for(int each:matrix[vertex-1])
            {
                s=s+each + " ";
            }
            System.out.println(s.substring(0, s.length() - 1));
        }
    }
}
class Solution 
{
    public static void main(final String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String option= scan.nextLine();
        int ve = Integer.parseInt(scan.nextLine());
        int ed = Integer.parseInt(scan.nextLine());
        String city[] = scan.nextLine().split(",");
        if(option.equals("List"))
        {
            Graphlist list=new Graphlist(ve,ed,city);
            for(int i=0;i<ed;i++) 
            {
                String input[] = scan.nextLine().split(" ");
                list.addEdge(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            }
            System.out.println(list.vertices()+ " vertices, " + list.edges() + " edges");

            list.display();

        } 
        else 
        {
            Graphmatrix matrix = new Graphmatrix(ve, ed, city);
            for(int i=0;i<ed;i++)
            {

                String input[] = scan.nextLine().split(" ");
                matrix.addEdge(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            }
            System.out.println(matrix.vertices()+ " vertices, " + matrix.edges() + " edges");
            matrix.print();
        }
    }
}