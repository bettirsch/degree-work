package service.mapper.reslover;

import javax.inject.Inject;

import model.Partner;
import repository.PartnerRepository;

public class PartnerMapperResolver {

	@Inject
	private PartnerRepository repo;
	
	public Partner map(Integer value) {
		if (value != null) {
			return repo.find(value);
		}
		//should throw exception?
		return null;
	}

}
