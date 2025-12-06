public class Main {
    public static void main(String[] args) {

        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();

        System.out.println("Adding values:");
        System.out.println("put(A, 1) -> " + map.put("A", 1));
        System.out.println("put(B, 2) -> " + map.put("B", 2));
        System.out.println("put(C, 3) -> " + map.put("C", 3));

        System.out.println("\nGetting values:");
        System.out.println("get(A) -> " + map.get("A"));
        System.out.println("get(B) -> " + map.get("B"));
        System.out.println("get(Z) -> " + map.get("Z"));

        System.out.println("\nUpdating a value:");
        System.out.println("put(B, 20) old value -> " + map.put("B", 20));
        System.out.println("get(B) -> " + map.get("B"));

        System.out.println("\nRemoving:");
        System.out.println("remove(C) -> " + map.remove("C"));
        System.out.println("remove(C) again -> " + map.remove("C"));

        System.out.println("\nSize:");
        System.out.println("size() -> " + map.size());

        System.out.println("\nEmpty?");
        System.out.println("isEmpty() -> " + map.isEmpty());
    }
}
