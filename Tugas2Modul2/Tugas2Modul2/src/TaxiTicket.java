public class TaxiTicket {
    public String pName;
    public String sLocation;
    public String dest;
    public double prc;
    private double duration;
    private double speed;

    private static final double MIN_SPEED = 5;
    private static final double MAX_SPEED = 100;

    public TaxiTicket(String passengerName, String startLocation, String destination, double price, double duration, double speed) {
        this.pName = passengerName;
        this.sLocation = startLocation;
        this.dest = destination;
        this.prc = price;
        this.duration = duration;
        this.speed = speed;
    }

    // Method to check taxi status
    public void cS() {
        System.out.println("Your taxi is heading to " + dest);
    }

    // Method to display estimated travel duration
    public void dED() {
        System.out.println("Estimated travel duration: " + duration + " minutes");
    }

    // Method to display the route
    public void dR() {
        System.out.println("Route: " + sLocation + " -> " + dest);
    }

    // Method to slow down the taxi
    public void slowDown(double speedReduction) {
        speed -= speedReduction;
        if (speed < MIN_SPEED)
            speed = MIN_SPEED;
        duration += speedReduction * 0.5;
        System.out.println("Taxi slowed down! Current speed: " + speed + " km/h");
    }

    // Method to speed up the taxi
    public void speedUp(double speedIncrease) {
        speed += speedIncrease;
        if (speed > MAX_SPEED)
            speed = MAX_SPEED;
        System.out.println("Taxi sped up! Current speed: " + speed + " km/h");
    }

    // Method to display basic info (passenger and trip)
    public void dI() {
        System.out.println("Passenger Name : " + pName);
        System.out.println("Start Location : " + sLocation);
        System.out.println("Destination    : " + dest);
        System.out.println("Price          : " + prc);
        System.out.println("Final Price    : " + (prc + (prc * 0.1))); // Price including 10% tax
    }

    // Method to display full info including duration and speed
    public void detailedInfo() {
        dI();
        System.out.println("Duration       : " + duration + " minutes");
        System.out.println("Speed          : " + speed + " km/h");
    }

    public static void main(String[] args) {
        TaxiTicket ticket = new TaxiTicket("Alice", "Downtown", "Airport", 50.0, 30.0, 60.0);

        ticket.detailedInfo(); // Display full info
        ticket.cS();           // Check taxi status

        // Display route and estimated duration
        ticket.dR();
        ticket.dED();

        // Simulate slowing down and speeding up
        ticket.slowDown(20);
        ticket.speedUp(15);
    }
}
