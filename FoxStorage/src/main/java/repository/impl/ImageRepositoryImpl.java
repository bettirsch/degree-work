package repository.impl;

import model.Image;
import repository.ImageRepository;
import repository.util.BaseRepositoryImpl;

public class ImageRepositoryImpl extends BaseRepositoryImpl<Image> implements ImageRepository {

	public ImageRepositoryImpl() {
		super(Image.class);
	}

}
