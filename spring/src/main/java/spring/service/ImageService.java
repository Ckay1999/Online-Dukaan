package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo_models.Images;
import spring.dao.ImageDao;

@Service
public class ImageService {
	@Autowired
	private ImageDao imageDao;
	
	public int imageUpload(Images img) {
		return this.imageDao.saveImage(img);
	}
}

