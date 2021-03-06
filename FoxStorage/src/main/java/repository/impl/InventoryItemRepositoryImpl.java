package repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Facility;
import model.InventoryItem;
import model.Product;
import repository.InventoryItemRepository;
import repository.util.BaseRepositoryImpl;

public class InventoryItemRepositoryImpl extends BaseRepositoryImpl<InventoryItem> implements InventoryItemRepository {

	public InventoryItemRepositoryImpl() {
		super(InventoryItem.class);
	}
	
	@Override
	public InventoryItem getByFacilityAndProduct(Facility facility, Product product) {
		Map<String, Object> queryParamMap = new HashMap<>();
		queryParamMap.put("facility", facility);
		queryParamMap.put("product", product);
		return createTypedQuerySingleResult(InventoryItem.GET_BY_FACILITY_AND_PRODUCT, queryParamMap);
	}

	@Override
	public List<InventoryItem> findByProductId(Integer productId) {
		return createTypedQueryResultList(InventoryItem.GET_BY_PRODUCT_ID, "productId", productId);
	}

	@Override
	public List<InventoryItem> findByFacilityId(Integer facilityId) {
		return createTypedQueryResultList(InventoryItem.GET_BY_FACILITY_ID, "facilityId", facilityId);
	}

}
