public class ReversedCharSeq implements CharSequence{
    String data;
    public ReversedCharSeq(String seq){
	data = reverse(seq);
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
    
    public ReversedCharSeq subSequence(int start, int end){
        String ans = data.substring(start, end);
        ReversedCharSeq a = new ReversedCharSeq(reverse(ans));
        return a;
    }
    
    public String toString(){
        return data;
    }
    
}
