package main;

	public class LLRedBlack<Key extends Comparable<Key>, Value> {

	    public static final boolean _RED   = true;
	    public static final boolean _BLACK = false;

	    public Node _root;     // _root of the BST

	    // BST helper Node data type
	    public class Node {
	        private Key _key;           // _key
	        private Value _val;         // associated data
	        private Node _left, _right;  // links to _left and _right subtrees
	        private boolean _color;     // _color of parent link

	        public Node(Key key, Value val, boolean _color) {
	            this._key = key;
	            this._val = val;
	            this._color = _color;
	        }
	    }
	    
	    
	    private boolean is_RED(Node n)
	    {
	    	if(n == null) return false;
	    	return n._color == _RED;
	    }
	   
	    
	 // make a _right-leaning link lean to the _left
	    private Node rotate_left(Node h)
	    {
	        assert (h != null) && is_RED(h._right);

	        Node x = h._right;
	        h._right = x._left;
	        x._left = h;
	        x._color = x._left._color;
	        x._left._color = _RED;


	        return x;
	    }
	   
	    
	 // make a _left-leaning link lean to the _right
	    private Node rotate_right(Node h)
	    {
	        assert (h != null) && is_RED(h._left);

	        Node x = h._left;
	        h._left = x._right;
	        x._right = h;
	        x._color = x._right._color;
	        x._right._color = _RED;
	        

	        return x;
	    }
	    
	    
	 // flip the _colors of a Node and its two children
	    private void flip_colors(Node h)
	    {
	        h._color = !h._color;
	        h._left._color = !h._left._color;
	        h._right._color = !h._right._color;
	    }

	    
	    
	    public void put(Key key, Value val)
	    {
	    	_root = put(_root, key, val);
	    	_root._color = _BLACK;
	    }
	    
	    private Node put(Node h, Key key, Value val)
	    {
	    	if(h == null) return new Node(key, val, _RED);
	    	
	    	Integer cmp = key.compareTo(h._key);
	    	if(cmp < 0) h._left = put(h._left, key, val);
	    	else if(cmp > 0) h._right = put(h._right, key, val);
	    	else if(cmp == 0) h._val = val;
	    	
	    	if(is_RED(h._right) && !is_RED(h._left)) h = rotate_left(h);
	    	if(is_RED(h._left) && is_RED(h._left._left)) h = rotate_right(h);
	    	if(is_RED(h._left) && is_RED(h._right)) flip_colors(h);
	    	
	    	return h;
	    	
	    }
	    
	    
	    
	    public Key getFirstKey(Value val) throws IllegalArgumentException
	    {
	    	if(val == null) throw new IllegalArgumentException(); 
	    	return getFirstKey(_root, val);
	    }
	    
	    private Key getFirstKey(Node node, Value val)
	    {
	    	if(node == null) return null;
	    	if(node._val.equals(val)) return node._key;
	    	if(getFirstKey(node._left, val) != null) return getFirstKey(node._left, val); 
	    	return getFirstKey(node._right, val);
	    }
	    
	    
	    public void inOrder()
	    {
	    	inOrder(_root);
	    }
	    
	    
	    private void inOrder(Node n)
	    {
	    	if(n._left != null) inOrder(n._left);
	    	System.out.println(n._key + " " + n._val);
	    	if(n._right != null) inOrder(n._right);
	    }
	    
	    
	    public void preOrder()
	    {
	    	preOrder(_root);
	    }
	    
	    private void preOrder(Node n)
	    {
	    	System.out.println(n._key + " " + n._val);
	    	if(n._left != null) preOrder(n._left);
	    	if(n._right != null) preOrder(n._right);
	    }
	    
	    public void postOrder()
	    {
	    	postOrder(_root);
	    }
	    
	    private void postOrder(Node n)
	    {
	    	if(n._left != null) postOrder(n._left);
	    	if(n._right != null) postOrder(n._right);
	    	System.out.println(n._key + " " + n._val);
	    }
	    
	    public Integer size(Node n)
	    {
	    	if(n == null) return 0;
	    	return 1 + size(n._left) + size(n._right);
	    }
	    
	    
	    
	}
