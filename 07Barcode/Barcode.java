import java.util.*;
public class Barcode implements Comparable<Barcode>{
    String zip;
    public Barcode(String zipCode){
        if(zipCode.length() != 5){
            throw new IllegalArgumentException();
        }
        
        int foo = Integer.parseInt(zipCode);
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
    private int getCSum(){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            sum += zip.charAt(i) - 30;
        }
        return sum % 10;
    }
    public String getCode(){
        String code = "|";
        for(int i = 0; i < 5; i++){
            code += getChar(zip.charAt(i) - 30); 
        }
        return code + getChar(this.getCSum()) + '|';
    }
    
    public int compareTo(Barcode other){
        return zip.compareTo(other.getZip());
    }
    
    public boolean equals(Barcode other){
        return zip.equals(other.getZip());
    }
    
    public String toString(){
        return zip + '[' + this.getCode() + ']';
    }
    
    
}