package facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Kodeskelet til VOP eksamen F15, opgave 2.
 * @author erso
 */
public class Facade {
    private int[] intArray;
    private Random random;

    public Facade() {
        this.random = new Random();
    }

    public int[] getIntArray() {
        return intArray;
    }

    public int[] fillArray(int size, int max) {
        intArray = new int[size];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(max);
        }
        return intArray;
    }

    public int sumOfDivisors(int divisor) {
        int sum = 0;
        for (int number: intArray) {
            if (number % divisor == 0) {
                sum += number;
            }
        }
        return sum;
    }

    public int[] fillUniqueArray(int size, int max) {
        if (size >= max) {
            System.out.println("max number needs to be larger than size!!!");
            return null;
        }

        intArray = new int[size];
        for (int i = 0; i < size; i++) {
            int number = random.nextInt(max);
            while (contains(number, i - 1)) {
                number = random.nextInt(max);
            }
            intArray[i] = number;
        }
        Arrays.sort(intArray);
        return intArray;
    }

    private boolean contains(int x, int index) {
        for (int i = 0; i < index; i++) {
            if (intArray[i] == x) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Facade facade = new Facade();

        System.out.println("fillArray: " + Arrays.toString(facade.fillArray(20, 10)));
        int divisor = 3;
        System.out.println("Divisors of " + divisor + " has Sum: " + facade.sumOfDivisors(divisor));

        System.out.println("fillUnique: " + Arrays.toString(facade.fillUniqueArray(20, 30)));

        System.out.println("Error: " + Arrays.toString(facade.fillUniqueArray(20, 20)));

    }
}
