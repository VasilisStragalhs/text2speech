package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import view.WindowData;

class TuneAudioTest {
	
	
	

	@Test
	void test() {
		WindowData wData = new WindowData();
		wData.setFlag("pitch");
		wData.setPitch(100);
		TuneAudio  tuner = new TuneAudio(wData);
		tuner.execute();
		assertEquals(100, wData.getDocument().getPitch());
		
	}
	
	@Test
	void test2() {
		WindowData wData = new WindowData();
		wData.setFlag("volume");
		wData.setVolume(50);
		TuneAudio  tuner = new TuneAudio(wData);
		tuner.execute();
		assertEquals(50, wData.getDocument().getVolume());
		
	}

}
