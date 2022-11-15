package main;

import main.LLRedBlack.Node;

public class Main {

	public static void main(String[] args)
	{
		LLRedBlack<Integer, Integer> tree = new LLRedBlack<Integer, Integer>();
		tree.put(5, 5);
		tree.put(3, 3);
		tree.put(7, 7);
			
		tree.preOrder();
		
		System.out.println(tree.getFirstKey(7));

	}
}
