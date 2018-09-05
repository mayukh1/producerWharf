package com.tarento.wharf.util;

/**
 * This interface will hold all the SQL Quries which are being used by the application
 * Internally, the inner interface will have the queries separated based on the functionalities that they are associated with
 *  
 * @author Darshan Nagesh
 *
 */
public interface Sql {
	
		final String ID = "id";
		
		/**
		 * All the queries associated with the Common activities or transactions will be placed here
		 * @author Darshan Nagesh
		 *
		 */
		public interface Common {
			final String VERIFY_PASSWORD = "SELECT id FROM user WHERE password = ? AND username = ? ";
			final String WHERE_CLAUSE = " WHERE "; 
			final String AND_CONDITION = " AND ";
			final String OR_CONDITION = " OR "; 
			final String OPEN_BRACE = "("; 
			final String CLOSE_BRACE = ")"; 
			final String GET_COUNTRY_LIST = "SELECT id, name, code, currency, phone_code, FALSE as is_default FROM country ";
			final String GET_COUNTRY_LIST_FOR_USER = "SELECT c.id, c.name, c.code, c.currency, c.phone_code, cu.is_default FROM country c left join country_user cu ON c.id = cu.country_id where cu.user_id = ?"; 

		}
		
		public interface RoleAction { 
			final String GET_ALL_ROLES = "SELECT id, role_name, description, priority FROM musti_role" ;
			final String SELECT_ROLES_ON_ID = "SELECT id, role_name, description, priority FROM musti_role WHERE id=?" ; 
			final String SELECT_ROLE_ACTIONS_ON_ROLEID = "SELECT * FROM musti_role_actions WHERE role_id=?"; 
			final String SELECT_ACTIONS_ON_ID ="SELECT * FROM musti_actions WHERE id=?"; 
			final String SAVE_NEW_ROLE = "INSERT INTO musti_role (description, role_name, priority) VALUES (? ,?, ?)"; 
			final String UPDATE_ROLE = "UPDATE musti_role SET role_name = ?, description = ?, priority = ? WHERE id = ? "; 
			final String INSERT_ACTION = "INSERT INTO musti_actions (description, module_code, module_name, url) VALUES (?, ?, ?, ?)"; 
		}
		
		public interface UserQueries {
			final String SELECT_USER_BY_TOKEN = "SELECT COUNT(*) FROM user_authentication WHERE auth_token = ? " ;
			final String SELECT_USER_ON_USERNAME = "SELECT * FROM user WHERE username=?";
			final String MAP_USER_TO_ROLE = "INSERT INTO musti_user_role (user_id, role_id) VALUES (?, ?)" ; 
			final String MAP_USER_TO_COUNTRY = "INSERT INTO country_user (user_id, country_id, is_default) VALUES (?, ?, ?)" ; 
			final String REMOVE_USER_ROLE_MAP = "DELETE FROM musti_user_role WHERE user_id = ? ";
			final String REMOVE_USER_COUNTRY_MAP = "DELETE FROM country_user WHERE user_id = ? ";

			final String INSERT_USER_PROFILE = "INSERT INTO user_profile (user_id, first_name, last_name, age, phone_number, dob, gender, " + 
					"avatar_url, work_start_date, work_end_date, email_id, country, registration_date, " + 
					"created_by, created_date, updated_by, updated_date, employment_type) VALUES " + 
					"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;

			final String Update_USER_PROFILE = "UPDATE user_profile SET user_id = ?, first_name = ?, last_name = ?, age = ?, phone_number = ?, dob = ?, gender = ?, " +
					"avatar_url = ?, work_start_date = ?, work_end_date = ?, salary = ?, email_id = ?, country = ?, is_active = ?, is_deleted = ?, registration_date = ?, " +
					"created_by = ?, created_date = ?, updated_by = ?, updated_date = ?" ;

			final String Update_USER_PROFILE_PROFILE_IMAGE = "UPDATE user_profile SET avatar_url = ? WHERE id = ?" ;

