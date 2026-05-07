public class DiscountInspector {
    public static double calculateDiscount(double price, String memberType) {
        if (price < 0) { throw new IllegalArgumentException("Price cannot be negative"); }
        if (memberType == null) { throw  new IllegalArgumentException("Invalid member type"); }

        switch (memberType.toUpperCase()) {
            case "GUEST":
                return 0.0;
            case "MEMBER":
                return (price < 100? price * 0.05: price * 0.1);
            case "VIP":
                return (price < 100? price * 0.15: price * 0.2);
            default:
                throw new IllegalArgumentException("Invalid member type");
        }
    }
}
