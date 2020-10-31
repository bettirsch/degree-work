package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dto.ProductDto;
import model.Product;
import repository.ProductRepository;
import service.ProductService;
import service.util.BaseServiceImpl;

public class ProductServiceImpl extends BaseServiceImpl implements ProductService{
	
	@Inject
	private ProductRepository repository;
	
    public ProductDto getProduct(Integer entityId) {
    	return getMapper().convert(repository.find(entityId));
    }
    
    public List<ProductDto> getAllProduct() {
        List<Product> entityList = repository.findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product entity: entityList) {
            dtoList.add(getMapper().convert(entity));
        }
        return dtoList;
    }

    public Integer createProduct(ProductDto dto) {
        Product entity = repository.create(getMapper().convert(dto));
        return entity.getId();
    }
}
