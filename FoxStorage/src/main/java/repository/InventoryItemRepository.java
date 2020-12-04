package repository;

import model.Facility;
import model.InventoryItem;
import model.Product;
import repository.util.BaseRepository;

public interface InventoryItemRepository extends BaseRepository<InventoryItem> {

	InventoryItem getByFacilityAndProduct(Facility facility, Product product);
}
