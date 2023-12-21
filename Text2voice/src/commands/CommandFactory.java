package commands;

import view.WindowData;

public class CommandFactory {

	private WindowData wData;
	public CommandFactory(WindowData data) {
		super();
		this.wData = data;
	}

	public Command createCommand(String type) {
		
		if (type.equals("documentToSpeech")) {
			return new DocumentToSpeech(wData);
		}
		if (type.equals("editDocument")) {
			return new EditDocument();
		}
		if (type.equals("lineToSpeech")) {
			return new LineToSpeech(wData);
		}
		if (type.equals("newDocument")) {
			return new NewDocument(wData);
		}
		if (type.equals("openDocument")) {
			return new OpenDocument(wData);
		}
		if (type.equals("replayManager")) {
			return new ReplayManager(wData);
		}
		if (type.equals("saveDocument")) {
			return new SaveDocument(wData);
		}
		if (type.equals("tuneAudio")) {
			return new TuneAudio(wData);
		}
		
		
		return null;
	}
}
