package service.util;

import javax.ejb.Stateless;
import javax.inject.Inject;

import service.mapper.ModelMapper;

@Stateless
public abstract class BaseServiceImpl {

	@Inject
	private ModelMapper mapper;

	protected ModelMapper getMapper() {
		return mapper;
	}
}
