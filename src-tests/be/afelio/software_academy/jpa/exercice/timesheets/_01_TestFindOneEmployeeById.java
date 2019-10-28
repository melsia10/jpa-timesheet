package be.afelio.software_academy.jpa.exercice.timesheets;



import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Employee;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class _01_TestFindOneEmployeeById extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindNotExistingId() {
		Employee e = this.repository.findOneEmployeeById(0L);
		assertNull(e);
	}
	
	@Test
	public void testFindBatmanById() {
		Employee e = this.repository.findOneEmployeeById(1L);
		this.isBatman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(1, list.size());
		this.isJusticeLeague(list.get(0));
	}
	
	@Test
	public void testFindWonderwomanById() {
		Employee e = repository.findOneEmployeeById(2L);
		this.isWonderwoman(e);
		
		java.util.List<? extends Project> list = e.getManagedProjects();
		assertNotNull(list);
		assertEquals(0, list.size());
	}

}
