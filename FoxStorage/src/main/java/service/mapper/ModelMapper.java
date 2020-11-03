package service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.ImageDto;
import dto.ProductDto;
import dto.UserDto;
import dto.UserDtoRegister;
import model.Image;
import model.Product;
import model.User;

@Mapper(componentModel = "cdi")
public interface ModelMapper{

	ImageDto convert(Image entity);
	
	Image convert(ImageDto dto);
	
	ProductDto convert(Product entity);

	Product convert(ProductDto dto);
	
    @Mapping(target = "roles", ignore = true)
	User convert(UserDtoRegister dto);

    @Mapping(target = "roles", source = "roles")
	UserDto convert(User entity);
}
