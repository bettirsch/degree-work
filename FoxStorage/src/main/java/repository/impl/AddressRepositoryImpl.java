package repository.impl;

import model.Address;
import repository.AddressRepository;
import repository.util.BaseRepositoryImpl;

public class AddressRepositoryImpl extends BaseRepositoryImpl<Address> implements AddressRepository {

	public AddressRepositoryImpl() {
		super(Address.class);
	}

}
