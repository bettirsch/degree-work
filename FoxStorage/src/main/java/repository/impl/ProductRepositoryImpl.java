package repository.impl;

import javax.persistence.Query;

import model.Product;
import repository.ProductRepository;
import repository.util.BaseRepositoryImpl;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {

	public ProductRepositoryImpl() {
		super(Product.class);
	}

	@Override
	public Integer countByNameExceptThisId(String productName, Integer id) {
		Query query = getEntityManager().createNamedQuery(Product.COUNT_BY_NAME_EXCEPT_THIS_ID);
		query.setParameter("productName", productName);
		query.setParameter("id", id);
		return Math.toIntExact((long) query.getSingleResult());
	}

	@Override
	public Integer countByEanExceptThisId(String productEan, Integer id) {
		Query query = getEntityManager().createNamedQuery(Product.COUNT_BY_EAN_EXCEPT_THIS_ID);
		query.setParameter("productEan", productEan);
		query.setParameter("id", id);
		return Math.toIntExact((long) query.getSingleResult());
	}

	@Override
	public Integer countByItemNrExceptThisId(String itemNr, Integer id) {
		Query query = getEntityManager().createNamedQuery(Product.COUNT_BY_ITEMNR_EXCEPT_THIS_ID);
		query.setParameter("itemNr", itemNr);
		query.setParameter("id", id);
		return Math.toIntExact((long) query.getSingleResult());
	}

}
