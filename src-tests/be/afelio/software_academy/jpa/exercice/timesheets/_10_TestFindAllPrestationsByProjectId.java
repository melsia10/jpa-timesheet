package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _10_TestFindAllPrestationsByProjectId extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllPrestationsByProjectId() {
		java.util.List<? extends Prestation> list = this.repository.findAllPrestationsByProjectId(1L);
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Prestation p : list) {
			assertNotNull(p);
			assertEquals(p, this.repository.findOnePrestationById(p.getId()));
		}
	}

}
