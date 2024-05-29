package fr.formation.pigeon.service;

import java.util.List;

import fr.formation.pigeon.entity.Pigeon;

public interface PigeonService {
	public void addPigeon(Pigeon pigeon);
	public List<Pigeon> getAllPigeon();
	public void delPigeon(Pigeon pigeon);
	public List<Pigeon> getByCode(String numero);
	public List<Pigeon> rapt(String code);
}
