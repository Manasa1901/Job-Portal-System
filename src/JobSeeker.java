public class JobSeeker {
    private String name;
    private String email;
    private String skills;

    public JobSeeker(String name, String email, String skills) {
        this.name = name;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSkills() {
        return skills;
    }

    public void displayProfile() {
        System.out.println("Job Seeker: " + name + " | Email: " + email + " | Skills: " + skills);
    }
}
