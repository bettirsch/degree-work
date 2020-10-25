package service.util;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dto.BaseDto;
import model.BaseModel;
import repository.util.BaseRepository;

/**
 *
 * @author spdue4cb
 */
@Stateless
public abstract class BaseServiceImpl<D extends BaseDto, E extends BaseModel> implements BaseService<D, E>{
    
	@Inject
    private BaseRepository<E> repository;
	
	public BaseRepository<E> getRepository() {
		return repository;
	}

	protected void setRepository(Class<E> classE) {
    	this.repository.setRepository(classE);
    }
	
}