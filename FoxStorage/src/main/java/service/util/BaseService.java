package service.util;

import java.util.List;

import dto.BaseDto;
import model.BaseModel;

public interface BaseService<D extends BaseDto, E extends BaseModel> {

	List<D> getAllInstances();

	D getInstance(Integer entityId);

	Integer createInstance(D dto);


}
