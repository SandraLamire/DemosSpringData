package fr.formation.vote;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.formation.vote.entity.Bureau;
import fr.formation.vote.entity.Candidat;
import fr.formation.vote.entity.Votant;
import fr.formation.vote.service.VoteException;
import fr.formation.vote.service.VoteService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class VoteApplication implements CommandLineRunner {

	private VoteService service;
	
	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Bureau b = Bureau.builder().numero("1B").adresse("là à coté").build();
		
		Candidat c1 = Candidat.builder().nom("Moi").prenom("Aimé").parti("Sans Laisser D'Adresse").build();
		Candidat c2 = Candidat.builder().nom("Lemiller").prenom("Jessy").parti("Denrire").build();
			
		service.voter(Votant.builder().nom("Terrieur").prenom("alex").ddn(LocalDate.now().minusYears(21)).candidat(c1).bureau(b).build());
		try {
			service.voter(Votant.builder().nom("Tim").prenom("Vincent").ddn(LocalDate.now().minusYears(12)).candidat(c1).bureau(b).build());
		} catch (VoteException e) {
			System.err.println(e.getMessage());;
		}
		
		service.voter(Votant.builder().nom("Latournée").prenom("Jerémie").ddn(LocalDate.now().minusYears(21)).candidat(c1).bureau(b).build());
		service.voter(Votant.builder().nom("Conpas").prenom("Amédé").ddn(LocalDate.now().minusYears(21)).candidat(c2).bureau(b).build());

		System.out.println("---------------------------");
		service.getAll().forEach(System.out::println);

		System.out.println("Le gagnant est .....");
		System.out.println(service.winner());

		System.out.println("-----------------------------");
		System.out.println("MOYENNE AGE DES VOTANTS");
		System.out.println(service.moyenneAgeVotants());

		System.out.println("-----------------------------");
		System.out.println("MOYENNE AGE DES VOTANTS QUI ON VOTE POUR LE PARTI Sans Laisser D'Adresse");
		System.out.println(service.moyenneAgeVotantsVoteParti("Sans Laisser D'Adresse"));
		
	}

}
