package BestGymEver;

public class Customer {

    protected String name;
    protected String socialSecurityNumber;
    protected String memberSince;

    // Constructor
    public Customer(String name, String socialSecurityNumber, String memberSince) {
        this.name = name;
        this.socialSecurityNumber = socialSecurityNumber;
        this.memberSince = memberSince;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getMemberSince() {
        return memberSince;
    }
}
