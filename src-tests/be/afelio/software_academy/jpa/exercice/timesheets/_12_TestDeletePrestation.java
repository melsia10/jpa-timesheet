package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _12_TestDeletePrestation extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testDeletePrestation() {
		long time = System.currentTimeMillis();
		long employeeId = 3L;
		long projectId = 2L;
		java.util.Date day = this.getStringAsDate("2017-06-30");
		String comment = String.valueOf(time);
		int duration = 3;
		
		Prestation p = this.repository.addPrestation(employeeId, projectId, comment, day, duration);
		assertNotNull(p);
		System.out.println(p);
		System.out.println(p.getId());
		assertNotNull(p.getId());
		assertEquals(day, p.getDay());
		assertEquals(comment, p.getComment());
		assertEquals(duration, p.getDuration());
		this.isSuperman(p.getEmployee());
		this.isFortressOfSolitude(p.getProject());
		
		Prestation p2 = this.repository.findOnePrestationById(p.getId());
		assertNotNull(p2);
		assertEquals(p, p2);
		
		this.repository.deletePrestation(p.getId());
		p2 = this.repository.findOnePrestationById(p.getId());
		assertNull(p2);
	}
}
