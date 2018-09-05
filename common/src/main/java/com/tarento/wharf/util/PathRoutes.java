package com.tarento.wharf.util;

/**
 * 
 * @author Darshan Nagesh
 *
 */

public interface PathRoutes {
	
	public interface UserRoutes { 
		final String USER_ACTIONS_POST = "/actions/_get" ;
		final String COUNTRY_LIST_GET = "/getCountryList"; 
		final String COUNTRY_LIST_USER_GET = "/getCountryList/{id}"; 
		final String EMPLOYMENT_TYPES_GET = "/getEmploymentTypes" ; 
		final String NUMBER_OF_USERS_GET = "/getNumberOfUsers";
		final String NUMBER_OF_ROLES_GET = "/getNumberOfRoles"; 
		final String LIST_USER_GET = "/user" ; 
		final String USER_BY_ID_GET = "/user/{id}";
		final String CREATE_UPDATE_USER_POST = "/createOrUpdate"; 
		final String USER_ROLE_MAPPING_POST = "/role/mapping";
		final String USER_COUNTRY_MAPPING_POST ="/country/mapping";
		final String USER_DETAILS_GET = "/getUserDetails"; 
		final String SINGLE_FILE_UPLOAD_POST = "/upload"; 
		final String IMAGE_GET = "/images"; 
		final String USER_DEVICE_TOKEN_POST="/updateUserDeviceToken"; 
	}
}
