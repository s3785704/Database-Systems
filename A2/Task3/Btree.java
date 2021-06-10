/**
 * 
 */
package treeload;

/**
 * @author lenovo
 *
 */

public class Btree {
	public abstract class Node{
	}
	
	public class LeafNode extends Node{
	    private String [] keys;
		private long   [] offsets;
		private int       order;
		private int       total;
		
		public LeafNode(int mOrder) {
			order   = mOrder;
			keys    = new String[order];
			offsets = new long[order];
			total   = 0;
		}
		
		public void print_node() {
			for(int i=0; i < total; i++) {
				System.out.print(keys[i] + "-");
				System.out.print(offsets[i]);
				System.out.print("|");
			}
			System.out.println();
		}
	}
	
	public class InternalNode extends Node{
		private String [] keys;
		private Node   [] nptr;
		private int       order;
		private int       total;
		
		public InternalNode(int mOrder) {
			order = mOrder;
			keys  = new String[order];
			nptr  = new Node[order];
			total = 0;
			for(int i =0; i < order; i++) {
				nptr[i] = null;
			}
		}
		
		public void print_node() {
			for(int i=0; i < total; i++) {
				System.out.print(keys[i]);
				System.out.print("|");
			}
			System.out.println();
		}
	}


	/**
	 * 
	 */
	public Btree(int order) {
		// TODO Auto-generated constructor stub
		root = new InternalNode(order);
		total_nodes = 1 ;
		this.order  = order;
		total_items = 0;
	}
	
	public void insert(String key, long offset) {
		if(total_items == 0 ) {
			//Then the problem here is that this is leaf node to be inserted
		}
		
	}
	
	//Data items 
	public int 	total_nodes;
	public Node root;
	public int 	order; 
	public int  total_items;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Hello");

	}

}
