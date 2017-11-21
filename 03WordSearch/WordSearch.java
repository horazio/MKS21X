import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
    private char[][] data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;
    private int seed;
    
    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    
    public WordSearch( int rows, int cols, String fileName){
        data = newOne(rows, cols);
        seed = (int) (10000 * Math.random());
        randgen = new Random(seed);
        wordsToAdd = readFile(fileName);
        wordsAdded = new ArrayList<String>();
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed){
        this(rows, cols, fileName);
        seed = randSeed;
        randgen = new Random(seed);
        
    }
    
    private ArrayList readFile(String fileName){
        ArrayList<String> ans = new ArrayList<String>();
        try{
            File f = new File(fileName);
            Scanner reader = new Scanner(f);
            while(reader.hasNext()){
                ans.add((reader.nextLine()).toLowerCase());
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found: " + fileName);
            //e.printStackTrace();
            System.out.println("Please give a file that exists in this directory.");
            System.exit(1);
    }
        return ans;
    }
    
    
    
    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
        data = newOne(data.length, data[0].length);
    }
    
    private static char[][] newOne(int a, int b){
        if(a < 1 || b < 1){
            System.out.println("Please use positive integer values for size");
            System.exit(1);
        }
        try{
            char[][] ans = new char[a][b];
            for(int pos = 0; pos < a; pos++){
                for(int pos2 = 0; pos2 < b; pos2++){
                    ans[pos][pos2] = ' ';
            }
        }
        return ans;
        }catch(IllegalArgumentException e){
            System.out.println("Please use positive integer values for size");
            System.exit(1);
        }
        return new char[1][1];
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
        String ans = ""; 
        for(int pos = 0; pos < data.length; pos++){
            for(int pos2 = 0; pos2 < data[0].length; pos2++){
                ans +=  " " + data[pos][pos2];
            }
            ans += '\n';
        }
        return ans;
    }
    
    public String makePuzzle(){
        String ans = ""; 
        for(int pos = 0; pos < data.length; pos++){
            for(int pos2 = 0; pos2 < data[0].length; pos2++){
                ans +=  " ";
                if (data[pos][pos2] != ' '){
                    ans += data[pos][pos2];
                }
                else{
                    ans += (char) (randgen.nextInt(26) + 97);
                }    
            }
            ans += '\n';
        }
        return ans + "\n \n The seed is: " + seed + "\n \n";  
    }

    public String key(){
        String ans = "";
        for(int pos = 0; pos < wordsAdded.size(); pos++){
            if((pos % 3) == 0){
                ans += "\n";
            }
            ans += ' ' + wordsAdded.get(pos);
        }
        return ans + "\n \n";
    }
    
    
    
    private boolean add(String word, int row, int col, int rDir, int cDir){
        boolean added = doesFit(word, row, col, rDir, cDir);
        if (added){
            for (int pos = 0; pos < word.length(); pos++){
                data[row + pos * rDir][col + pos * cDir] = word.charAt(pos);
            }
        }
        return  added;
    }
    
    
    private boolean doesFit(String word, int row, int col, int rDir, int cDir){ 
        if(rDir == 0 && cDir == 0){
            return false;
        }
        try{
            for (int pos = 0; pos < word.length(); pos++){
                 if (data[row + pos * rDir][col + pos * cDir] != ' '){
                     return false;
                 }
            }     
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return true;
    }
    private boolean addAllWords(){
        int count = 1000;
        while(count > 0 && wordsToAdd.size() > 0){
            count--;
            String word = wordsToAdd.get(randgen.nextInt(wordsToAdd.size()));
            boolean added = this.add(word, 
                                     randgen.nextInt(data.length), 
                                     randgen.nextInt(data[0].length),
                                     randgen.nextInt(3) - 1,
                                     randgen.nextInt(3) - 1);
            if(added){
                wordsToAdd.remove(word);
                wordsAdded.add(word);
            }
        }
        return wordsToAdd.size() == 0;
    }
    
    public static void main(String[] args){
        String error = "Hello, Im afraid you need to provide something better than that.\n " +
                        "We need a size for the word search, and a valid text file. \n" +
                        "If you desire we will accept a random seed, and we will display the answers as well if your final argument after seed is: key. \n" +
                        "The final format of your input should be: \n" +
                        "java WordSearch rows columns filename [seed [key]]";
        if(args.length < 3 || args.length > 5){
            System.out.println(error);
            System.exit(1);
        }
        if(args.length == 3){
            try{
                WordSearch it = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2]);
                it.addAllWords();
                System.out.println(it.makePuzzle());
                System.out.println(it.key());
            }catch(NumberFormatException e){
                System.out.println("Please give counting numbers as the first two arguments, they represent the size of the array");
                System.exit(1);
            }
        }
        else{
            try{
                WordSearch it = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
                it.addAllWords();
                System.out.println(it.makePuzzle());
                System.out.println(it.key());
                if(args.length == 5 && args[4].equals("key")){
                    System.out.println(it);  
                }
            }catch(NumberFormatException e){
                System.out.println("Please give counting numbers as the first two and fourth arguments, they represent the size of the array, and the seed respectively");
                System.exit(1);
            }
        }
        
        
    }
}