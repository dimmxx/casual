package com.example.tree;

import java.util.Comparator;

public class CustomBinaryTree<T> {

    private final Comparator<T> comparator;
    private Node<T> root;

    public CustomBinaryTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    private void traverseAndAddRecursively(Node<T> node, T element) {
        if (comparator.compare(element, node.getValue()) < 0) {
            if (node.getLeft() != null) {
                traverseAndAddRecursively(node.getLeft(), element);
            } else {
                node.setLeft(new Node<>(element));
            }
        } else if (comparator.compare(element, node.getValue()) >= 0) {
            if (node.getRight() != null) {
                traverseAndAddRecursively(node.getRight(), element);
            } else {
                node.setRight(new Node<>(element));
            }
        }
    }


    public T put(T element) {
        if (root != null) {
            traverseAndAddRecursively(root, element);
        } else {
            root = new Node<>(element);
        }
        return element;


    }


    static class Node<T> {

        private Node<T> left;
        private Node<T> right;
        private T value;

        public Node(T value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }


}
