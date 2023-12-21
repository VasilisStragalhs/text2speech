package commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.Doc;
import view.WindowData;

public class SaveDocument implements Command{
	
	private WindowData wData;
	public SaveDocument(WindowData wData) {
		this.wData = wData;
	}
	
	public void execute() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
	    String date = dtf.format(now);
	    wData.setSaveDate(date);
	    
		Doc d = new Doc(wData.getTitle(), wData.getAuthor(), wData.getDate(),wData.getContents(), wData.getSaveDate());
		
		try {
			FileOutputStream f = new FileOutputStream(new File(wData.getFilename()));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(d);
			o.close();
			f.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}
		
	
	}
}
