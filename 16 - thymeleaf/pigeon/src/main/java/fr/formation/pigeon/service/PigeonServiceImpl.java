package fr.formation.pigeon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.pigeon.entity.Pigeon;
import fr.formation.pigeon.repository.PigeonRepository;
import jakarta.annotation.PostConstruct;

@Service
public class PigeonServiceImpl implements PigeonService {
	private final String PROPRIO = "MANU";
	@Autowired
	PigeonRepository repo;
	
	@PostConstruct
	public void init() {
		addPigeon(new Pigeon("Pierre"));
		addPigeon(new Pigeon("Philippe"));
		addPigeon(new Pigeon("René"));
		
		System.out.println();
		getAllPigeon().forEach(System.out::println);
		System.out.println();
		System.out.println(getAllPigeon().stream().findFirst().orElse(null));
	}
	
	
	@Override
	public void addPigeon(Pigeon pigeon) {
		pigeon.setProprio(PROPRIO);
		Integer rs = (int) (Math.random() * 10);
		pigeon.setCode(rs.toString());	
		System.out.println("AJOUT DE "+pigeon);
		repo.save(pigeon);
	}

	@Override
	public List<Pigeon> getAllPigeon() {
		return (List<Pigeon>) repo.findAll();
	}

	@Override
	public void delPigeon(Pigeon pigeon) {
		repo.delete(pigeon);
	}

	@Override
	public List<Pigeon> getByCode(String numero) {
		return repo.findByCode(numero);
	}


	@Override
	public List<Pigeon> rapt(String code) {
		System.out.println("VOUS AVEZ ETE ATTAQUE");
		List<Pigeon> lst = getByCode(code);
		if(lst.size()>0) {
			lst.forEach(p->{
				System.out.println(p.getNom()+ " est capturé !");
				delPigeon(p);
			});
		}
		else {
			System.out.println("le pigeonnier a resisté !!");
		}
		return lst;
	}


	@Override
	public void addRaptedPigeon(Pigeon pigeon) {
		pigeon.setIdPigeon(null);
		repo.save(pigeon);
	}

}
