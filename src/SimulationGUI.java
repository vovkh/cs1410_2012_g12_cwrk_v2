
//create
	//update

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class SimulationGUI implements SimulationOutput {

	private JFrame mainFrame;
	private JTextArea log;
	
	public SimulationGUI(){
		final int blankSpace = 6; 
		final int numChars = 50;
		JButton stopButton = new JButton();
		JButton pauseButton = new JButton();
		JButton playButton = new JButton();
		JButton showGraphButton = new JButton();
		
		log = new JTextArea();
		log.setEditable(false);
		JScrollPane listScroller = new JScrollPane(log);
		listScroller.setPreferredSize(new Dimension(300, 300));
		listScroller.setMinimumSize(new Dimension(200,200));
	
		stopButton.setText("Stop");
		stopButton.setToolTipText("Stop the simulation");
		pauseButton.setText("Pause");
		pauseButton.setToolTipText("Pause the simulation");
		playButton.setText("Play");
		playButton.setToolTipText("Play the simulation");
		showGraphButton.setText("Show Graph");
		showGraphButton.setToolTipText("Show Statistics");
		
		final JTextField randomSEEDEntry = new JTextField(numChars);
		randomSEEDEntry.setEditable(true);
		JLabel randomSEEDLabel = new JLabel("Enter SEED: ");

		
		mainFrame = new JFrame("Airport Simulation");
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
		JPanel statusPanel = new JPanel();
		JPanel graphPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel propertiesPanel = new JPanel();
		
		mainFrame.setLayout(new BorderLayout());
		((JPanel)mainFrame.getContentPane()).setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBorder(new 
				EmptyBorder(blankSpace, blankSpace, blankSpace, blankSpace));
		
		statusPanel.add(listScroller);
		buttonPanel.add(playButton);
		buttonPanel.add(stopButton);
		buttonPanel.add(pauseButton);
		graphPanel.add(showGraphButton);
		propertiesPanel.add(randomSEEDLabel);
		propertiesPanel.add(randomSEEDEntry);
		mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		mainFrame.add(listScroller, BorderLayout.NORTH);
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}
