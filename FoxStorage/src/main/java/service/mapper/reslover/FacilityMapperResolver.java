package service.mapper.reslover;

import javax.inject.Inject;

import model.Facility;
import repository.FacilityRepository;

public class FacilityMapperResolver{

	@Inject
	private FacilityRepository repo;

	public Facility map(Integer value) {
		if (value != null) {
			return repo.find(value);
		}
		//should throw exception?
		return null;
	}

}
