package proj5;

/**
 * Driver for the index maker project
 *
 * @author Brock Harris
 * @version 11/8/17
 */
public class Client
{
    public static void main(String[] args)
    {
    	makeIndex("smallFile.txt"); //replace with correct path
    }

    /**
     * Makes an index out of fileName. Gradescope needs this function.
     *
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
    	FileReader fileReader = new FileReader(fileName);

    	String token;
        boolean done = false;
        BinarySearchTree<String> dictionary = new BinarySearchTree<String>();
        BinarySearchTree index = new BinarySearchTree();
        int pageNumber = 1;


    	while (!done){
    	    token = fileReader.nextToken();
    	    if(token == null){ //|| token.contains("EOF")){
    	        done = true;
            }
    	    else if(token.contains("#")){
    	        pageNumber++;
            }
    	    else if(token.length()>2 && dictionary.find(token) == null){
    	        //token =token.toLowerCase();
    	        WordPages tokenList = (WordPages) index.find(new WordPages(token));
    	        if(tokenList != null){
    	            if(!tokenList.contain(pageNumber)){
                        if(!tokenList.isFull()){
                            tokenList.insert(pageNumber);
                        }
                        else {
                            System.out.println("Deleting '" + tokenList + "' from index");
                            dictionary.insert(tokenList.getWord());
                            index.delete(tokenList);
                        }
                    }
                }
                else {
    	            WordPages newWord = new WordPages(token);
    	            newWord.insert(pageNumber);
    	            index.insert(newWord);
                }
            }
        }
        printable(index);
        //System.out.println(dictionary);
    }

    /**
     * Takes the print out from a bst and prints out a string that is in the format required for gradescope
     * @param bst The bst that needs to be printed
     */
    public static void printable(BinarySearchTree bst){
        String toReturn  = bst.toString();
        toReturn = toReturn.replaceAll(" ", "");
        toReturn = toReturn.replaceAll("\\(", "\n");
        toReturn = toReturn.replaceAll("\\)", "\n");
        for(int i = 0; i<toReturn.length()-1; i++){
            if(toReturn.charAt(i) == '\n' && toReturn.charAt(i + 1) == '\n'){
                toReturn = toReturn.substring(0,i) + toReturn.substring(i+1,toReturn.length());
                i--;
            }
        }
        System.out.println(toReturn);

    }
}
