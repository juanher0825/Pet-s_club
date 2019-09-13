package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CentralSistem {
	protected static final String path = "data/Clubs.csv";
	protected static final String pathOwner = "data/Owners.csv";
	protected static final String pathSerialized = "data/owners.ser";
	protected static final char searchByOwner = 'o';
	protected static final char searchByClub = 'c';
	protected static final char searchByPet = 'p';

	protected static final char byIdClub = 'i';
	protected static final char byNameClub = 'n';
	protected static final char byCreationDateClub = 'c';

	protected static final char byIdOwner = 'i';
	protected static final char byNameOwner = 'n';
	protected static final char byLastNameOwner = 'l';
	protected static final char byBirthdateOwner = 'b';
	protected static final char byKindOfPetsOwner = 'k';

	protected static final char byIdPet = 'i';
	protected static final char byNamePet = 'n';
	protected static final char byBithdatePet = 'b';
	protected static final char byGenderPet = 'g';
	protected static final char byKindOfPet = 'k';

	private Club club;
	private Owner owner;
	private ArrayList<Owner> owners;
	private ArrayList<Club> clubs;
	private long timeBinary;
	private long timeLineal;

	public CentralSistem() throws IOException, ClassNotFoundException {
		owners = new ArrayList<Owner>();
		clubs = new ArrayList<Club>();
		
		loadClubs();
		loadOwners();
	}

	public void loadClubs() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));

		String line = br.readLine();

		while (line != null) {

			String[] parts = line.split(",");

			String id = parts[0];
			String name = parts[1];
			String creationDate = parts[2];

			Club club = new Club(id, name, creationDate);

			clubs.add(club);

			line = br.readLine();
		}
		br.close();
	}

	/*public void saveClubs() throws FileNotFoundException {
		PrintWriter writting = new PrintWriter(new File(path));
		String tmp = "";

		for (int I = 0; I < clubs.size(); I++) {
			tmp += clubs.get(I).getId() + " " + clubs.get(I).getName() + " " + clubs.get(I).getCreationDate() + "\n";
		}

		writting.print(tmp);
		writting.close();

	}*/

	public void saveOwners() throws FileNotFoundException, IOException {
		ObjectOutputStream writting = new ObjectOutputStream(new FileOutputStream(pathSerialized));
		writting.writeObject(owners);
		writting.close();
	}

	/*public void loadOwners() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream loading = new ObjectInputStream(new FileInputStream(pathSerialized));
		owners = (ArrayList<Owner>) loading.readObject();
		loading.close();
	}*/
	
	public void loadOwners() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(pathOwner)));

		String line = br.readLine();

		while (line != null) {

			String[] parts = line.split(",");

			String id = parts[0];
			String name = parts[1];
			String lastName = parts[2];
			String creationDate = parts[3];

			Owner owner = new Owner(id,name,lastName,creationDate, "", null);

			owners.add(owner);

			line = br.readLine();
		}
		br.close();
	}

	public void sortByClubsByName() {
		for (int I = 0; I < clubs.size() - 1; I++) {
			String minorClub = clubs.get(I).getName();
			int minorPosition = I;
			for (int J = I + 1; J < clubs.size(); J++) {
				String currentClub = clubs.get(J).getName();
				if (currentClub.compareTo(minorClub) < 0) {
					minorClub = currentClub;
					minorPosition = J;
				}
			}
			Club temp = clubs.get(minorPosition);
			clubs.set(minorPosition, clubs.get(I));
			clubs.set(I, temp);
		}
	}

	public void sortByClubsById() {
		for (int I = 0; I < clubs.size() - 1; I++) {
			String minorClub = clubs.get(I).getId();
			int minorPosition = I;
			for (int J = I + 1; J < clubs.size(); J++) {
				String currentClub = clubs.get(J).getId();
				if (currentClub.compareTo(minorClub) < 0) {
					minorClub = currentClub;
					minorPosition = J;
				}
			}
			Club temp = clubs.get(minorPosition);
			clubs.set(minorPosition, clubs.get(I));
			clubs.set(I, temp);
		}
	}

	public void sortByClubsByCreationDate() {
		for (int I = 0; I < clubs.size() - 1; I++) {
			String minorClub = clubs.get(I).getCreationDate();
			int minorPosition = I;
			for (int J = I + 1; J < clubs.size(); J++) {
				String currentClub = clubs.get(J).getCreationDate();
				if (currentClub.compareTo(minorClub) < 0) {
					minorClub = currentClub;
					minorPosition = J;
				}
			}
			Club temp = clubs.get(minorPosition);
			clubs.set(minorPosition, clubs.get(I));
			clubs.set(I, temp);
		}
	}

	public void sortByOwnerByName() {
		for (int I = 0; I < owners.size() - 1; I++) {
			for (int J = 0; J < owners.size() - 1; J++) {
				if (owners.get(J + 1).getName().compareTo(owners.get(J).getName()) < 0) {
					Owner tmp = owners.get(J + 1);
					owners.set(J + 1, owners.get(J));
					owners.set(J, tmp);
				}
			}
		}
	}

	public void sortByOwnerById() {
		Collections.sort(owners, new OwnerComparator());
	}

	public void sortByOwnerByLastName() {
		for (int I = 0; I < owners.size() - 1; I++) {
			for (int J = 0; J < owners.size() - 1; J++) {
				if (owners.get(J + 1).getLastName().compareTo(owners.get(J).getLastName()) < 0) {
					Owner tmp = owners.get(J + 1);
					owners.set(J + 1, owners.get(J));
					owners.set(J, tmp);
				}
			}
		}
	}

	public void sortByOwnerByBirthdate() {
		for (int I = 0; I < owners.size() - 1; I++) {
			for (int J = 0; J < owners.size() - 1; J++) {
				if (owners.get(J + 1).getBirthdate().compareTo(owners.get(J).getBirthdate()) < 0) {
					Owner tmp = owners.get(J + 1);
					owners.set(J + 1, owners.get(J));
					owners.set(J, tmp);
				}
			}
		}
	}

	public void sortByOwnerByKindOfPets() {
		for (int I = 0; I < owners.size() - 1; I++) {
			for (int J = 0; J < owners.size() - 1; J++) {
				if (owners.get(J + 1).getKindOfPets().compareTo(owners.get(J).getKindOfPets()) < 0) {
					Owner tmp = owners.get(J + 1);
					owners.set(J + 1, owners.get(J));
					owners.set(J, tmp);
				}
			}
		}
	}

	public void sortByPetById() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j - 1).getPet().getId()
					.compareToIgnoreCase(owners.get(j).getPet().getId()) > 0; j--) {
				Owner owner1 = owners.get(j);
				Owner owner2 = owners.get(j - 1);
				owners.remove(j);
				owners.remove(j - 1);
				owners.add(j - 1, owner1);
				owners.add(j, owner2);
			}
		}
	}

	public void sortByPetByName() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j - 1).getPet().getName()
					.compareToIgnoreCase(owners.get(j).getPet().getName()) > 0; j--) {
				Owner owner1 = owners.get(j);
				Owner owner2 = owners.get(j - 1);
				owners.remove(j);
				owners.remove(j - 1);
				owners.add(j - 1, owner1);
				owners.add(j, owner2);
			}
		}
	}

	public void sortByPetByBirthdate() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j - 1).getPet().getBirthdate()
					.compareToIgnoreCase(owners.get(j).getPet().getBirthdate()) > 0; j--) {
				Owner owner1 = owners.get(j);
				Owner owner2 = owners.get(j - 1);
				owners.remove(j);
				owners.remove(j - 1);
				owners.add(j - 1, owner1);
				owners.add(j, owner2);
			}
		}
	}

	public void sortByPetByGender() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j - 1).getPet().getGender()
					.compareToIgnoreCase(owners.get(j).getPet().getGender()) > 0; j--) {
				Owner owner1 = owners.get(j);
				Owner owner2 = owners.get(j - 1);
				owners.remove(j);
				owners.remove(j - 1);
				owners.add(j - 1, owner1);
				owners.add(j, owner2);
			}
		}
	}

	public void sortByPetByKinfOfPet() {
		for (int i = 0; i < owners.size(); i++) {
			for (int j = i; j > 0 && owners.get(j - 1).getPet().getKindOfPet()
					.compareToIgnoreCase(owners.get(j).getPet().getKindOfPet()) > 0; j--) {
				Owner owner1 = owners.get(j);
				Owner owner2 = owners.get(j - 1);
				owners.remove(j);
				owners.remove(j - 1);
				owners.add(j - 1, owner1);
				owners.add(j, owner2);
			}
		}
	}

	public Owner searchByIdOwner(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getId().equals(valueToLookFor)) {
				return owners.get(position);
			} else if (valueToLookFor.compareTo(owners.get(position).getId()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Owner searchByNameOwner(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getName().equals(valueToLookFor)) {
				return owners.get(position);
			} else if (valueToLookFor.compareTo(owners.get(position).getName()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Owner searchByLastNameOwner(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getLastName().equals(valueToLookFor)) {
				return owners.get(position);
			} else if (valueToLookFor.compareTo(owners.get(position).getLastName()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Owner searchByBirthdateOwner(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getBirthdate().equals(valueToLookFor)) {
				return owners.get(position);
			} else if (valueToLookFor.compareTo(owners.get(position).getBirthdate()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Owner searchByKindOfPetsOwner(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getKindOfPets().equals(valueToLookFor)) {
				return owners.get(position);
			} else if (valueToLookFor.compareTo(owners.get(position).getKindOfPets()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Club searchByIdClub(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (clubs.get(position).getId().equals(valueToLookFor)) {
				return clubs.get(position);
			} else if (valueToLookFor.compareTo(clubs.get(position).getId()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Club searchByNameClub(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (clubs.get(position).getName().equals(valueToLookFor)) {
				return clubs.get(position);
			} else if (valueToLookFor.compareTo(clubs.get(position).getName()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Club searchByCreationDateClub(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (clubs.get(position).getCreationDate().equals(valueToLookFor)) {
				return clubs.get(position);
			} else if (valueToLookFor.compareTo(clubs.get(position).getCreationDate()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Pet searchByIdPet(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getPet().getId().equals(valueToLookFor)) {
				return owners.get(position).getPet();
			} else if (valueToLookFor.compareTo(owners.get(position).getPet().getId()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Pet searchByNamePet(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getPet().getName().equals(valueToLookFor)) {
				return owners.get(position).getPet();
			} else if (valueToLookFor.compareTo(owners.get(position).getPet().getName()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Pet searchByBirthdatePet(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getPet().getBirthdate().equals(valueToLookFor)) {
				return owners.get(position).getPet();
			} else if (valueToLookFor.compareTo(owners.get(position).getPet().getBirthdate()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Pet searchByGenderPet(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getPet().getGender().equals(valueToLookFor)) {
				return owners.get(position).getPet();
			} else if (valueToLookFor.compareTo(owners.get(position).getPet().getGender()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Pet searchByKindOfPet(String valueToLookFor) {
		int start = 0;
		int end = owners.size() - 1;
		int position;

		while (start <= end) {
			position = (start + end) / 2;

			if (owners.get(position).getPet().getKindOfPet().equals(valueToLookFor)) {
				return owners.get(position).getPet();
			} else if (valueToLookFor.compareTo(owners.get(position).getPet().getKindOfPet()) > 0) {
				start = position + 1;
			} else {
				end = position - 1;
			}
		}

		return null;
	}

	private Owner searchByIdOwnerLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getId().equals(valueToLookFor)) {
				return owners.get(I);
			}
		}

		return null;
	}

	private Owner searchByNameOwnerLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getName().equals(valueToLookFor)) {
				return owners.get(I);
			}
		}

		return null;
	}

	private Owner searchByLastNameOwnerLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getLastName().equals(valueToLookFor)) {
				return owners.get(I);
			}
		}

		return null;
	}

	private Owner searchByBirthdateOwnerLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getBirthdate().equals(valueToLookFor)) {
				return owners.get(I);
			}
		}

		return null;
	}

	private Owner searchByKindOfPetsOwnerLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getKindOfPets().equals(valueToLookFor)) {
				return owners.get(I);
			}
		}

		return null;
	}

	private Club searchByIdClubLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (clubs.get(I).getId().equals(valueToLookFor)) {
				return clubs.get(I);
			}
		}

		return null;
	}

	private Club searchByNameClubLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (clubs.get(I).getName().equals(valueToLookFor)) {
				return clubs.get(I);
			}
		}

		return null;
	}

	private Club searchByCreationDateClubLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (clubs.get(I).getCreationDate().equals(valueToLookFor)) {
				return clubs.get(I);
			}
		}

		return null;
	}

	private Pet searchByIdPetLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().getId().equals(valueToLookFor)) {
				return owners.get(I).getPet();
			}
		}

		return null;
	}

	private Pet searchByNamePetLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().getName().equals(valueToLookFor)) {
				return owners.get(I).getPet();
			}
		}

		return null;
	}

	private Pet searchByBirthdatePetLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().getBirthdate().equals(valueToLookFor)) {
				return owners.get(I).getPet();
			}
		}

		return null;
	}

	private Pet searchByGenderPetLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().getGender().equals(valueToLookFor)) {
				return owners.get(I).getPet();
			}
		}

		return null;
	}

	private Pet searchByKindOfPetLineal(String valueToLookFor) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().getKindOfPet().equals(valueToLookFor)) {
				return owners.get(I).getPet();
			}
		}

		return null;
	}

	public Object search(char type, char criterion, String toSearch) {
		if (type == searchByOwner) {
			if (criterion == byIdOwner) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByOwnerById();
				searchByIdOwner(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjO(searchByIdOwnerLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByIdOwnerLineal(toSearch);
			} else if (criterion == byNameOwner) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByOwnerByName();
				searchByNameOwner(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjO(searchByNameOwnerLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByNameOwnerLineal(toSearch);
			} else if (criterion == byLastNameOwner) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByOwnerByLastName();
				System.out.println(toStringObjO(searchByLastNameOwner(toSearch)));
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByLastNameOwnerLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByLastNameOwnerLineal(toSearch);
			} else if (criterion == byBirthdateOwner) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByOwnerByBirthdate();
				System.out.println(toStringObjO(searchByBirthdateOwner(toSearch)));
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByBirthdateOwnerLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByBirthdateOwnerLineal(toSearch);
			} else if (criterion == byKindOfPetsOwner) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByOwnerByKindOfPets();
				searchByKindOfPetsOwner(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjO(searchByKindOfPetsOwnerLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByKindOfPetsOwnerLineal(toSearch);
			}
			return null;
		} else if (type == searchByClub) {
			if (criterion == byIdClub) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByClubsById();
				searchByIdClub(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjC(searchByIdClubLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByIdClubLineal(toSearch);
			} else if (criterion == byNameClub) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByClubsByName();
				searchByNameClub(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjC(searchByNameClubLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByNameClubLineal(toSearch);
			} else if (criterion == byCreationDateClub) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByClubsByCreationDate();
				searchByCreationDateClub(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				System.out.println(toStringObjC(searchByCreationDateClubLineal(toSearch)));
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByCreationDateClubLineal(toSearch);
			}
			return null;
		} else if (type == searchByPet) {
			if (criterion == byIdPet) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByPetById();
				searchByIdPet(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByIdPetLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByIdPetLineal(toSearch);
			} else if (criterion == byNamePet) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByPetByName();
				searchByNamePet(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByNamePetLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByNamePetLineal(toSearch);
			} else if (criterion == byBithdatePet) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByPetByBirthdate();
				searchByBirthdatePet(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByBirthdatePetLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByBirthdatePetLineal(toSearch);
			} else if (criterion == byGenderPet) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByPetByGender();
				searchByGenderPet(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByGenderPetLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByGenderPetLineal(toSearch);
			} else if (criterion == byKindOfPet) {
				timeBinary = 0;
				timeBinary = System.currentTimeMillis();
				sortByPetByKinfOfPet();
				searchByKindOfPet(toSearch);
				long end = System.currentTimeMillis();
				timeSpentBinary(end);

				timeLineal = 0;
				timeLineal = System.currentTimeMillis();
				searchByKindOfPetLineal(toSearch);
				long endLineal = System.currentTimeMillis();
				timeSpentLineal(endLineal);

				return searchByKindOfPetLineal(toSearch);
			}
			return null;
		}
		return null;
	}

	public void deleteClub(String id) {
		clubs.remove(searchByIdClub(id));
	}

	public void deleteOwner(String id) {
		owners.remove(searchByIdOwner(id));
	}

	public void deletePet(String id) {
		for (int I = 0; I < owners.size(); I++) {
			if (owners.get(I).getPet().equals(searchByIdPet(id))) {
				owners.get(I).setPet(null);
			}
		}
	}

	public boolean addOwner(String id, String name, String lastName, String birthdate, String kindOfPets, String idPet,
			String birthdatePet, String namePet, String genderPet, String kindOfPet) {
		boolean added = false;
		if (searchByIdOwner(id) == null) {
			Owner toAdd = new Owner(id, name, lastName, birthdate, kindOfPets,
					addPet(idPet, namePet, birthdatePet, genderPet, kindOfPet));
			owners.add(toAdd);
			added = true;
		}
		return added;
	}

	private Pet addPet(String id, String name, String birthdate, String gender, String kindOfPet) {
		Pet toAdd = new Pet(id, name, birthdate, gender, kindOfPet);
		boolean is = false;
		for (int I = 0; I < clubs.size(); I++) {

		}
		if (!is) {
			return toAdd;
		}
		return null;
	}

	private long timeSpentBinary(long end) {
		timeBinary = timeBinary - end;

		return timeBinary;
	}

	private long timeSpentLineal(long end) {
		timeLineal = timeLineal - end;

		return timeLineal;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	public ArrayList<Club> getClubs() {
		return clubs;
	}

	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}

	public long timeBinary() {
		return timeBinary;
	}

	public long timeLineal() {
		return timeLineal;
	}
	public String toString() {
		
		String a = "";
		for (int I = 0; I < clubs.size(); I++) {
			a += "" + clubs.get(I).toString() + "\n";
		}
		return a;
	}
	
	public String toStringOwners() {
		String a = "";
		for (int I = 0; I < owners.size(); I++) {
			
			a += ""+ owners.get(I).toString() + "\n";
		}
		return a;
	}
	
	public String toStringObjO(Owner owner) {
		String a = owner.getId() + " " + owner.getName() + " " + owner.getLastName() + " "
				+ owner.getBirthdate();
		return a;
	}
	
	public String toStringObjC(Club club) {
		String a = club.getId() + " " + club.getName() + " "
				+ club.getCreationDate();
		return a;
	}
}