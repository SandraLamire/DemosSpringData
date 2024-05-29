package pocStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exec {

	public static void main(String[] args) {
		List<Contact> lst = Arrays.asList(
				new Contact("Cérien","Jean","1244478",18),
				new Contact("Terrieur","Alain","112447",25),
				new Contact("Terrieur","Alex","112447",24),
				new Contact("Tim","Tim","112447",8)
				);
		
		// le parcours
		for (Contact contact : lst) {
			System.out.println(contact);
		}
		
		lst.forEach(System.out::println);
		lst.forEach(c->System.out.println(c));
		lst.forEach(c->{
			System.out.println(c);
		});
		
		lst.stream().forEach(System.out::println);
		
		// le filtre
		for (Contact contact : lst) {
			if("Terrieur".equals(contact.getNom())) {
				if(contact.getAge()>24) {
					System.out.println(contact);
				}
			}
		}
		
		lst.stream()
			.filter(c->"Terrieur".equals(c.getNom()))
			.filter(c->c.getAge()>24)
			.forEach(System.out::println);
		
		// Projection
		for (Contact contact : lst) {
			System.out.println(contact.getNom());
		}
		
		lst.stream()
			.map(c->c.getNom())
			.forEach(System.out::println);
		
		// liste des prénoms de frères Terrieur
		List<String> freres = new ArrayList<>();
		for (Contact contact : lst) {
			if("Terrieur".equals(contact.getNom())) {
				freres.add(contact.getPrenom());
			}
		}
		
		List<String> freres2 = lst.stream()
				.filter(c->c.getNom().equals("Terrieur"))
				.map(c->c.getPrenom())
				.toList();
		System.out.println(freres2);
		
		// tri
		List<String> freres3 = lst.stream()
				.filter(c->c.getNom().equals("Terrieur"))
				.map(c->c.getPrenom())
				.sorted()
				.toList();
		System.out.println(freres3);
		
		lst.stream()
			.sorted(Comparator.comparing(Contact::getPrenom))
			.forEach(System.out::println);

	}
	

}
