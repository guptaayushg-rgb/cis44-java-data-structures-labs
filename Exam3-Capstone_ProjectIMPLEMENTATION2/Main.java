public class Main {
    public static void main(String[] args) {
        DecisionTree loanTree = new DecisionTree();

        System.out.println(loanTree.evaluate(60000, 720));
        System.out.println(loanTree.evaluate(60000, 680));
        System.out.println(loanTree.evaluate(40000, 750));
    }
}
