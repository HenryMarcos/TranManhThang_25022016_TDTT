
import java.util.ArrayList;
import java.util.List;

class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }
    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    private double getTotalFee() {
        return tickets.stream().mapToDouble(ParkingTicket::getFee).sum();
    }

    private int getTotalBonus() {
        return tickets.stream().mapToInt(ParkingTicket::getBonus).sum();
    }

    public String receipt() {
        StringBuilder result = new StringBuilder("Parking Receipt for " + name + "\n");

        for (ParkingTicket each : tickets) {
            // Receipt bây giờ chỉ làm nhiệm vụ format hiển thị
            result.append("\t").append(each.getPlate())
                  .append("\t").append(each.getFee()).append("\n");
        }

        result.append("Total fee is ").append(getTotalFee()).append("\n");
        result.append("You earned ").append(getTotalBonus()).append(" bonus points");
        return result.toString();
    }
}
