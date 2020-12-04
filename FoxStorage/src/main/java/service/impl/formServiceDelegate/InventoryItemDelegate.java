package service.impl.formServiceDelegate;

import javax.ejb.Stateless;
import javax.inject.Inject;

import model.Facility;
import model.InventoryItem;
import model.Product;
import repository.InventoryItemRepository;
import utils.logger.Loggable;

@Loggable
@Stateless
public class InventoryItemDelegate {

	@Inject
	private InventoryItemRepository inventoryItemRepo;
	
	public void reserveQuantity(Facility facility, Product product, Double quantity) throws RuntimeException{
		try {
			InventoryItem inventoryItem = inventoryItemRepo.getByFacilityAndProduct(facility, product);
			if (inventoryItem.getQuantity() >= quantity) {
				inventoryItem.setQuantity(inventoryItem.getQuantity()-quantity);
				inventoryItem.setQuantityReserved(inventoryItem.getQuantityReserved()+quantity);
				inventoryItemRepo.update(inventoryItem);
			}else {
				throw new RuntimeException("Nincs elegendő termék raktáron!");
			}
		}catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a mennyiséget lefoglalni a raktárkészletetből!");
		}
	}
	
	public void unReserveQuantity(Facility facility, Product product, Double quantity) throws RuntimeException{
		reserveQuantity(facility, product, quantity * (-1));
	}
	
}
