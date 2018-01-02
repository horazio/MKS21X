public class ReversedCharSequence implements CharSequence{
    String data;
    public ReversedCharSequence(String seq){
        data = reverse(seq);
    }
    public ReversedCharSequence(ReversedCharSequence a){
        data = reverse(a.toString());
    }
    public static String reverse(String word){
        String reversed = "";
        for(int i = 0; i < word.length(); i++){
            reversed = word.charAt(i) + reversed;
        }
        return reversed;
    }

    public char charAt(int index){
        return data.charAt(index);
    }

    public int length(){        
        return data.length();
    }
    
    public ReversedCharSequence subSequence(int start, int end){
        String ans = data.substring(start, end);
        ReversedCharSequence a = new ReversedCharSequence(reverse(ans));
        return a;
    }
    
    public String toString(){
        return data;
    }
    public static void main(String[] args){
        
    }
}
