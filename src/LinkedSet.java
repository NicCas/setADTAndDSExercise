public class LinkedSet <T> implements SetInterface <T> {

    private Node head = null;
    private int qtyOfItems;

    /** Gets the current number of entries in this set.
     @return  The integer number of entries currently in the set. */
    public int getCurrentSize() {
        return qtyOfItems;
    }

    /** Sees whether this set is empty.
     @return  True if the set is empty, or false if not. */
    public boolean isEmpty() {
        if (head == null)
        {
            return true;
        }

        return false;
    }

    /** Adds a new entry to this set, avoiding duplicates.
     @param newEntry  The object to be added as a new entry.
     @return  True if the addition is successful, or
     false if the item already is in the set. */
    public boolean add(T newEntry) {
        // Check for any duplicates
        Node search = head;
        while (search != null) {
            if (search.item.equals(newEntry)){
                return false;
            }
            search = search.next;
        }

        // Point new node.next to previous head and set head pointing to new node
        Node newStartingNode = new Node (newEntry, head);
        head = newStartingNode;
        qtyOfItems++;

        return true;
    }

    /** Removes a specific entry from this set, if possible.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry) {
        // Check that the array is not empty
        if (qtyOfItems == 0) {
            return false;
        }

        Node search = head;

        while (search != null) {
            if (search.item.equals(anEntry)){
                search.item = head.item;
                remove();
                return true;
            }
            search = search.next;
        }

        return false;
    }

    /** Removes one unspecified entry from this set, if possible.
     @return  Either the removed entry, if the removal
     was successful, or null. */
    public T remove() {
        // Check that the array is not empty
        if (qtyOfItems == 0) {
            return null;
        }

        T removedItem = head.item;
        head = head.next;
        qtyOfItems --;

        return removedItem;
    }

    /** Removes all entries from this set. */
    public void clear() {
        for (int i = 1; i <= qtyOfItems; i++) {
            remove(head.item);
        }
        head = null;
        qtyOfItems = 0;
    }

    /** Tests whether this set contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the set contains anEntry, or false if not. */
    public boolean contains(T anEntry) {
        Node search = head;

        while (search != null) {
            if (search.item.equals(anEntry)){
                return true;
            }
            search = search.next;
        }

        return false;
    }

    /** Retrieves all entries that are in this set.
     @return  A newly allocated array of all the entries in the set. */
    public T[] toArray() {
        T[] completedArray = (T[]) new Object[qtyOfItems];
        Node scrub = head;

        for (int i = 0; i < qtyOfItems; i++) {
            completedArray[i] = scrub.item;
            scrub = scrub.next;
        }

        return completedArray;
    }

    private class Node {
        T item;
        Node next;

        private Node() {
            this(null,null);
        }

        private Node(T item) {
            this(item,null);
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
