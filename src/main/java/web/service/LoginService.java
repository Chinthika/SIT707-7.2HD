package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Null checks
		if (username == null || password == null || dob == null) {
			return false;
		}

		// Empty checks
		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}

		// Match fixed credentials
		if ("chinthika".equals(username) &&
			"chinthika_pass".equals(password) &&
			"1994-08-19".equals(dob)) {
			return true;
		}

		return false;
	}
	
	
}
