/**
 * 链表练习
 * Created by WangJun on 2016/4/7.
 */
public class Exercise1_3_Link {

    public static void main(String[] args) {
        Node node4 = new Node(5, null);
        Node node3 = new Node(3, node4);
        Node node33 = new Node(3, node3);
        Node node2 = new Node(9, node33);
        Node node = new Node(1, node2);
//        printLink(node);
//        node = remove(node, 1);
//        printLink(node);
        System.out.println(max_digui(node));
    }

    private static class Node {

        public Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }

        Integer item;
        Node next;
    }

    static void printLink(Node node) {
        System.out.println();
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }

    }

    /**
     * 1.3.26
     * 删除链表中所有item域为key的结点
     *
     * @param first
     * @param key
     * @return node 必须要返回链表的新的头结点，否则是无法实现删除头结点操作的
     */
    static Node remove(Node first, Integer key) {
        Node node = first;
        Node old = first;
        while (node != null) {
            if (node.item.equals(key)) {
                if (node == first) {
                    first = first.next;
                } else {
                    old.next = node.next;
                    node = node.next;
                }
            } else {
                old = node;
                node = node.next;
            }

        }
        return first;
    }


    /**
     * 1.3.27 返回链表中最大节点的值
     *
     * @param first
     * @return
     */
    static Integer max(Node first) {
        Integer max = 0;
        while (first != null) {
            if (first.item > max) {
                max = first.item;
            }
            first = first.next;

        }
        return max;
    }

    /**
     * 1.3.28 返回链表中最大节点的值，递归实现
     * @param first
     * @return
     */
    static Integer max_digui(Node first) {
        if (first.next == null) return first.item;
        int next = max_digui(first.next);
        return first.item > next ? first.item : next;
    }

    /**
     * 1.3.30  将链表反转并返回结果链表的首节点
     * 使用迭代和递归两种方式
     * TODO 链表练习 将链表反转并返回结果链表的首节点
     * @param first
     * @return
     */
    static Node reverse(Node first){
        return null;
    }


}
