package repository.impl;

import model.Price;
import repository.PriceRepository;
import repository.util.BaseRepositoryImpl;

public class PriceRepositoryImpl extends BaseRepositoryImpl<Price> implements PriceRepository{

	public PriceRepositoryImpl() {
		super(Price.class);
	}

}
