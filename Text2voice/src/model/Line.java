package model;


import java.util.ArrayList;

import com.sun.speech.freetts.*;

public class Line {

	private ArrayList<String> words;// = new ArrayList<String>();
	private String sp;
	
	private VoiceManager voiceManager;
	private Voice voice;
	private float pitch;
	private float volume;
	
	public Line( ArrayList<String> w) {
		this.words = w;
		this.voiceManager = VoiceManager.getInstance();
		this.voice = this.voiceManager.getVoice("kevin16");
		voice.allocate();
		
	}
	
	public Line(String s) {
		this.sp = s;
	}
	public Line() {

	}
	public void setWords(ArrayList<String> w) {
		this.words = w;
	}
	
	public void playLine() {

		this.voice.setPitch(pitch);
		this.voice.setVolume(volume);
		System.out.println(volume);
		for(String s : this.words) {
			this.voice.speak(s);
			
		}

	}
	
	public void playReverseLine() {

		this.voice.setPitch(pitch);
		this.voice.setVolume(volume);
		for(String s : this.words) {
			this.voice.speak(s);
		}
	}
	

	
	public void setPitch(float f) {
		this.pitch = f;
	}

	public void setVolume(float v) {
		this.volume = v;
	}
	
}
