package BestGymEver;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HandleCustomers hc = new HandleCustomers();
        Scanner scanner = new Scanner(System.in);

        String fileIn = "C:\\Users\\rober\\IdeaProjects\\OOP_Inlämningsuppgift1\\src\\BestGymEver\\customers.txt";
        String fileOut = "C:\\Users\\rober\\IdeaProjects\\OOP_Inlämningsuppgift1\\src\\BestGymEver\\activeCustomers.txt";

        List<Customer> allCustomers = hc.customersFromFileToList(fileIn);

        System.out.print("Enter name or social security number: ");
        String input = scanner.nextLine();

        List<Customer> isCustomerActive = hc.processActiveCustomer(allCustomers, input);

        hc.writeToFileIfCustomerIsActive(fileOut, isCustomerActive);
    }
}
