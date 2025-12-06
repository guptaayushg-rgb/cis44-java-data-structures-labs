public class DecisionTree {
    private DecisionNode root;

    public DecisionTree() {
        DecisionNode approved = new DecisionNode("Approved");
        DecisionNode rejected = new DecisionNode("Rejected");
        DecisionNode creditScoreCheck = new DecisionNode("creditScore > 700", rejected, approved);
        root = new DecisionNode("income > 50000", rejected, creditScoreCheck);
    }

    public String evaluate(int income, int creditScore) {
        return evaluateNode(root, income, creditScore);
    }

    private String evaluateNode(DecisionNode node, int income, int creditScore) {
        if (node.isLeaf()) {
            return node.getOutcome();
        }

        if (node.getCondition().equals("income > 50000")) {
            if (income > 50000) return evaluateNode(node.getRight(), income, creditScore);
            else return evaluateNode(node.getLeft(), income, creditScore);
        } else if (node.getCondition().equals("creditScore > 700")) {
            if (creditScore > 700) return evaluateNode(node.getRight(), income, creditScore);
            else return evaluateNode(node.getLeft(), income, creditScore);
        }

        return "Unknown";
    }
}
