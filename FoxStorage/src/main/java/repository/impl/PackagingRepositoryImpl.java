package repository.impl;

import model.Packaging;
import repository.PackagingRepository;
import repository.util.BaseRepositoryImpl;

public class PackagingRepositoryImpl extends BaseRepositoryImpl<Packaging> implements PackagingRepository{

	public PackagingRepositoryImpl() {
		super(Packaging.class);
	}

}
