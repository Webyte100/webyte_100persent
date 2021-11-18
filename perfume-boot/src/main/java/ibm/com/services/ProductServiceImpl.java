package ibm.com.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ibm.entity.Product;
import com.ibm.repo.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Qualifier("productRepository")
	@Autowired
	private ProductRepository prod_repo;

	@Transactional
	@Override
	public void saveProduct(Product product) {
		prod_repo.save(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return prod_repo.findAll();
	}

	@Override
	public List<Product> findAllProductByName(String prodName) {
		return prod_repo.findProductByProductName(prodName);
	}

	@Override
	public List<Product> findAllProductByPrice(long price) {
		return prod_repo.findProductByPrice(price);
	}

	@Override
	public List<Product> findAllProductByCategory(String category) {
		return prod_repo.findProductByCategory(category);
	}

	@Override
	public List<Product> findAllProductByDiscount(int discount) {
		return prod_repo.findProductByDiscount(discount);
	}
	
}
