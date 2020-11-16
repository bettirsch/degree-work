package repository.impl;

import model.FormItem;
import repository.FormItemRepository;
import repository.util.BaseRepositoryImpl;

public class FormItemRepositoryImpl extends BaseRepositoryImpl<FormItem> implements FormItemRepository{

	public FormItemRepositoryImpl() {
		super(FormItem.class);
	}

}
