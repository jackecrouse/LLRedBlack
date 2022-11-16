package main;

public class Node <Key extends Comparable<Key>, Value>  {
	        public Key _key;           // _key
	        public Value _val;         // associated data
	        public Node _left;  // links to _left and _right subtrees
			public Node _right;
	        public boolean _color;     // _color of parent link

	        public Node(Key key, Value val, boolean _color) {
	            this._key = key;
	            this._val = val;
	            this._color = _color;
	        }
	    }
	    