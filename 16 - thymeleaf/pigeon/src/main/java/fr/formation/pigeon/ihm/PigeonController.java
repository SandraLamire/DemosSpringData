package fr.formation.pigeon.ihm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import fr.formation.pigeon.entity.Pigeon;
import fr.formation.pigeon.service.PigeonService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/ihm/pigeon")
public class PigeonController {
	@Autowired
	PigeonService service;

	@ModelAttribute("lstPigeons")
	public List<Pigeon> getList() {
		return service.getAllPigeon();
	}

	@ModelAttribute("pigeon")
	public Pigeon getPigeon() {
		return new Pigeon();
	}

	@ModelAttribute("attaqueDTO")
	public AttaqueDTO getAttaque() {
		return new AttaqueDTO(26, 1);
	}

	@GetMapping
	public String getAll() {
		return "pigeon";
	}

	@PostMapping
	public String validPigeon(@Valid Pigeon pigeon, BindingResult errors) {
		if (errors.hasErrors()) {
			return "pigeon";
		}
		service.addPigeon(pigeon);
		return "redirect:/ihm/pigeon";
	}

	@PostMapping("/attaque")
	public String attaquePigeon(@Valid AttaqueDTO attaque, BindingResult errors, RestTemplate restTemplate) {
		if (errors.hasErrors()) {
			return "pigeon";
		}
		Pigeon[] re = restTemplate.getForObject(
				"http://10.46.101." + attaque.getIp() + ":8080/rapt/" + attaque.getCode(), Pigeon[].class);
		if (re != null) {
			for (Pigeon pigeon : re) {
				service.addRaptedPigeon(pigeon);
			}
		}

		return "redirect:/ihm/pigeon";
	}

}
