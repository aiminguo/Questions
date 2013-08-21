package main;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriNaryTreeTest {
	TriNaryTree tree = new TriNaryTree();
	@Rule 
	public ExpectedException  exception = ExpectedException.none();
	
	@Test 
	//Insert/Delete valid data case
	public void testTriNaryTree() {
		int sets[] = {5, 4, 9, 5, 7, 2, 2};
		tree.insert(sets);
		Node root = tree.Root();
		
		//root level
		assertEquals(5, root.data);
		//level 2 nodes
		assertEquals(4, root.left.data);
		assertEquals(5, root.middle.data);
		assertEquals(9, root.right.data);
		//level 3 nodes
		assertEquals(2, root.left.left.data);
		assertEquals(7, root.right.left.data);
		//level 4 node
		assertEquals(2, root.left.left.middle.data);	
		
		//remove level 4 node
		tree.delete(2, root);
		assertEquals(null, root.left.left.middle);
		
		//remove level 3 nodes
		tree.delete(7, root);
		assertEquals(null, root.right.left);
		tree.delete(2, root);
		assertEquals(null, root.left.left);		
		
		//remove level 2 nodes
		tree.delete(4, root);
		assertEquals(null, root.left);
		tree.delete(5, root);
		assertEquals(null, root.middle);		
		tree.delete(9, root);
		assertEquals(null, root.right);		

		//remove root node
		root = tree.delete(5, root);
		assertEquals(null, root);
	}
	
	@Test 
	//Insert/Delete invalid data case
	public void testTernaryTreeException() {
		exception.expect(IllegalArgumentException.class);
		int sets[] = {-5, 4, 9, 5, 7, 2, 2};
		tree.insert(sets);
		tree.delete(99, null);
	}
}
