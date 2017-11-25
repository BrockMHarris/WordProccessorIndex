package proj5;

/**
 * This is a page list object. it holds an array of page lists or ints
 */
public class PageList{

    private int count;
    private int capacity;

    private int[] itemArray;

    /**
     * constructor, sets number of items to 0 the size of the list to 4 and the list of pages to an empty array
     */
    public PageList(){
        count = 0;
        capacity = 4;
        itemArray = new int[capacity];
    }

    /**
     * @return number of items being held by the page list
     */
    public int size(){
        return count;
    }

    /**
     * @return true if the number if items held is 4, otherwise false
     */
    public boolean isFull(){
        return count == capacity;
    }

    /**
     * inserts a page into the list
     * @param newItem (int) page you want held
     */
    public void insert(int newItem){
        itemArray[count] = newItem;
        count++;
    }

    /**
     * checks if the page is already in the page list
     * @param elem page to check
     * @return true if it is, false if not
     */
    public boolean contains(int elem){
        return itemArray[count-1] == elem;
    }

    /**
     * string representation of pageList object
     * @return format: {1,2,4-5}
     */
    @Override
    public String toString() {
        String toReturn = "{";
        int size = size();
        for(int i = 0; i<size; i++){
            int first = i;
            while(i+1 <= 3 && itemArray[i]+1 == itemArray[i+1]){
                i++;
            }
            if(i == first){
                if(i<size-1){
                    toReturn += itemArray[i] + ",";
                }
                else {
                    toReturn += itemArray[i] + "}";
                }
            }
            else {
                if(i<size-1){
                    toReturn += itemArray[first] + "-" + itemArray[i] + ",";
                }
                else {
                    toReturn += itemArray[first] + "-" + itemArray[i] + "}";
                }
            }
        }
        if(size<1) {
        toReturn+="}";
        }
        return toReturn;
    }
}
