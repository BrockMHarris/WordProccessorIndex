import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import proj5.BinarySearchTree;
import proj5.WordPages;

/**
 *
 * This class tests the stack class to make sure that it works completely as intended
 *
 * @author Brock Harris
 * @version 10/22/17
 *
 */
public class testWordPages {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private WordPages wordPage;

    @Before
    public void setUp() throws Exception {
        wordPage = new WordPages("word");
    }

    @After
    public void tearDown() throws Exception {
        wordPage = null;
    }


    @Test
    public void testConstructor_word(){
        wordPage = new WordPages("hello");
        assertEquals("Test that the constructor holds the word", "hello", wordPage.getWord());
    }

    @Test
    public void testConstructor_pageList(){
        wordPage = new WordPages("hello");
        assertEquals("Test that the constructor holds the pageList", false, wordPage.isFull());
    }

    @Test
    public void testContains_does_contain(){
        wordPage.insert(5);
        assertEquals("elem is in the list", true, wordPage.contain(5));
    }

    @Test
    public void testContains_doesnt_contain(){
        wordPage.insert(5);
        assertEquals("elem is in the list", false, wordPage.contain(4));
    }

    @Test
    public void testContains_emptyList(){
        assertEquals("test that an empty list does not contain an element", false, wordPage.contain(1));
    }

    @Test
    public void testIsFull_Empty(){
        assertEquals("no elements in the list", false, wordPage.isFull());
    }

    @Test
    public void testIsFull_notFull(){
        wordPage.insert(5);
        wordPage.insert(4);
        assertEquals("2 of the 4 possible elements in the list", false, wordPage.isFull());
    }

    @Test
    public void testIsFull_full(){
        wordPage.insert(1);
        wordPage.insert(2);
        wordPage.insert(3);
        wordPage.insert(4);

        assertEquals("full list of 4 elements", true, wordPage.isFull());
    }

    @Test
    public void testCompareTo_larger(){
        WordPages SecondWord = new WordPages("word1");
        assertEquals("compare original to larger word", -1, wordPage.compareTo(SecondWord));
    }

    @Test
    public void testCompareTo_Same(){
        WordPages SecondWord = new WordPages("word");
        assertEquals("compare original to same word", 0, wordPage.compareTo(SecondWord));
    }

    @Test
    public void testCompareTo_smaller(){
        WordPages SecondWord = new WordPages("wor");
        assertEquals("compare original to smaller word", 1, wordPage.compareTo(SecondWord));
    }

    @Test
    public void testToString_empty(){
        assertEquals("toString of an empty word", "word {}", wordPage.toString());
    }

    @Test
    public void testToString_elements(){
        wordPage.insert(1);
        wordPage.insert(2);
        assertEquals("toString of an word with some page numbers", "word {1,2}", wordPage.toString());
    }

    @Test
    public void testToString_full(){
        wordPage.insert(1);
        wordPage.insert(2);
        wordPage.insert(3);
        wordPage.insert(4);
        assertEquals("toString of an word with 4 numbers", "word {1,2,3,4}", wordPage.toString());
    }
}