package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.CentralSistem;

public class Main {

	private static CentralSistem centralSistem;

	public static void main(String[] args) {
		Main m = new Main();
		centralSistem = new CentralSistem();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\t SISTEMA CENTRAL \n");
		try {
			String line = br.readLine();		
			int option = Integer.parseInt(line);
	
			while(option != 32) {
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
				System.out.println("28. Registrara una mascota");
				
				System.out.println("29. Eliminar club por id");
				System.out.println("30. Eliminar dueño por id");
				System.out.println("31. Eliminar mascota por id");
				
				System.out.println("32. Salir");
				
				if(option == 1) {
					centralSistem.sortByOwnerByName();
				}else if(option == 2) {
					centralSistem.sortByOwnerById();
				}else if(option == 3) {
					centralSistem.sortByOwnerByLastName();
				}else if(option == 4) {
					centralSistem.sortByOwnerByBirthdate();
				}else if(option == 5) {
					centralSistem.sortByOwnerByKindOfPets();
				}else if(option == 6) {
					centralSistem.sortByClubsById();
				}else if(option == 7) {
					centralSistem.sortByClubsByName();
				}else if(option == 8) {
					centralSistem.sortByClubsByCreationDate();
				}else if(option == 9) {
					centralSistem.sortByPetById();
				}else if(option == 10) {
					centralSistem.sortByPetByName();
				}else if(option == 11) {
					centralSistem.sortByPetByBirthdate();
				}else if(option == 12) {
					centralSistem.sortByPetByGender();
				}else if(option == 13) {
					centralSistem.sortByPetByKinfOfPet();
				}else if(option == 14) {
					System.out.println("Digite el nombre del dueño que va a buscar");
					line = br.readLine();
					if(centralSistem.search('o', 'n', line) != null) {
						System.out.println("El dueño ya esta registrado");
					}else {
						System.out.println("El dueño no esta registrado");
					}						
				}else if(option == 15) {
					System.out.println("Digite el id del dueño que va a buscar");
					line = br.readLine();
					if(centralSistem.search('o', 'i', line) != null) {
						System.out.println("El dueño ya esta registrado");
					}else {
						System.out.println("El dueño no esta registrado");
					}					
				}else if(option == 16) {
					
				}else if(option == 17) {
					
				}else if(option == 18) {
					
				}else if(option == 19) {
					
				}else if(option == 20) {
					
				}else if(option == 21) {
					
				}else if(option == 22) {
					
				}else if(option == 23) {
					
				}else if(option == 24) {
					
				}else if(option == 25) {
					
				}else if(option == 26) {
					
				}else if(option == 27) {
					
				}else if(option == 28) {
					
				}else if(option == 29) {
					
				}else if(option == 30) {
					
				}else if(option == 31) {
					
				}else{
					System.exit(0);
				}
			
				line = br.readLine();
			}			
		} catch (IOException e) {}
	}

}
