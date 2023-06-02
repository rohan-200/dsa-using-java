public class TowersOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n-1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + n + " from " + fromRod + " to " + toRod);
        towerOfHanoi(n-1, auxRod, toRod, fromRod);
    }

}
