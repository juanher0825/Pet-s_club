package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class CentralSistemTest {
	
	CentralSistem central;
	
	public void setupScenary1() throws ClassNotFoundException, IOException {
		central = new CentralSistem();
	}

	@Test
	void loadClubsTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.loadClubs();
		
		assertTrue(central.getClubs().get(0).getName().equals("Cassie"), "No se reviso nada");
		assertTrue(central.getClubs().get(1).getName().equals("Orion"), "No se reviso nada");
	}
	
	@Test
	void loadOwnersTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.loadOwners();
		
		assertTrue(central.getOwners().get(0).getName().equals("Fin"), "No se reviso nada");
		assertTrue(central.getOwners().get(1).getName().equals("Rosalinda"), "No se reviso nada");
	}
	
	@Test
	
	void sortByClubsByNameTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.sortByClubsByName();
		assertTrue(central.getClubs().get(0).getName().equals("Aaron"), "No se reviso correctamente");
	}
	
	@Test
	
	void sortByClubsByIdTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.sortByClubsById();
		assertTrue(central.getClubs().get(2).getName().equals("Florella"), "No se reviso correctamente");
	}
	
	@Test
	

	
	void sortByOwnersByNameTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.sortByOwnerByName();
		assertTrue(central.getOwners().get(0).getName().equals("Aarika"), "No se reviso correctamente");
	}
	
@Test
	

	
	void sortByOwnersByLastNameTest() throws ClassNotFoundException, IOException {
		setupScenary1();
		central.sortByOwnerByLastName();
		assertTrue(central.getOwners().get(0).getLastName().equals("Abbotson"), "No se reviso correctamente");
	}



}
