

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//System.out.println("Please enter input");
		int grid_size = sc.nextInt(); 
		Percolation perc = new Percolation(grid_size);
		
		while(sc.hasNext() ) 
		{
			int p = sc.nextInt();
			int q = sc.nextInt();
			perc.open(p,q);
		}
		System.out.println(perc.percolates());

	}

}
