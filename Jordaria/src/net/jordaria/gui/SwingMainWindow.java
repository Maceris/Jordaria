package net.jordaria.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import net.jordaria.Jordaria;
import net.jordaria.KeyBind;
import net.jordaria.debug.DebugPanel;
import net.jordaria.event.EventHandler;
import net.jordaria.event.EventManager;
import net.jordaria.event.Listener;
import net.jordaria.event.events.ShuttingDown;
import net.jordaria.event.events.Tick;

/**
 * The main window for the program. 
 * This is the swing version, as opposed to the opengl window.
 * 
 * @author Ches Burks
 *
 */
public class SwingMainWindow extends WindowAdapter implements Listener, ActionListener, KeyListener, MouseMotionListener{
	//This windows frame
	JFrame frame;
	//The menu bar for the window
	JMenuBar menuBar;
	JMenu menuFile;//The file menu
	JMenuItem menuItemFileExit;//File.exit menu item.
	JMenu menuSettings;//The settings menu
	JMenu menuDebug;//The debug menu. Disabled if debug is not active
	JMenuItem menuItemDebugPanel;//starts the debug panel
	//The area for displaying the map
	MapArea mapArea;
	//A reference to the main jordaria class
	Jordaria jordaria;
	private TextureManager textureManager;

	/**
	 * Constructs a new {@link SwingMainWindow} to serve 
	 * as the gui. This is the window the program shows in.
	 */
	public SwingMainWindow(){
		this.jordaria = Jordaria.getInstance();
		this.init();
	}
	/**
	 * Initializes the frame for use.
	 */
	public void init(){
		
		try {
			EventManager.getInstance().registerEventListeners(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//frame
		frame = new JFrame(Jordaria.config.getWindow_title());
		frame.setSize(Jordaria.config.getWindow_width(), Jordaria.config.getWindow_height());
		frame.setLayout(new GridBagLayout());
		
		//menus
		menuBar = new JMenuBar();
		menuFile = new JMenu("File");
		menuSettings = new JMenu("Settings");
		menuDebug = new JMenu("Debug");
		menuItemFileExit = new JMenuItem("Exit");
		menuItemFileExit.addActionListener(this);
		menuItemDebugPanel = new JMenuItem("Debug panel");
		menuItemDebugPanel.addActionListener(this);

		menuDebug.setEnabled(Jordaria.config.getDebugActive());

		menuBar.add(menuFile);
		menuBar.add(menuSettings);
		menuBar.add(menuDebug);
		menuFile.add(menuItemFileExit);
		menuDebug.add(menuItemDebugPanel);
		
		textureManager = new TextureManager();

		mapArea = new MapArea(textureManager);
		mapArea.setVisible(true);
		frame.addKeyListener(this);
		menuBar.addKeyListener(this);
		mapArea.addKeyListener(this);

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = .5;
		c.weighty = GridBagConstraints.REMAINDER;
		frame.add(menuBar, c);
		c.gridwidth = 1;
		c.gridheight = 4;
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 1;
		frame.add(mapArea, c);
		
		BufferedImage myPicture = textureManager.getTextureBuffer("test");
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setSize(100, 100);
		
		//frame.getLayeredPane().add(picLabel, JLayeredPane.MODAL_LAYER);

		frame.setVisible(true);

	}

	/**
	 * Disposes of the frame and components
	 * 
	 * @param event The event that occurred
	 */
	@EventHandler
	public void onEventShutdown(ShuttingDown event){
		frame.dispose();
	}

	@EventHandler
	public void onTick(Tick event){
		if (!frame.isVisible()){
			EventManager.getInstance().fireEvent(new ShuttingDown());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemFileExit){
			EventManager.getInstance().fireEvent(new ShuttingDown());
		}
		else if (e.getSource() == menuItemDebugPanel){
			new DebugPanel();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		KeyBind.setKeyBindState(e.getKeyCode(), true);
		KeyBind.onTick(e.getKeyCode());
		//System.out.println(e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		KeyBind.setKeyBindState(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
}
