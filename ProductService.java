import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();

    // Add a product to the list
    public void addProduct(Product p){
        products.add(p);
    }

    // Get all products
    public List<Product> getAllProducts(){
        return products;
    }

    // Get a product by name
    public Product getProduct(String name) {
        return products.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    // Get products that contain the specified text in name, type, or place
    public List<Product> getProductWithText(String text) {
        return products.stream()
        .filter(prod ->(prod.getName().toLowerCase().contains(text.toLowerCase()) 
        || prod.getType().toLowerCase().contains(text.toLowerCase()))
        || prod.getPlace().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());

    }
    
    // Get products that match the specified place
    public List<Product> getProductWithPlace(String place){
        return products.stream().filter(s->s.getPlace().toLowerCase().contains(place.toLowerCase())).collect(Collectors.toList());
    }
    
    // Get products with a specific warranty year
    public List<Product> getProductWithWarrenty(int year){
        return products.stream().filter(s -> s.getWarranty()==year).collect(Collectors.toList());
    }
}
