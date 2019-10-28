package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class _04_TestFindAllEmployees extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllEmployees() {
		java.util.List<? extends Employee> list = this.repository.findAllEmployees();
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Employee e : list) {
			assertNotNull(e);
			assertEquals(e, this.repository.findOneEmployeeById(e.getId()));
		}
	}
}
