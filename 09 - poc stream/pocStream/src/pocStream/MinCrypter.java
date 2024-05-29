package pocStream;

public class MinCrypter implements Crypter {

	@Override
	public String crypter(String message) {
		return message.toLowerCase();
	}

}
