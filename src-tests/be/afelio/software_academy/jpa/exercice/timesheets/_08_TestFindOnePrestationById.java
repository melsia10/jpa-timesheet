package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Prestation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _08_TestFindOnePrestationById extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindSendmailById() {
		Prestation p = this.repository.findOnePrestationById(1L);
		this.isSendmail(p);
	}
	
	@Test
	public void testFindReadmailById() {
		Prestation p = this.repository.findOnePrestationById(2L);
		this.isReadmail(p);
	}

}
