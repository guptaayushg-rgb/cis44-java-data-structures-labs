class DecisionNode {
    String question;
    DecisionNode yesNode;
    DecisionNode noNode;
    String decision;

    DecisionNode(String decision) {
        this.decision = decision;
    }

    DecisionNode(String question, DecisionNode yesNode, DecisionNode noNode) {
        this.question = question;
        this.yesNode = yesNode;
        this.noNode = noNode;
    }

    boolean isLeaf() {
        return decision != null;
    }
}

class DecisionTree {

    DecisionNode root;

    DecisionTree() {
        buildTree();
    }

    private void buildTree() {
        DecisionNode approved = new DecisionNode("Approved");
        DecisionNode rejected = new DecisionNode("Rejected");

        DecisionNode creditCheck = new DecisionNode("Is credit score >= 700?", approved, rejected);
        DecisionNode incomeCheck = new DecisionNode("Is income >= 50,000?", creditCheck, rejected);

        root = incomeCheck;
    }

    public String makeDecision(int income, int creditScore) {
        DecisionNode current = root;

        while (!current.isLeaf()) {
            if (current.question.equals("Is income >= 50,000?")) {
                current = (income >= 50000) ? current.yesNode : current.noNode;
            } else if (current.question.equals("Is credit score >= 700?")) {
                current = (creditScore >= 700) ? current.yesNode : current.noNode;
            }
        }

        return current.decision;
    }
}

public class DecisionEngineTest {
    public static void main(String[] args) {
        DecisionTree tree = new DecisionTree();

        int income1 = 60000, creditScore1 = 720;
        int income2 = 40000, creditScore2 = 680;

        System.out.println("Applicant 1: " + tree.makeDecision(income1, creditScore1));
        System.out.println("Applicant 2: " + tree.makeDecision(income2, creditScore2));
    }
}
