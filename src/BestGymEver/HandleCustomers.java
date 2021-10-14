package BestGymEver;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleCustomers {

    protected List<Customer> customersFromFileToList(String readFile) {
        String firstRow;
        String secondRow;
        Path pathInName;
        List<Customer> allCustomers = new ArrayList<>();

        String[] customerFirstLine;
        String[] customerSecondLine = new String[0];
        pathInName = Paths.get(readFile);

        try (Scanner scanner = new Scanner(pathInName)) {

            while (scanner.hasNext()) {
                firstRow = scanner.nextLine();
                customerFirstLine = firstRow.split(",");
                if (scanner.hasNext()) {
                    secondRow = scanner.nextLine();
                    customerSecondLine = secondRow.split(",");
                }
                Customer c = new Customer(customerFirstLine[1].trim(),
                        customerFirstLine[0].trim(),
                        customerSecondLine[0].trim());

                allCustomers.add(c);
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("An error occurred while loading the file.");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
        return allCustomers;
    }

    protected boolean isCustomerActive(Customer customer) {

        LocalDate dateToday = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(customer.getMemberSince());
        Period p = Period.between(inputDate, dateToday);

        return p.getYears() < 1;

    }

    protected List<Customer> processActiveCustomer(List<Customer> allCostumers, String input) {

        List<Customer> isCustomerActive = new ArrayList<>();
        boolean foundCustomer = false;

        for (Customer c : allCostumers) {
            if (c.getName().equalsIgnoreCase(input) || c.getSocialSecurityNumber().equalsIgnoreCase(input)) {

                if (isCustomerActive(c)) {
                    System.out.println(c.getName() + " is a proud member of BestGymEver.\nWelcome back!");
                    isCustomerActive.add(c);
                } else
                    System.out.println(c.getName() + "'s subscription payment is expired.\nPlease renew your subscription.");

                foundCustomer = true;
            }
        }
        if (!foundCustomer) {
            System.out.println("You have never been a member. Sorry can't come in.");
        }
        return isCustomerActive;
    }

    protected void writeToFileIfCustomerIsActive(String writeFile, List<Customer> isCustomerActive) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(writeFile, true))) {

            for (Customer c : isCustomerActive) {
                writer.print("Member: " + c.getName() + ", " + c.getSocialSecurityNumber() +
                        "\nLast Visit: " + LocalDate.now() + "\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file could not be found.");
            e.printStackTrace();
            System.exit(0);

        } catch (IOException e) {
            System.out.println("Could not write to file.");
            e.printStackTrace();
            System.exit(0);

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            System.exit(0);
        }
    }
}
