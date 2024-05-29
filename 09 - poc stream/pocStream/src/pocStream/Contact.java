package pocStream;

public class Contact {
	private String nom;
	private String prenom;
	private String tel;
	private Integer age;

	public Contact() {
	}

	public Contact(String nom, String prenom, String tel, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", age=" + age + "]";
	}

}
