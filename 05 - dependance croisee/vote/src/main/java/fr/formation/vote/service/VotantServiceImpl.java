package fr.formation.vote.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.vote.entity.Votant;
import fr.formation.vote.repository.VotantRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VotantServiceImpl implements VotantService{
	private VotantRepository repo;
	
	private final static Integer MAJORITE = 18;
	
	@Override
	@Transactional
	public void voter(Votant votant) throws VotantException {
		if(votant.getDdn().isAfter(LocalDate.now().minusYears(MAJORITE))) {
			throw new VotantException("Trop Jeune");
		}
		repo.save(votant);
	}

	@Override
	public List<Votant> getAll() {
		return (List<Votant>) repo.findAll();
	}

	@Override
	public String winner() {
		Integer aime = repo.countWhen("Aimé Moi");
		Integer jessy = repo.countWhen("Jessy Lemilleur");
		Integer jeffrey = repo.countWhen("Jeffrey Toupourvous");
		if(aime>jessy && aime>jeffrey) {
			return "Aimé Moi";
		}
		else if(jessy > aime && jessy > jeffrey) {
			return "Jessy Lemilleur";
		}
		else {
			return "Jeffrey Toupourvous";
		}
	}

}
