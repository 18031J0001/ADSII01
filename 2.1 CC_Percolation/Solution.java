import java.util.Scanner;

public class Solution
{
  
    public static boolean[][] flow(boolean[][] isOpen) 
    {
        int number= isOpen.length;
        boolean[][] isFull = new boolean[number][number];
        for (int j = 0; j < number; j++) {
            flow(isOpen, isFull, 0, j);
        }
        return isFull;
    }

    public static void flow(boolean[][] isOpen, boolean[][] isFull, int i, int j) {
        int num = isOpen.length;
        if(i<0 || i>=num)
        	return;    
        if(j<0 || j>=num)
        	return;  
        if(!isOpen[i][j])
        	return;     
        if(isFull[i][j]) 
        	return;     
        isFull[i][j]=true;

        flow(isOpen,isFull,i+1,j);
        flow(isOpen,isFull,i,j+1);  
        flow(isOpen,isFull,i,j-1);   
        flow(isOpen,isFull,i-1,j);  
    }


    public static boolean percolates(boolean[][] isOpen) 
    {
        int number = isOpen.length;
        boolean[][] isFull = flow(isOpen);
        for (int k=0;k<number;k++)
        {
            if(isFull[number-1][k]) 
            	return true;
        }
        return false;
    }

   
  
    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	int n=Integer.parseInt(sc.nextLine());
	    boolean[][] isOpen = new boolean[n][n];
        try
        {
        while(sc.hasNext())
        {
        	String input[]=sc.nextLine().split(" ");
        	int i=Integer.parseInt(input[0]);
        	int j=Integer.parseInt(input[1]);
        	isOpen[i-1][j-1]=true;
        }
        }
        catch(Exception e)
        {
        	System.out.println("index out of bound"+e.getMessage());
        }
   
        System.out.println(percolates(isOpen));
    }

}
