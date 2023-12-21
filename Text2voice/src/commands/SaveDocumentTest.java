package commands;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.jupiter.api.Test;

import model.Doc;
import view.WindowData;

class SaveDocumentTest {

	@Test
	void test() {
		WindowData wData = new WindowData();
		wData.setContents("Hi my name is hi");
		wData.setAuthor("Me");
		wData.setTitle("ThisTitle");
		wData.setDate("today");
		wData.setFilename("./savedFile");
		SaveDocument save = new SaveDocument(wData);
		save.execute();
		
		Doc doc = new Doc();
		try {

			FileInputStream fi = new FileInputStream(new File("./savedFile"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			doc = (Doc) oi.readObject();
			
			wData.setFilename("./savedFile");
			wData.setContents(doc.getContents());
			wData.setAuthor(doc.getAuthor());
			wData.setTitle(doc.getTitle());
			wData.setDate(doc.getDate());
			wData.setSaveDate(doc.getSaveDate());
		
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		assertEquals("Me", doc.getAuthor()); // or assertEquals(wData.getAuthor(),doc.getAuthor());
		assertEquals("ThisTitle", doc.getTitle());
		assertEquals("Hi my name is hi", doc.getContents());
		assertEquals("today", doc.getDate());
		
	}

}
