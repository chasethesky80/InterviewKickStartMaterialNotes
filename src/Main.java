public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        int x = 10;
        int[] arr = new int[]{ 1, 2, 4 };
        System.out.println(arr);
        int[] arr2 = arr;
        System.out.println(arr2);
        System.out.println(arr2[2]);
        arr[2] = 6;
        System.out.println(arr2[2]);
        System.out.println("N POWER K "+ computeNPowerK(3, 5));
    }

    private static Integer computeNPowerK(int n, int k) {
        if (k == 1) {
            return n;
        }
            return n * computeNPowerK(n, k-1);
        }
}