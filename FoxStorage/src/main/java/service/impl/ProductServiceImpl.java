package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dto.ProductDto;
import model.Product;
import service.ProductService;
import service.mapper.ModelMapper;
import service.util.BaseServiceImpl;

@Stateless
public class ProductServiceImpl extends BaseServiceImpl<ProductDto, Product> implements ProductService{

	@Inject
	private ModelMapper mapper;
	
	@PostConstruct
	public void setRepository() {
		super.setRepository(Product.class);
	}

	@Override
    public ProductDto getInstance(Integer entityId) {
    	return mapper.convert(getRepository().find(entityId));
    }
    
    @Override
    public List<ProductDto> getAllInstances() {
        List<Product> entityList = getRepository().findAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product entity: entityList) {
            dtoList.add(mapper.convert(entity));
        }
        return dtoList;
    }

    @Override
    public Integer createInstance(ProductDto dto) {
        Product entity = getRepository().create(mapper.convert(dto));
        return entity.getId();
    }
}
