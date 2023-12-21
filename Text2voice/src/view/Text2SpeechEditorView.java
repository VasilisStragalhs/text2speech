package view;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javax.swing.JOptionPane;


public class Text2SpeechEditorView {

	private JFrame frame;
	//private JEditorPane editorPane = new JEditorPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechEditorView window = new Text2SpeechEditorView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Text2SpeechEditorView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(null);

		JButton btnCreate = new JButton("New Document");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				WindowData wData = new WindowData();
				wData.getController().enact("newDocument");
			}
		});
		btnCreate.setBounds(80, 26, 278, 36);
		frame.getContentPane().add(btnCreate);

		
		JButton btnOpen = new JButton("Open Document");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					WindowData wData = new WindowData();
					wData.getController().enact("openDocument");

			}
		});
		btnOpen.setBounds(80, 92, 278, 36);
		frame.getContentPane().add(btnOpen);
		
		
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(80, 158, 278, 36);
		frame.getContentPane().add(btnExit);

		
		
	}

}
