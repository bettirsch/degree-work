package repository.impl;

import model.Site;
import repository.SiteRepository;
import repository.util.BaseRepositoryImpl;

public class SiteRepositoryImpl extends BaseRepositoryImpl<Site> implements SiteRepository{

	public SiteRepositoryImpl() {
		super(Site.class);
	}

}
