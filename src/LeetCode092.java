public class LeetCode092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = head;
        ListNode head2 = head;
        ListNode end = null;
        int i =1;
        while(head != null){
            if(i==n){
                end = head.next;
                head.next = null;
                break;
            }
            head = head.next;
            i++;
        }
        i =1;
        if(m == 1){
            head2 = reverse(head2);
            ListNode hh = head2;
            while(head2.next != null){
                head2 = head2.next;
            }
            head2.next = end;
            return hh;
        }else{
            while(head2 != null){
                if(i==m-1){
                    ListNode next = head2.next;
                    head2.next = reverse(head2.next);
                    next.next = end;
                }
                head2 = head2.next;
                i++;
            }
        }
        return start;
    }

    public ListNode reverse(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
