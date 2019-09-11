package model;

public class Club {
	private String id;
	private String name;
	private String creationDate;

	public Club(String id,String name,String creationDate) {
		this.id=id;
		this.name=name;
		this.creationDate=creationDate;
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

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

}
