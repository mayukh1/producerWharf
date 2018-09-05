package com.tarento.wharf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.models.Project;

@Service(value = "wharfService")

public class WharfServiceImpl implements WharfService {
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	 private static final String TOPIC = "Kafka_Publish_Project";

	@Override
	public Project create(Project project) {
		System.out.println("hello");
		kafkaTemplate.send(TOPIC, project);
		return null;
	}

	@Override
	public List<ProjectDto> getProjects() {

		return null;
	}

	@Override
	public Project update(Project project) {
		return null;
	}

}
