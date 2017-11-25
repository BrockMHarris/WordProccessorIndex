package proj5;

/**
 * This is a class that holds a word and a pageList object. This is meant to be put into the index BST.
 * @param <E> WordPages must be comaprable and can only be compared to things of its own type
 */
public class WordPages<E> implements Comparable<E>
{
    private PageList pages;
    private String word;

    /**
     *  contructor sets the word to desired word and pages to an empty pageList object
     * @param newWord the word that is to be held
     */
    public WordPages(String newWord){
        word = newWord;
        pages = new PageList();
    }

    /**
     * @return returns the word that is being held word
     */
    public String getWord() {
        return word;
    }

    /**
     * checks if the page is already in the page list
     * @param i page that needs to be checked
     * @return true if the page is already there, false otherwise
     */
    public boolean contain(int i){
        return pages.contains(i);
    }

    /**
     * checks if the page list is full of pages
     * @return true if it is full false otherwise
     */
    public boolean isFull(){
        return pages.isFull();
    }

    /**
     * inserts a page number into the page list
     * @param pageNumber page number to be inserted
     */
    public void insert(int pageNumber){
        pages.insert(pageNumber);
    }

    /**
     * compares two word pages objects by comparing the words they hold
     * @param o wordPages object to be compared
     * @return -1 if this word is larger in ascii 0 if they are the same, 1 if the other is larger
     */
    @Override
    public int compareTo(E o) {
        WordPages otherWord = (WordPages) o;
        return word.compareTo(otherWord.getWord());
    }

    /**
     * @return a string representation of the object: "word {0,2,4}"
     */
    @Override
    public String toString() {
        return word + " " + pages.toString();
    }
}
