package main;

public class TriNaryTree {
    Node root = null;
    
    //Reset the root of the tree
    public TriNaryTree() {
    	root = null;
    }
    
    //Get the root of the tree
    public Node Root() {
    	return root;
    }
    
    //Add integer array
    public void insert(int A[]) {  
        //Add the first integer as root 
        root = new Node(A[0]);  
          
        //Insert values into the tree  
        for (int i = 1; i < A.length; i++)  {
            insert(root, A[i]);  
        }   
    }  
    
    //Add new integer node to the tree 
    public void insert(Node node, int value) {
        //for left node case  
        if (value < node.data) {
            // create left child if not exist  
            if (null == node.left) {   
            	node.left = new Node(value); 
            }  else {  
            	insert(node.left, value);   
            }  
        }   
        // for right node case 
        else if (value > node.data) {
            // create right child if not exist  
            if (null == node.right) {   
            	node.right = new Node(value); 
            }  else {  
            	insert(node.right, value);   
            } 
        }  
        // for middle node case  
        else  {
            // create middle child if not exist  
            if (null == node.middle) {   
            	node.middle = new Node(value); 
            }  else {  
            	insert(node.middle, value);   
            } 
        }  
    }  
    
    ///Find the most left node 
    private Node findMostLeft(Node node) {
    	if (node != null) {
	    	while (node.left != null) {
	    		node = node.left;
		    }
    	}
    	return node;
    }
    
    public Node delete(int value, Node node) {
    	if (null == node) {
    		throw new IllegalArgumentException("Node cannot be set to null.");
    	} else if (value < node.data) {
    		node.left = delete(value, node.left);
    	} else if (value > node.data) {
    		node.right = delete(value, node.right);
    	} else {
    		//delete middle if it exists
	    	if (node.middle != null) {
	    		node.middle = delete(value, node.middle);
	    	} else if (node.right != null) {
	    		//replace it with most left node in Right subtree
	    		Node ml = findMostLeft(node.right);
	    		node.data = ml.data;
	    		node.right = delete(ml.data, node.right);
	    	} else {
	    		//replace it with the left node    		
	    		node = node.left;
	    	}
    	}
		return node;
	}     
}

//TriNary Tree Node definition
class Node {
    int data;
    Node left, middle, right;

    public Node(int value) {
    	//Not sure if it is required, just in case
        if (value <= 0) throw new IllegalArgumentException("It must be a positive number.");
        data = value;
    }
}
