package com.demo.comptency.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.comptency.model.SkillDto;
import com.demo.comptency.service.CompetencyService;

import io.swagger.annotations.Api;

@RestController
@Api(value = "Competence Controller", description = "Operations pertaining to Skills Data from CSOD")
public class CompetencyController {

	@Autowired
	private CompetencyService competencyService;

	private static final Logger LOG = LoggerFactory.getLogger(CompetencyController.class);

	@GetMapping(value = "/comptency", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SkillDto>> getCompetencyList() throws IOException {

		LOG.info("CompetencyController: getCompetencyList");
		return ResponseEntity.status(HttpStatus.OK).body(competencyService.getAllCompetence());
	}
}
