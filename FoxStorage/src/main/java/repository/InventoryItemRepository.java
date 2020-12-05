package repository;

import java.util.List;

import model.Facility;
import model.InventoryItem;
import model.Product;
import repository.util.BaseRepository;

public interface InventoryItemRepository extends BaseRepository<InventoryItem> {

	InventoryItem getByFacilityAndProduct(Facility facility, Product product);

	List<InventoryItem> findByProductId(Integer productId);

	List<InventoryItem> findByFacilityId(Integer facilityId);
}
