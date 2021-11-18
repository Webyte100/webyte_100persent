package ibm.com.services;

import java.util.List;

import com.ibm.entity.User;
//import com.ibm.pojo.Login;

public interface UserService {

	    void saveUser(User user);

	    User findUserByEmailAndPasswd(String email, String passwd);
	    
	    User findUserByPhoneNumber(long phoneNo);
	    
	    List<User>getAllUsers();
	    
	    //User authenticate(Login login);
	}


