package com.demo.comptency.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.demo.comptency.model.SkillDto;
import com.demo.comptency.service.CompetencyService;

@Service
public class CompetencyServiceImpl implements CompetencyService {

	@Value("${skills.path}")
	String FILEPATH;
	
	private static final Logger LOG = LoggerFactory.getLogger(CompetencyServiceImpl.class);

	@Override
	public List<SkillDto> getAllCompetence() throws IOException {
		LOG.info("CompetencyServiceImpl: getAllCompetence");
		return convertCsvToPojo();
	}

	private List<SkillDto> convertCsvToPojo() throws IOException {
		LOG.info("CompetencyServiceImpl: convertCsvToPojo");
		
		List<SkillDto> competencyList = new ArrayList<>();
		if(FILEPATH.isEmpty())
			throw new IOException("Filepath can't be empty");
		
		Path path = Paths.get(FILEPATH); // Skipping the Logic for edge cases if file not present for simplicity
		try (BufferedReader br = Files.newBufferedReader(path)) {
			br.readLine(); //Skip the headers
			
			String row = br.readLine();
			while (null != row ) {
				String[] attribute = row.split(",");
				SkillDto competencyDTO = getCompetencyObject(attribute);
				competencyList.add(competencyDTO);
				row = br.readLine();
			}
		}

		return competencyList;
	}

	private SkillDto getCompetencyObject(String[] attribute) {

		LOG.info("CompetencyServiceImpl: getCompetencyObject");
		
		SkillDto competencyDTO = new SkillDto();
		competencyDTO.setCapabilityId(attribute[0]);
		competencyDTO.setName(attribute[1]);
		competencyDTO.setDescription(attribute[2]);
		competencyDTO.setModifiedDate(attribute[3]);
		competencyDTO.setSourceId(attribute[4]);
		competencyDTO.setSource(attribute[5]);
		competencyDTO.setStatusId(attribute[6]);
		competencyDTO.setStatus(attribute[7]);
		competencyDTO.setTypeId(attribute[8]);
		competencyDTO.setType(attribute[9]);
		competencyDTO.setVersion(attribute[10]);
		return competencyDTO;
	}

}
