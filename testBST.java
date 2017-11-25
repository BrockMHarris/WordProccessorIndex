import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import proj5.BinarySearchTree;

/**
 *
 * This class tests the stack class to make sure that it works completely as intended
 *
 * @author Brock Harris
 * @version 10/22/17
 *
 */
public class testBST {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void testInsert_EmptyTree () {
        tree.insert("test");
        assertEquals ("inserting onto empty stack", "test\n", tree.toString());
    }

    @Test
    public void testInsert_insertOnRight () {
        tree.insert("1");
        tree.insert("2");
        assertEquals ("inserting a node to the left of the root", "1\n2\n", tree.toString());
    }

    @Test
    public void testInsert_insertOnRightRight () {
        tree.insert("1");
        tree.insert("2");
        tree.insert("3");
        assertEquals ("inserting a node to the right of the right root", "1\n2\n3\n", tree.toString());
    }
    @Test
    public void testInsert_insertEqualValues () {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("inserting a node that is equal to a node in the tree", "1\n2\n3\n3\n4\n", tree.toString());
    }

    @Test
    public void testSearch_EmptyTree () {
        assertEquals ("find for an element in an empty tree", false, tree.search("null"));
    }

    @Test
    public void testSearch_fullTree_there() {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("find for an element in an a tree and its there", true, tree.search("3"));
    }

    @Test
    public void testSearch_fullTree_notThere() {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("find for an element in an a tree and its not there", false, tree.search("20"));
    }

    public void testFind_EmptyTree () {
        assertEquals ("find for an element in an empty tree", null, tree.find("null"));
    }

    @Test
    public void testFind_fullTree_there() {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("find for an element in an a tree and its there", "3", tree.find("3"));
    }

    @Test
    public void testFind_fullTree_notThere() {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("find for an element in an a tree and its not there", null, tree.find("20"));
    }

    @Test
    public void testSearch_notInTree () {
        tree.insert("1");
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("3");
        assertEquals ("find for an element that is not in a full tree", null, tree.find("null"));
    }

    @Test
    public void testSearch_isInTree () {
        tree.insert("3");
        tree.insert("2");
        tree.insert("4");
        tree.insert("test");
        assertNotNull ("Searching for an element that is in the tree", tree.find("test"));
    }

    @Test
    public void testToString_EmptyString () {
        assertEquals ("String representation of an empty tree", "", tree.toString());
    }

    @Test
    public void testToString_fullTree () {
        tree.insert("5");
        tree.insert("2");
        tree.insert("7");
        assertEquals ("Searching for an element that is in the tree", "2\n5\n7\n", tree.toString());
    }
    @Test

    public void testToString_1Sided () {
        tree.insert("5");
        tree.insert("6");
        tree.insert("7");
        assertEquals ("Searching for an element that is in the tree", "5\n6\n7\n", tree.toString());
    }

    @Test
    public void testDelete_root(){
        tree.insert(5);
        tree.delete(5);
        assertEquals("delete the root of the tree when tree is empty", "", tree.toString());
    }


    @Test
    public void testDelete_notThere(){
        tree.insert(5);
        tree.delete(4);
        assertEquals("delete an element that is not there", "5\n", tree.toString());
    }

    @Test
    public void testDelete_empty(){
        tree.delete(4);
        assertEquals("delete from an empty tree", "", tree.toString());
    }

    @Test
    public void testDelete_root_Fulltree(){
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.delete(5);
        assertEquals("delete the root of the tree", "4\n6\n", tree.toString());
    }

    @Test
    public void testDelete_LeftNode_Fulltree(){
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);
        tree.insert(4);
        tree.insert(2);

        tree.delete(4);
        assertEquals("delete the root of the tree", "2\n2\n3\n4\n5\n6\n", tree.toString());
    }

    @Test
    public void testDelete_RightNode_Fulltree(){
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.insert(7);
        tree.insert(9);
        tree.insert(14);

        tree.delete(6);
        assertEquals("delete the root of the tree", "4\n5\n7\n8\n9\n14\n", tree.toString());
    }

    @Test
    public void testConstructor () {
        BinarySearchTree tree = new BinarySearchTree();
        assertEquals ("testing constructor", "", tree.toString());
    }



}