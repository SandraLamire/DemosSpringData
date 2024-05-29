package pocStream;

public class MajCrypter implements Crypter {

	@Override
	public String crypter(String message) {
		return message.toUpperCase();
	}

}
