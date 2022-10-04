public class PasswordDriver {
	
	public static void main(String[] args) {
		String candidate;
		
		candidate = "1234abcd";
		if(Password.checkPWD(candidate)){
			System.out.println("String \""+candidate+"\" is a an allowd passwor.");
		} else {
			System.out.println("String \""+candidate+"\" is not allowed as password.");
		}
		
		
		// put more tests here.
		
	}

}
