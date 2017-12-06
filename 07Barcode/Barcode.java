import java.util.*;
public class Barcode implements Comparable<Barcode>{
    String zip;
    public Barcode(String zipCode){
        if(zipCode.length() != 5){
            throw new IllegalArgumentException();
        }
        
        try {
            int foo = Integer.parseInt(zipCode);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        zip = zipCode;
    }
    public String getZip(){
        return zip;
    }
    private static String getChar(int dig){
        String[] chars = {"||:::",
                          ":::||",
                          "::|:|",
                          "::||:",
                          ":|::|",
                          ":|:|:",
                          ":||::",
                          "|:::|",
                          "|::|:",
                          "|:|::",
                          };
        return chars[dig];
    }
    private static int getCSum(String zip){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += zip.charAt(i) - 48;
        }
        return sum % 10;
    }
    public String getCode(){
        return toCode(zip);
    }
    public static String toCode(String zip){
        if(zip.length() != 5){
            throw new IllegalArgumentException();
        }
        
        try {
            int foo = Integer.parseInt(zip);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
        
        String code = "|";
        for(int i = 0; i < 5; i++){
            //System.out.println(code);
            code += getChar(zip.charAt(i) - 48); 
        }
        return code + getChar(getCSum(zip)) + '|';
    }
    
    public static String toZip(String code){
        ArrayList<String> chars = new ArrayList<String>();
        chars.add("||:::");
        chars.add(":::||");
        chars.add("::|:|");
        chars.add("::||:");
        chars.add(":|::|");
        chars.add(":|:|:");
        chars.add(":||::");
        chars.add("|:::|");
        chars.add("|::|:");
        chars.add("|:|::");                  
        if (code.length() != 32 ||
            code.charAt(0) != '|' ||
            code.charAt(31) != '|'){
                throw new IllegalArgumentException();
            }
        String numbers = "";
        String accumulated = "";
        code = code.substring(1,31);
        for(int i = 0; i < code.length(); i++){
            accumulated += code.charAt(i);
            if (code.charAt(i) != '|' &&
                code.charAt(i) != ':'){
                    throw new IllegalArgumentException();
                }
            if (accumulated.length() == 5){
                numbers += chars.indexOf(accumulated);
                accumulated = "";
            }
        }
        int sum = 0;
        for(int i = 0; i < numbers.length(); i++){
            sum = numbers.charAt(i) - 48;
        }
        if (numbers.charAt(5) - 48 != sum % 10){
            throw new IllegalArgumentException();
        }
        return numbers.substring(0,5);
        
    }
    
    public int compareTo(Barcode other){
        return Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip());
    }
    
    public boolean equals(Barcode other){
        return zip.equals(other.getZip());
    }
    
    public String toString(){
        return this.getCode() + '(' + zip + ')';
    }
    
    public static void main(String[] args){
        Barcode a = new Barcode("92010");
        Barcode b = new Barcode("92010");
        System.out.println(getChar(9));
        System.out.println(a.compareTo(b));
        System.out.println(a);
        System.out.println(a.equals(b));
        //System.out.println(toZip("|::::::::::||:::::::|||:::::|:||"));
        
        
        
        //Barcode e = new Barcode("12sa1"); //Should throw an error, sa not valid nums
        //Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
        //Barcode.toCode("131"); //Should throw an error, too little nums
        //Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
        //Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
        //Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
        //Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
        //Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found
        
         Barcode stuy = new Barcode("10282");
        Barcode btech = new Barcode("11217");
        Barcode stech = new Barcode("10306");

        Barcode[] listOfBarcodes = {stuy, btech, stech};

        for (int i = 0; i < listOfBarcodes.length; i++){
            Barcode current = listOfBarcodes[i];
            System.out.println(current + "\ntoZip result: "
                         + Barcode.toZip(current.getCode())
                         +"\nCorrect? "
                         + Barcode.toZip(current.getCode()).equals(current.getZip())
                         );
    }
}
}