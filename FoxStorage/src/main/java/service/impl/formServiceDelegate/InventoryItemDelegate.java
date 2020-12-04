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

	public void reserveQuantity(Facility facility, Product product, Double quantity) throws RuntimeException {
		try {
			InventoryItem inventoryItem = inventoryItemRepo.getByFacilityAndProduct(facility, product);
			if (inventoryItem.getQuantity() >= quantity) {
				inventoryItem.setQuantity(inventoryItem.getQuantity() - quantity);
				inventoryItem.setQuantityReserved(inventoryItem.getQuantityReserved() + quantity);
				inventoryItemRepo.update(inventoryItem);
			} else {
				throw new RuntimeException("Nincs elegendő termék raktáron!");
			}
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a mennyiséget lefoglalni a raktárkészletetből!");
		}
	}

	public void unReserveQuantity(Facility facility, Product product, Double quantity) throws RuntimeException {
		try {
			InventoryItem inventoryItem = inventoryItemRepo.getByFacilityAndProduct(facility, product);
			inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
			inventoryItem.setQuantityReserved(inventoryItem.getQuantityReserved() - quantity);
			inventoryItemRepo.update(inventoryItem);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a foglalt mennyiséget visszarakni a raktárkészletetbe!");
		}
	}

	public void removeQuantity(Facility facility, Product product, Double quantity) throws RuntimeException {
		try {
			quantityMove(facility, product, (-1)*quantity);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a foglalt mennyiséget levonni a raktárkészletetből!");
		}
	}
	
	public void addQuantity(Facility facility, Product product, Double quantity) throws RuntimeException {
		try {
			quantityMove(facility, product, quantity);
		} catch (Exception e) {
			throw new RuntimeException("Nem sikerült a mennyiséget a raktárkészlethez adni!");
		}
	}

	private void quantityMove(Facility facility, Product product, Double quantity) {
		InventoryItem inventoryItem = inventoryItemRepo.getByFacilityAndProduct(facility, product);
		inventoryItem.setQuantity(inventoryItem.getQuantity() + quantity);
		inventoryItemRepo.update(inventoryItem);
	}
}
