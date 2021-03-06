package me.MinerX;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Frame1
extends JFrame
{
	private static final long serialVersionUID = 5728268678792319157L;
	public JTextField Series;
	public JTextField Walletaddress;
	public JTextField ExactName;
	public JTextField BTCaddress;
	public JTextField FTCaddress;
	public JTextField Region;
	public JButton PoolInfo;
	public JButton CoinCalc;
	public JRadioButton chooserchina, choosereurope, choosereuropeone;
	private JButton StartMining;
	private boolean ExactNameRight = false;
	private boolean ExactWalletAddress = false;
	private JTextField ExperModeField;
	private JCheckBox ExpertModeCheckBox;
	private JRadioButton expertamd, experenv;
	public static final String version = "TZC-MinerX Alpha 1.0";
	public Font ftdefault = new Font("Times New Roman", Font.BOLD, 22);
	public Font normal = new Font("Times New Roman", Font.BOLD, 20);
	

	public Frame1()
	{
		setLayout(null);
		setSize(807, 530);
		setUndecorated(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("MinerX");

		setContentPane(new DrawPane());
		setLayout(null);

		expertamd = new JRadioButton("AMD", ResourceLoader.Iconload("/checkbox.png"));
		expertamd.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		expertamd.setBounds(56, 240, 100, 20);
		expertamd.setVisible(false);
		expertamd.setOpaque(false);
		expertamd.setEnabled(false);
		expertamd.setBackground(Color.WHITE);
		expertamd.setSelected(true);
		add(expertamd);

		experenv = new JRadioButton("NVIDIA", ResourceLoader.Iconload("/checkbox.png"));
		experenv.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		experenv.setBounds(56, 260, 100, 20);
		experenv.setVisible(false);
		experenv.setOpaque(false);
		experenv.setEnabled(false);
		experenv.setBackground(Color.WHITE);
		add(experenv);
		
		choosereurope = new JRadioButton("Altminer.net",ResourceLoader.Iconload("/checkbox.png"));
		choosereurope.setBounds(645,250,100, 20);
		choosereurope.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		choosereurope.setVisible(true);
		choosereurope.setEnabled(true);
		choosereurope.setOpaque(false);
		choosereurope.setBackground(Color.WHITE);
		choosereurope.setSelected(true);
		add(choosereurope);
		
		choosereuropeone = new JRadioButton("US",ResourceLoader.Iconload("/checkbox.png"));
		choosereuropeone.setBounds(645,270,100, 20);
		choosereuropeone.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		choosereuropeone.setVisible(false);
		choosereuropeone.setEnabled(true);
		choosereuropeone.setOpaque(false);
		choosereuropeone.setBackground(Color.WHITE);
		choosereuropeone.setSelected(true);
		add(choosereuropeone);
		
		chooserchina = new JRadioButton("China",ResourceLoader.Iconload("/checkbox.png"));
		chooserchina.setBounds(645,290,100, 20);
		chooserchina.setVisible(false);
		chooserchina.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		chooserchina.setEnabled(true);
		chooserchina.setOpaque(false);
		chooserchina.setBackground(Color.WHITE);
		add(chooserchina);


		ButtonGroup toggle = new ButtonGroup();
		toggle.add(expertamd);
		toggle.add(experenv);
		
		ButtonGroup chose = new ButtonGroup();
		chose.add(choosereurope);
		//chose.add(chooserchina);
		//chose.add(choosereuropeone);

		Series = new JTextField("Getting Grafik Card Series ...", 30);
		Series.setEditable(false);
		Series.setBounds(53, 36, 261, 30);
		Series.setOpaque(false);
		Series.setFont(new Font("Impact", 0, 20));
		add(this.Series);
		
		Region = new JTextField("Region");
		Region.setVisible(true);
		Region.setBounds(650, 220, 100 ,30);
		Region.setEditable(false);
		Region.setOpaque(false);
		Region.setFont(normal);
		Region.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
		Region.setBackground(Color.WHITE);
		add(Region);

		ExactName = new JTextField("Waiting for Series", 20);
		ExactName.setEditable(false);
		ExactName.setOpaque(false);
		ExactName.setFont(new Font("Impact", 0, 20));
		ExactName.setBounds(53, 106, 262, 30);
		add(this.ExactName);

		PoolInfo = new JButton(ResourceLoader.Iconload("/250x50_button_pool.png"));
		PoolInfo.setBounds(503, 36, 250, 50);
		add(this.PoolInfo);

		CoinCalc = new JButton("Trezarcoin Calculator");
		CoinCalc.setBounds(503, 106, 250, 50);
		CoinCalc.setVisible(true);
		add(this.CoinCalc);

		Walletaddress = new JTextField("@Walletaddress", 30);
		Walletaddress.setBounds(246, 261, 310, 20);
		Walletaddress.setFont(new Font("Impact", 0, 20));
		Walletaddress.setOpaque(false);
		Walletaddress.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
		add(this.Walletaddress);

		StartMining = new JButton(ResourceLoader.Iconload("/start_button.png"));
		StartMining.setEnabled(false);
		StartMining.setBounds(253, 346, 300, 125);
		add(this.StartMining);

		setVisible(true);
		thehandler handler = new thehandler();

		ExpertModeCheckBox = new JCheckBox("Expert Mode", ResourceLoader.Iconload("/checkbox.png"));
		ExpertModeCheckBox.setSelectedIcon(ResourceLoader.Iconload("/checkbox_checked.png"));
		ExpertModeCheckBox.setBounds(56, 160, 240, 20);
		ExpertModeCheckBox.setBackground(Color.WHITE);
		ExpertModeCheckBox.setOpaque(false);
		ExpertModeCheckBox.setFont(normal);
		ExpertModeCheckBox.setText("Expert Mode");
		ExpertModeCheckBox.setVisible(false);
		add(ExpertModeCheckBox);

		ExperModeField = new JTextField("sgminer --neoscrypt -o http://...", 20);
		ExperModeField.setBounds(58, 202, 700, 25);
		ExperModeField.setFont(new Font("Times New Roman", Font.BOLD, 25));
		ExperModeField.setOpaque(false);
		ExperModeField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 0));
		ExperModeField.setEnabled(false);
		ExperModeField.setVisible(false);
		add(ExperModeField);

		PoolInfo.addActionListener(handler);
		CoinCalc.addActionListener(handler);
		StartMining.addActionListener(handler);
		ExpertModeCheckBox.addActionListener(handler);
		
		
		
		ExperModeField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent arg0) {
				if(ExperModeField.getText().equals("nsgminer --neoscrypt -o http://...")){
					ExperModeField.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {}
		
		});
		
		
		ExperModeField.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				if(ExperModeField.getText().equals("nsgminer --neoscrypt -o http://...")){
					ExperModeField.setText("");
				}
			}

			public void mouseEntered(MouseEvent arg0) {
				if(ExperModeField.getText().equals("nsgminer --neoscrypt -o http://...")){
					ExperModeField.setText("");
				}
			}

			public void mouseExited(MouseEvent arg0) {
				if(ExperModeField.getText().equals("")){
					ExperModeField.setText("nsgminer --neoscrypt -o http://...");
				}
			}
		});
		
		repaint();
	}

	private class thehandler
	implements ActionListener
	{
		PrintWriter writer;
		String folderpath;

		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == StartMining)
			{
				/*if(Main.ExpertMode == true){
					if(ExperModeField.getText().contains("nsgminer") && ExperModeField.getText().contains("-u")){
						
						Main.Batchfile = ExperModeField.getText();
						if(expertamd.isSelected() == true){
							folderpath = "Neosgminer";
						}else if(experenv.isSelected() == true){
							folderpath = "Neosgminer";
						}
					}else{
						JOptionPane.showMessageDialog(null, "That wouldnt work, please try again.");
						return;
					}
				}
				else if (Main.GrakaSeries.contains("AMD"))
					if(choosereurope.isSelected() == true){
						
						
							Main.Batchfile = "ccminer.exe -a neoscrypt -o stratum+tcp://eu1.altminer.net:4233 -u " + Walletaddress.getText().toString() + " -p c=PXC " + (String)Specs.AMDNeo.get(ExactName.getText().toString());
							folderpath = "Neosgminer";
					}
				
					else if(choosereuropeone.isSelected() == true){
						
							Main.Batchfile = "nsgminer --neoscrypt -o  -u" + Walletaddress.getText().toString() + " -p x " + (String)Specs.AMDNeo.get(ExactName.getText().toString()); 
							folderpath = "Neosgminer";
					}
						
						else{
							
							Main.Batchfile = "nsgminer --neoscrypt -o 7 -u " + Walletaddress.getText().toString() + " -p x " + (String)Specs.AMDNeo.get(ExactName.getText().toString());
							folderpath = "Neosgminer";
							
						}
			
				
					 
				else if (Main.GrakaSeries.contains("NVIDIA"))
					if(choosereurope.isSelected() == true){
						
						Main.Batchfile = "ccminer.exe -a neoscrypt -o stratum+tcp://eu1.altminer.net:4233  -u " + Walletaddress.getText().toString() + " -p c=PXC ";
						folderpath = "CCminer";
						
					}
				
					else if(choosereuropeone.isSelected() == true){
						
						Main.Batchfile = "ccminer.exe -a neoscrypt -o  -u " + Walletaddress.getText().toString() + " -p c=TZC ";
						folderpath = "CCminer";
						
					}
					else{
						Main.Batchfile = "ccminer.exe -a neoscrypt -o  -u " + Walletaddress.getText().toString() + " -p c=TZC ";
						folderpath = "CCminer";
					}*/
				
				if(choosereuropeone.isSelected() == true){
					Main.Batchfile = "ccminer.exe -a neoscrypt -o stratum+tcp://eu1.altminer.net:10002 -u " + Walletaddress.getText().toString() + " -p c=PXC ";
					folderpath = "CCminer";
				}

				try { 
					writer = new PrintWriter(new FileWriter(System.getProperty("user.dir")+"\\"+folderpath+"\\mine.bat")); 
					writer.println(Main.Batchfile); 
				} catch (IOException ioe) { 
					ioe.printStackTrace(); 
				} finally { 
					if (writer != null) 
						writer.flush();
					writer.close();
				}


					try {
						Process p =  Runtime.getRuntime().exec("cmd /c start mine.bat", null, new File("" + System.getProperty("user.dir")+"\\"+folderpath+""));
						p.waitFor();
					} catch (InterruptedException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
			if(e.getSource() == PoolInfo)
			{
				if(choosereurope.isSelected() == true){
					try{
						OtherStuff.poolInfoFTCWellen();
					}
					catch(IOException | URISyntaxException e1){
						e1.printStackTrace();
					}
				}
				
				else if(choosereuropeone.isSelected() == true){
					try{
						OtherStuff.poolInfoFTCMuddy();
					} catch (URISyntaxException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					try {
						OtherStuff.poolInfoFTCLizhi();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}

			}
			if(e.getSource() == CoinCalc)
			{
					try {
						OtherStuff.CoinCalcFTC();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}

			}

			if(e.getSource() == ExpertModeCheckBox){
				if(ExpertModeCheckBox.isSelected() == true){
					ExperModeField.setEnabled(true);
					ExperModeField.setVisible(true);
					experenv.setVisible(true);
					experenv.setEnabled(true);
					expertamd.setVisible(true);
					expertamd.setEnabled(true);
					Series.setEnabled(false);
					Walletaddress.setEnabled(false);
					ExactName.setEnabled(false);
					Region.setVisible(false);
					choosereurope.setEnabled(false);
					chooserchina.setEnabled(false);
					choosereuropeone.setEnabled(false);
					Main.ExpertMode = true;
				}else{
					ExperModeField.setEnabled(false);
					ExperModeField.setVisible(false);
					experenv.setVisible(false);
					experenv.setEnabled(false);
					expertamd.setVisible(false);
					expertamd.setEnabled(false);
					Series.setEnabled(true);
					Walletaddress.setEnabled(true);
					ExactName.setEnabled(true);
					Main.ExpertMode = false;
					Region.setVisible(true);
					choosereurope.setEnabled(true);
					chooserchina.setEnabled(true);
					choosereuropeone.setEnabled(true);
					//ExperModeField.setText("sgminer -k neoscrypt -o http://...");
				}
			}
		}
	}

	class DrawPane extends JPanel{
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g){
			
				expertamd.setFont(normal);
				experenv.setFont(normal);
				Series.setFont(normal);
				ExactName.setFont(normal);
				PoolInfo.setFont(normal);
				CoinCalc.setFont(normal);
				ExpertModeCheckBox.setFont(normal);
				Walletaddress.setFont(normal);
				StartMining.setFont(normal);
				//ExperModeField.setFont(normal);
			
				g.drawImage(ResourceLoader.ImageLoad("/background.png"), 0, 0, null);
				g.drawImage(ResourceLoader.ImageLoad("/TrezarMiner.png"),280,50,null);
				g.drawImage(ResourceLoader.ImageLoad("/input_bar.png"),241, 256,null);
				g.drawImage(ResourceLoader.ImageLoad("/status_text_bg3.png"),53,36,null);
				g.drawImage(ResourceLoader.ImageLoad("/status_text_bg3.png"),53,106,null);
				g.drawString(version,680,490);
				g.setFont(ftdefault);
				
			if(ExpertModeCheckBox.isSelected() == true){
				g.drawImage(ResourceLoader.ImageLoad("/status_text_bg4.png"),56,200,null);
			}
				
				if(OtherStuff.pFTCPriceinUSDisPulled == true){
					g.drawString(OtherStuff.pFTCPriceinUSD, 575, 400);
				}else{
					g.drawString("Fetching USD Price...", 570, 400);
				}
				
				if(OtherStuff.pFTCDiff != null && OtherStuff.pFTCDiff != "null"){
					g.drawString(OtherStuff.pFTCDiff, 575, 430);
				}else{
					g.drawString("Fetching difficulty...", 570, 430);
				}
				
						
			if(ExactWalletAddress == true)
			{
				g.drawImage(ResourceLoader.ImageLoad("/icontrue.png"), 180, 255, 35, 35, null);
			}
			else if(ExactWalletAddress == false)
			{
				g.drawImage(ResourceLoader.ImageLoad("/iconfalse.png"), 180, 255, 35, 35, null);
			}
			if(ExactNameRight == true)
			{
				g.drawImage(ResourceLoader.ImageLoad("/icontrue.png"), 10, 105, 35, 35, null);
			}
			else if(ExactNameRight == false)
			{
				g.drawImage(ResourceLoader.ImageLoad("/iconfalse.png"), 10, 105, 35, 35, null);
			}
		}
	}



	public void CheckExactName()
	{
		String p = ExactName.getText().toString();
		String f = (String)Specs.AMDNeo.get(p);
		String g = (String)Specs.NVIDIANeo.get(p);
		boolean check1 = false;
		boolean check2 = false;
			
		if ((!Walletaddress.getText().equals("@Walletaddress") && Walletaddress.getText().length() == 34)  || Main.ExpertMode == true)
		{
			check1 = true;
			ExactWalletAddress = true;

		}
		else {
			check1 = false;
			StartMining.setEnabled(false);
			ExactWalletAddress = false;
		}
		if((f != "null") && (f != null) || (g != "null") && (g != null) || Main.ExpertMode == true)
		{

			if ((p.contains("AMD")) || (p.contains("NVIDIA")) || Main.ExpertMode == true) {
				check2 = true;
				ExactNameRight = true;
			}
			else{
				check2 = false;
				StartMining.setEnabled(false);
				ExactNameRight = false;
			}
		}else{
			check2 = false;
			StartMining.setEnabled(false);
			ExactNameRight = false;
		}

		if(check1 == true && check2 == true){
			StartMining.setEnabled(true);
		}

		repaint();
	}
}