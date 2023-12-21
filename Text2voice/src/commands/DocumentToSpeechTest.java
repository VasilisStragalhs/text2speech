package commands;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Document;
import view.WindowData;

class DocumentToSpeechTest {

	private WindowData wData = new WindowData();
	private DocumentToSpeech d2s = new DocumentToSpeech(wData);
	
	
	@Test
	void test() {
		
		this.wData.setDocument(new Document("Hi my name is hi"));
		d2s.execute();
		assertEquals("Hi my name is hi", this.wData.getDocument().getContents());
			
	}

	@Test
	void test2() {
		
		this.wData.setDocument(new Document("Hi my name is hi"));
		this.wData.setReversed(true);
		d2s.execute();
		assertEquals("hi is name my Hi ", this.wData.getDocument().getContents());
			
	}
}
