package be.afelio.software_academy.jpa.exercice.timesheets;

import be.afelio.software_academy.jpa.exercice.timesheets.TimesheetsRepository;
import be.afelio.software_academy.jpa.exercice.timesheets.beans.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _05_TestFindOneProjectById extends TestBase {

	private TimesheetsRepository repository;
	
	@BeforeEach
	public void setUp() throws Exception {
		repository = TestsFactory.createTimesheetsRepository();
		assertNotNull(repository);
	}

	@Test
	public void testFindJusticeLeagueById() {
		Project p = this.repository.findOneProjectById(1L);
		this.isJusticeLeague(p);
	}
}
