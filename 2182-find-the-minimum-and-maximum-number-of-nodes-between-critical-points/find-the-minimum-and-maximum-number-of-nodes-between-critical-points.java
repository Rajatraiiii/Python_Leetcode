class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        int index = 1;
        int first = -1;
        int last = -1;
        int minDistance = Integer.MAX_VALUE;
        
        while (curr != null && curr.next != null) {
            
            int prevVal = prev.val;
            int currVal = curr.val;
            int nextVal = curr.next.val;
            
            // Check if current node is a critical point
            if ((currVal > prevVal && currVal > nextVal) ||
                (currVal < prevVal && currVal < nextVal)) {
                
                if (first == -1) {
                    first = index;
                } else {
                    minDistance = Math.min(minDistance, index - last);
                }
                
                last = index;
            }
            
            prev = curr;
            curr = curr.next;
            index++;
        }
        
        // Less than 2 critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }
        
        int maxDistance = last - first;
        
        return new int[]{minDistance, maxDistance};
    }
}