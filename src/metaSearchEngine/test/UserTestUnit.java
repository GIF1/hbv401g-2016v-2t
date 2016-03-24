import org.hamcrest.*;

import java.util.*;
import org.junit.Test;

public class UserTestUnit {
	String[] username = {"Gunnar","_Gunnar Ingi","G"};
	String[] age = {"25","is"," "};
	String[] email = {"gif1@hi.is","bla","@hi.is"};
	String[] password = {"Gunnar","Gunnar","Gunnar"};
	String[] admin = {"false","true","bla"};
	String[][] hobbie = {{"Skiing","Beach"},{"Skiing","Beach"},{"Skiing","Beach"}};
	
	public List<List<String>> setUserInfo(String username, String age, String email, String password, String admin, String[] hobbie) {
		List<List<String>> userData = new ArrayList<List<String>>();
		List<String> uData = new ArrayList<String>();
		List<String> hobbies = new ArrayList<String>();
		
		uData.add(username);
		uData.add(age);
		uData.add(email);
		uData.add(password);
		uData.add(admin);
		
		for (int i = 0; i < hobbie.length; i++) {
			hobbies.add(hobbie[i]);
		}
		userData.add(uData);
		userData.add(hobbies);
		
		return userData;
	}
	
	@Test
   public void testPrintMessage() {	
		//for (int i = 0; i < username.length; i++) {
		int i = 0;
			List<List<String>> userData = setUserInfo(username[i],age[i],email[i],password[i],admin[i],hobbie[i]);
			User newUser = new User();
			newUser.setProfile(userData);
			System.out.println(newUser.username);
			//MatcherAssert.assertThat(newUser.username, Matchers.not(Matchers.matchesPattern("^(?=.{4,20}$)[a-zA-Z0-9-záÁéÉíÍúÚóÓıİğĞşŞöÖ]+$")));
			MatcherAssert.assertThat(username[0], Matchers.matchesPattern("^(?=.{4,20}$)[a-zA-Z0-9-záÁéÉíÍúÚóÓıİğĞşŞöÖ]+$"));
			MatcherAssert.assertThat(username[1], Matchers.not(Matchers.matchesPattern("^(?=.{4,20}$)[a-zA-Z0-9-záÁéÉíÍúÚóÓıİğĞşŞöÖ]+$")));
		//}
   }
}
