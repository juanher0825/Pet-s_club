package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.CentralSistem;
import model.Pet;

public class Main {

	private static CentralSistem centralSistem;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String line;

	public static void main(String[] args) {
		centralSistem = new CentralSistem();
		
		try {
			menu();
		} catch (IOException e) {
		}
	}
	
	protected static void menu() throws IOException {		
		System.out.println("\t SISTEMA CENTRAL \n");
		System.out.println("Que desea hacer?");
		System.out.println("1. Ordenar dueños por nombre");
		System.out.println("2. Ordenar dueños por id");
		System.out.println("3. Ordenar dueños por apellido");
		System.out.println("4. Ordenar dueños por fecha nacimiento");
		System.out.println("5. Ordenar dueños por tipo de mascotas");
		System.out.println("6. ordenar clubs por id");
		System.out.println("7. ordenar clubs por nombre");
		System.out.println("8. ordenar clubs por fecha de creacion");
		System.out.println("9. ordenar mascotas por id");
		System.out.println("10. ordenar mascotas por nombre");
		System.out.println("11. ordenar mascotas por fecha de nacimiento");
		System.out.println("12. ordenar mascotas por genero");
		System.out.println("13. ordenar mascotas por tipo de mascota");

		System.out.println("14. Buscar dueños por nombre");
		System.out.println("15. Buscar dueños por id");
		System.out.println("16. Buscar dueños por apellido");
		System.out.println("17. Buscar dueños por fecha nacimiento");
		System.out.println("18. Buscar dueños por tipo de mascotas");
		System.out.println("19. Buscar clubs por id");
		System.out.println("20. Buscar clubs por nombre");
		System.out.println("21. Buscar clubs por fecha de creacion");
		System.out.println("22. Buscar mascotas por id");
		System.out.println("23. Buscar mascotas por nombre");
		System.out.println("24. Buscar mascotas por fecha de nacimiento");
		System.out.println("25. Buscar mascotas por genero");
		System.out.println("26. Buscar mascotas por tipo de mascota");

		System.out.println("27. Registrar dueño");
		System.out.println("28. Registrar una mascota");

		System.out.println("29. Eliminar club por id");
		System.out.println("30. Eliminar dueño por id");
		System.out.println("31. Eliminar mascota por id");

		System.out.println("32. Salir");
		
		line = br.readLine();
		int option = Integer.parseInt(line);
		
		if (option == 1) {
			centralSistem.sortByOwnerByName();
			menu();
		} else if (option == 2) {
			centralSistem.sortByOwnerById();
			menu();
		} else if (option == 3) {
			centralSistem.sortByOwnerByLastName();
			menu();
		} else if (option == 4) {
			centralSistem.sortByOwnerByBirthdate();
			menu();
		} else if (option == 5) {
			centralSistem.sortByOwnerByKindOfPets();
			menu();
		} else if (option == 6) {
			centralSistem.sortByClubsById();
			menu();
		} else if (option == 7) {
			centralSistem.sortByClubsByName();
			menu();
		} else if (option == 8) {
			centralSistem.sortByClubsByCreationDate();
			menu();
		} else if (option == 9) {
			centralSistem.sortByPetById();
			menu();
		} else if (option == 10) {
			centralSistem.sortByPetByName();
			menu();
		} else if (option == 11) {
			centralSistem.sortByPetByBirthdate();
			menu();
		} else if (option == 12) {
			centralSistem.sortByPetByGender();
			menu();
		} else if (option == 13) {
			centralSistem.sortByPetByKinfOfPet();
			menu();
		} else if (option == 14) {
			System.out.println("Digite el nombre del dueño que va a buscar");
			line = br.readLine();
			if (centralSistem.search('o', 'n', line) != null) {
				System.out.println("El dueño ya esta registrado");
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 15) {
			System.out.println("Digite el id del dueño que va a buscar");
			line = br.readLine();
			if (centralSistem.search('o', 'i', line) != null) {
				System.out.println("El dueño ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 16) {
			System.out.println("Digite el apellido del dueño que va a buscar");
			line = br.readLine();
			if (centralSistem.search('o', 'l', line) != null) {
				System.out.println("El dueño ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 17) {
			System.out.println("Digite la fecha de nacimiento del dueño que va a buscar (D/M/AAAA)");
			line = br.readLine();
			if (centralSistem.search('o', 'b', line) != null) {
				System.out.println("El dueño ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 18) {
			System.out.println("Digite el tipo de mascotas del dueño que va a buscar");
			line = br.readLine();
			if (centralSistem.search('o', 'k', line) != null) {
				System.out.println("El dueño ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 19) {
			System.out.println("Digite el id del club que va a buscar");
			line = br.readLine();
			if (centralSistem.search('c', 'i', line) != null) {
				System.out.println("El club ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El club no esta registrado");
			}
			menu();
		} else if (option == 20) {
			System.out.println("Digite el nombre del club que va a buscar");
			line = br.readLine();
			if (centralSistem.search('c', 'n', line) != null) {
				System.out.println("El club ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El club no esta registrado");
			}
			menu();
		} else if (option == 21) {
			System.out.println("Digite la fecha de cracion del club que va a buscar (D/M/AAAA)");
			line = br.readLine();
			if (centralSistem.search('c', 'c', line) != null) {
				System.out.println("El club ya esta registrado");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("El club no esta registrado");
			}
			menu();
		} else if (option == 22) {
			System.out.println("Digite el id de la mascota que va a buscar");
			line = br.readLine();
			if (centralSistem.search('p', 'i', line) != null) {
				System.out.println("La mascota ya esta registrada");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("La mascota no esta registrada");
			}
			menu();
		} else if (option == 23) {
			System.out.println("Digite el nombre de la mascota que va a buscar");
			line = br.readLine();
			if (centralSistem.search('p', 'n', line) != null) {
				System.out.println("La mascota ya esta registrada");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("La mascota no esta registrada");
			}
			menu();
		} else if (option == 24) {
			System.out.println("Digite la fecha de nacimiento de la mascota que va a buscar (D/M/AAAA)");
			line = br.readLine();
			if (centralSistem.search('p', 'b', line) != null) {
				System.out.println("La mascota ya esta registrada");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("La mascota no esta registrada");
			}
			menu();
		} else if (option == 25) {
			System.out.println("Digite el genero de la mascota que va a buscar");
			line = br.readLine();
			if (centralSistem.search('p', 'g', line) != null) {
				System.out.println("La mascota ya esta registrada");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("La mascota no esta registrada");
			}
			menu();
		} else if (option == 26) {
			System.out.println("Digite el tipo de mascota que va a buscar");
			line = br.readLine();
			if (centralSistem.search('p', 'k', line) != null) {
				System.out.println("La mascota ya esta registrada");
				System.out.println("El tiempo que tardo haciendo la busqueda binaria fue: " + centralSistem.timeBinary());
				System.out.println("El tiempo que tardo haciendo la busqueda lineal fue: " + centralSistem.timeLineal());
			} else {
				System.out.println("La mascota no esta registrada");
			}
			menu();
		} else if (option == 27) {
			System.out.println("Digite el id del dueño");
			String id = br.readLine();
			System.out.println("Digite el nombre del dueño");
			String name = br.readLine();
			System.out.println("Digite el apellido del dueño");
			String lastName = br.readLine();
			System.out.println("Digite la fecha de nacimiento del dueño");
			String birthdate = br.readLine();
			System.out.println("Digite el genero de mascotas preferidas del dueño");
			String kindOfPets = br.readLine();
			System.out.println("Digite el id de la mascota del dueño");
			String idPet = br.readLine();
			System.out.println("Digite la fecha de nacimiento de la mascota del dueño");
			String birthdatePet = br.readLine();
			System.out.println("Digite el nombre de la mascota del dueño");
			String namePet = br.readLine();
			System.out.println("Digite el genero de la mascota del dueño");
			String genderPet = br.readLine();
			System.out.println("Digite el tipo de mascota del dueño");
			String kindOfPet = br.readLine();

			centralSistem.addOwner(id, name, lastName, birthdate, kindOfPets, idPet, birthdatePet, namePet,
					genderPet, kindOfPet);

			System.out.println("El dueño ha sido agregado correctamente");
			menu();
		} else if (option == 28) {
			System.out.println("Digite el id del dueño a quien desea agregar la mascota");
			String idOwner = br.readLine();

			if (centralSistem.search('o', 'i', idOwner) != null) {
				System.out.println("Digite el id de la mascota a agregar");
				String id = br.readLine();
				System.out.println("Digite la fecha de nacimiento de la mascota a agregar");
				String birthdate = br.readLine();
				System.out.println("Digite el nombre de la mascota a agregar");
				String name = br.readLine();
				System.out.println("Digite el genero de la mascota a agregar");
				String gender = br.readLine();
				System.out.println("Digite el tipo de mascota a agregar");
				String kindOfPet = br.readLine();

				Pet p = new Pet(id, name, birthdate, gender, kindOfPet);
				centralSistem.searchByIdOwner(idOwner).setPet(p);

				System.out.println("La mascota ha sido registrada en el dueño indicado");
			} else {
				System.out.println("El dueño no esta registrado");
			}
			menu();
		} else if (option == 29) {
			System.out.println("Digite el id del club que va a eliminar");
			line = br.readLine();
			centralSistem.deleteClub(line);
			System.out.println("La mascota ha sido eliminada exitosamente");
			menu();
		} else if (option == 30) {
			System.out.println("Digite el id del dueño que va a eliminar");
			line = br.readLine();
			centralSistem.deleteOwner(line);
			System.out.println("La mascota ha sido eliminada exitosamente");
			menu();
		} else if (option == 31) {
			System.out.println("Digite el id de la mascota que va a eliminar");
			line = br.readLine();
			centralSistem.deletePet(line);
			System.out.println("La mascota ha sido eliminada exitosamente");
			menu();
		} else {
			centralSistem.saveClubs();
			centralSistem.saveOwners();
			System.exit(0);
		}
	}
}