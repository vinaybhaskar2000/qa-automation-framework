package utils;

public class JavaUtility {
	
	public String getRandomEmail() {
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }

    public int getRandomNumber() {
        return (int)(Math.random() * 1000);
    }

}
