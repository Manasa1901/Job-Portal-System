public class Application {
    private JobSeeker seeker;
    private JobPosting job;

    public Application(JobSeeker seeker, JobPosting job) {
        this.seeker = seeker;
        this.job = job;
    }

    public void displayApplication() {
        System.out.println(seeker.getName() + " applied for " + job.getTitle() + " at " + job.getCompany());
    }
}
