package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _09_TestFindAllPrestationsByEmployeeId extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindAllPrestationsByBatman() {
		java.util.List<? extends Prestation> list = this.repository.findAllPrestationsByEmployeeId(1L);
		assertNotNull(list);
		assertEquals(1, list.size());
		Prestation p = list.get(0);
		this.isSendmail(p);
	}
	
	@Test
	public void testFindAllPrestationsByWonderwoman() {
		java.util.List<? extends Prestation> list = this.repository.findAllPrestationsByEmployeeId(2L);
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Prestation p : list) {
			assertNotNull(p);
			assertNotNull(p.getId());
			if (p.getId() == 2L) {
				isReadmail(p);
			} else {
				isRespondmail(p);
			}
		}
	}

}
