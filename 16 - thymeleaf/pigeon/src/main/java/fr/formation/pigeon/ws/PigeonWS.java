package fr.formation.pigeon.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.formation.pigeon.entity.Pigeon;
import fr.formation.pigeon.service.PigeonService;

@RestController
@RequestMapping()
public class PigeonWS {
	@Autowired
	private PigeonService service;
	
	
	@GetMapping("/rapt/{numero}")
	public ResponseEntity<List<Pigeon>> rapt(@PathVariable("numero") String numero) {
		List<Pigeon> lst = service.rapt(numero);
		if(lst.size()>0) {
			return ResponseEntity.ok().body(lst);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@GetMapping("/vachercher/{ip}/{code}")
	public ResponseEntity<String> vachercher(@PathVariable("ip") String ip, @PathVariable("code")String code, RestTemplate restTemplate){
		Pigeon[] re = restTemplate.getForObject("http://10.46.101."+ip+":8080/pigeon/rapt/"+code, Pigeon[].class);
		for (Pigeon pigeon : re) {
			System.out.println("capture de "+pigeon.getNom());
			pigeon.setIdPigeon(null);
			service.addPigeon(pigeon);
		}
		return ResponseEntity.ok().body(re.length+" pigeon(s) volé");
	}
}
