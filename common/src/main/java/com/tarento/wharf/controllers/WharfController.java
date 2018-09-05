package com.tarento.wharf.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.dtos.UserDetailsDto;
import com.tarento.wharf.models.Project;
import com.tarento.wharf.models.Task;
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

	@RequestMapping(value = "/getProjectPeUser", method = RequestMethod.GET)
	public List<Project> getProjectPeUser(@RequestParam(value = "id") Long id) throws JsonProcessingException {
		Map<Long, Object> map=new HashMap<>();
		UserDetailsDto userDetail=wharfService.validateUser(id);
		if(userDetail!=null) {
			map.put(id, userDetail);
			wharfService.getProjectPeUser(map);
		}
		//return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.USER_UNAVAILABLE);
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
		if (project.getId() == null) {
			Project project1 = wharfService.create(project);
			if (project1 != null) {
				return ResponseGenerator.successResponse(project1);
			} else
				return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.XYZ);

		} else {
			Project project1 = wharfService.update(project);
			if (project1 != null) {
				return ResponseGenerator.successResponse(project1);
			} else
				return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.XYZ);
		}

	}

	///////// ADD TASK //////////////////////////////////////

	@RequestMapping(value = "/addTask", method = RequestMethod.POST)
	public String addTask(@RequestBody Task task, BindingResult result) throws JsonProcessingException {
		if (task != null) {
			if (StringUtils.isBlank(task.getName())) {
				return ("Project name cant be empty");
			}
		}
		if (task.getId() == null) {
			Task task1 = wharfService.create(task);
			if (task1 != null) {
				return ResponseGenerator.successResponse(task1);
			} else
				return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.XYZ);

		} else {
			Task task1 = wharfService.update(task);
			if (task1 != null) {
				return ResponseGenerator.successResponse(task1);
			} else
				return ResponseGenerator.failureResponse(ResponseMessages.ErrorMessages.XYZ);
		}

	}

}
