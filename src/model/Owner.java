package model;

public class Owner {
	private String id;
	private String name;
	private String lastName;
	private String birthdate;
	private String kindOfPets;
	private Pet pet;

	public Owner(String id, String name, String lastName, String birthdate, String kindOfPets, Pet pet) {
		this.id=id;
		this.name=name;
		this.lastName=lastName;
		this.birthdate=birthdate;
		this.kindOfPets=kindOfPets;
		this.pet=pet;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getKindOfPets() {
		return kindOfPets;
	}

	public void setKindOfPets(String kindOfPets) {
		this.kindOfPets = kindOfPets;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
