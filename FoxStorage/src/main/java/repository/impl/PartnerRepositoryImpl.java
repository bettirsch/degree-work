package repository.impl;

import model.Partner;
import repository.PartnerRepository;
import repository.util.BaseRepositoryImpl;

public class PartnerRepositoryImpl extends BaseRepositoryImpl<Partner> implements PartnerRepository{

	public PartnerRepositoryImpl() {
		super(Partner.class);
	}

}
