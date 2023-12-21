package commands;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import view.MainWindow;
import view.WindowData;

public class NewDocument implements Command{
	
	private WindowData wData;
	public NewDocument(WindowData wData) {
		this.wData = wData;
	}
	
	public void execute() {
		
		String title = JOptionPane.showInputDialog("Give a title");
		String author = JOptionPane.showInputDialog("Give the name of the author");
	   
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    LocalDateTime now = LocalDateTime.now();
	    String date = dtf.format(now);
  
	    
	    JFileChooser filechooser = new JFileChooser();
		 filechooser.setCurrentDirectory(new java.io.File("./")); 

		int option = filechooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			String filename = filechooser.getSelectedFile().toString();
			if (filename.endsWith(".t2s") == false) {
				filename = filename + ".t2s";
			}
	    
			this.wData = new WindowData(title,author,date,filename);
			MainWindow mainWindow = new MainWindow(wData);
		
		}
	
	}
}
