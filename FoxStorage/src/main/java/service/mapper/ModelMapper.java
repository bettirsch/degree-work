package service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import dto.FormHeadReadDto;
import dto.FormHeadWriteDto;
import dto.FormItemReadDto;
import dto.FormItemWriteDto;
import dto.ImageDto;
import dto.InventoryItemFacilityDto;
import dto.ProductDto;
import dto.UserReadDto;
import dto.UserRegisterDto;
import model.Form;
import model.FormItem;
import model.Image;
import model.InventoryItem;
import model.Product;
import model.User;
import service.mapper.reslover.FacilityMapperResolver;
import service.mapper.reslover.PartnerMapperResolver;
import service.mapper.reslover.ProductMapperResolver;

@Mapper(componentModel = "cdi", uses = { ProductMapperResolver.class, PartnerMapperResolver.class,
		FacilityMapperResolver.class })
public interface ModelMapper {

	ImageDto convert(Image entity);

	Image convert(ImageDto dto);

	@Mapping(source = "entity.basePrice.netUnitPrice", target = "baseNetUnitPrice")
	@Mapping(source = "entity.basePrice.vatRate", target = "baseVatRate")
	ProductDto convert(Product entity);

	@Mapping(source = "dto.baseNetUnitPrice", target = "basePrice.netUnitPrice")
	@Mapping(source = "dto.baseVatRate", target = "basePrice.vatRate")
	Product convert(ProductDto dto);

	@Mapping(target = "roles", ignore = true)
	User convert(UserRegisterDto dto);

	@Mapping(target = "roles", source = "roles")
	UserReadDto convert(User entity);

	@Mapping(source = "dto.partnerId", target = "partner")
	@Mapping(source = "dto.facilityId", target = "facility")
	Form convert(FormHeadWriteDto dto);

	@Mapping(source = "entity.partner.id", target = "partnerId")
	@Mapping(source = "entity.facility.id", target = "facilityId")
	FormHeadReadDto convert(Form entity);

	@Mapping(source = "entity.product.id", target = "productId")
	@Mapping(source = "entity.product.productEan", target = "productEan")
	@Mapping(source = "entity.product.itemNr", target = "itemNr")
	@Mapping(source = "entity.product.productName", target = "productName")
	FormItemReadDto convert(FormItem entity);
	
	@Mapping(source = "dto.productId", target = "product")
	FormItem convert(FormItemWriteDto dto);
	
	@Mapping(source = "entity.product.productName", target = "productName")
	@Mapping(source = "entity.product.productEan", target = "productEan")
	@Mapping(source = "entity.product.itemNr", target = "itemNr")
	InventoryItemFacilityDto convert(InventoryItem entity);
}
