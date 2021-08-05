package ru.rav.my_linked_list;

public class Main {

    public static void main(String[] args) {
        DoublyList list = new DoublyLinkedList();
        list.add("BMW");
        list.add("GAZ");
        list.add("Mercedes");
        list.add("Toyota");

        System.out.println(list);

        DoublyIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.print(next + " ");
        }
        System.out.println();

        DoublyIterator iterator2 = list.iterator();
        while (iterator2.hasPrevious()) {
            String prev = iterator2.previous();
            System.out.print(prev + " ");
        }
        System.out.println();

        System.out.println(list.get(2));

        System.out.println("Size before remove " + list.size());
        boolean isToyotaRemoved = list.remove("GAZ");
        System.out.println("Is GAZ removed? " + isToyotaRemoved);
        System.out.println("Size after remove " + list.size());

        System.out.println(list);

    }
}
