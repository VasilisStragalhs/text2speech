package commands;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import view.WindowData;

public class Controller {
	
	private HashMap<String, Command> commands;
	ArrayList<String> cname = new ArrayList<String>();
	List<String> classnames = Arrays.asList("documentToSpeech","editDocument","lineToSpeech","newDocument","openDocument","replayDocument","replayManager","saveDocument","tuneAudio","tuneEncoding");
	
	public Controller(WindowData wData) {
		cname.addAll(classnames);
		CommandFactory commandFactory = new CommandFactory(wData);
		commands = new HashMap<String, Command>();
		for(String str : cname) {
			commands.put(str, commandFactory.createCommand(str));
		}

	}

	public void enact(String com) {
		commands.get(com).execute();
	}
}
