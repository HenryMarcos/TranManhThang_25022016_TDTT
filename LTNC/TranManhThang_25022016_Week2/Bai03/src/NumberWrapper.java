public class NumberWrapper {
    private int value;

    public NumberWrapper() {
        value = 0;
    }

    public NumberWrapper(int value) {
        this.value = value;
    }

    public NumberWrapper(NumberWrapper p_number) {
        this.value = p_number.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public void swap(NumberWrapper a, NumberWrapper b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {
        NumberWrapper n1 = new NumberWrapper(5);
        NumberWrapper n2 = new NumberWrapper(10);
        n1.swap(n1, n2);
        System.out.println(n1.getValue());
        System.out.println(n2.getValue());
    } 
}
