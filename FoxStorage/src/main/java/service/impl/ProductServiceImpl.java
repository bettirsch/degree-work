package service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import dto.ProductDto;
import model.Facility;
import model.InventoryItem;
import model.Price;
import model.Product;
import repository.FacilityRepository;
import repository.InventoryItemRepository;
import repository.ProductRepository;
import service.ProductService;
import service.util.BaseServiceImpl;
import utils.logger.Loggable;

@Transactional
@Loggable
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Inject
	private ProductRepository productRepo;

	@Inject
	private InventoryItemRepository inventoryItemRepo;

	@Inject
	private FacilityRepository facilityRepo;

	@Override
	public ProductDto getProduct(Integer entityId) {
		Product findedProduct = findProduct(entityId);
		return getMapper().convert(findedProduct);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> entityList = productRepo.findAll();
		List<ProductDto> dtoList = new ArrayList<>();
		for (Product entity : entityList) {
			dtoList.add(getMapper().convert(entity));
		}
		return dtoList;
	}

	@Override
	public Integer createProduct(ProductDto dto) {
		Product createdProduct = productRepo.create(getMapper().convert(dto));
		List<Facility> allFacility = facilityRepo.findAll();
		for (Facility facility : allFacility) {
			InventoryItem inventoryItem = new InventoryItem();
			inventoryItem.setFacility(facility);
			inventoryItem.setProduct(createdProduct);
			inventoryItemRepo.create(inventoryItem);
		}
		return createdProduct.getId();
	}

	@Override
	public ProductDto updateProduct(Integer id, ProductDto dto) throws RuntimeException {
		Integer isNameExists = productRepo.countByNameExceptThisId(dto.getProductName(), id);
		if (isNameExists != 0) {
			throw new RuntimeException("Ezzel a névvel már létezik temék!");
		}
		Integer isEanExists = productRepo.countByEanExceptThisId(dto.getProductEan(), id);
		if (isEanExists != 0) {
			throw new RuntimeException("Ezzel az ean-nal már létezik temék!");
		}
		Integer isItemNrExists = productRepo.countByItemNrExceptThisId(dto.getItemNr(), id);
		if (isItemNrExists != 0) {
			throw new RuntimeException("Ezzel a cikkszámmal már létezik temék!");
		}
		Product updatableProduct = findProduct(id);
		updatableProduct.setBaseMeasuringUnit(dto.getBaseMeasuringUnit());
		Price basePrice = new Price();
		basePrice.setNetUnitPrice(dto.getBaseNetUnitPrice());
		basePrice.setVatRate(dto.getBaseVatRate());
		updatableProduct.setBasePrice(basePrice);
		updatableProduct.setItemNr(dto.getItemNr());
		updatableProduct.setProductEan(dto.getProductEan());
		updatableProduct.setProductName(dto.getProductName());
		Product updatedProduct = productRepo.update(updatableProduct);
		return getMapper().convert(updatedProduct);
	}
	
	@Override
	public void softDeleteProduct(Integer id) {
		Product findedProduct = findProduct(id);
		findedProduct.setDeleted(true);
		productRepo.update(findedProduct);
	}
	
	private Product findProduct(Integer id) {
		Product product = productRepo.find(id);
		if (product == null) {
			throw new RuntimeException("A termék nem található az adatbázisban!");
		}
		return product;
	}
}
