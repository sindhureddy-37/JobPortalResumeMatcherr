
public class Application {

    String candidateName;
    String jobName;
    int matchPercentage;
    String status;

    // Constructo
    public Application(String candidateName, String jobName,
                       int matchPercentage, String status) {

        this.candidateName = candidateName;
        this.jobName = jobName;
        this.matchPercentage = matchPercentage;
        this.status = status;
    }

    // Display application details
    public void displayApplication() {

        System.out.println("\n--- APPLICATION TRACKING ---");

        System.out.println("Candidate Name: " + candidateName);
        System.out.println("Applied Job: " + jobName);
        System.out.println("Match Percentage: " + matchPercentage + "%");
        System.out.println("Application Status: " + status);
    }
}
