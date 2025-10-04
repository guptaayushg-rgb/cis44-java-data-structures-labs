public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        var paris = itinerary.addLast("Paris");
        var rome = itinerary.addLast("Rome");
        var london = itinerary.addFirst("London");

        itinerary.addAfter(paris, "Eiffel Tower");
        itinerary.addBefore(rome, "Colosseum");
        itinerary.addAfter(london, "British Museum");

        System.out.println("Final Travel Itinerary:");
        for (String stop : itinerary) {
            System.out.println("- " + stop);
        }
    }
}