
import java.util.Scanner;

public class JobPortal {

    // Method to get non-empty input
    public static String getValidInput(Scanner sc, String message) {

        String input;

        do {
            System.out.print(message);
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty! Try again.");
            }

        } while (input.isEmpty());

        return input;
    }

    // Method to get a valid email
    public static String getValidEmail(Scanner sc) {

        String email;

        do {
            email = getValidInput(sc, "Enter your email: ");

            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
                System.out.println("Invalid email! Please enter a valid email.");
            }

        } while (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"));

        return email;
    }

    // Method to display all available jobs
    public static void displayJobs(Job[] jobs) {

        System.out.println("\nAvailable Job Postings:");

        for (int i = 0; i < jobs.length; i++) {
            System.out.println("\nJob " + (i + 1));
            jobs[i].displayJobRequirements();
        }
    }

    // Method to register a candidate
    public static Candidate registerCandidate(Scanner sc) {

        System.out.println("\n--- Candidate Registration ---");

        String name = getValidInput(sc, "Enter your name: ");

        String email = getValidEmail(sc);

        String skill1 = getValidInput(sc, "Enter your first skill: ");

        String skill2 = getValidInput(sc, "Enter your second skill: ");

        Candidate candidate =
                new Candidate(name, email, skill1, skill2);

        System.out.println("\nCandidate registered successfully!");

        return candidate;
    }

    // Method to select a valid job
    public static Job selectJob(Scanner sc, Job[] jobs) {

        while (true) {

            String choice = getValidInput(
                    sc, "\nEnter job number or job name: ");

            try {
                int jobNumber = Integer.parseInt(choice);

                if (jobNumber >= 1 && jobNumber <= jobs.length) {
                    return jobs[jobNumber - 1];
                }

                System.out.println("Invalid job number! Try again.");

            } catch (NumberFormatException e) {

                for (Job job : jobs) {

                    if (job.jobName.equalsIgnoreCase(choice)) {
                        return job;
                    }
                }

                System.out.println("Job not found! Please try again.");
            }
        }
    }

    // Method to count matching skills
    public static int countMatchingSkills(Candidate candidate, Job job) {

        int match = 0;

        if (candidate.hasSkill(job.skill1)) {
            match++;
        }

        if (candidate.hasSkill(job.skill2)) {
            match++;
        }

        return match;
    }

    // Method to calculate matching percentage
    public static int calculateMatchPercentage(int matchingSkills) {

        int totalSkills = 2;

        return (matchingSkills * 100) / totalSkills;
    }

    // Method to display matched and missing skills
    public static void displaySkillDetails(Candidate candidate, Job job) {

        System.out.println("\n--- SKILL MATCHING DETAILS ---");

        System.out.println("Matched Skills:");

        boolean hasMatch = false;

        if (candidate.hasSkill(job.skill1)) {
            System.out.println("- " + job.skill1);
            hasMatch = true;
        }

        if (candidate.hasSkill(job.skill2)) {
            System.out.println("- " + job.skill2);
            hasMatch = true;
        }

        if (!hasMatch) {
            System.out.println("No matching skills found.");
        }

        System.out.println("\nMissing Skills:");

        boolean hasMissing = false;

        if (!candidate.hasSkill(job.skill1)) {
            System.out.println("- " + job.skill1);
            hasMissing = true;
        }

        if (!candidate.hasSkill(job.skill2)) {
            System.out.println("- " + job.skill2);
            hasMissing = true;
        }

        if (!hasMissing) {
            System.out.println("No missing skills!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Job[] jobs = {

            new Job("Java Developer", "Java", "SQL",
                    "Develop and maintain Java-based applications."),

            new Job("Python Developer", "Python", "Machine Learning",
                    "Build Python applications and machine learning models."),

            new Job("Web Developer", "HTML", "CSS",
                    "Design and develop attractive websites.")
        };

        System.out.println("================================");
        System.out.println("       JOB PORTAL SYSTEM");
        System.out.println("================================");

        displayJobs(jobs);

        Candidate candidate = registerCandidate(sc);

        Job selectedJob = selectJob(sc, jobs);

        int match = countMatchingSkills(candidate, selectedJob);

        int percentage = calculateMatchPercentage(match);

        System.out.println("\n================================");
        System.out.println("       APPLICATION DETAILS");
        System.out.println("================================");

        candidate.displayCandidate();

        System.out.println("Selected Job: " + selectedJob.jobName);

        System.out.println("Job Description: "
                + selectedJob.description);

        System.out.println("Required Skills: "
                + selectedJob.skill1 + ", "
                + selectedJob.skill2);

        displaySkillDetails(candidate, selectedJob);

        System.out.println("\nMatching Skills: " + match + "/2");

        System.out.println("Match Percentage: " + percentage + "%");

        // Create application record
        String status;

        if (percentage >= 50) {
            status = "Applied Successfully";
        } else {
            status = "Low Skill Match";
        }

        Application application = new Application(
                candidate.name,
                selectedJob.jobName,
                percentage,
                status
        );

        application.displayApplication();

        System.out.println("\nThank you for using Job Portal!");

        sc.close();
    }
}
