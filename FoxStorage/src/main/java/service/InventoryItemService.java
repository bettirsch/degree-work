package service;

import java.util.List;

import dto.InventoryItemFacilityDto;
import dto.InventoryItemProductDto;

public interface InventoryItemService {

	List<InventoryItemProductDto> getProductInventories(Integer productId);

	List<InventoryItemFacilityDto> getFacilityInventories(Integer facilityId);

}
