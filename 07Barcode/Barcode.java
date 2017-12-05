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
            System.out.println(code);
            code += getChar(zip.charAt(i) - 48); 
        }
        return code + getChar(getCSum(zip)) + '|';
    }
    
    //public static toZip(String code){
    //   if (code.length() != 32 ||
    //        code.charAt(0) != '|' ||
    //      code.charAt(31) != '|' ||
    //      )
    //}
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
    }
}