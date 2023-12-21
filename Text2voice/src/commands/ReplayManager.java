package commands;

import view.WindowData;

public class ReplayManager implements Command{
	
	private WindowData wData;
	public ReplayManager(WindowData wData) {
		this.wData = wData;
	}
	
	public void execute() {
		
		int i = 0;
		for(String s: wData.getReplay()) {
			String con = wData.getContents();
			if(s.equals("reversed")) {
				wData.setReversed(true);
				//wData.setContents(editorPane.getText());
				wData.setContents(wData.getContentsHistory().get(i));
				wData.getController().enact("documentToSpeech");
			}
			else if(s.equals("reversedLine")){
				wData.setReversed(true);
				//wData.setContents(editorPane.getText());
				wData.setContents(wData.getContentsHistory().get(i));
				wData.getController().enact("lineToSpeech");
			}
			else {
				wData.setContents(wData.getContentsHistory().get(i));
				wData.getController().enact(s);
			}
			wData.setContents(con);
			i++;
		}
		
	}
}
