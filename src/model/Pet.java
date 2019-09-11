package model;

public class Pet {
	private String id;
	private String name;
	private String birthdate;
	private String gender;
	private String kindOfPet;
	
	public Pet(String id, String name,String birthdate,String gender,String kindOfPet) {
		this.id=id;
		this.name=name;
		this.birthdate=birthdate;
		this.gender=gender;
		this.kindOfPet=kindOfPet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getKindOfPet() {
		return kindOfPet;
	}

	public void setKindOfPet(String kindOfPet) {
		this.kindOfPet = kindOfPet;
	}
}
