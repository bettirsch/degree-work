package repository.impl;

import model.CompanyInfo;
import repository.CompanyInfoRepository;
import repository.util.BaseRepositoryImpl;

public class CompanyInfoRepositoryImpl extends BaseRepositoryImpl<CompanyInfo> implements CompanyInfoRepository {

	public CompanyInfoRepositoryImpl() {
		super(CompanyInfo.class);
	}

}
