package com.tarento.wharf.dao;

import com.tarento.wharf.dtos.UserDetailsDto;

public interface WharfDao {
	public UserDetailsDto validateUser(Long id);

}
