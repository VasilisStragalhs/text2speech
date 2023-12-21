package model;
import java.util.ArrayList;



public class Document {
	
	private ArrayList<String> words;
	private String contents;
	private String[] lines;
	private Line line;
	private float pitch;
	private float volume = 1;
	public Document() {
		this.words = new ArrayList<String>();
		this.pitch = 100.0f;
	}
	public Document(String cont) {
		this.pitch = 100.0f;
		this.words = new ArrayList<String>();
		this.contents = cont;
		String temp[] = cont.split("\\s+");
		for(String s : temp) {
			this.words.add(s);
		}
		this.line = new Line(words);
		
	}
	
	
	public void setPitch(float f) {
		this.pitch = f;
	}
	

	public void setVolume(float f) {
		this.volume = f;
	}
	public void playContents() {

		this.line = new Line(words);
		this.line.setPitch(this.pitch);
		this.line.setVolume(this.volume);
		this.line.playLine();
	}
	public Line getLine() {
		return this.line;
	}
	
	public void playReverseContents() {
		String junitestString = "";
		String temp[] = contents.split("\\s+");
		ArrayList<String> reversed = new ArrayList<String>();
		for(int x = temp.length-1; x>=0; x--) {
			reversed.add(temp[x]);
			junitestString += temp[x]+" ";
		}
		
		this.contents = junitestString;
		
		Line l = new Line(reversed);
		l.setPitch(this.pitch);
		l.setVolume(this.volume);
		l.playReverseLine();
	}
	
	
	public void playLine(int x) {
		words = new ArrayList<String>();
		String temp[] = lines[x].split("\\s+");
		for(String s : temp) {
			this.words.add(s);
		}
		Line l = new Line(words);
		l.setPitch(this.pitch);
		l.setVolume(this.volume);
		l.playLine();
	}

	public void playReverseLine(int x) {
		words = new ArrayList<String>();
		String temp[] = lines[x].split("\\s+");
		ArrayList<String> reversed = new ArrayList<String>();
		for(int i = temp.length-1; i>=0; i--) {
			reversed.add(temp[i]);
		}
		
		Line l = new Line(reversed);
		l.setPitch(this.pitch);
		l.setVolume(this.volume);
		l.playReverseLine();
		
	}
	
	
	public void setContents(String cont) {
		this.contents = cont;
		words = new ArrayList<String>();
		String temp[] = cont.split("\\s+");
		for(String s : temp) {
			this.words.add(s);
		}
	}
	
	public void setLines(String[] l) {
		this.lines = l;
	}
	
	//for junit testing
	public String getContents() {
		return this.contents;
	}
	public float getPitch() {
		return this.pitch;
	}
	public float getVolume() {
		return this.volume;
	}
	
}
