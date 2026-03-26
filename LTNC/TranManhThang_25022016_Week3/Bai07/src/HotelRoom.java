public class HotelRoom {
    private String caseNumber;
    private String roomType;
    private int stayingDays;
    
    public HotelRoom(String caseNumber, String roomType, int stayingDays) {
        this.caseNumber = caseNumber;
        this.roomType = roomType;
        this.stayingDays = stayingDays;
    }

    public int getFinalPrice() {
        switch (roomType) {
            case "S":
                if (stayingDays > 3) {
                    return stayingDays * 500000 / 20 * 19;
                }
                return stayingDays * 500000;
            
            case "V":
                return stayingDays * 2000000;
            default:
                break;
        }
        return 0;
    }

    @Override 
    public String toString() {
        return caseNumber + "\n" + getFinalPrice();
    }
}