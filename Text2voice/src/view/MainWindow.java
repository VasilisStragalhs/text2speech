package view;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFrame;

import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Document;



public class MainWindow {

	private JFrame frame;
	private JEditorPane editorPane = new JEditorPane();
	private ArrayList<String> commands;
	private Document document;
	private WindowData wData;
	public MainWindow(WindowData wData) {
		this.document = new Document();
		this.commands = new ArrayList<String>();
		
		this.wData = wData;
		
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFRAMEnew Text2SpeechEditorView());
		
		//JScrollPane scrollPane = new JScrollPane();
		//frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		frame.getContentPane().setLayout(null);
		editorPane.setText(wData.getContents());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 39, 415, 200);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(editorPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 800, 25);
		frame.getContentPane().add(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);


		JMenuItem mnOpen = new JMenuItem("Open");
		mnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				commands = wData.getReplay();
				ArrayList<String> conhistory = wData.getContentsHistory();
				WindowData wData = new WindowData(commands,conhistory);
				wData.getController().enact("openDocument");
	
			}
		});
		mnFile.add(mnOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 	
				wData.setContents(editorPane.getText());
				wData.getController().enact("saveDocument");
				wData.setReplay("saveDocument");
				wData.setContentsHistory("save");
			}
		});
		mnFile.add(mntmSave);
		
		
		JMenu mnControls = new JMenu("Controls");
		menuBar.add(mnControls);
		
		
		JMenuItem mnSpeak = new JMenuItem("Play");
		mnSpeak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//wData.setContents(editorPane.getText());
				document.setContents(editorPane.getText());
				wData.setDocument(document);
				
				wData.getController().enact("documentToSpeech");
				wData.setReplay("documentToSpeech");
				wData.setContentsHistory(editorPane.getText());
			}
		});
		mnControls.add(mnSpeak);
		
		JMenuItem mnSpeakReverse = new JMenuItem("Play in reverse");
		mnSpeakReverse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wData.setReversed(true);
				//wData.setContents(editorPane.getText());
				
				document.setContents(editorPane.getText());
				wData.setDocument(document);
				wData.getController().enact("documentToSpeech");
				wData.setReplay("reversed"); 
				wData.setContentsHistory(editorPane.getText());

			}
		});
		mnControls.add(mnSpeakReverse);


		
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem clickMenu = new JMenuItem("Play this line");
				clickMenu.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	wData.setJEditorPane(editorPane);
                    	
                    	wData.setDocument(document);
				        wData.getController().enact("lineToSpeech");
				        wData.setReplay("documentToSpeech");
				        
                    }
                });
        popupMenu.add(clickMenu);
        
        
        JMenuItem clickReversed = new JMenuItem("Play this line in reverse");
        clickReversed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	wData.setReversed(true);
            	
            	wData.setJEditorPane(editorPane);
            	wData.setDocument(document);
		        wData.getController().enact("lineToSpeech");
		        wData.setReplay("reversed"); 
            }
        });
		popupMenu.add(clickReversed);
                
        editorPane.setComponentPopupMenu(popupMenu);
        editorPane.addMouseListener(new MouseAdapter() {
				
        			public void mousePressed(MouseEvent e) {
				        int y=e.getY();
				        wData.setLine(y-3);
				       
				    }
			
	    }); 
        
        
		
		
		JMenu mnHistory = new JMenu("History");
		menuBar.add(mnHistory);

		JMenuItem mainWin = new JMenuItem("Return to Main Window");
		mainWin.setEnabled(false);
		
		JMenuItem showHistory = new JMenuItem("Show History");
		showHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JList list = new JList(wData.getReplay().toArray());
				scrollPane.setViewportView(list);
				mainWin.setEnabled(true);
			}
		});
		mnHistory.add(showHistory);
		

		JMenuItem replayMng = new JMenuItem("Replay");
		replayMng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				wData.getController().enact("replayManager");
				
			}
		});
		mnHistory.add(replayMng);
		
		//JMenuItem mainWin = new JMenuItem("Return to Main Window");
		mainWin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				scrollPane.setViewportView(editorPane);
				mainWin.setEnabled(false);
			}
		});
		mnHistory.add(mainWin);
		
		
		JMenu mnVolume = new JMenu("Volume");
		menuBar.add(mnVolume);
		
		JSlider volumeSlider = new JSlider();
		volumeSlider.setValue(100);
		volumeSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		        float value = volumeSlider.getValue();
		        
		        System.out.println(value);
		        if(value>35) {
		        	value = value + 15;
		        }
		        wData.setVolume(value/100);
		        
		        wData.setFlag("volume");
		        wData.getController().enact("tuneAudio");
		        //document.setVolume(value/100);
		      }
		    });
		
		mnVolume.add(volumeSlider);
		
		
		
		JMenu mnPitch = new JMenu("Pitch");
		menuBar.add(mnPitch);
		
		JSlider pitchSlider = new JSlider();
		pitchSlider.addChangeListener(new ChangeListener() {
		      public void stateChanged(ChangeEvent event) {
		        float value = pitchSlider.getValue();
		        if(value>35) {
		        	value = value+120.0f;
		        }
		        wData.setPitch(value);
		        wData.setFlag("pitch");
		        wData.getController().enact("tuneAudio");
		        //document.setPitch(value);
		      }
		    });
		
		mnPitch.add(pitchSlider);
		
		
		
	}

}
