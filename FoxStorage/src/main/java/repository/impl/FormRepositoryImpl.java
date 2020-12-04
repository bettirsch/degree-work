package repository.impl;

import java.util.List;

import javax.persistence.Query;

import model.Form;
import repository.FormRepository;
import repository.util.BaseRepositoryImpl;
import utils.enums.FormType;

public class FormRepositoryImpl extends BaseRepositoryImpl<Form> implements FormRepository{

	public FormRepositoryImpl() {
		super(Form.class);
	}

	@Override
	public List<Form> getAllFormByType(FormType type){
		return createTypedQueryResultList(Form.GET_ALL_BY_FORMTYPE, "formType", type);
	}

	@Override
	public String getLastFormNrByFormType(FormType formType) {
		Query query = getEntityManager().createNamedQuery(Form.GET_FORMNR_BY_FORMTYPE);
		query.setParameter("formType", formType);
		Object result = query.getSingleResult();
		return (result == null) ? null : (String) result;
	}
}
