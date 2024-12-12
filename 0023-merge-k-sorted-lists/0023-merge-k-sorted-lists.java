/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        if(list1 != null){
            tail.next = list1;
        }
        if(list2 != null){
            tail.next = list2;
        }
        return dummyNode.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        while(lists.length > 1){
            List<ListNode> list = new ArrayList<ListNode>();
            for(int i = 0; i < lists.length; i = i + 2){
                ListNode list1 = lists[i];
                ListNode list2 = null;
                if(i + 1 < lists.length){
                    list2 = lists[i + 1];
                }
                list.add(mergeTwoLists(list1, list2));
            }
            ListNode[] arr = new ListNode[list.size()];
            arr = list.toArray(arr);
            lists = arr;
        }
        return lists[0];
    }
}