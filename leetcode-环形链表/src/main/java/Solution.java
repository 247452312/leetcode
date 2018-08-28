import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 *
 * @author 龙龙 E-mail: 247452312@qq.com
 * @version 1.0
 * @date 2018-08-28 10:38
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode ll = head;
        while (ll != null) {
            if (list.contains(ll)) {
                return true;
            }
            list.add(ll);
            ll = ll.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(3);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
//        listNode.next.next.next = listNode.next.next;
        boolean b = solution.hasCycle(listNode);
        System.out.println(b);
    }


    public boolean batter(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode pre = head;
        ListNode cur = head;

        while (pre != null && pre.next != null && pre.next.next != null) {
            cur = cur.next;
            pre = pre.next.next;
            if (pre == cur) {
                return true;
            }
        }
        return false;
    }
}
