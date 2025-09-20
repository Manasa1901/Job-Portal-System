public class JobPosting {
    private String title;
    private String description;
    private String company;

    public JobPosting(String title, String description, String company) {
        this.title = title;
        this.description = description;
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }

    public void displayJob() {
        System.out.println("Job Title: " + title + " | Company: " + company + " | Description: " + description);
    }
}
