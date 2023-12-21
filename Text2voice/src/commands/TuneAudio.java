package commands;

import model.Document;
import view.WindowData;

public class TuneAudio implements Command{
	
	private WindowData wData;
	public TuneAudio(WindowData wData) {
		this.wData = wData;
	}
	
	public void execute() {
		
		if(wData.getFlag().equals("pitch")) {
			wData.getDocument().setPitch(wData.getPitch());
		}else {
			wData.getDocument().setVolume(wData.getVolume());
		}
	}
}
