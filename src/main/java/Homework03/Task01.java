package Homework03;

import java.util.Iterator;

public class Task01 {
    public static class ListNode implements Iterable<Integer> {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public Iterator<Integer> iterator() {
            ListNode node = this;
            return new ListNodeIterator(node);

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[ ");
            sb.append(this.val);
            if (this.next != null) {
                for (Integer value : this.next) {
                    sb.append(" -> ").append(value);
                }
            }
            sb.append(" ]");
            return sb.toString();
        }

        private static class ListNodeIterator implements Iterator<Integer> {
            private ListNode node;

            public ListNodeIterator(ListNode node) {
                this.node = node;
            }

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Integer next() {
                int toReturn = node.val;
                node = node.next;
                return toReturn;
            }

        }

        public static class ListNodeUtils {

            public static ListNode addFirst(ListNode node, int value) {
                return new ListNode(value, node);
            }

            public static ListNode removeFirst(ListNode node) {
                if (node == null)
                    return null;
                return node.next;
            }

            public static ListNode revertList(ListNode node) {
                if (node == null)
                    return null;
                return revertList(node, null);
            }

            private static ListNode revertList(ListNode node, ListNode prev) {
                if (node.next != null) {
                    ListNode next = node.next;
                    node.next = prev;
                    return revertList(next, node);
                }
                node.next = prev;
                return node;
            }
        }

        public static void main(String[] args) {
            ListNode list = new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(7, new ListNode(8)))));
            System.out.println(list);
            System.out.println(list.next);
            list = ListNodeUtils.addFirst(list, 4);
            System.out.println(list);
            list = ListNodeUtils.removeFirst(list);
            System.out.println(list);
            list = ListNodeUtils.revertList(list);
            System.out.println(list);
        }
    }
}

