package LinkedList;

import java.util.HashMap;

/**
 * @author jianw.li
 * @date 2019/9/22 5:18 PM
 * @Description: TODO
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode curNode) {
        ListNode preNode = null;
        ListNode nextNode = null;
        while (curNode != null) {
            nextNode = curNode.next; //赋值下一节点
            curNode.next = preNode; //转置
            preNode = curNode; //当前节点设置问前置节点
            curNode = nextNode; //下一节点成为当前节点
        }
        return curNode;
    }

    public static ListNode reverse1(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode temp = head.next;//保存下一个节点
        ListNode newHead = reverse1(head.next);//整体思维，宏观语义
        temp.next = head;//连上头与递归部分
        head.next = null;//调整尾部
        return newHead;//返回头节点
    }

    //1->2->3->4->null   4->3->2->1
    public static ListNode reverseList2(ListNode head) {
        if(head.next == null || head == null){
            return head;
        }
        //记录当前节点与下一节点
        ListNode next = head.next;
        //cur 与 next只向内存地址相同，next会随着递归而改变，但是cur不会，是一种技巧
        ListNode cur = reverseList2(head.next);
        //调换位置
        next.next = head;
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = null;
        ListNode curNode = listNode;

        ListNode resultList = reverseList2(curNode);
        System.out.println(resultList);
    }

}
