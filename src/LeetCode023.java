public class LeetCode023 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length -1);
    }

    private ListNode sort(ListNode[] lists, int start, int end){
        if(start>=end) return lists[start];
        int mid = (end - start) /2 + start;
        ListNode l1 = sort(lists, start, mid);
        ListNode l2 = sort(lists, mid + 1, end);
        return merge(l1,l2);
    }

    private ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
