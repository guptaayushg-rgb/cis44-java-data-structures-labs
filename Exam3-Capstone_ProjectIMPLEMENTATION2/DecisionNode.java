public class DecisionNode {
    private String condition;
    private DecisionNode left;
    private DecisionNode right;
    private String outcome;

    public DecisionNode(String outcome) {
        this.outcome = outcome;
    }

    public DecisionNode(String condition, DecisionNode left, DecisionNode right) {
        this.condition = condition;
        this.left = left;
        this.right = right;
    }

    public String getCondition() { return condition; }
    public DecisionNode getLeft() { return left; }
    public DecisionNode getRight() { return right; }
    public String getOutcome() { return outcome; }
    public boolean isLeaf() { return outcome != null; }
}
