import java.util.ArrayList;
import java.util.List;

public class WareHouse<T extends Product> {
    private List<T> items;

    public WareHouse() {
        this.items = new ArrayList<>();
    }

    public void importProduct(T product) {
        items.add(product);
    }

    public void exportProduct(T product) {
        items.remove(product);
    }

    public void checkInventory() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }
}
