package arrays_pack;
public class Polynomial {
    private int[] coeffs;

    // Constructor to represent a polynomial
    public Polynomial(int[] coeffs) {
        this.coeffs = coeffs;
    }

    // Method to add two polynomials
    public Polynomial add(Polynomial p) {
        int n = Math.max(coeffs.length, p.coeffs.length);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int c1 = (i < coeffs.length) ? coeffs[i] : 0;
            int c2 = (i < p.coeffs.length) ? p.coeffs[i] : 0;
            result[i] = c1 + c2;
        }
        return new Polynomial(result);
    }

    // Method to subtract two polynomials
    public Polynomial subtract(Polynomial p) {
        int n = Math.max(coeffs.length, p.coeffs.length);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int c1 = (i < coeffs.length) ? coeffs[i] : 0;
            int c2 = (i < p.coeffs.length) ? p.coeffs[i] : 0;
            result[i] = c1 - c2;
        }
        return new Polynomial(result);
    }

    // Method to multiply two polynomials
    public Polynomial multiply(Polynomial p) {
        int n = coeffs.length + p.coeffs.length - 1;
        int[] result = new int[n];
        for (int i = 0; i < coeffs.length; i++) {
            for (int j = 0; j < p.coeffs.length; j++) {
                result[i+j] += coeffs[i] * p.coeffs[j];
            }
        }
        return new Polynomial(result);
    }

    // Method to find derivative of a polynomial
    public Polynomial derivative() {
        if (coeffs.length == 1) {
            return new Polynomial(new int[] {0});
        }
        int[] result = new int[coeffs.length - 1];
        for (int i = 1; i < coeffs.length; i++) {
            result[i-1] = i * coeffs[i];
        }
        return new Polynomial(result);
    }

    // Method to print the polynomial
    public void print() {
        int n = coeffs.length;
        for (int i = n - 1; i >= 0; i--) {
            if (coeffs[i] != 0) {
                System.out.print(coeffs[i]);
                if (i > 0) {
                    System.out.print("x^" + i + " + ");
                }
            }
        }
        System.out.println();
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[] coeffs1 = {2, 3, 5,3}; // represents 5x^2 + 3x^1 + 2
        int[] coeffs2 = {4, 1, -3}; // represents -3x^2 + 1x^1 + 4
        /**
         *
         * insert coffes in the order of max degree to min degree of the of x
         * enter 0 to skip one x^ value
          */
        Polynomial p1 = new Polynomial(coeffs1);
        Polynomial p2 = new Polynomial(coeffs2);

        Polynomial p3 = p1.add(p2);
        System.out.print("p1 + p2 = ");
        p3.print();

        Polynomial p4 = p1.subtract(p2);
        System.out.print("p1 - p2 = ");
        p4.print();

        Polynomial p5 = p1.multiply(p2);
        System.out.print("p1 x p2 = ");
        p5.print();
        Polynomial p6 = p1.derivative();
        System.out.print("expression =" );
        p1.print();
        System.out.print("derivative = ");
        p6.print();
    }
}


