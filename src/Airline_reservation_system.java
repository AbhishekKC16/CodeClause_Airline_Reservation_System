import java.util.ArrayList;
import java.util.Scanner;

public class Airline_reservation_system {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("<------------Welcome to the Airline Reservation System By ABHISHEK KUMAR CHAUHAN------------>");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Passenger Details");
            System.out.println("4. Exit");
            System.out.print("--> Enter your choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    viewPassengerDetails();
                    break;
                case 4:
                    System.out.println("EXITING...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("<------------INVALID CHOICE, PLEASE TRY AGAIN------------>");
            }
        }
    }
    public static void bookTicket() {
        System.out.println("Enter Passenger Name:");
        String name = scanner.next();
        System.out.println("Enter Departure City:");
        String departure = scanner.next();
        System.out.println("Enter Destination City:");
        String destination = scanner.next();
        System.out.println("Enter Travel Date (DD/MM/YYYY):");
        String travelDate = scanner.next();
        Passenger passenger = new Passenger(name, departure, destination, travelDate);
        passengers.add(passenger);
        System.out.println("<------------TICKET BOOKED SUCCESSFULLY------------>");
    }
    public static void cancelTicket() {
        System.out.println("Enter Passenger Name:");
        String name = scanner.next();
        System.out.println("Enter Travel Date (DD/MM/YYYY):");
        String travelDate = scanner.next();
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getName().equals(name) && passenger.getTravelDate().equals(travelDate)) {
                passengers.remove(i);
                System.out.println("<------------TICKET CANCELLED SUCCESSFULLY------------>");
                return;
            }
        }
        System.out.println("<------------TICKET NOT FOUND------------>");
    }
    public static void viewPassengerDetails() {
        System.out.println("Enter passenger name:");
        String name = scanner.next();
        for (int i = 0; i < passengers.size(); i++) {
            Passenger passenger = passengers.get(i);
            if (passenger.getName().equals(name)) {
                System.out.println("Name: " + passenger.getName());
                System.out.println("Departure: " + passenger.getDeparture());
                System.out.println("Destination: " + passenger.getDestination());
                System.out.println("Travel Date: " + passenger.getTravelDate());
                return;
            }
        }
        System.out.println("<------------PASSENGER NOT FOUND------------>");
    }
}
class Passenger {
    private String name;
    private String departure;
    private String destination;
    private String travelDate;
    public Passenger(String name, String departure, String destination, String travelDate) {
        this.name = name;
        this.departure = departure;
        this.destination = destination;
        this.travelDate = travelDate;
    }
    public String getName() {
        return name;
    }
    public String getDeparture() {
        return departure;
    }
    public String getDestination() {
        return destination;
    }
    public String getTravelDate() {
        return travelDate;
    }
}