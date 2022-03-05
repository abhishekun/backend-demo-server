package com.demo.comptency.service;

import java.io.IOException;
import java.util.List;

import com.demo.comptency.model.SkillDto;


public interface CompetencyService {

	List<SkillDto> getAllCompetence() throws IOException; 
}
