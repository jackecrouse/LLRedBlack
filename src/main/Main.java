package main;

public class Main {

	public static void main(String[] args)
	{
		LLRedBlack<Integer, Integer> tree = new LLRedBlack<Integer, Integer>();
		tree.put(35, 35);
		tree.put(25, 25);
		tree.put(60, 60);
		tree.put(15, 15);
		tree.put(30, 30);
		tree.put(50, 50);
		tree.put(70, 70);
		tree.put(10, 10);
		tree.put(25, 25);
		tree.put(40, 40);
		tree.put(55, 55);
		tree.put(54, 54);
		
		Node node = tree._root;
		
		System.out.println("---Preorder---");
		tree.preOrder();
		System.out.println("--------------");
		System.out.println("First Key 40: " + tree.getFirstKey(40));
		System.out.println("Size: " + tree.size(node));
		System.out.println("Black Height: " + tree.blackHeight(node));
		System.out.println("Normal Height: " + tree.height(node));
		System.out.println("Depth: " + tree.depth(tree._root._right));
	}
}
