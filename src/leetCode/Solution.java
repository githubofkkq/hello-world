package leetCode;


import javax.sound.midi.Soundbank;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        System.out.println();
        return String.valueOf(val);
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cursor = dummyHead;

        ListNode[] cursors = lists;
        while(!stop(cursors)){
            int minIndex = 0;
            int min = 0;
            int i;
            for(i = 0; i < cursors.length; i++){
                if(cursors[i] != null){
                    minIndex = i;
                    min = cursors[i].val;
                    break;
                }
            }
            for(int j = i; j < cursors.length; j++){
                if(cursors[j] != null){
                    if(cursors[j].val < min){
                        min = cursors[j].val;
                        minIndex = j;
                    }
                }
            }
            cursor.next= cursors[minIndex];
            cursor = cursor.next;
            cursors[minIndex] = cursors[minIndex].next;

        }
        cursor.next = null;
        return dummyHead.next;


    }

    public boolean stop(ListNode[] lists){
        boolean flag = true;
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        [[1,4,7],[2,5,8],[3,6]]

         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(4);
         ListNode l3 = new ListNode(7);
         l1.next = l2;
         l2.next = l3;

        ListNode w1 = new ListNode(2);
        ListNode w2 = new ListNode(5);
        ListNode w3 = new ListNode(8);
        w1.next = w2;
        w2.next = w3;
        ListNode s1 = new ListNode(3);
        ListNode s2 = new ListNode(6);
        s1.next = s2;

        ListNode[] lists = {l1, w1, s1};

        ListNode head = sol.mergeKLists(lists);
        ListNode cursor = head;
        while(cursor != null){
            System.out.println(cursor.val);
            cursor = cursor.next;

        }
    }
}

