package LinkedList;

/**
 * @author jianw.li
 * @date 2019/10/1 10:58 PM
 * @Description: TODO
 */
public class LinkedListCycleII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode oneStepNode = head;
        ListNode twoStepNode = head;
        boolean flag = false;
        while(twoStepNode != null && twoStepNode.next != null){
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
            if(oneStepNode == twoStepNode){
                flag = true;
                break;
            }
        }

        //头结点到相交处距离相等
        if(flag){
            ListNode ps1 = head;
            ListNode ps2 = oneStepNode;
            while(oneStepNode != null && ps1 != null){
                if(ps1 == ps2){
                    return ps1;
                }
                ps1 = ps1.next;
                ps2 = ps2.next;
            }
        }

        return null;
    }
}
