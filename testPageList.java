import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import proj5.BinarySearchTree;
import proj5.PageList;
import proj5.WordPages;

/**
 *
 * This class tests the stack class to make sure that it works completely as intended
 *
 * @author Brock Harris
 * @version 10/22/17
 *
 */
public class testPageList {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private PageList pageList;

    @Before
    public void setUp() throws Exception {
        pageList = new PageList();
    }

    @After
    public void tearDown() throws Exception {
        pageList = null;
    }

    @Test
    public void testConstructor_size(){
        assertEquals("constructor sets size to 0", 0, pageList.size());
    }

    @Test
    public void testConstructor_capacity(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("Test that the capacity is set to 4", true, pageList.isFull());
    }

    @Test
    public void testIsFull_full(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("is full when full ", true, pageList.isFull());
    }

    @Test
    public void testIsFull_half(){
        pageList.insert(1);
        pageList.insert(2);
        assertEquals("is full when only 2 elements", false, pageList.isFull());
    }

    @Test
    public void testIsFull_empty(){
        assertEquals("is full when no items in list", false, pageList.isFull());
    }

    @Test
    public void testSize_empty(){
        assertEquals("size when list is empty", 0, pageList.size());
    }

    @Test
    public void testSize_half(){
        pageList.insert(1);
        pageList.insert(2);
        assertEquals("Size when it has 2 items", 2, pageList.size());
    }

    @Test
    public void testSize_full(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("size when there is 4 elements in the list", 4, pageList.size());
    }

    @Test
    public void testContains_contained(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("Contains when desired element is in list", true, pageList.contains(2));
    }

    @Test
    public void testContains_notContained(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("Contains when desired element is not in list", false, pageList.contains(15));
    }
    @Test
    public void testContains_empty(){
        assertEquals("Contains on an empoty list", false, pageList.contains(15));
    }

    @Test
    public void testToString_Empty(){
        assertEquals("ToString on emply list", "{}", pageList.toString());
    }

    @Test
    public void testToString_half(){
        pageList.insert(1);
        pageList.insert(2);
        assertEquals("ToString on list that is half full", "{1,2}", pageList.toString());
    }

    @Test
    public void testToString_full(){
        pageList.insert(1);
        pageList.insert(2);
        pageList.insert(3);
        pageList.insert(4);
        assertEquals("ToString on full list", "{1,2,3,4}", pageList.toString());
    }
}