			final String GET_USER_ACTIONS = "SELECT * FROM musti.musti_actions ma inner join musti.musti_role_actions mra on mra.action_id = ma.id where ma.enabled = true and mra.role_id = ? order by ma.order_number";
			final String USER_PROFILE_FETCH = "select usr.id, usr.username, usr.email_id, usr.phone_no, " + 
					"prof.first_name, prof.last_name, prof.age, prof.dob, prof.gender, prof.avatar_url,  " + 
					"prof.work_start_date, prof.work_end_date, prof.salary, prof.email_id, prof.country, usr.is_active, usr.is_deleted, prof.registration_date, " + 
					"prof.created_date, prof.created_by, prof.updated_date, prof.updated_by, prof.employment_type, usrrole.role_id, role.role_name, role.description, role.priority " + 
					"from user usr LEFT JOIN user_profile prof ON usr.id = prof.user_id " + 
					"LEFT JOIN musti_user_role usrrole ON usr.id = usrrole.user_id " + 
					"LEFT JOIN musti_role role ON role.id = usrrole.role_id ";
			final String GET_USER_BY_ID = USER_PROFILE_FETCH + " WHERE usr.id = ?" ;
			final String GET_USER_AUTH_DETAILS = "SELECT id, user_id, auth_token FROM user_authentication WHERE id=?" ;
			final String SAVE_USER = "INSERT INTO user(username,password,email_id, phone_no, is_active, is_deleted ) VALUES (?,?,?,?,?,?)";
			final String SAVE_USER_AUTHENTICATION = "INSERT INTO user_authentication(user_id,auth_token) VALUES (?,?)";
			final String GET_USER_ROLE = "SELECT user_id, role_id FROM musti_user_role WHERE user_id=?" ;
			final String GET_ROLES_FOR_USER = " select mur.user_id, mur.role_id, mr.role_name, mr.description, mr.priority from musti_user_role mur LEFT JOIN musti_role mr ON mur.role_id = mr.id " + 
					" WHERE mur.user_id = ? " ; 
			final String GET_USER_BY_PHONE = "SELECT id, username, password, email_id, phone_no  FROM user WHERE phone_no=?"; 
			final String USER_ACTIVE_CONDITION = " WHERE usr.is_active = ? " ;
			final String WHERE_CLAUSE = " WHERE "; 
			final String AND_CONDITION = " AND ";
			final String OR_CONDITION = " OR "; 

			final String USER_PROFILE_FETCH_PAGINATION_1 = "select usr.id, usr.username, usr.email_id, usr.phone_no, prof.first_name, prof.last_name, prof.age, prof.dob, prof.gender, prof.avatar_url,  prof.work_start_date, prof.work_end_date, prof.salary, prof.email_id, prof.country, usr.is_active, usr.is_deleted, prof.registration_date, prof.created_date, prof.created_by, prof.updated_date, prof.updated_by, prof.employment_type, usrrole.role_id, role.role_name, role.description, role.priority " + 
					" from (select id, username, email_id, phone_no, is_active, is_deleted from user " ;
			final String USER_ACTIVE_CONDITION_PAGINATION = " WHERE is_active = ? " ; 
			final String USER_PROFILE_FETCH_PAGINATION_2 = " order by id limit ?,?) usr LEFT JOIN user_profile prof ON usr.id = prof.user_id " + 
					" LEFT JOIN musti_user_role usrrole ON usr.id = usrrole.user_id " + 
					" LEFT JOIN musti_role role ON role.id = usrrole.role_id ";
			final String TAIL_CONDITIONS_EMAIL_LIKE = " usr.email_id LIKE ?";
			final String TAIL_CONDITIONS_FIRSTNAME_LIKE = " prof.first_name LIKE ?";
			final String TAIL_CONDITIONS_LASTNAME_LIKE = " prof.last_name LIKE ?";
			final String TAIL_CONDITIONS_COUNTRY_LIKE = " prof.country LIKE ?";
			final String TAIL_CONDITIONS_USER_ACTIVE = " usr.is_active is TRUE " ;
			final String TAIL_CONDITIONS_USER_ROLEIN = " usrrole.role_id IN ";
			final String ORDER_BY_USER_ID = " ORDER BY usr.id ";
			final String USER_ID_EQUAL_CONDITION = " usr.id = ?"; 
			final String USER_ID_IN_CONDITION = " usr.id IN "; 
			
			final String UPDATE_USER = "UPDATE user SET email_id = ?, username = ?, phone_no = ?, is_active = ?, is_deleted = ? where id = ? "; 
			final String UPDATE_USER_PROFILE = "UPDATE user_profile SET first_name = ?, last_name = ?, age = ?, phone_number = ?, dob = ?, gender = ?, work_start_date = ?,  " + 
					"work_end_date = ?, country = ?, updated_date = ?, updated_by = ?, employment_type = ?  WHERE user_id = ? " ;
			final String GET_USER_COUNT = "SELECT count(*) FROM user usr";
			final String GET_USER_COUNT_ON_ACTIVE_STATUS = "SELECT count(*) FROM user usr where usr.is_active = ? ";
			final String GET_USER_COUNT_FOR_ROLE = "SELECT count(*) FROM user usr LEFT JOIN musti_user_role usrrole ON usr.id = usrrole.user_id where usrrole.role_id = ? " + 
					"and usr.is_active IS TRUE"; 
			final String GET_ROLE_COUNT = "SELECT count(*) FROM musti_role";
			
			final String INVALIDATE_TOKEN = "DELETE from user_authentication WHERE auth_token = ? "; 
			final String CHECK_USER_DEVICE_TOKEN = "SELECT COUNT(*) FROM user_device WHERE user_id = ? AND device_token = ? ";
			final String INSERT_USER_DEVICE_TOKEN = "INSERT INTO user_device (user_id, device_token, created_date) VALUES (?,?,?) ";
			final String UPDATE_USER_DEVICE_TOKEN = "UPDATE user_device SET device_token = ?, created_date = ? WHERE user_id = ? "; 
					
		}

}
