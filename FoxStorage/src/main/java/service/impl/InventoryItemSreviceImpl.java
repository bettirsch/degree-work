package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.InventoryItemFacilityDto;
import dto.InventoryItemProductDto;
import model.InventoryItem;
import repository.InventoryItemRepository;
import service.InventoryItemService;
import service.util.BaseServiceImpl;
import utils.logger.Loggable;

@Transactional
@Loggable
public class InventoryItemSreviceImpl extends BaseServiceImpl implements InventoryItemService{

	@Inject
	private InventoryItemRepository inventoryItemRepo;
	
	@Override
	public List<InventoryItemProductDto> getProductInventories(Integer productId) {
		List<InventoryItem> findedInventoryItems = inventoryItemRepo.findByProductId(productId);
		List<InventoryItemProductDto> inventoryItemDtos = new ArrayList<>();
		for (InventoryItem inventoryItem : findedInventoryItems) {
			InventoryItemProductDto dto = new InventoryItemProductDto();
			dto.setFacilityName(inventoryItem.getFacility().getName());
			dto.setQuantity(inventoryItem.getQuantity());
			dto.setQuantityReserved(inventoryItem.getQuantityReserved());
			inventoryItemDtos.add(dto);
		}
		return inventoryItemDtos;
	}

	@Override
	public List<InventoryItemFacilityDto> getFacilityInventories(Integer facilityId) {
		List<InventoryItem> findedInventoryItems = inventoryItemRepo.findByFacilityId(facilityId);
		List<InventoryItemFacilityDto> inventoryItemDtos = new ArrayList<>();
		for (InventoryItem inventoryItem : findedInventoryItems) {
			inventoryItemDtos.add(getMapper().convert(inventoryItem));
		}
		return inventoryItemDtos;
	}

}
