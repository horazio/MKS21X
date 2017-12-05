public class ReversedCharSeq implements CharSequence{
    String data;
    public ReversedCharSeq(String seq){
        data = reverse(seq);
    }
    public ReversedCharSeq(ReversedCharSeq a){
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
    
    public ReversedCharSeq subSequence(int start, int end){
        String ans = data.substring(start, end);
        ReversedCharSeq a = new ReversedCharSeq(reverse(ans));
        return a;
    }
    
    public String toString(){
        return data;
    }
    public static void main(String[] args){
        ReversedCharSeq a = new ReversedCharSeq("Hello");
        ReversedCharSeq b = new ReversedCharSeq(a);
    
        System.out.println(a);//olleH
        System.out.println(b);//Hello
        System.out.println(a.charAt(3));//e
        System.out.println(a.length());//5
        System.out.println(a.toString());//olleH
        System.out.println(a.subSequence(2,4));//le
        System.out.println(a.subSequence(0,3));//oll
        System.out.println(a);//olleH
       
    }
}
