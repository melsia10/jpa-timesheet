package be.afelio.software_academy.jpa.exercice.timesheets;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;


public class _02_TestFindOneEmployeeByFirstnameAndName extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindBatmanByFirstnameAndName() {
		Employee e = this.repository.findOneEmployeeByFirstnameAndName("bruce", "wayne");
		this.isBatman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(1, list.size());
		this.isJusticeLeague(list.get(0));
	}
	
	@Test
	public void testFindWonderwomanByFirstnameAndName() {
		Employee e = repository.findOneEmployeeByFirstnameAndName("diana", "prince");
		this.isWonderwoman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}
