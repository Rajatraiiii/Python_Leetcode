class Solution {
    public int mirrorDistance(int n) {
        int original=n,reverse=0,lastdigit;
        while(n>0){
            lastdigit=n%10;
            reverse=reverse*10+lastdigit;
            n=n/10;
            
        }
        
        int diff=Math.abs(original-reverse);
        return diff;
        
    }
}