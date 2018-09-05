package com.tarento.wharf.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tarento.wharf.dao.WharfDao;
import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.dtos.UserDetailsDto;
import com.tarento.wharf.models.Project;
import com.tarento.wharf.models.Task;

@Service(value = "wharfService")

public class WharfServiceImpl implements WharfService {
	public static final Logger LOGGER = LoggerFactory.getLogger(WharfServiceImpl.class);
	@Autowired
	private WharfDao dao;
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	private static final String TOPIC = "Kafka_Publish_Project";
	private static final String TOPIC1 = "Kafka_Publish_Task";

	@Override
	public Project create(Project project) {
		System.out.println("hello");
		kafkaTemplate.send(TOPIC, project);
		return null;
	}

	@Override
	public Project update(Project project) {
		return null;
	}

	@Override
	public Task create(Task task) {
		kafkaTemplate.send(TOPIC1, task);
		return null;
	}

	@Override
	public Task update(Task task) {
		return null;
	}

	@Override
	public UserDetailsDto validateUser(Long id) {
		UserDetailsDto userDetails = dao.validateUser(id);
		return userDetails;
	}

	@Override
	public List<ProjectDto> getProjectPeUser(Map<Long, Object> map) {
		ProjectDto project=new ProjectDto();
			RestTemplate restTemplate = new RestTemplate();
			final String URL_GET_PROJECT = "10.173.0.0";
			HttpHeaders headers = getHttpHeaders();
			try{
				String userOutput = restTemplate.postForObject(URL_GET_PROJECT,map, String.class);
				//user = restTemplate.postForObject(URL_GET_PROJECT,map, String.class);
			}catch (Exception ex){
				LOGGER.error("Encountered an exception while getting User By Token "  + ex);
			}

		
		return null;
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

}
