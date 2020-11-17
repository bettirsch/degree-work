package repository.impl;

import model.InventoryItem;
import repository.InventoryItemRepository;
import repository.util.BaseRepositoryImpl;

public class InventoryItemRepositoryImpl extends BaseRepositoryImpl<InventoryItem> implements InventoryItemRepository {

	public InventoryItemRepositoryImpl() {
		super(InventoryItem.class);
	}

}
