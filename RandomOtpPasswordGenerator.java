import java.util.Random;

public class RandomOtpPasswordGenerator {
	public static void main(String[] args) {
		new PasswordGenerator();
		new OtpGenerator();
	}
}

class OtpGenerator {
	public OtpGenerator() {
		String numbers = "0123456789";
		Random randomCharacter = new Random();
		char[] otp = new char[6];
		for (int i = 0; i < 6; i++) {
			otp[i] = numbers.charAt(randomCharacter.nextInt(numbers.length()));
		}
		System.out.print("your otp: ");
		System.out.println(otp);
	}
}

class PasswordGenerator {
	public PasswordGenerator() {
		
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		Random randomCharacter = new Random();
		char[] password = new char[6];
		for (int i = 0; i < 6; i++) {
			password[i] = values.charAt(randomCharacter.nextInt(values.length()));
		}
		System.out.print("your password: ");
		System.out.println(password);
	}
}
