package service.mapper;


import org.mapstruct.Mapper;

import dto.ImageDto;
import dto.ProductDto;
import dto.UserDto;
import model.Image;
import model.Product;
import model.User;

@Mapper(componentModel = "cdi")
public interface ModelMapper{

	ImageDto convert(Image entity);
	
	Image convert(ImageDto dto);
	
	ProductDto convert(Product entity);

	Product convert(ProductDto dto);
	
	User convert(UserDto dto);
	
	UserDto convert(User entity);
	
}
