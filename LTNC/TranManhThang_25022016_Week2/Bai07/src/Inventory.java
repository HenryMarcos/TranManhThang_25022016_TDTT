public class Inventory {
    private Product[] items;

    public Inventory(Product[] initialItems) {
        if (initialItems == null) items = new Product[0];
        else {
            items = new Product[initialItems.length];
            for (int i = 0; i < items.length; i++) {
                items[i] = new Product(initialItems[i]);
            }
        }
    }

    public void printItems() {
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        Product[] arr = new Product[]{new Product("01", "Laptop", 1000), new Product("02", "Desktop", 1500)};
        Inventory kho = new Inventory(arr);
        arr[0].setPrice(5000);
        kho.printItems();
    }
}
