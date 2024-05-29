package pocStream;

import java.util.function.Predicate;

public class ExecLambda {
	public static void main(String[] args) {
		MajCrypter cr = new MajCrypter();
		MinCrypter cr2 = new MinCrypter();
		
		Crypter cr3 = new Crypter() {
			
			@Override
			public String crypter(String message) {
				return new StringBuilder(message).reverse().toString();
			}
		};
		
		
		Crypter cr4 = m -> new StringBuilder(m).reverse().toString();
		
		System.out.println(cr.crypter("Ceci est mon message"));
		System.out.println(cr2.crypter("Ceci est mon message"));
		System.out.println(cr3.crypter("Ceci est mon message"));
		System.out.println(cr4.crypter("Ceci est mon message"));
	

		Predicate<String> p1= s->s.equals("toto");

		System.out.println(p1.test("tata"));
		System.out.println(p1.test("toto"));
	}
}
