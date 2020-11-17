package repository.impl;

import model.Contact;
import repository.ContactRepository;
import repository.util.BaseRepositoryImpl;

public class ContactRepositoryImpl extends BaseRepositoryImpl<Contact> implements ContactRepository {

	public ContactRepositoryImpl() {
		super(Contact.class);
	}

}
