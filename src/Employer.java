public class Employer {
    private String companyName;
    private String email;

    public Employer(String companyName, String email) {
        this.companyName = companyName;
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public void displayEmployer() {
        System.out.println("Employer: " + companyName + " | Contact: " + email);
    }
}
