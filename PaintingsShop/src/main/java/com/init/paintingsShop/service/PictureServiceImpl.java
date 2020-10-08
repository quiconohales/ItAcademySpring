package com.init.paintingsShop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.paintingsShop.dao.IPictureDAO;
import com.init.paintingsShop.dto.Picture;

@Service
public class PictureServiceImpl implements IPictureService {

	@Autowired
	IPictureDAO ipictureDAO;
	
	@Override
	public Picture savePicture(Picture picture) {
	
		return ipictureDAO.save(picture);
	}
//	@Override
//	public Picture savePictureShop(Integer shop_id,Picture picture) {
//	
//		return ipictureDAO.save(picture);
//	}
	@Override
	public List<Picture> listPictures() {
		return ipictureDAO.findAll();
		//return ipictureDAO.findAllById(Iterable<integer>,integer);	
		//return null;
	}
	
	@Override
	public List<Picture> listPicturesbyShop(Integer Shop_id){
		return ipictureDAO.findAll();
	}
	@Override
	public void deletePicture(Picture picture) {
	}

}
