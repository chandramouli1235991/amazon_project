package com.amazon.service;

import com.amazon.dao.AmazonDAO;
import com.amazon.dao.AmazonDAOInterface;
import com.amazon.entity.AmazonUser;

public class AmazonService implements  AmazonServiceInterface {

	public static AmazonServiceInterface createServiceObject() {
	
		return new AmazonService();
	}

	
	public int createProfile(AmazonUser au) {
		AmazonDAOInterface ad=AmazonDAO.createDaoObject("f");
		int i = ad.createProfileDao(au);
		
		return 1;
	}

}
