package service.mapper.reslover;

import javax.inject.Inject;

import model.Product;
import repository.ProductRepository;

public class ProductMapperResolver{

	@Inject
	private ProductRepository repo;
	
	public Product map(Integer value) {
		if (value != null) {
			return repo.find(value);
		}
		//should throw exception?
		return null;
	}

}
