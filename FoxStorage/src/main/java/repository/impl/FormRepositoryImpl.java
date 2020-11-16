package repository.impl;

import model.Form;
import repository.FormRepository;
import repository.util.BaseRepositoryImpl;

public class FormRepositoryImpl extends BaseRepositoryImpl<Form> implements FormRepository{

	public FormRepositoryImpl() {
		super(Form.class);
	}

}
