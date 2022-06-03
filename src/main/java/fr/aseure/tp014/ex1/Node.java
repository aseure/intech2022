package fr.aseure.tp014.ex1;

public class Node<T> {
    final T value;
    Node<T> next;

    Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
