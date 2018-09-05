package com.tarento.wharf.controllers;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.models.Project;
import com.tarento.wharf.service.WharfService;
import com.tarento.wharf.util.ResponseGenerator;
import com.tarento.wharf.util.ResponseMessages;

@RestController
@RequestMapping("/wharf")
public class WharfController {
	@Autowired
	private WharfService wharfService;

	public static final org.slf4j.Logger logger = LoggerFactory.getLogger(WharfController.class);

	///////// GET LIST OF PROJECTS //////////////////////////////

	@RequestMapping(value = "/getProject", method = RequestMethod.GET)
	public List<Project> getProjects() throws JsonProcessingException {
		System.out.println("I AM INSIDE THE CONTROLLER");
		//List<Project> project=wharfService.getProjects();
		return null;
	}

	///////// ADD PROJECTS //////////////////////////////////////

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addProject(@RequestBody Project project, BindingResult result) throws JsonProcessingException {
		if (project != null) {
			if (StringUtils.isBlank(project.getName())) {
				return ("Project name cant be empty");
			}
		}
		if (project.getId()== null) {
			Project project1 = wharfService.create(project);
				if (project1 != null) {
					return ResponseGenerator.successResponse(project1);
				} else
					return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.FEATURE_CODE_UNAVAILABLE);
		
		} else {
			Project project1 = wharfService.update(project);
			if (project1 != null) {
				return ResponseGenerator.successResponse(project1);
			} else
				return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.FEATURE_DETAILS_UNAVAILABLE);
		}

	}

}
