package test.objetuakTest;
import static org.junit.Assert.*;

import org.junit.Test;

import model.Podcasterra;

public class PodcasterraTest {

	@Test 
	public void testPodcasterraEquals() {
		Podcasterra podcasterra1 = new Podcasterra("Podcasterra", null, 1);
		Podcasterra podcasterra2 = new Podcasterra("Podcasterra", null, 1);
		assertTrue(podcasterra1.equals(podcasterra2));
	}
	
	@Test 
	public void testPodcasterraEquals2() {
		Podcasterra podcasterra1 = new Podcasterra(1, "Podcasterra", "desc", null);
		Podcasterra podcasterra2 = new Podcasterra(1, "Podcasterra", "desc", null);
		assertTrue(podcasterra1.equals(podcasterra2));
	}
	
	@Test 
	public void testPodcasterraEquals3() {
		Podcasterra podcasterra1 = new Podcasterra(1, "Podcasterra");
		Podcasterra podcasterra2 = new Podcasterra(1, "Podcasterra");
		assertTrue(podcasterra1.equals(podcasterra2));
	}
}