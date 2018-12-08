package beans;

public class Test {
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Test() {
		System.out.println("Test Class Constructor...");
	}

	public void sayHello() {
		System.out.println("Hello, "+getUserName());
		System.out.println("Welcome to Spring Demo Program");
	}
		
}
