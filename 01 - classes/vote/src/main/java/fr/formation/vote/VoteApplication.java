package fr.formation.vote;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.vote.entity.Votant;
import fr.formation.vote.service.VotantException;
import fr.formation.vote.service.VotantService;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class VoteApplication implements CommandLineRunner {

	private VotantService service;
	
	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.voter(Votant.builder().nom("Terrieur").prenom("alex").ddn(LocalDate.now().minusYears(21)).candidat("Aimé Moi").build());
		try {
			service.voter(Votant.builder().nom("Tim").prenom("Vincent").ddn(LocalDate.now().minusYears(12)).candidat("Aimé Moi").build());
		} catch (VotantException e) {
			System.err.println(e.getMessage());;
		}
		
		service.voter(Votant.builder().nom("Latournée").prenom("Jerémie").ddn(LocalDate.now().minusYears(21)).candidat("Aimé Moi").build());
		service.voter(Votant.builder().nom("Conpas").prenom("Amédé").ddn(LocalDate.now().minusYears(21)).candidat("Jessy Lemiller").build());

		System.out.println("---------------------------");
		service.getAll().forEach(System.out::println);

		System.out.println("Le gagnant est .....");
		System.out.println(service.winner());

	
	}

}
