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
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Err").build();
		}
	}
}
