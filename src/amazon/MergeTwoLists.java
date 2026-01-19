package amazon;

public class MergeTwoLists {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return head;
    }

    public static void main(String[] args) {
        // Example Usage:
        // Create two sorted linked lists:
        // l1: 1 -> 2 -> 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        // l2: 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        MergeTwoLists merger = new MergeTwoLists();
        ListNode mergedList = merger.mergeTwoLists(l1, l2);

        // Print the merged list: 1 -> 1 -> 2 -> 3 -> 4 -> 4
        System.out.print("Merged List: ");
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.println("null");

        // Another example: one list is null
        ListNode l3 = new ListNode(5);
        ListNode l4 = null;
        ListNode mergedList2 = merger.mergeTwoLists(l3, l4);
        System.out.print("Merged List 2: ");
        while (mergedList2 != null) {
            System.out.print(mergedList2.val + " -> ");
            mergedList2 = mergedList2.next;
        }
        System.out.println("null");
    }
}
