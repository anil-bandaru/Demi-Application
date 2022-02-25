package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.api.PostalData;
import com.example.demo.service.PostalDataService;
import com.example.demo.util.Constants;
import com.example.demo.util.GlobalResponseUtil;

@RestController
public class PostalDataController {

	@Autowired
	PostalDataService postalDataService;

	@GetMapping("/getSuburbanData")
	public ResponseEntity<Object> getSuburbanData(@RequestBody List<Integer> postalCodes) {
		GlobalResponseUtil responseUtil=null;
		HttpStatus status=null;
		try {
		Map<String, Object> response=postalDataService.getSuburbNames(postalCodes);
		status=HttpStatus.OK;
		responseUtil=new GlobalResponseUtil(status,response,Constants.Success_Message);
	} catch (Exception e) {
		status=HttpStatus.INTERNAL_SERVER_ERROR;
		responseUtil=new GlobalResponseUtil(status,null,Constants.AppInternalServerError);
	}
	return ResponseEntity.status(status).body(responseUtil);
	}

	@PostMapping("/add")
	public ResponseEntity<GlobalResponseUtil> updatePostalInfo(@RequestBody List<PostalData> inputDatas) {
		GlobalResponseUtil responseUtil=null;
		HttpStatus status=null;
		try {
			postalDataService.savePostalData(inputDatas);
			status=HttpStatus.OK;
			responseUtil=new GlobalResponseUtil(status,null,Constants.Success_Message);
		} catch (Exception e) {
			status=HttpStatus.INTERNAL_SERVER_ERROR;
			responseUtil=new GlobalResponseUtil(status,null,Constants.AppInternalServerError);
		}
		return ResponseEntity.status(status).body(responseUtil);
	}

}
