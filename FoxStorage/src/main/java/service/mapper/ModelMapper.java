package service.mapper;

import javax.enterprise.context.Dependent;

import org.mapstruct.Mapper;

import dto.ImageDto;
import dto.ProductDto;
import model.Image;
import model.Product;

@Mapper(componentModel = "cdi")
@Dependent
public interface ModelMapper{

	ImageDto convert(Image entity);
	
	Image convert(ImageDto dto);
	
	ProductDto convert(Product entity);

	Product convert(ProductDto dto);
	
}
