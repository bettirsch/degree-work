package service;

import java.util.List;

import dto.ProductDto;

public interface ProductService {
	
	ProductDto getProduct(Integer entityId);

	List<ProductDto> getAllProduct();

	Integer createProduct(ProductDto dto);
}
