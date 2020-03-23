package LinkedList;

/**
 * @author jianw.li
 * @date 2019/9/30 6:29 PM
 * @Description: TODO
 */
public class Test1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode iteNode = new ListNode(0);
        iteNode.next = head;
        ListNode resNode = iteNode;
        while(iteNode != null && iteNode.next != null){
            ListNode pre = iteNode;
            ListNode start = iteNode.next;
            ListNode end = iteNode.next.next;
            if(end != null && start.val == end.val){
                while(end != null){
                    //寻找相同节点
                    if(end.next != null && end.val == end.next.val){
                        end = end.next;
                    }else{
                        //清除相同节点
                        pre.next = end.next;
                        //start = end.next;
                        //end = end.next.next;
                        break;
                    }
                }
            }else{
                iteNode = iteNode.next;
            }

            /*else{
                pre = start;
                start = end;
                end = end.next;
            }*/
        }

        return resNode.next;
    }

    public static void main(String[] args) {
        /*ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next = new ListNode(4);
        listNode.next.next.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next.next.next = null;*/

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = null;

        ListNode resultList = deleteDuplicates(listNode);
        System.out.println(resultList);
    }
}
