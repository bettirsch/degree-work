package repository.impl;

import model.Facility;
import repository.FacilityRepository;
import repository.util.BaseRepositoryImpl;

public class FacilityRepositoryImpl extends BaseRepositoryImpl<Facility> implements FacilityRepository{

	public FacilityRepositoryImpl() {
		super(Facility.class);
	}

}
