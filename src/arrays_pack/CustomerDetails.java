package arrays_pack;

import java.util.*;

public class CustomerDetails {
    private List<List<String>> customers;
    private int size;

    public List<List<String>> getCustomers() {
        return customers;
    }

    // Constructor to initialize the size of customer details for 5 customers
    public CustomerDetails(int size) {
        this.size = size;
        customers = new ArrayList<>(size);
    }

    // Method to add customer details
    public void addCustomer(List<String> customer) {
        customers.add(customer);
    }

    // Method to get customer details by customer ID
    public List<String> getCustomer(String customerId) {
        List<String> result = new ArrayList<>();
        for (List<String> customer : customers) {
            if (customer.get(0).equals(customerId)) {
                result = customer;
                break;
            }
        }
        return result;
    }

    // Method to sort customers by city using insertion sort
    public void sortCustomers() {
        for (int i = 1; i < customers.size(); i++) {
            List<String> current = customers.get(i);
            int j = i - 1;
            while (j >= 0 && customers.get(j).get(2).compareTo(current.get(2)) > 0) {
                customers.set(j + 1, customers.get(j));
                j--;
            }
            customers.set(j + 1, current);
        }
    }

    // Method to search for customer by name using binary search
    public List<String> searchCustomers(String customerName) {
        sortCustomers();
        int left = 0, right = customers.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (customers.get(mid).get(1).equals(customerName)) {
                return customers.get(mid);
            } else if (customers.get(mid).get(1).compareTo(customerName) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new ArrayList<>();
    }
}
