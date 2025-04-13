import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.0),
            new Product("Smartphone", "Electronics", 800.0),
            new Product("Tablet", "Electronics", 600.0),
            new Product("Chair", "Furniture", 150.0),
            new Product("Desk", "Furniture", 300.0),
            new Product("Sofa", "Furniture", 700.0),
            new Product("Apple", "Groceries", 1.5),
            new Product("Milk", "Groceries", 2.0),
            new Product("Cheese", "Groceries", 5.0)
        );

        System.out.println("🗂️ Grouped Products by Category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        groupedByCategory.forEach((category, prodList) -> {
            System.out.println(category + ": " + prodList);
        });

        System.out.println("\n💸 Most Expensive Product in Each Category:");
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));
        mostExpensiveByCategory.forEach((category, product) -> {
            System.out.println(category + ": " + product.orElse(null));
        });

        System.out.println("\n📊 Average Price of All Products:");
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0.0);
        System.out.println("Average Price: " + averagePrice);
    }
}
