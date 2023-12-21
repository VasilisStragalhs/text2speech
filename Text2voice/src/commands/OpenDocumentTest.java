package commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.jupiter.api.Test;

import model.Doc;
import view.WindowData;

class OpenDocumentTest {

	@Test
	void test() {

		WindowData wData = new WindowData();
		wData.setContents("Hi my name is hi");
		wData.setAuthor("Me");
		wData.setTitle("ThisTitle");
		wData.setDate("today");
		wData.setFilename("./openFileTest");
		SaveDocument save = new SaveDocument(wData);
		save.execute();
		
		WindowData wDataOpen = new WindowData();
		OpenDocument open = new OpenDocument(wDataOpen);
		open.execute();
		
		assertEquals("Me", wDataOpen.getAuthor());
		assertEquals("ThisTitle", wDataOpen.getTitle());
		assertEquals("Hi my name is hi", wDataOpen.getContents());
		assertEquals("today", wDataOpen.getDate());
		
		
	}

}
