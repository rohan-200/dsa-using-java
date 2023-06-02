package arrays_pack;

import java.util.*;

public class DriverClass {
    public static void main(String[] args) {
        /**
         * quesion 1 and 2 driver
         */
        GenSort<Integer> integerGenSort = new GenSort<>();
        GenSearch<Integer> integerGenSearch = new GenSearch<>();

        Integer[] a = {5, 8, 9, 1, 3, 6, 1, 0, 3};
        Double[] b = {5.0, 6.9, 48.2, 487.3, 5.9, 2.1, 0.1, 1.0};
        Character[] c = {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        String[] s = {"aa", "Ab", "re", "ew", "r", "ldo"};
        List<Integer> la = new ArrayList<>(Arrays.asList(a));
        List<Double> ld = new ArrayList<>(Arrays.asList(b));
        List<Character> lc = new ArrayList<>(Arrays.asList(c));
        List<String> ls = new ArrayList<>(Arrays.asList(s));
        System.out.println(integerGenSort.bubbleSort(la));
        System.out.println(integerGenSearch.binarySearch(integerGenSort.selectionSort(la), 9));

        /**
         * question 3 driver
         */
        SecondMinMax<Character> characterSecondMinMax = new SecondMinMax<>();
        SecondMinMax<Integer> integerSecondMinMax = new SecondMinMax<>();
        Integer[] arr = {1,3, 7,5 , 9, 1, 5, 8};
//        Integer[] arr = {1,1,1,1,1,1,1,1,1,1}; //output if this array used {Second Minimum= Not Present, Second Largest= Not Present}
//        Character[] cs = {'a','a','a','a','a','a','a'};

        System.out.println(integerSecondMinMax.findSecondMinMax(arr));
        System.out.println(characterSecondMinMax.findSecondMinMax(c));



        /**
         * question 4 driver
         */

        int[][] matrix = {{1, 0, 2}, {0, 3, 4}, {5, 6, 0}};
        SparseMatrix sparseMatrix = new SparseMatrix(matrix);
        //Printing the initial sparse matrix
        for (int[] i :
                sparseMatrix.getMatrix()) {
            for (int j : i) {
                System.out.print("      " + j);
            }
            System.out.println("\n");

        }

        SparseMatrix transposed = sparseMatrix.transpose();
        System.out.println("----------Transpose----------");
        //Printing transpose of the sparse matrix
        for (int[] i :
                transposed.getMatrix()) {
            for (int j : i) {
                System.out.print("      " + j);
            }
            System.out.println("\n");

        }

        /**
         * question 5 driver
         *
         */
        CheckTriangular triangularChecker = new CheckTriangular();
        int[][] lowerTriangular = {{1, 0, 0}, {2, 3, 0}, {4, 5, 6}};
        int[][] upperTriangular = {{1, 2, 3}, {0, 4, 5}, {0, 0, 6}};
        int[][] diagonal = {{1, 0, 0}, {0, 2, 0}, {0, 0, 3}};
        int[][] identity = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        int[][] tridiagonal = {{1, 2, 0, 0}, {3, 4, 5, 0}, {0, 6, 7, 8}, {0, 0, 9, 10}};

        System.out.println("Is lower triangular: " + triangularChecker.isLowerTriangular(lowerTriangular));
        System.out.println("lowerTriangular Is upper triangular: " + triangularChecker.isUpperTriangular(lowerTriangular));
        System.out.println("Is upper triangular: " + triangularChecker.isUpperTriangular(upperTriangular));
        System.out.println("Is diagonal: " + triangularChecker.isDiagonal(diagonal));
        System.out.println("Is identity: " + triangularChecker.isIdentity(identity));
        System.out.println("Is tridiagonal: " + triangularChecker.isTridiagonal(tridiagonal));

        /**
         * question 6 driver
         *
         */
        MatrixOperations matrixOperations = new MatrixOperations();
        int norm = matrixOperations.norm1(matrix);
        System.out.println("The 1-norm of the matrix is: " + norm);
        int[][] matrix2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        System.out.println("Is matrix orthogonal: " + matrixOperations.isOrthogonal(matrix));
        System.out.println("Is matrix2 orthogonal: " + matrixOperations.isOrthogonal(matrix2));


        /**
         * question number 7 driver
         */
        CustomerDetails cd = new CustomerDetails(5);

        // Adding customer details
        cd.addCustomer(Arrays.asList("C001", "John Doe", "New York"));
        cd.addCustomer(Arrays.asList("C002", "Jane Smith", "Los Angeles"));
        cd.addCustomer(Arrays.asList("C003", "Mike Johnson", "San Francisco"));
        cd.addCustomer(Arrays.asList("C004", "Lisa Brown", "Chicago"));
        cd.addCustomer(Arrays.asList("C005", "Tom Wilson", "Boston"));

        // Searching for customer by name
        List<String> result = cd.searchCustomers("Mike Johnson");
        if (result.size() == 0) {
            System.out.println("Customer not found!");
        } else {
            System.out.println("Customer details:\nID: " + result.get(0) + "\nName: " + result.get(1) + "\nCity: " + result.get(2));
        }

        // Sorting customers by city
        cd.sortCustomers();
        System.out.println("\nCustomers sorted by city:");
        for (List<String> customer : cd.getCustomers()) {
            System.out.println("ID: " + customer.get(0) + "\tName: " + customer.get(1) + "\tCity: " + customer.get(2));
        }
    }
    /**
     * NOTE : question 8 driver is in its own class polynomial
     */

}

