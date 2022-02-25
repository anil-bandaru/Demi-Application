package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.api.PostalData;
import com.example.demo.repository.PostalDataRepository;

@Service
public class PostalDataServiceImpl implements  PostalDataService{
	@Autowired
	PostalDataRepository postalRepo;
	
	@Transactional
	@Override
	public void savePostalData(List<PostalData> postalDtos) {
		postalDtos.forEach(postalRepo::save);
	}

	@Override
	public Map<String, Object> getSuburbNames(List<Integer> postCodes) {
		List<PostalData> postalDataList=postalRepo.findByCodeInOrderBySuburbname(postCodes);
		
		int characterLength=(postalDataList!=null&&!postalDataList.isEmpty())?
			postalDataList.stream().map(data->{return data.getSuburbname();}).mapToInt(String::length).sum()
			:0;
		
		Map<String,Object> responseMap=new HashMap<>();
		responseMap.put("data", postalDataList);
		responseMap.put("characterLength", characterLength);
		return responseMap;
	}
	
	
}
