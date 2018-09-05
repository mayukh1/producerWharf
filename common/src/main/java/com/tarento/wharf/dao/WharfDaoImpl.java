package com.tarento.wharf.dao;

import org.springframework.stereotype.Repository;

import com.tarento.wharf.dtos.UserDetailsDto;

@Repository(value="dao")
public class WharfDaoImpl implements WharfDao {

	@Override
	public UserDetailsDto validateUser(Long id) {
		return null;
	}

}
