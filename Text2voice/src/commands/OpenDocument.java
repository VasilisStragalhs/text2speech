package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import model.Doc;
import view.MainWindow;
import view.WindowData;

public class OpenDocument implements Command{
	
	private WindowData wData;
	public OpenDocument(WindowData wData) {
		this.wData = wData;
	}

	public void execute() {
		
		
		JFileChooser chooser = new JFileChooser();
		 chooser.setCurrentDirectory(new java.io.File("./")); 
		int option = chooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			String filename = chooser.getSelectedFile().toString();
		
		
		try {

			FileInputStream fi = new FileInputStream(new File(filename));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			Doc doc = (Doc) oi.readObject();
			
			wData.setFilename(filename);
			wData.setContents(doc.getContents());
			wData.setAuthor(doc.getAuthor());
			wData.setTitle(doc.getTitle());
			wData.setDate(doc.getDate());
			wData.setSaveDate(doc.getSaveDate());

			System.out.println(doc.toString());
		

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
		
		MainWindow mainWindow = new MainWindow(wData);
		}
	}
}
