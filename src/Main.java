public class Main {
    public static void main(String[] args) {
        // Create Job Seeker
        JobSeeker seeker = new JobSeeker("Arun", "arun@gmail.com", "Java, SQL, OOP");

        // Create Employer
        Employer employer = new Employer("TechCorp", "hr@techcorp.com");

        // Create Job Posting
        JobPosting job = new JobPosting("Software Engineer", "Develop Java applications", employer.getCompanyName());

        // Display data
        seeker.displayProfile();
        employer.displayEmployer();
        job.displayJob();

        // Job Application
        Application app = new Application(seeker, job);
        app.displayApplication();
    }
}
