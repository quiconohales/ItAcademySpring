package com.init.paintingsShop.service;

import java.util.List;

import com.init.paintingsShop.dto.Picture;

public interface IPictureService {
	
	public Picture savePicture(Picture picture);
	public List<Picture> listPictures();
	public void deletePicture(Picture picture);
	public List<Picture> listPicturesbyShop(Integer shop_id);
	//public Picture savePictureShop(Integer shop_id,Picture picture);

}
