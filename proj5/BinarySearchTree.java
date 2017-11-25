package proj5;
/** This is a Binary search tree. You can add objects of comparable type. They are order by parent and 2 children nodes
 * this ADT is made up of a linked list so this class only holds a pointer to the root of the tree
 * the elements are held by BSTNodes
 *
 * 
 * @author Brock Harris
 * @version 10/30/17
 */
public class BinarySearchTree<E extends Comparable<E>>
{
     private BSTNode root;

    /**
     * This is a constructor the BST. it sets the root to null
     */
    public BinarySearchTree() {
    	 root=null; 
     }
     
     /**
      * inserts recursively. Inserts comparable elements into the tree with smaller and equal elements on the left of the
      * root, and larger elements on the right
      * 
      * @param startingNode inserts into subtree rooted at staringNode
      * @param newNode node to insert
      * @return startingNode with newNode already inserted
      */
     private BSTNode insert(BSTNode startingNode, BSTNode newNode) {
    	 if (startingNode == null) {
    		 return newNode;
    	 }
    	 else if (startingNode.key.compareTo(newNode.key) < 0) {
    		 startingNode.rlink = insert(startingNode.rlink,newNode);
    		 return startingNode;
    	 }
    	 else {  // startingNode.key bigger than newNode.key, so newNode goes on left
    		 startingNode.llink = insert(startingNode.llink,newNode);
    		 return startingNode;
    	 }
     }
     
     /**
      * public method for the recursive insert above.
      * 
      * @param newElem Elem to insert
      */
     public void insert(E newElem){
    	 BSTNode newNode = new BSTNode(newElem);
    	 root = insert(root, newNode);
     }

    /**
     * Public method for the recursive delete used
     * @param elem element to remove
     */
    public void delete(E elem){
//         BSTNode subroot = root;
         BSTNode target = new BSTNode(elem);
         root = rDelete(root, target);
    }

    /**
     * private recursive helper for delete. takes and root and returns the root with the target removed
     * @param root root of the tree you want the target deleted from
     * @param target bstNode with the same key as the thing you want deleted
     * @return returns the root of the tree with the element deleted
     */
    private BSTNode rDelete(BSTNode root, BSTNode target){
        if(root == null){
            return null;
        }
        else if (root.key.compareTo(target.key) > 0){
            root.llink = rDelete(root.llink, target);
        }
        else if (root.key.compareTo(target.key) < 0){
            root.rlink = rDelete(root.rlink, target);
        }
        else{
            if(root.llink == null && root.rlink == null){
                return null;
            }
            else if(root.llink != null && root.rlink == null){
                root = root.llink;
                //return root;
            }
            else if(root.rlink != null && root.llink == null){
                root = root.rlink;
                //return root;
            }
            else {
                BSTNode temp = root;
                BSTNode right = findReplacement(temp);
                root.key = right.key;
                root.llink = rDelete(root.llink, right);
            }
        }
        return root;
    }

    /**
     * helper for delete, finds the element directly to the left of the desired element if they are lined up using comparTo
     * @param root the node that is the target
     * @return node directly left to the target
     */
    private BSTNode findReplacement(BSTNode root){
        BSTNode runner = root;
        runner = runner.llink;
        while(runner.rlink != null){
            runner = runner.rlink;
        }
        return runner;
    }

    /**
     * searches through the tree for the given element
     * @param target the element you are looking for
     * @return true if the element is in the tree, and false if it is not
     */
    public boolean search(E target)
    {
        return recursiveSearch(target,root);
    }

    private boolean recursiveSearch(E target, BSTNode root){
        if(root == null){
            return false;
        }
        else if(root.key == target){
            return true;
        }
        else{
            boolean branchAnswer = recursiveSearch(target, root.llink);
            if(branchAnswer){
                return true;
            }
            branchAnswer = recursiveSearch(target, root.rlink);
            if(branchAnswer){
                return true;
            }
            return false;

        }
    }


    /**
     * searches through the tree for the given element
     * @param target the element you are looking for
     * @return the element that your were searching for that is in the BST or null if it is not there
     */
    public E find(E target)
    {
        return recursiveFind(target,root);
    }

    /**
     *  recursive helper method for find
     * @param target the element that is being searched for
     * @param root the root of the desired bst
     * @return the element bieng serached for, or null if root is null
     */
    private E recursiveFind(E target, BSTNode root){

         if(root == null){
             return null;
         }
         else if(root.key.compareTo(target) == 0){
             return (E) root.key;
         }
         else{
             E branchAnswer = recursiveFind(target, root.llink);
             if(branchAnswer != null){
                 return branchAnswer;
             }
             branchAnswer = recursiveFind(target, root.rlink);
             if(branchAnswer != null){
                 return branchAnswer;
             }
             return null;

         }
    }

    /**
     * @return string representation of the BST in the format ((  N  )  N  (  N  ))
     */
    public   String   toString()
    {
        return  RecusiveToString(root);
    }
        /**
         *   private helper for the toString so that the string can be made recursively
         *   @param N the new root of the tree to be printed
         *   @return a string representation of the tree starting at the root N. if N is null returns an empty string


         *   if N has no children returns (  N  )
         *   if N has a child then it returns ((  child  )  N  (  child  ))
         */
        private   String   RecusiveToString(BSTNode   N){
        String   toReturn   =   "";
        if   (N   !=   null)   {               //   stop   recursing   when   N   is   null
            toReturn   +=   "(";
            toReturn   +=   RecusiveToString(N.llink);
            toReturn   +=   "  "   +   N   +   "  ";
            toReturn   +=   RecusiveToString(N.rlink);
            toReturn   +=   ")";
        }
        return   toReturn;
    }

}
