package metaSearchEngine.test;

// import metaSearchEngine.mockobjects.User;
import metaSearchEngine.program.*;

import java.util.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import junit.framework.Assert;

import static org.junit.Assert.assertTrue;

public class test_UpdateUser {
	
	ArrayList<String> user_info = new ArrayList<String>();
	
	@Before
	public void setUp() {
		// Create an instance of a test user whose information we want to update
		User testUser = new User("noialbinoi",40,"noi@sirius.is","hiking","abc123",true);
	}
	
	@After
	public void tearDown() {
		User testUser = null;
	}
	
	@Test
	public void updateAge() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noialbinoi", 41, "noi@sirius.is", "hiking", "abc123", true);
		assertTrue(tmp.compareTo(testUser) != 0);
	}
	
	@Test
	public void updateUsername() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noisirius", 40, "noi@sirius.is", "hiking", "abc123", true);
		assertTrue(tmp.compareTo(testUser) != 0);
	}
	
	@Test
	public void updateEmail() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noialbinoi", 40, "noi@örkin.is", "hiking", "abc123", true);
		assertTrue(tmp.compareTo(testUser) != 0);
	}
	
	@Test
	public void updateHobbies() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noialbinoi", 40, "noi@sirius.is", "hunting", "abc123", true);
		assertTrue(tmp.compareTo(testUser) != 0);
	}
	
	@Test
	public void updatePassword() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noialbinoi", 40, "noi@sirius.is", "hiking", "nyttPasswordHehe", true);
		assertTrue(tmp.compareTo(testUser) != 0);
	}
	
	@Test
	public void updateAdmin() {
		User tmp = testUser;
		testUser.updateUser(testUser,"noialbinoi", 40, "noi@sirius.is", "hiking", "abc123", false);
		assertTrue(tmp.compareTo(testUser) != 0);
	}

}
