package com.tarento.wharf.service;

import java.util.List;
import java.util.Map;

import com.tarento.wharf.dtos.ProjectDto;
import com.tarento.wharf.dtos.UserDetailsDto;
import com.tarento.wharf.models.Project;
import com.tarento.wharf.models.Task;

public interface WharfService {
	
	public UserDetailsDto validateUser(Long id);
	public Project create (Project project);
	public List<ProjectDto> getProjectPeUser(Map<Long, Object> map);
	public Project update (Project project);
	public Task create (Task task);
	public Task update (Task task);

}
