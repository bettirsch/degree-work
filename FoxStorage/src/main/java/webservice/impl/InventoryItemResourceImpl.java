package webservice.impl;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;

import dto.InventoryItemFacilityDto;
import dto.InventoryItemProductDto;
import service.InventoryItemService;
import webservice.InventoryItemResource;

@Transactional
public class InventoryItemResourceImpl implements InventoryItemResource{

	@Inject
	private InventoryItemService inventoryItemService;
	
	@Override
	public Response getProductInventories(Integer productId) {
		try {
			List<InventoryItemProductDto> inventoryItemDtos = inventoryItemService.getProductInventories(productId);
			return Response.status(Response.Status.OK).entity(inventoryItemDtos).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

	@Override
	public Response getFacilityInventories(Integer facilityId) {
		try {
			List<InventoryItemFacilityDto> inventoryItemDtos = inventoryItemService.getFacilityInventories(facilityId);
			return Response.status(Response.Status.OK).entity(inventoryItemDtos).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
	}

}
