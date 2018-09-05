package com.tarento.wharf.service;

import java.util.List;

import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.models.Project;

public interface WharfService {
	public Project create (Project project);
	public List<ProjectDto> getProjects();
	public Project update (Project project);

}
