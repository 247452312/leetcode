import java.util.List;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * <p>
 * <p>
 * 致谢:
 * 特别感谢 @stellari 添加此问题并创建所有测试用例。
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-29 15:31
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aLength = 0;
        int bLength = 0;

        while (a != null) {
            aLength++;
            a = a.next;
        }
        while (b != null) {
            bLength++;
            b = b.next;
        }

        int x = Math.abs(bLength - aLength);
        ListNode listNode = null;
        a = headA;
        b = headB;

        if (aLength > bLength) {
            for (int i = 0; i < x; i++) {
                a = a.next;
            }
        } else {
            for (int i = 0; i < x; i++) {
                b = b.next;
            }
        }

        while (a != null) {
            if (a.val == b.val && listNode == null) {
                listNode = a;
            } else if (a.val != b.val && listNode != null) {
                listNode = null;
            }
            a = a.next;
            b = b.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(5);
        listNode1.next.next.next.next = new ListNode(6);
        listNode1.next.next.next.next.next = new ListNode(4);
        listNode1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(1);
        listNode2.next.next = new ListNode(3);
        listNode2.next.next.next = new ListNode(5);
        listNode2.next.next.next.next = new ListNode(6);
        listNode2.next.next.next.next.next = new ListNode(4);
        listNode2.next.next.next.next.next.next = new ListNode(7);
        ListNode intersectionNode = new Solution().getIntersectionNode(listNode1, listNode2);
        while (intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }
}
