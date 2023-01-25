package Homework04;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Task01 {
//    Реализовать метод contains в классе Tree

    public static class Tree<T extends Comparable<T>> {

        private Node root;

        private class Node {
            private T value;
            private Node left;
            private Node right;

            public Node(T value) {
                this.value = value;
            }
        }

        public void add(T value) {
            Objects.requireNonNull(value);
            root = appendNode(root, value);
        }

        private Node appendNode(Node current, T value) {
            if (current == null) {
                return new Node(value);
            }

            int compare = value.compareTo(current.value);
            if (compare < 0) {
                current.left = appendNode(current.left, value);
            } else if (compare > 0) {
                current.right = appendNode(current.right, value);
            }

            return current;
        }

        public boolean contains(T value) {
            Objects.requireNonNull(value);
            return containsValue(root, value);
        }

        private boolean containsValue(Node currentRoot, T value) {
            if (currentRoot == null) return false;
            if (value.compareTo(currentRoot.value) == 0)
                return true;
            if (value.compareTo(currentRoot.value) < 0) {
                return containsValue(currentRoot.left, value);
            }
            return containsValue(currentRoot.right, value);
        }
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,7,8};
        Tree<Integer> tree = new Tree<Integer>();
        for (int n : num) {
            tree.add(n);
        }
        System.out.println(tree.contains(5));
    }
}


