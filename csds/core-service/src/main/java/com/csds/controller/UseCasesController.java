package com.csds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csds.response.ResponseObject;
import com.csds.service.UseCasesServices;

@RestController
@RequestMapping(value = "/api/v1")
public class UseCasesController {

	private static final Logger logger = LoggerFactory.getLogger(UseCasesController.class);


	@Autowired
	private UseCasesServices useCaseService;

	@GetMapping(value = "/use-cases")
	public ResponseEntity<ResponseObject> getListOfUseCases() {

		logger.info("Started UseCasesController Controller  for : getListOfUseCases");
		return ResponseEntity.ok(useCaseService.getUseCases());
	}


}