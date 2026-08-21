class Solution {
    public boolean isPalindrome(int x) {
        String s=String.valueOf(x);
        int l=0,r=s.length()-1;
        for(;l<r;l++,r--){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            
        }
        return true;

    }
}