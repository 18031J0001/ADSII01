
public class Prim
{

    static class Graph
    {
        int vertices;
        int matrix[][];

        public Graph(int vertex)
        {
            this.vertices = vertex;
            matrix = new int[vertex][vertex];
        }

        public void addEdge(int source, int destination, int weight)
        {
            
            matrix[source][destination]=weight;
             matrix[destination][source] = weight;
        }

        int getMinimumVertex(boolean [] mst, int [] key)
        {
            int minKey = Integer.MAX_VALUE;
            int vertex = -1;
            for (int i = 0; i <vertices ; i++) {
                if(mst[i]==false && minKey>key[i]){
                    minKey = key[i];
                    vertex = i;
                }
            }
            return vertex;
        }

        class ResultSet
        {
             int parent;
             int weight;
        }

        public void primMST()
        {
            boolean mst[] = new boolean[vertices];
            ResultSet resultSet[]= new ResultSet[vertices];
            int key[] = new int[vertices];
          
            for (int i=0;i<vertices;i++)
            {
                key[i]=Integer.MAX_VALUE;
                resultSet[i]=new ResultSet();
            }
            key[0] = 0;
            resultSet[0] = new ResultSet();
            resultSet[0].parent = -1;
            for (int i = 0; i <vertices ; i++)
            {
                int vertex = getMinimumVertex(mst, key);
                mst[vertex] = true;
                for (int j=0;j<vertices;j++)
                {
                    if(matrix[vertex][j]>0)
                    {
                        if(mst[j]==false && matrix[vertex][j]<key[j])
                        {
                           
                            key[j] = matrix[vertex][j];
                            resultSet[j].parent = vertex;
                            resultSet[j].weight = key[j];
                        }
                    }
                }
            }
           
            printMST(resultSet);
        }

        public void printMST(ResultSet[] resultSet){
            int total_min_weight = 0;
            System.out.println("Minimum Spanning Tree: ");
            for (int i=1;i<vertices;i++)
            {
                System.out.println("Edge: " + i + " - " + resultSet[i].parent +
                        " key: " + resultSet[i].weight);
                total_min_weight += resultSet[i].weight;
            }
            System.out.println("Total minimum key: " + total_min_weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 9;
        Graph graph = new Graph(vertices);
        graph.addEdge(0, 1, 4 );
        graph.addEdge(1, 2, 8 );
        graph.addEdge(2, 3, 7 );
        graph.addEdge(3, 4, 9 );
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2 );
        graph.addEdge(6, 7, 1 );
        graph.addEdge(5, 3, 14);
        graph.addEdge(5, 2, 4 );
        graph.addEdge(6, 8, 6 );
        graph.addEdge(8, 2, 2 );
        graph.addEdge(7, 8, 7 );
        graph.addEdge(1, 7, 11);
        graph.addEdge(0, 7, 8 );

        graph.primMST();
    }

}

