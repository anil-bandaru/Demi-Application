package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.api.PostalData;

public interface PostalDataRepository extends CrudRepository<PostalData, Long> {
	List<PostalData> findByCodeInOrderBySuburbname(List<Integer> postalCodes);
}
