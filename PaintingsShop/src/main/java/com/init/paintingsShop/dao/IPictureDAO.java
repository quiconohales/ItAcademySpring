package com.init.paintingsShop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.paintingsShop.dto.Picture;


public interface IPictureDAO extends JpaRepository <Picture,Integer>{

}
