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
		Map<String, Object> response=postalDataService.getSuburbNames(postalCodes);
		responseUtil=new GlobalResponseUtil(HttpStatus.OK,response,Constants.Success_Message);
		return ResponseEntity.ok().body(responseUtil);
	}

	@PostMapping("/add")
	public ResponseEntity<GlobalResponseUtil> updatePostalInfo(@RequestBody List<PostalData> inputDatas) {
		GlobalResponseUtil responseUtil=null;
		postalDataService.savePostalData(inputDatas);
		status=HttpStatus.OK;
		responseUtil=new GlobalResponseUtil(HttpStatus.OK,null,Constants.Success_Message);
		return ResponseEntity.status(status).body(responseUtil);
	}

}
