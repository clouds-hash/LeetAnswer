public class Leet3304 {
    public static void main(String[] args) {
        System.out.println(new Solution3304().kthCharacter(3));
    }
}

class Solution3304 {
    public char kthCharacter(int k) {
        if(k==1) return 'a';
        int len=1;
        while(len*2<k){
            len*=2;
        }
        //k一定在后半段，对应前半段的字符+1
        char prev =kthCharacter(k-len);
        return prev=='z'?'a':(char)(prev+1);


        

    }
}
