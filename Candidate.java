
public class Candidate {

    String name;
    String email;
    String skill1;
    String skill2;

    // Constructor
    public Candidate(String name, String email, String skill1, String skill2) {
        this.name = name;
        this.email = email;
        this.skill1 = skill1;
        this.skill2 = skill2;
    }

    // Check whether candidate has a particular skill
    public boolean hasSkill(String requiredSkill) {

        return skill1.equalsIgnoreCase(requiredSkill)
                || skill2.equalsIgnoreCase(requiredSkill);
    }

    // Display candidate details
    public void displayCandidate() {

        System.out.println("Candidate Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Skills: " + skill1 + ", " + skill2);
    }
}