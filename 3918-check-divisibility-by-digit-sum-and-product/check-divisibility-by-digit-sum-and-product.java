class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int original =n;
        int product=1;
        while(n>0){
            int temp=n%10;
            sum=sum+temp;
            product=product*temp;
            n=n/10;
        }
        if(original%(sum+product)==0){
            return true;
        }
        else{
            return false;
        }
        
    }
}