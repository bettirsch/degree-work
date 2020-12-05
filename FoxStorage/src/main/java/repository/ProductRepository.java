package repository;

import model.Product;
import repository.util.BaseRepository;

public interface ProductRepository extends BaseRepository<Product>{
	
	Integer countByNameExceptThisId(String productName, Integer id);

	Integer countByEanExceptThisId(String productEan, Integer id);

	Integer countByItemNrExceptThisId(String itemNr, Integer id);

}
