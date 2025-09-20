import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<JobSeeker> seekers = new ArrayList<>();
        ArrayList<Employer> employers = new ArrayList<>();
        ArrayList<JobPosting> jobs = new ArrayList<>();
        ArrayList<Application> applications = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Job Portal Menu =====");
            System.out.println("1. Register Job Seeker");
            System.out.println("2. Register Employer");
            System.out.println("3. Post a Job");
            System.out.println("4. Apply for a Job");
            System.out.println("5. View All Jobs");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String seekerName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String seekerEmail = scanner.nextLine();
                    System.out.print("Enter skills: ");
                    String seekerSkills = scanner.nextLine();
                    seekers.add(new JobSeeker(seekerName, seekerEmail, seekerSkills));
                    System.out.println("Job Seeker registered successfully!");
                    break;

                case 2:
                    System.out.print("Enter company name: ");
                    String companyName = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String employerEmail = scanner.nextLine();
                    employers.add(new Employer(companyName, employerEmail));
                    System.out.println("Employer registered successfully!");
                    break;

                case 3:
                    if (employers.isEmpty()) {
                        System.out.println("No employers registered. Please register first!");
                        break;
                    }
                    System.out.print("Enter job title: ");
                    String jobTitle = scanner.nextLine();
                    System.out.print("Enter job description: ");
                    String jobDesc = scanner.nextLine();
                    System.out.print("Enter company name: ");
                    String jobCompany = scanner.nextLine();
                    jobs.add(new JobPosting(jobTitle, jobDesc, jobCompany));
                    System.out.println("Job posted successfully!");
                    break;

                case 4:
                    if (seekers.isEmpty() || jobs.isEmpty()) {
                        System.out.println("Either no seekers or no jobs available!");
                        break;
                    }
                    System.out.print("Enter job seeker email: ");
                    String applyEmail = scanner.nextLine();
                    JobSeeker seeker = null;
                    for (JobSeeker s : seekers) {
                        if (s.getEmail().equals(applyEmail)) {
                            seeker = s;
                            break;
                        }
                    }
                    if (seeker == null) {
                        System.out.println("Job seeker not found!");
                        break;
                    }

                    System.out.print("Enter job title to apply: ");
                    String applyJob = scanner.nextLine();
                    JobPosting selectedJob = null;
                    for (JobPosting j : jobs) {
                        if (j.getTitle().equals(applyJob)) {
                            selectedJob = j;
                            break;
                        }
                    }
                    if (selectedJob == null) {
                        System.out.println("Job not found!");
                        break;
                    }

                    applications.add(new Application(seeker, selectedJob));
                    System.out.println("Application submitted successfully!");
                    break;

                case 5:
                    if (jobs.isEmpty()) {
                        System.out.println("No jobs available.");
                    } else {
                        for (JobPosting job : jobs) {
                            job.displayJob();
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting Job Portal. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
