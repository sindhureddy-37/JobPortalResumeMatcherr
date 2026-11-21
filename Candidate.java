
public class Candidate {

    String name;
    String email;
    String skill1;
    String skill2;

    // Constructor


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
