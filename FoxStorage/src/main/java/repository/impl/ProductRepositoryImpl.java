package repository.impl;

import model.Product;
import repository.ProductRepository;
import repository.util.BaseRepositoryImpl;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {

	public ProductRepositoryImpl() {
		super(Product.class);
	}

}
