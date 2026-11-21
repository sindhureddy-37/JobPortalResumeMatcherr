
public class Job {

    String jobName;
    String skill1;
    String skill2;
    String description;

    // Constructo
    public Job(String jobName, String skill1, String skill2,
               String description) {

        this.jobName = jobName;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.description = description;
    }

    // Display job details
    public void displayJob() {

        System.out.println("Job Name: " + jobName);
        System.out.println("Required Skills: " + skill1 + ", " + skill2);
        System.out.println("Description: " + description);
    }

    // Display detailed job requirements
    public void displayJobRequirements() {

        System.out.println("Job Position: " + jobName);
        System.out.println("Description: " + description);
        System.out.println("Skill Requirement 1: " + skill1);
        System.out.println("Skill Requirement 2: " + skill2);
        System.out.println("Total Required Skills: 2");
    }
}
