package practicetestng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Check{

	@Test
	public void login() { 
		System.out.println("login");
	}
	@Test @AfterMethod
public void logout() { 
	System.out.println("logout");
	}
	@Test @BeforeTest
public void signup() { 
	System.out.println("signup");
}
@Test
public void upLoadprofile() { 
	System.out.println("uploadprofile");
}
@Test
public void sendFriendRequest() { 
	System.out.println("sendFriendRequest");
}

public void acceptFriendRequest() { 
	System.out.println("acceptfriendRequest");
}

@Test
public void uploadPost() { 
	System.out.println("uploadPost");
}
	
}
