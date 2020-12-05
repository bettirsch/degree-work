package webservice.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import dto.ProductDto;
import service.ProductService;
import webservice.ProductResource;

@Transactional
public class ProductResourceImpl implements ProductResource{

	@Inject
	private ProductService productService;
	
	@Override
	public Response getAllProducts() {
		try {
			List<ProductDto> productDtos = productService.getAllProduct();
			return Response.status(Response.Status.OK).entity(productDtos).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

	@Override
	public Response createProduct(ProductDto dto) {
		try {
			Integer createdProductId = productService.createProduct(dto);
			return Response.status(Response.Status.OK).entity(createdProductId).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

	@Override
	public Response getProduct(Integer id) {
		try {
			ProductDto findedProductDto = productService.getProduct(id);
			return Response.status(Response.Status.OK).entity(findedProductDto).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

	@Override
	public Response updateProduct(Integer id, ProductDto dto) {
		try {
			ProductDto updatedProductDto = productService.updateProduct(id, dto);
			return Response.status(Response.Status.OK).entity(updatedProductDto).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

	@Override
	public Response deleteProduct(Integer id) {
		try {
			productService.softDeleteProduct(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
	}

}
