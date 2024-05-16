package test.testDao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Audio;
import model.Musikaria;
import model.dao.MusikariaDao;
import model.sql.Kone;

public class MusikariaDaoTest {
	private static String irudia = "/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxANDg0ODw4IDg0NDQ0ODQ0PDQ8ODQoNFREWFhURExMYHSggGBolGxMTITEhJSkrLi4uFx8zODM4NygtOisBCgoKDg0OFQ8QFSsZFRktKy0rKys3Kys3LSstKysrNy0rKy0rNy03KysrKystKzcrLS0rKysrKystKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAaAAEAAwEBAQAAAAAAAAAAAAAAAgMEBQEH/8QAKRABAAEDAgUEAgMBAAAAAAAAAAECAxEEMSFBUWGBEpGhsTJxFCJC0f/EABcBAQEBAQAAAAAAAAAAAAAAAAACAQP/xAAWEQEBAQAAAAAAAAAAAAAAAAAAARH/2gAMAwEAAhEDEQA/APqYDu4gAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAnbtTV/1pt2IjvLNMZabcztEradNPOYhqGarFMaaO73+PT0+VoaYq/j09J93k6aOtS4NMZatNPKYlVVbmN4lvDTHOGy5Yie0s1y3NO/u3U4gA0AAAAAAAAAAAAAAF9mxnjPt1S09nnPiGhlrZCIwAlQAAK7l+Ke8qJ1M8sQ3Ga1jJGpq7Sut6iJ34SYatAY0JjIAy3rGOMbdOih0WbUWeceYVKmxnAawAAAAAAAAAAXae1mcztHzKqinMxHVvopxGGWtkegJUAAKdRdxwjefhcwXKszMtjKiApIADTprv8AmfDQ50Tji6FM5iJTVR6AxoADHqLXpnMbT8KnQrpzEwwVU4mY6KlTY8AawAAAAAAABo0lG9XiGlG1TimI7JJqoAMaAAVbT+nOdFhvU4qlsTUAFMAAG+z+NP6YaKczEdXQiMMrYAJUAAM2ro2q8S0o3qc0zDYysACkgAAAAACVqM1RHdFbpo/tANgCFgAAACu9a9Ud4WAOfVGOEvG+u3FW8KZ0scplWpxmIhpjS9ZW0Wop2jyaYhp7Pp4zv9LgSoAAAAABz7kYmY7vFmoj+0q1oAAAAAAF2l/LwpW6af7eCkbAELAAAAARqriN5gEhTOpp7o/yu0+7cZrQM8artPulGpp7mGrh5TXE7TD1jQAAAAAGPVfl4hUt1M/2lUuIoAAAAAAnZnFUftAgHRHlFWYiez1CwABTc1ERtx+lV+9nhG32pVIm1Ou7M80AawAAAATouzHNABrt6iJ34T8LnOXWL2OE7fTLGytYCVAI3KsRMgxXZzVP7RBaAAAAAAAAGrSV8MdF7Bbr9MxLfE5TVQRvfjOOiQxrnC/UWccY2+lC0AAAAAAAAAL9PZzxnbl3BotfjGd8JAhYz6uvaPMtEziMsFyr1TMtjKiApIAAAAAAAA0aa7/mfDOA6IqsXfVwnf7WoWM17T86fZpBjnDdXaireOPVRVpp5Yn7VrMUCU25jlPsjhrAMJRbmeU+wIkQvp0088QvotRTtHlmtxTZ0/Or2aQS0BTfvY4Rv9DUNTd/zHlnBaAAAAAAAAAAAACJw12b+eE7/bIFhrojJavzHCeMfLTRciraU4rUgGNDH6ADH6AAAAEa7kU7yy3b8zwjhHy3GatvX8cI369GWZBWJ0AAAAAAAAAAAAAAAAIkAW0aiY34rqdTHPMMgzDW6LtM84S9UdYc8MbroeqOsIzdpjnDCGGtdWpjlEypr1Ez2VBjNJAaAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAP/2Q==";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Musikaria musikariTest = new Musikaria("probaEzabatuTest", "deskripzioa", irudia, "taldea");
		Musikaria musikari1Test = new Musikaria("probaTest", "deskripzioa", irudia, "taldea");
		Musikaria musikari2Test = new Musikaria("probaEditTest", "deskripzioa", irudia, "taldea");

		Kone.konektatuAdminKomprobatu("root", "");
		MusikariaDao.gehituMusikaria(musikariTest);
		MusikariaDao.gehituMusikaria(musikari1Test);
		MusikariaDao.gehituMusikaria(musikari2Test);
	}

	@Test
	public void getMusikariaTest() throws SQLException {
		Musikaria musikariaTest = MusikariaDao.getMusikaria("Burnout Syndromes");
		Musikaria musikariTest = new Musikaria(1, "Burnout Syndromes",
				"BURNOUT SINDROMES (バーンアウトシンドロームズ) Osakako japoniar rock talde bat da. 2005eko maiatzaren 4an eratua.",
				null, "taldea");

		assertEquals(musikariaTest, musikariTest);

	}

	@Test
	public void getMusikariaByAudio() throws SQLException {
		Audio audioTest = new Audio();
		audioTest.setIdAudio(1);

		Musikaria musikariaTestarako = new Musikaria("Burnout Syndromes", "BURNOUT SINDROMES (バーンアウトシンドロームズ) Osakako japoniar rock talde bat da. 2005eko maiatzaren 4an eratua.",
				null);

		Musikaria musikariaTest = MusikariaDao.getMusikariaByAudio(audioTest);

		assertEquals(musikariaTestarako, musikariaTest);
	}

	@Test
	public void gehituMusikariaTest() throws SQLException {
		Kone.konektatuAdminKomprobatu("root", "");
		Musikaria musikariTest = new Musikaria("probaGehituTest", "deskripzioa", irudia, "bakarlaria");
		boolean test = MusikariaDao.gehituMusikaria(musikariTest);
		assertTrue(test);
	}
	
	@Test
	public void getMusikariakTest() throws SQLException {
		
		ArrayList<Musikaria> musikariak = MusikariaDao.getMusikariak();
		Musikaria musikariaTestarako = new Musikaria(1, "Burnout Syndromes",
				"BURNOUT SINDROMES (バーンアウトシンドロームズ) Osakako japoniar rock talde bat da. 2005eko maiatzaren 4an eratua.", null, "taldea");
		assertEquals(musikariaTestarako, musikariak.get(0));
	}

	@Test
	public void ezabatuMusikariaTest() throws SQLException {
		boolean test;
		test = MusikariaDao.ezabatuMusikaria("probaEzabatuTest");
		assertTrue(test);
	}

	@AfterClass
	public static void setUpAfterClass() throws Exception {
		MusikariaDao.ezabatuMusikaria("probaGehituTest");
		MusikariaDao.ezabatuMusikaria("probaEditatuTest");
		MusikariaDao.ezabatuMusikaria("probaEditTest");
		
	}

}