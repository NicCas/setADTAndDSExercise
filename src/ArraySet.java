public class ArraySet <T> implements SetInterface <T>  {

    public static final int minSize = 50;
    public static final int maxSize = 10000;
    private T[] workingArray = (T[]) new Object[minSize];
    private int qtyOfItems = 0;
    private int actualArraySize = minSize;

    /** Gets the current number of entries in this set.
     * @return  The integer number of entries currently in the set.
     */
    public int getCurrentSize() {
        return qtyOfItems;
    }

    /** Sees whether this set is empty.
     * @return  True if the set is empty, or false if not.
     */
    public boolean isEmpty() {
        if (qtyOfItems == 0) {
            return true;
        }

        return false;
    }

    /** Adds a new entry to this set, avoiding duplicates.
     * @param newEntry  The object to be added as a new entry.
     * @return  True if the addition is successful, or
     * false if the item already is in the set.
     */
    public boolean add(T newEntry) {
        // Checking to make sure the array is not full
        // If it is then resize before adding
        if (qtyOfItems == actualArraySize) {
            resizeStorage();
        }

        // Checking to make sure the array has not reached the max size
        if (qtyOfItems == maxSize) {
            return false;
        }

        // Checking that there are not any duplicates
        for (int i = 0; i < qtyOfItems; i++) {
            if (newEntry.equals(workingArray[i])) {
                return false;
            }
        }

        // Adding newEntry
        workingArray [qtyOfItems] = newEntry;
        qtyOfItems ++;

        return true;
    }

    /** If array is full then doubles the size
     * Continues to double as needed until array equals maxSize
     */
    private void resizeStorage() {
        // Store the current contents of the array
        T[] tempArray = workingArray;

        // Double the array size, or set to maxSize
        actualArraySize *= 2;
        actualArraySize = Math.min(actualArraySize, maxSize);

        // Set array to a new empty array that is either maxSize or double previous size
        workingArray = (T[]) new Object[actualArraySize];

        // Copy data from the original array into the new larger array starting at array[0]
        System.arraycopy(tempArray, 0, workingArray, 0, qtyOfItems);

    }

    /** Removes a specific entry from this set, if possible.
     @param anEntry  The entry to be removed.
     @return  True if the removal was successful, or false if not. */
    public boolean remove(T anEntry) {
        // Check that the array is not empty
        if (qtyOfItems == 0) {
            return  false;
        }

        // Check for entry in the array
        for (int i = 0; i < qtyOfItems; i++)
        {
            if (anEntry.equals(workingArray[i]))
            {
                // Remove the specified entry by replacing it with the
                // entry at the end of the list
                workingArray[i] = workingArray[qtyOfItems - 1];
                workingArray[qtyOfItems - 1] = null;
                qtyOfItems--;
                return true;
            }
        }

        return false;
    }

    /** Removes one unspecified entry from this set, if possible.
     @return  Either the removed entry, if the removal
     was successful, or null. */
    public T remove() {
        // Check that the array is not empty
        if (qtyOfItems == 0) {
            return  null;
        }

        // Remove the last item from the array
        T itemRemoved = workingArray [qtyOfItems - 1];
        workingArray [qtyOfItems - 1] = null;
        qtyOfItems --;

        return itemRemoved;
    }

    /** Removes all entries from this set. */
    public void clear() {
        for (int i = 0; i < qtyOfItems; i++) {
            workingArray[i] = null;
            qtyOfItems = 0;
        }
    }

    /** Tests whether this set contains a given entry.
     @param anEntry  The entry to locate.
     @return  True if the set contains anEntry, or false if not. */
    public boolean contains(T anEntry) {
        // Check that the array is not empty
        if (qtyOfItems == 0) {
            return  false;
        }

        // Check for entry in the array
        for (int i = 0; i < qtyOfItems; i++)
        {
            if (anEntry.equals(workingArray[i]))
            {
                return true;
            }
        }

        return false;
    }

    /** Retrieves all entries that are in this set.
     @return  A newly allocated array of all the entries in the set. */
    public T[] toArray() {

        T[] completedArray = (T[]) new Object[qtyOfItems];

        // Starting at workingArray[0], copy up to workingArray [qtyOdItems] into the new smaller array
        System.arraycopy(workingArray, 0, completedArray, 0, qtyOfItems);

        return completedArray;
    }
}
