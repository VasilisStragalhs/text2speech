package view;

import java.util.ArrayList;

import javax.swing.JEditorPane;

import commands.Controller;
import model.Document;

public class WindowData {

	private String title;
	private String author;
	private String date;
	private String saveDate;
	private String filename;
	private Controller con;
	private String contents;
	private JEditorPane jedp;
	private int line;
	private boolean reversed;
	private ArrayList<String> commands;
	private ArrayList<String> contentsHistory;
	private Document document;
	private float pitch;
	private float volume = 1;
	private String flag;
	
	public WindowData(	ArrayList<String> com,ArrayList<String> ch) {
		this.con = new Controller(this);
		this.commands = com;
		this.contentsHistory = ch;
		this.document = new Document();
	}
	public void setReplay(String r) {
		this.commands.add(r);
	}
	public ArrayList<String> getReplay() {
		return this.commands;
	}
	public void setContentsHistory(String cont) {
		this.contentsHistory.add(cont);
	}
	public ArrayList<String> getContentsHistory() {
		return this.contentsHistory;
	}
	
	public WindowData() {
		this.con = new Controller(this);
		this.commands = new ArrayList<String>();
		this.contentsHistory = new ArrayList<String>();
		this.document = new Document();
	}
	public WindowData(	String filename) {
		this.filename = filename;
		this.con = new Controller(this);
		this.commands = new ArrayList<String>();
		this.contentsHistory = new ArrayList<String>();
		this.document = new Document();
	}
	public WindowData(String title, String author, String date, String filename) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.filename = filename;
		this.con = new Controller(this);
		this.commands = new ArrayList<String>();
		this.contentsHistory = new ArrayList<String>();
		this.document = new Document();
	}
		
	public Controller getController() {
		return con;
	}
	
	public void setFilename(String f) {
		this.filename = f;
	}
	
	public String getFilename() {
		return this.filename;
	}
	
	public void setContents(String cont) {
		this.contents = cont;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getSaveDate() {
		return this.saveDate;
	}
	
	public void setSaveDate(String d) {
		this.saveDate = d;
	}
	
	public void setTitle(String t) {
		this.title = t;
	}
	
	public void setAuthor(String a) {
		this.author = a;
	}
	
	public void setDate(String d) {
		this.date = d;
	}
	
	public void setJEditorPane(JEditorPane j) {
		this.jedp = j;
	}
	
	public JEditorPane getJEditorPane() {
		return this.jedp;
	}
	public void setLine(int x) {
		this.line = x;
	}
	public int getLine() {
		return this.line;
	}
	public boolean isReversed() {
		return reversed;
	}
	public void setReversed(boolean x) {
		this.reversed = x;
	}
	
	public void setDocument(Document d) {
		this.document = d;
	}
	public Document getDocument() {
		return this.document;
	}
	
	public void setPitch(float f) {
		this.pitch = f;
	}
	public float getPitch() {
		return this.pitch;
	}
	public void setVolume(float f) {
		this.volume = f;
	}
	public float getVolume() {
		return this.volume;
	}
	public void setFlag(String s) {
		this.flag = s;
	}
	public String getFlag() {
		return this.flag;
	}
}
