package commands;

import model.Document;
import view.WindowData;

public class DocumentToSpeech implements Command{

	private WindowData wData;
	public DocumentToSpeech(WindowData wData) {
		this.wData = wData;
	}
	public void execute() {
		
		if(wData.isReversed()==true) {
			
			wData.getDocument().playReverseContents();
			wData.setReversed(false);
		}else {
			wData.getDocument().playContents();
		}
		
	}
}
