package commands;


import model.Document;
import view.WindowData;

public class LineToSpeech implements Command{
	
	private WindowData wData;
	public LineToSpeech(WindowData wData) {
		this.wData = wData;
	}
	
	public void execute() {
		
		String lines[] = wData.getJEditorPane().getText().split("\n");	
		
		 wData.getDocument().setLines(lines);
		if(lines.length > (wData.getLine()-2)/15) {
			if(wData.isReversed()==true) {
				
				 wData.getDocument().playReverseLine(wData.getLine()/15);
				wData.setReversed(false);
				
			}else {
				 wData.getDocument().playLine(wData.getLine()/15);
					
			}
			wData.setContentsHistory(lines[wData.getLine()/15]);
		}
		
		
	}
}
