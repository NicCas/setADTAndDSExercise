import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SetInterface<Integer> link = new LinkedSet<>();

        link.add(1);
        link.add(2);
        link.add(3);

        System.out.println(link.contains(1));
        System.out.println(link.contains(0));

        link.clear();
        System.out.println(link.add(1));
        link.add(2);
        link.add(3);
        link.remove(2);

        Object [] testArray = link.toArray();
        System.out.println(Arrays.toString(testArray));
        /*
        SetInterface<Integer> set = new ArraySet<>();

        System.out.println("Check that size is 0: '" + set.getCurrentSize() + "' and that array is empty: " + set.isEmpty());

        for (int i = 0; i < 7; i++) {
            set.add(i);
        }

        System.out.println("Check the size: '" + set.getCurrentSize() + "' and that array is empty: " + set.isEmpty());

        System.out.println("Check if a duplicate can be added: " + set.add(0));

        set.remove();
        set.remove(5);
        System.out.println("Check if array contains an element: " + set.contains(0));

        set.clear();
        System.out.println("Check that size is 0: '" + set.getCurrentSize() + "' and that array is empty: " + set.isEmpty());
        System.out.println("Check if something could be removed: " + set.remove());
        //System.out.println("Check if array contains an element: " + set.contains(0));


        Object [] testArray = set.toArray();
        System.out.println(Arrays.toString(testArray));

         */

    }
}
