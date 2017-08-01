
public class Login {
	 
    public static boolean authenticate1(String username, String password) {
        // hardcoded username and password
        if (username.equals("user1") && password.equals("hello")) {
            return true;
        }
        else
        	if(username.equals("user2") && password.equals("hello")) {
                return true;
            }
        return false;
    }
    public static boolean authenticate2(String username, String password) {
        // hardcoded username and password
        if (username.equals("admin") && password.equals("egmaray")) {
        	System.out.println("Hello world");

        	return true;
        }
        return false;
    }

}
