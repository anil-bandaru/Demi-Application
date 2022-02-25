package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.api.PostalData;

public interface PostalDataService {

	void savePostalData(List<PostalData> postalDtos);
	Map<String, Object> getSuburbNames(List<Integer> postCodes);

}
