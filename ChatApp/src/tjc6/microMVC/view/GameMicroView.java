package tjc6.microMVC.view;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.UIManager;
import java.util.function.Supplier;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class for the games micro view.
 * 
 * @author tyrac
 *  
 */
public class GameMicroView extends JFrame {

	/**
	 * The serial version UUID.
	 */
	private static final long serialVersionUID = 2954155189487138667L;
	
	/**
	 * A new JPanel.
	 */
	private final JPanel gameUpdatesPanel = new JPanel();
	
	/**
	 * A new micro view 2 model adapter.
	 */
	private IMicroView2ModelAdapter _v2mAdpt;
	
	/**
	 * All the gameplay buttons.
	 */
	private final JButton btn1 = new JButton("1");
	private final JButton btn2 = new JButton("2");
	private final JButton btn14 = new JButton("14");
	private final JButton btn3 = new JButton("3");
	private final JButton btn4 = new JButton("4");
	private final JButton btn5 = new JButton("5");
	private final JButton btn6 = new JButton("6");
	private final JButton btn7 = new JButton("7");
	private final JButton btn8 = new JButton("8");
	private final JButton btn9 = new JButton("9");
	private final JButton btn10 = new JButton("10");
	private final JButton btn11 = new JButton("11");
	private final JButton btn12 = new JButton("12");
	private final JButton btn13 = new JButton("13");
	private final JButton btn15 = new JButton("15");
	private final JButton btn16 = new JButton("16");
	private final JButton btn27 = new JButton("27");
	private final JButton btn17 = new JButton("17");
	private final JButton btn18 = new JButton("18");
	private final JButton btn19 = new JButton("19");
	private final JButton btn20 = new JButton("20");
	private final JButton btn21 = new JButton("21");
	private final JButton btn22 = new JButton("22");
	private final JButton btn23 = new JButton("23");
	private final JButton btn24 = new JButton("24");
	private final JButton btn25 = new JButton("25");
	private final JButton btn26 = new JButton("26");
	private final JButton btn28 = new JButton("28");
	private final JButton btn40 = new JButton("40");
	private final JButton btn53 = new JButton("53");
	private final JButton btn66 = new JButton("66");
	private final JButton btn79 = new JButton("79");
	private final JButton btn92 = new JButton("92");
	private final JButton btn105 = new JButton("105");
	private final JButton btn118 = new JButton("118");
	private final JButton btn131 = new JButton("131");
	private final JButton btn144 = new JButton("144");
	private final JButton btn157 = new JButton("157");
	private final JButton btn170 = new JButton("170");
	private final JButton btn183 = new JButton("183");
	private final JButton btn29 = new JButton("29");
	private final JButton btn30 = new JButton("30");
	private final JButton btn31 = new JButton("31");
	private final JButton btn32 = new JButton("32");
	private final JButton btn33 = new JButton("33");
	private final JButton btn34 = new JButton("34");
	private final JButton btn35 = new JButton("35");
	private final JButton btn36 = new JButton("36");
	private final JButton btn37 = new JButton("37");
	private final JButton btn38 = new JButton("38");
	private final JButton btn39 = new JButton("39");
	private final JButton btn41 = new JButton("41");
	private final JButton btn42 = new JButton("42");
	private final JButton btn43 = new JButton("43");
	private final JButton btn44 = new JButton("44");
	private final JButton btn45 = new JButton("45");
	private final JButton btn46 = new JButton("46");
	private final JButton btn47 = new JButton("47");
	private final JButton btn48 = new JButton("48");
	private final JButton btn49 = new JButton("49");
	private final JButton btn50 = new JButton("50");
	private final JButton btn51 = new JButton("51");
	private final JButton btn52 = new JButton("52");
	private final JButton btn54 = new JButton("54");
	private final JButton btn55 = new JButton("55");
	private final JButton btn56 = new JButton("56");
	private final JButton btn57 = new JButton("57");
	private final JButton btn58 = new JButton("58");
	private final JButton btn59 = new JButton("59");
	private final JButton btn60 = new JButton("60");
	private final JButton btn61 = new JButton("61");
	private final JButton btn62 = new JButton("62");
	private final JButton btn63 = new JButton("63");
	private final JButton btn64 = new JButton("64");
	private final JButton btn65 = new JButton("65");
	private final JButton btn67 = new JButton("67");
	private final JButton btn68 = new JButton("68");
	private final JButton btn69 = new JButton("69");
	private final JButton btn70 = new JButton("70");
	private final JButton btn71 = new JButton("71");
	private final JButton btn72 = new JButton("72");
	private final JButton btn73 = new JButton("73");
	private final JButton btn74 = new JButton("74");
	private final JButton btn75 = new JButton("75");
	private final JButton btn76 = new JButton("76");
	private final JButton btn77 = new JButton("77");
	private final JButton btn78 = new JButton("78");
	private final JButton btn80 = new JButton("80");
	private final JButton btn81 = new JButton("81");
	private final JButton btn82 = new JButton("82");
	private final JButton btn83 = new JButton("83");
	private final JButton btn84 = new JButton("84");
	private final JButton btn85 = new JButton("85");
	private final JButton btn86 = new JButton("86");
	private final JButton btn87 = new JButton("87");
	private final JButton btn88 = new JButton("88");
	private final JButton btn89 = new JButton("89");
	private final JButton btn90 = new JButton("90");
	private final JButton btn91 = new JButton("91");
	private final JButton btn93 = new JButton("93");
	private final JButton btn94 = new JButton("94");
	private final JButton btn95 = new JButton("95");
	private final JButton btn96 = new JButton("96");
	private final JButton btn97 = new JButton("97");
	private final JButton btn98 = new JButton("98");
	private final JButton btn99 = new JButton("99");
	private final JButton btn100 = new JButton("100");
	private final JButton btn101 = new JButton("101");
	private final JButton btn102 = new JButton("102");
	private final JButton btn103 = new JButton("103");
	private final JButton btn104 = new JButton("104");
	private final JButton btn106 = new JButton("106");
	private final JButton btn107 = new JButton("107");
	private final JButton btn108 = new JButton("108");
	private final JButton btn109 = new JButton("109");
	private final JButton btn110 = new JButton("110");
	private final JButton btn111 = new JButton("111");
	private final JButton btn112 = new JButton("112");
	private final JButton btn113 = new JButton("113");
	private final JButton btn114 = new JButton("114");
	private final JButton btn115 = new JButton("115");
	private final JButton btn116 = new JButton("116");
	private final JButton btn117 = new JButton("117");
	private final JButton btn119 = new JButton("119");
	private final JButton btn120 = new JButton("120");
	private final JButton btn121 = new JButton("121");
	private final JButton btn122 = new JButton("122");
	private final JButton btn123 = new JButton("123");
	private final JButton btn124 = new JButton("124");
	private final JButton btn125 = new JButton("125");
	private final JButton btn126 = new JButton("126");
	private final JButton btn127 = new JButton("127");
	private final JButton btn128 = new JButton("128");
	private final JButton btn129 = new JButton("129");
	private final JButton btn130 = new JButton("130");
	private final JButton btn132 = new JButton("132");
	private final JButton btn133 = new JButton("133");
	private final JButton btn134 = new JButton("134");
	private final JButton btn135 = new JButton("135");
	private final JButton btn136 = new JButton("136");
	private final JButton btn137 = new JButton("137");
	private final JButton btn138 = new JButton("138");
	private final JButton btn139 = new JButton("139");
	private final JButton btn140 = new JButton("140");
	private final JButton btn141 = new JButton("141");
	private final JButton btn142 = new JButton("142");
	private final JButton btn143 = new JButton("143");
	private final JButton btn145 = new JButton("145");
	private final JButton btn146 = new JButton("146");
	private final JButton btn147 = new JButton("147");
	private final JButton btn148 = new JButton("148");
	private final JButton btn149 = new JButton("149");
	private final JButton btn150 = new JButton("150");
	private final JButton btn151 = new JButton("151");
	private final JButton btn152 = new JButton("152");
	private final JButton btn153 = new JButton("153");
	private final JButton btn154 = new JButton("154");
	private final JButton btn155 = new JButton("155");
	private final JButton btn156 = new JButton("156");
	private final JButton btn158 = new JButton("158");
	private final JButton btn159 = new JButton("159");
	private final JButton btn160 = new JButton("160");
	private final JButton btn161 = new JButton("161");
	private final JButton btn162 = new JButton("162");
	private final JButton btn163 = new JButton("163");
	private final JButton btn164 = new JButton("164");
	private final JButton btn165 = new JButton("165");
	private final JButton btn166 = new JButton("166");
	private final JButton btn167 = new JButton("167");
	private final JButton btn168 = new JButton("168");
	private final JButton btn169 = new JButton("169");
	private final JButton btn171 = new JButton("171");
	private final JButton btn172 = new JButton("172");
	private final JButton btn173 = new JButton("173");
	private final JButton btn174 = new JButton("174");
	private final JButton btn175 = new JButton("175");
	private final JButton btn176 = new JButton("176");
	private final JButton btn177 = new JButton("177");
	private final JButton btn178 = new JButton("178");
	private final JButton btn179 = new JButton("179");
	private final JButton btn180 = new JButton("180");
	private final JButton btn181 = new JButton("181");
	private final JButton btn182 = new JButton("182");
	private final JButton btn184 = new JButton("184");
	private final JButton btn185 = new JButton("185");
	private final JButton btn186 = new JButton("186");
	private final JButton btn187 = new JButton("187");
	private final JButton btn188 = new JButton("188");
	private final JButton btn189 = new JButton("189");
	private final JButton btn190 = new JButton("190");
	private final JButton btn191 = new JButton("191");
	private final JButton btn192 = new JButton("192");
	private final JButton btn193 = new JButton("193");
	private final JButton btn194 = new JButton("194");
	private final JButton btn195 = new JButton("195");
	
	/**
	 * A JPanel that contains the game timer.
	 */
	private final JPanel timerPanel = new JPanel();
	/**
	 * A JPanel that contains the rules of the game.
	 */
	private final JPanel gameRulesPanel = new JPanel();
	/**
	 * A JTextPane that contains the rules of the game.
	 */
	private final JTextPane txtGameRules = new JTextPane();
	/**
	 * A JButton used to exit the game.
	 */
	private final JButton btnExitGame = new JButton("Exit Game");
	private JTextField timerTextField;


	/**
	
	* The constructor for the micro view.
	* 	 * 
	* 	 * @param v2mAdpt the micro view to model adapter.
	 */
	public GameMicroView(IMicroView2ModelAdapter v2mAdpt) {
		getContentPane().setBackground(new Color(0, 0, 0));
		setResizable(true);
		//setBounds(true);
		//setIconImage(true);
		//setClosable(true);
		setTitle("Don't Press the Button");
		setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);

		this._v2mAdpt = v2mAdpt;
		initGUI();
	}

	/**
	 * Initialize the GUI.
	 */
	private void initGUI() {
		
		// Game visual items
		getContentPane().setLayout(null);
		setResizable(false);
		gameUpdatesPanel.setToolTipText("A panel for game updates.");
		gameUpdatesPanel.setBorder(new TitledBorder(null, "Game Updates", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gameUpdatesPanel.setBounds(10, 11, 675, 57);
		getContentPane().add(gameUpdatesPanel);
		
		// Actions for all the buttons when pressed
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(1);
			}
		});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(2);
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(3);
			}
		});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(4);
			}
		});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(5);
			}
		});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(6);
			}
		});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(7);
			}
		});
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(8);
			}
		});
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(9);
			}
		});
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn10.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(10);
			}
		});
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn11.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(11);
			}
		});
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn12.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(12);
			}
		});
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn13.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(13);
			}
		});
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn14.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(14);
			}
		});
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn15.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(15);
			}
		});
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn16.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(16);
			}
		});
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn17.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(17);
			}
		});
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn18.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(18);
			}
		});
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn19.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(19);
			}
		});
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn20.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(20);
			}
		});
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn21.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(21);
			}
		});
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn22.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(22);
			}
		});
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn23.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(23);
			}
		});
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn24.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(24);
			}
		});
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn25.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(25);
			}
		});
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn26.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(26);
			}
		});
		btn27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn27.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(27);
			}
		});
		btn28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn28.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(28);
			}
		});
		btn29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn29.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(29);
			}
		});
		btn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn30.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(30);
			}
		});
		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn31.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(31);
			}
		});
		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn32.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(32);
			}
		});
		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn33.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(33);
			}
		});
		btn34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn34.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(34);
			}
		});
		btn35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn35.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(35);
			}
		});
		btn36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn36.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(36);
			}
		});
		btn37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn37.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(37);
			}
		});
		btn38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn38.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(38);
			}
		});
		btn39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn39.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(39);
			}
		});
		btn40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn40.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(40);
			}
		});
		btn41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn41.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(41);
			}
		});
		btn42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn42.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(42);
			}
		});
		btn43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn43.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(43);
			}
		});
		btn44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn44.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(44);
			}
		});
		btn45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn45.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(45);
			}
		});
		btn46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn46.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(46);
			}
		});
		btn47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn47.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(47);
			}
		});
		btn48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn48.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(48);
			}
		});
		btn49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn49.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(49);
			}
		});
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn50.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(50);
			}
		});
		btn51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn51.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(51);
			}
		});
		btn52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn52.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(52);
			}
		});
		btn53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn53.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(53);
			}
		});
		btn54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn54.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(54);
			}
		});
		btn55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn55.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(55);
			}
		});
		btn56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn56.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(56);
			}
		});
		btn57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn57.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(57);
			}
		});
		btn58.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn58.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(58);
			}
		});
		btn59.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn59.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(59);
			}
		});
		btn60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn60.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(60);
			}
		});
		btn61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn61.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(61);
			}
		});
		btn62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn62.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(62);
			}
		});
		btn63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn63.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(63);
			}
		});
		btn64.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn64.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(64);
			}
		});
		btn65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn65.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(65);
			}
		});
		btn66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn66.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(66);
			}
		});
		btn67.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn67.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(67);
			}
		});
		btn68.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn68.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(68);
			}
		});
		btn69.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn69.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(69);
			}
		});
		btn70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn70.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(70);
			}
		});
		btn71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn71.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(71);
			}
		});
		btn72.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn72.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(72);
			}
		});
		btn73.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn73.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(73);
			}
		});
		btn74.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn74.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(74);
			}
		});
		btn75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn75.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(75);
			}
		});
		btn76.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn76.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(76);
			}
		});
		btn77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn77.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(77);
			}
		});
		btn78.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn78.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(78);
			}
		});
		btn79.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn79.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(79);
			}
		});
		btn80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn80.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(80);
			}
		});
		btn81.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn81.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(81);
			}
		});
		btn82.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn82.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(82);
			}
		});
		btn83.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn83.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(83);
			}
		});
		btn84.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn84.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(84);
			}
		});
		btn85.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn85.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(85);
			}
		});
		btn86.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn86.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(86);
			}
		});
		btn87.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn87.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(87);
			}
		});
		btn88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn88.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(88);
			}
		});
		btn89.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn89.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(89);
			}
		});
		btn90.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn90.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(90);
			}
		});
		btn91.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn91.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(91);
			}
		});
		btn92.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn92.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(92);
			}
		});
		btn93.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn93.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(93);
			}
		});
		btn94.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn94.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(94);
			}
		});
		btn95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn95.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(95);
			}
		});
		btn96.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn96.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(96);
			}
		});
		btn97.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn97.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(97);
			}
		});
		btn98.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn98.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(98);
			}
		});
		btn99.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn99.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(99);
			}
		});
		btn100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn100.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(100);
			}
		});
		btn101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn101.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(101);
			}
		});
		btn102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn102.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(102);
			}
		});
		btn103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn103.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(103);
			}
		});
		btn104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn104.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(104);
			}
		});
		btn105.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn105.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(105);
			}
		});
		btn106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn106.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(106);
			}
		});
		btn107.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn107.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(107);
			}
		});
		btn108.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn108.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(108);
			}
		});
		btn109.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn109.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(109);
			}
		});
		btn110.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn110.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(110);
			}
		});
		btn111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn111.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(111);
			}
		});
		btn112.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn112.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(112);
			}
		});
		btn113.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn113.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(113);
			}
		});
		btn114.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn114.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(114);
			}
		});
		btn115.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn115.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(115);
			}
		});
		btn116.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn116.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(116);
			}
		});
		btn117.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn117.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(117);
			}
		});
		btn118.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn118.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(118);
			}
		});
		btn119.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn119.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(119);
			}
		});
		btn120.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn120.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(120);
			}
		});
		btn121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn121.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(121);
			}
		});
		btn122.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn122.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(122);
			}
		});
		btn123.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn123.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(123);
			}
		});
		btn124.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn124.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(124);
			}
		});
		btn125.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn125.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(125);
			}
		});
		btn126.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn126.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(126);
			}
		});
		btn127.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn127.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(127);
			}
		});
		btn128.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn128.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(128);
			}
		});
		btn129.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn129.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(129);
			}
		});
		btn130.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn130.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(130);
			}
		});
		btn131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn131.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(131);
			}
		});
		btn132.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn132.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(132);
			}
		});
		btn133.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn133.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(133);
			}
		});
		btn134.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn134.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(134);
			}
		});
		btn135.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn135.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(135);
			}
		});
		btn136.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn136.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(136);
			}
		});
		btn137.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn137.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(137);
			}
		});
		btn138.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn138.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(138);
			}
		});
		btn139.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn139.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(139);
			}
		});
		btn140.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn140.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(140);
			}
		});
		btn141.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn141.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(141);
			}
		});
		btn142.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn142.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(142);
			}
		});
		btn143.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn143.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(143);
			}
		});
		btn144.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn144.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(144);
			}
		});
		btn145.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn145.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(145);
			}
		});
		btn146.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn146.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(146);
			}
		});
		btn147.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn147.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(147);
			}
		});
		btn148.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn148.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(148);
			}
		});
		btn149.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn149.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(149);
			}
		});
		btn150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn150.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(150);
			}
		});
		btn151.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn151.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(151);
			}
		});
		btn152.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn152.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(152);
			}
		});
		btn153.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn153.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(153);
			}
		});
		btn154.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn154.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(154);
			}
		});
		btn155.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn155.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(155);
			}
		});
		btn156.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn156.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(156);
			}
		});
		btn157.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn157.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(157);
			}
		});
		btn158.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn158.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(158);
			}
		});
		btn159.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn159.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(159);
			}
		});
		btn160.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn160.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(160);
			}
		});
		btn161.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn161.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(161);
			}
		});
		btn162.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn162.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(162);
			}
		});
		btn163.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn163.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(163);
			}
		});
		btn164.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn164.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(164);
			}
		});
		btn165.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn165.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(165);
			}
		});
		btn166.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn166.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(166);
			}
		});
		btn167.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn167.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(167);
			}
		});
		btn168.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn168.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(168);
			}
		});
		btn169.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn169.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(169);
			}
		});
		btn170.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn170.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(170);
			}
		});
		btn171.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn171.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(171);
			}
		});
		btn172.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn172.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(172);
			}
		});
		btn173.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn173.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(173);
			}
		});
		btn174.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn174.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(174);
			}
		});
		btn175.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn175.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(175);
			}
		});
		btn176.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn176.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(176);
			}
		});
		btn177.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn177.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(177);
			}
		});
		btn178.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn178.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(178);
			}
		});
		btn179.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn179.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(179);
			}
		});
		btn180.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn180.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(180);
			}
		});
		btn181.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn181.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(181);
			}
		});
		btn182.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn182.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(182);
			}
		});
		btn183.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn183.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(183);
			}
		});
		btn184.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn184.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(184);
			}
		});
		btn185.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn185.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(185);
			}
		});
		btn186.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn186.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(186);
			}
		});
		btn187.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn187.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(187);
			}
		});
		btn188.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn188.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(188);
			}
		});
		btn189.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn189.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(189);
			}
		});
		btn190.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn190.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(190);
			}
		});
		btn191.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn191.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(191);
			}
		});
		btn192.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn192.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(192);
			}
		});
		btn193.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn193.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(193);
			}
		});
		btn194.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn194.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(194);
			}
		});
		btn195.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn195.setBackground(new Color(0, 0, 0));
				_v2mAdpt.buttonPressed(195);
			}
		});













		
		
//		btn1.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				// TODO Auto-generated method stub
//				btn1.setBackground(new Color(3, 59, 90).brighter());
//			}
//
//			@Override
//			public void mousePressed(MouseEvent e) {
//				// TODO Auto-generated method stub
//				UIManager.put("Button.select", Color.pink);
//			}
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				// TODO Auto-generated method stub
//				UIManager.put("Button.select", new Color(3, 59, 90));
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				// TODO Auto-generated method stub
//				btn1.setBackground(new Color(3, 59, 90).brighter());
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				// TODO Auto-generated method stub
//				 btn1.setBackground(new Color(3, 59, 90));
//			}
//		});
		btn1.setToolTipText("A button.");
		btn1.setBounds(10, 79, 51, 23);
		
		getContentPane().add(btn1);
		btn2.setToolTipText("A button.");
		btn2.setBounds(62, 79, 51, 23);
		
		getContentPane().add(btn2);
		btn14.setToolTipText("A button.");
		btn14.setBounds(10, 103, 51, 23);
		
		getContentPane().add(btn14);
		btn3.setToolTipText("A button.");
		btn3.setBounds(114, 79, 51, 23);
		
		getContentPane().add(btn3);
		btn4.setToolTipText("A button.");
		btn4.setBounds(166, 79, 51, 23);
		
		getContentPane().add(btn4);
		btn5.setToolTipText("A button.");
		btn5.setBounds(218, 79, 51, 23);
		
		getContentPane().add(btn5);
		btn6.setToolTipText("A button.");
		btn6.setBounds(270, 79, 51, 23);
		
		getContentPane().add(btn6);
		btn7.setToolTipText("A button.");
		btn7.setBounds(322, 79, 51, 23);
		
		getContentPane().add(btn7);
		btn8.setToolTipText("A button.");
		btn8.setBounds(374, 79, 51, 23);
		
		getContentPane().add(btn8);
		btn9.setToolTipText("A button.");
		btn9.setBounds(426, 79, 51, 23);
		
		getContentPane().add(btn9);
		btn10.setToolTipText("A button.");
		btn10.setBounds(478, 79, 51, 23);
		
		getContentPane().add(btn10);
		btn11.setToolTipText("A button.");
		btn11.setBounds(530, 79, 51, 23);
		
		getContentPane().add(btn11);
		btn12.setToolTipText("A button.");
		btn12.setBounds(582, 79, 51, 23);
		
		getContentPane().add(btn12);
		btn13.setToolTipText("A button.");
		btn13.setBounds(634, 79, 51, 23);
		
		getContentPane().add(btn13);
		btn15.setToolTipText("A button.");
		btn15.setBounds(62, 103, 51, 23);
		
		getContentPane().add(btn15);
		btn16.setToolTipText("A button.");
		btn16.setBounds(114, 103, 51, 23);
		
		getContentPane().add(btn16);
		btn27.setToolTipText("A button.");
		btn27.setBounds(10, 127, 51, 23);
		
		getContentPane().add(btn27);
		btn17.setToolTipText("A button.");
		btn17.setBounds(166, 103, 51, 23);
		
		getContentPane().add(btn17);
		btn18.setToolTipText("A button.");
		btn18.setBounds(218, 103, 51, 23);
		
		getContentPane().add(btn18);
		btn19.setToolTipText("A button.");
		btn19.setBounds(270, 103, 51, 23);
		
		getContentPane().add(btn19);
		btn20.setToolTipText("A button.");
		btn20.setBounds(322, 103, 51, 23);
		
		getContentPane().add(btn20);
		btn21.setToolTipText("A button.");
		btn21.setBounds(374, 103, 51, 23);
		
		getContentPane().add(btn21);
		btn22.setToolTipText("A button.");
		btn22.setBounds(426, 103, 51, 23);
		
		getContentPane().add(btn22);
		btn23.setToolTipText("A button.");
		btn23.setBounds(478, 103, 51, 23);
		
		getContentPane().add(btn23);
		btn24.setToolTipText("A button.");
		btn24.setBounds(530, 103, 51, 23);
		
		getContentPane().add(btn24);
		btn25.setToolTipText("A button.");
		btn25.setBounds(582, 103, 51, 23);
		
		getContentPane().add(btn25);
		btn26.setToolTipText("A button.");
		btn26.setBounds(634, 103, 51, 23);
		
		getContentPane().add(btn26);
		btn28.setToolTipText("A button.");
		btn28.setBounds(62, 127, 51, 23);
		
		getContentPane().add(btn28);
		btn40.setToolTipText("A button.");
		btn40.setBounds(10, 151, 51, 23);
		
		getContentPane().add(btn40);
		btn53.setToolTipText("A button.");
		btn53.setBounds(10, 175, 51, 23);
		
		getContentPane().add(btn53);
		btn66.setToolTipText("A button.");
		btn66.setBounds(10, 199, 51, 23);
		
		getContentPane().add(btn66);
		btn79.setToolTipText("A button.");
		btn79.setBounds(10, 223, 51, 23);
		
		getContentPane().add(btn79);
		btn92.setToolTipText("A button.");
		btn92.setBounds(10, 247, 51, 23);
		
		getContentPane().add(btn92);
		btn105.setToolTipText("A button.");
		btn105.setBounds(10, 271, 51, 23);
		
		getContentPane().add(btn105);
		btn118.setToolTipText("A button.");
		btn118.setBounds(10, 295, 51, 23);
		
		getContentPane().add(btn118);
		btn131.setToolTipText("A button.");
		btn131.setBounds(10, 319, 51, 23);
		
		getContentPane().add(btn131);
		btn144.setToolTipText("A button.");
		btn144.setBounds(10, 343, 51, 23);
		
		getContentPane().add(btn144);
		btn157.setToolTipText("A button.");
		btn157.setBounds(10, 367, 51, 23);
		
		getContentPane().add(btn157);
		btn170.setToolTipText("A button.");
		btn170.setBounds(10, 391, 51, 23);
		
		getContentPane().add(btn170);
		btn183.setToolTipText("A button.");
		btn183.setBounds(10, 415, 51, 23);
		
		getContentPane().add(btn183);
		btn29.setToolTipText("A button.");
		btn29.setBounds(114, 127, 51, 23);
		
		getContentPane().add(btn29);
		btn30.setToolTipText("A button.");
		btn30.setBounds(166, 127, 51, 23);
		
		getContentPane().add(btn30);
		btn31.setToolTipText("A button.");
		btn31.setBounds(218, 127, 51, 23);
		
		getContentPane().add(btn31);
		btn32.setToolTipText("A button.");
		btn32.setBounds(270, 127, 51, 23);
		
		getContentPane().add(btn32);
		btn33.setToolTipText("A button.");
		btn33.setBounds(322, 127, 51, 23);
		
		getContentPane().add(btn33);
		btn34.setToolTipText("A button.");
		btn34.setBounds(374, 127, 51, 23);
		
		getContentPane().add(btn34);
		btn35.setToolTipText("A button.");
		btn35.setBounds(426, 127, 51, 23);
		
		getContentPane().add(btn35);
		btn36.setToolTipText("A button.");
		btn36.setBounds(478, 127, 51, 23);
		
		getContentPane().add(btn36);
		btn37.setToolTipText("A button.");
		btn37.setBounds(530, 127, 51, 23);
		
		getContentPane().add(btn37);
		btn38.setToolTipText("A button.");
		btn38.setBounds(582, 127, 51, 23);
		
		getContentPane().add(btn38);
		btn39.setToolTipText("A button.");
		btn39.setBounds(634, 127, 51, 23);
		
		getContentPane().add(btn39);
		btn41.setToolTipText("A button.");
		btn41.setBounds(62, 151, 51, 23);
		
		getContentPane().add(btn41);
		btn42.setToolTipText("A button.");
		btn42.setBounds(114, 151, 51, 23);
		
		getContentPane().add(btn42);
		btn43.setToolTipText("A button.");
		btn43.setBounds(166, 151, 51, 23);
		
		getContentPane().add(btn43);
		btn44.setToolTipText("A button.");
		btn44.setBounds(218, 151, 51, 23);
		
		getContentPane().add(btn44);
		btn45.setToolTipText("A button.");
		btn45.setBounds(270, 151, 51, 23);
		
		getContentPane().add(btn45);
		btn46.setToolTipText("A button.");
		btn46.setBounds(322, 151, 51, 23);
		
		getContentPane().add(btn46);
		btn47.setToolTipText("A button.");
		btn47.setBounds(374, 151, 51, 23);
		
		getContentPane().add(btn47);
		btn48.setToolTipText("A button.");
		btn48.setBounds(426, 151, 51, 23);
		
		getContentPane().add(btn48);
		btn49.setToolTipText("A button.");
		btn49.setBounds(478, 151, 51, 23);
		
		getContentPane().add(btn49);
		btn50.setToolTipText("A button.");
		btn50.setBounds(530, 151, 51, 23);
		
		getContentPane().add(btn50);
		btn51.setToolTipText("A button.");
		btn51.setBounds(582, 151, 51, 23);
		
		getContentPane().add(btn51);
		btn52.setToolTipText("A button.");
		btn52.setBounds(634, 151, 51, 23);
		
		getContentPane().add(btn52);
		btn54.setToolTipText("A button.");
		btn54.setBounds(62, 175, 51, 23);
		
		getContentPane().add(btn54);
		btn55.setToolTipText("A button.");
		btn55.setBounds(114, 175, 51, 23);
		
		getContentPane().add(btn55);
		btn56.setToolTipText("A button.");
		btn56.setBounds(166, 175, 51, 23);
		
		getContentPane().add(btn56);
		btn57.setToolTipText("A button.");
		btn57.setBounds(218, 175, 51, 23);
		
		getContentPane().add(btn57);
		btn58.setToolTipText("A button.");
		btn58.setBounds(270, 175, 51, 23);
		
		getContentPane().add(btn58);
		btn59.setToolTipText("A button.");
		btn59.setBounds(322, 175, 51, 23);
		
		getContentPane().add(btn59);
		btn60.setToolTipText("A button.");
		btn60.setBounds(374, 175, 51, 23);
		
		getContentPane().add(btn60);
		btn61.setToolTipText("A button.");
		btn61.setBounds(426, 175, 51, 23);
		
		getContentPane().add(btn61);
		btn62.setToolTipText("A button.");
		btn62.setBounds(478, 175, 51, 23);
		
		getContentPane().add(btn62);
		btn63.setToolTipText("A button.");
		btn63.setBounds(530, 175, 51, 23);
		
		getContentPane().add(btn63);
		btn64.setToolTipText("A button.");
		btn64.setBounds(582, 175, 51, 23);
		
		getContentPane().add(btn64);
		btn65.setToolTipText("A button.");
		btn65.setBounds(634, 175, 51, 23);
		
		getContentPane().add(btn65);
		btn67.setToolTipText("A button.");
		btn67.setBounds(62, 199, 51, 23);
		
		getContentPane().add(btn67);
		btn68.setToolTipText("A button.");
		btn68.setBounds(114, 199, 51, 23);
		
		getContentPane().add(btn68);
		btn69.setToolTipText("A button.");
		btn69.setBounds(166, 199, 51, 23);
		
		getContentPane().add(btn69);
		btn70.setToolTipText("A button.");
		btn70.setBounds(218, 199, 51, 23);
		
		getContentPane().add(btn70);
		btn71.setToolTipText("A button.");
		btn71.setBounds(270, 199, 51, 23);
		
		getContentPane().add(btn71);
		btn72.setToolTipText("A button.");
		btn72.setBounds(322, 199, 51, 23);
		
		getContentPane().add(btn72);
		btn73.setToolTipText("A button.");
		btn73.setBounds(374, 199, 51, 23);
		
		getContentPane().add(btn73);
		btn74.setToolTipText("A button.");
		btn74.setBounds(426, 199, 51, 23);
		
		getContentPane().add(btn74);
		btn75.setToolTipText("A button.");
		btn75.setBounds(478, 199, 51, 23);
		
		getContentPane().add(btn75);
		btn76.setToolTipText("A button.");
		btn76.setBounds(530, 199, 51, 23);
		
		getContentPane().add(btn76);
		btn77.setToolTipText("A button.");
		btn77.setBounds(582, 199, 51, 23);
		
		getContentPane().add(btn77);
		btn78.setToolTipText("A button.");
		btn78.setBounds(634, 199, 51, 23);
		
		getContentPane().add(btn78);
		btn80.setToolTipText("A button.");
		btn80.setBounds(62, 223, 51, 23);
		
		getContentPane().add(btn80);
		btn81.setToolTipText("A button.");
		btn81.setBounds(114, 223, 51, 23);
		
		getContentPane().add(btn81);
		btn82.setToolTipText("A button.");
		btn82.setBounds(166, 223, 51, 23);
		
		getContentPane().add(btn82);
		btn83.setToolTipText("A button.");
		btn83.setBounds(218, 223, 51, 23);
		
		getContentPane().add(btn83);
		btn84.setToolTipText("A button.");
		btn84.setBounds(270, 223, 51, 23);
		
		getContentPane().add(btn84);
		btn85.setToolTipText("A button.");
		btn85.setBounds(322, 223, 51, 23);
		
		getContentPane().add(btn85);
		btn86.setToolTipText("A button.");
		btn86.setBounds(374, 223, 51, 23);
		
		getContentPane().add(btn86);
		btn87.setToolTipText("A button.");
		btn87.setBounds(426, 223, 51, 23);
		
		getContentPane().add(btn87);
		btn88.setToolTipText("A button.");
		btn88.setBounds(478, 223, 51, 23);
		
		getContentPane().add(btn88);
		btn89.setToolTipText("A button.");
		btn89.setBounds(530, 223, 51, 23);
		
		getContentPane().add(btn89);
		btn90.setToolTipText("A button.");
		btn90.setBounds(582, 223, 51, 23);
		
		getContentPane().add(btn90);
		btn91.setToolTipText("A button.");
		btn91.setBounds(634, 223, 51, 23);
		
		getContentPane().add(btn91);
		btn93.setToolTipText("A button.");
		btn93.setBounds(62, 247, 51, 23);
		
		getContentPane().add(btn93);
		btn94.setToolTipText("A button.");
		btn94.setBounds(114, 247, 51, 23);
		
		getContentPane().add(btn94);
		btn95.setToolTipText("A button.");
		btn95.setBounds(166, 247, 51, 23);
		
		getContentPane().add(btn95);
		btn96.setToolTipText("A button.");
		btn96.setBounds(218, 247, 51, 23);
		
		getContentPane().add(btn96);
		btn97.setToolTipText("A button.");
		btn97.setBounds(270, 247, 51, 23);
		
		getContentPane().add(btn97);
		btn98.setToolTipText("A button.");
		btn98.setBounds(322, 247, 51, 23);
		
		getContentPane().add(btn98);
		btn99.setToolTipText("A button.");
		btn99.setBounds(374, 247, 51, 23);
		
		getContentPane().add(btn99);
		btn100.setToolTipText("A button.");
		btn100.setBounds(426, 247, 51, 23);
		
		getContentPane().add(btn100);
		btn101.setToolTipText("A button.");
		btn101.setBounds(478, 247, 51, 23);
		
		getContentPane().add(btn101);
		btn102.setToolTipText("A button.");
		btn102.setBounds(530, 247, 51, 23);
		
		getContentPane().add(btn102);
		btn103.setToolTipText("A button.");
		btn103.setBounds(582, 247, 51, 23);
		
		getContentPane().add(btn103);
		btn104.setToolTipText("A button.");
		btn104.setBounds(634, 247, 51, 23);
		
		getContentPane().add(btn104);
		btn106.setToolTipText("A button.");
		btn106.setBounds(62, 271, 51, 23);
		
		getContentPane().add(btn106);
		btn107.setToolTipText("A button.");
		btn107.setBounds(114, 271, 51, 23);
		
		getContentPane().add(btn107);
		btn108.setToolTipText("A button.");
		btn108.setBounds(166, 271, 51, 23);
		
		getContentPane().add(btn108);
		btn109.setToolTipText("A button.");
		btn109.setBounds(218, 271, 51, 23);
		
		getContentPane().add(btn109);
		btn110.setToolTipText("A button.");
		btn110.setBounds(270, 271, 51, 23);
		
		getContentPane().add(btn110);
		btn111.setToolTipText("A button.");
		btn111.setBounds(322, 271, 51, 23);
		
		getContentPane().add(btn111);
		btn112.setToolTipText("A button.");
		btn112.setBounds(374, 271, 51, 23);
		
		getContentPane().add(btn112);
		btn113.setToolTipText("A button.");
		btn113.setBounds(426, 271, 51, 23);
		
		getContentPane().add(btn113);
		btn114.setToolTipText("A button.");
		btn114.setBounds(478, 271, 51, 23);
		
		getContentPane().add(btn114);
		btn115.setToolTipText("A button.");
		btn115.setBounds(530, 271, 51, 23);
		
		getContentPane().add(btn115);
		btn116.setToolTipText("A button.");
		btn116.setBounds(582, 271, 51, 23);
		
		getContentPane().add(btn116);
		btn117.setToolTipText("A button.");
		btn117.setBounds(634, 271, 51, 23);
		
		getContentPane().add(btn117);
		btn119.setToolTipText("A button.");
		btn119.setBounds(62, 295, 51, 23);
		
		getContentPane().add(btn119);
		btn120.setToolTipText("A button.");
		btn120.setBounds(114, 295, 51, 23);
		
		getContentPane().add(btn120);
		btn121.setToolTipText("A button.");
		btn121.setBounds(166, 295, 51, 23);
		
		getContentPane().add(btn121);
		btn122.setToolTipText("A button.");
		btn122.setBounds(218, 295, 51, 23);
		
		getContentPane().add(btn122);
		btn123.setToolTipText("A button.");
		btn123.setBounds(270, 295, 51, 23);
		
		getContentPane().add(btn123);
		btn124.setToolTipText("A button.");
		btn124.setBounds(322, 295, 51, 23);
		
		getContentPane().add(btn124);
		btn125.setToolTipText("A button.");
		btn125.setBounds(374, 295, 51, 23);
		
		getContentPane().add(btn125);
		btn126.setToolTipText("A button.");
		btn126.setBounds(426, 295, 51, 23);
		
		getContentPane().add(btn126);
		btn127.setToolTipText("A button.");
		btn127.setBounds(478, 295, 51, 23);
		
		getContentPane().add(btn127);
		btn128.setToolTipText("A button.");
		btn128.setBounds(530, 295, 51, 23);
		
		getContentPane().add(btn128);
		btn129.setToolTipText("A button.");
		btn129.setBounds(582, 295, 51, 23);
		
		getContentPane().add(btn129);
		btn130.setToolTipText("A button.");
		btn130.setBounds(634, 295, 51, 23);
		
		getContentPane().add(btn130);
		btn132.setToolTipText("A button.");
		btn132.setBounds(62, 319, 51, 23);
		
		getContentPane().add(btn132);
		btn133.setToolTipText("A button.");
		btn133.setBounds(114, 319, 51, 23);
		
		getContentPane().add(btn133);
		btn134.setToolTipText("A button.");
		btn134.setBounds(166, 319, 51, 23);
		
		getContentPane().add(btn134);
		btn135.setToolTipText("A button.");
		btn135.setBounds(218, 319, 51, 23);
		
		getContentPane().add(btn135);
		btn136.setToolTipText("A button.");
		btn136.setBounds(270, 319, 51, 23);
		
		getContentPane().add(btn136);
		btn137.setToolTipText("A button.");
		btn137.setBounds(322, 319, 51, 23);
		
		getContentPane().add(btn137);
		btn138.setToolTipText("A button.");
		btn138.setBounds(374, 319, 51, 23);
		
		getContentPane().add(btn138);
		btn139.setToolTipText("A button.");
		btn139.setBounds(426, 319, 51, 23);
		
		getContentPane().add(btn139);
		btn140.setToolTipText("A button.");
		btn140.setBounds(478, 319, 51, 23);
		
		getContentPane().add(btn140);
		btn141.setToolTipText("A button.");
		btn141.setBounds(530, 319, 51, 23);
		
		getContentPane().add(btn141);
		btn142.setToolTipText("A button.");
		btn142.setBounds(582, 319, 51, 23);
		
		getContentPane().add(btn142);
		btn143.setToolTipText("A button.");
		btn143.setBounds(634, 319, 51, 23);
		
		getContentPane().add(btn143);
		btn145.setToolTipText("A button.");
		btn145.setBounds(62, 343, 51, 23);
		
		getContentPane().add(btn145);
		btn146.setToolTipText("A button.");
		btn146.setBounds(114, 343, 51, 23);
		
		getContentPane().add(btn146);
		btn147.setToolTipText("A button.");
		btn147.setBounds(166, 343, 51, 23);
		
		getContentPane().add(btn147);
		btn148.setToolTipText("A button.");
		btn148.setBounds(218, 343, 51, 23);
		
		getContentPane().add(btn148);
		btn149.setToolTipText("A button.");
		btn149.setBounds(270, 343, 51, 23);
		
		getContentPane().add(btn149);
		btn150.setToolTipText("A button.");
		btn150.setBounds(322, 343, 51, 23);
		
		getContentPane().add(btn150);
		btn151.setToolTipText("A button.");
		btn151.setBounds(374, 343, 51, 23);
		
		getContentPane().add(btn151);
		btn152.setToolTipText("A button.");
		btn152.setBounds(426, 343, 51, 23);
		
		getContentPane().add(btn152);
		btn153.setToolTipText("A button.");
		btn153.setBounds(478, 343, 51, 23);
		
		getContentPane().add(btn153);
		btn154.setToolTipText("A button.");
		btn154.setBounds(530, 343, 51, 23);
		
		getContentPane().add(btn154);
		btn155.setToolTipText("A button.");
		btn155.setBounds(582, 343, 51, 23);
		
		getContentPane().add(btn155);
		btn156.setToolTipText("A button.");
		btn156.setBounds(634, 343, 51, 23);
		
		getContentPane().add(btn156);
		btn158.setToolTipText("A button.");
		btn158.setBounds(62, 367, 51, 23);
		
		getContentPane().add(btn158);
		btn159.setToolTipText("A button.");
		btn159.setBounds(114, 367, 51, 23);
		
		getContentPane().add(btn159);
		btn160.setToolTipText("A button.");
		btn160.setBounds(166, 367, 51, 23);
		
		getContentPane().add(btn160);
		btn161.setToolTipText("A button.");
		btn161.setBounds(218, 367, 51, 23);
		
		getContentPane().add(btn161);
		btn162.setToolTipText("A button.");
		btn162.setBounds(270, 367, 51, 23);
		
		getContentPane().add(btn162);
		btn163.setToolTipText("A button.");
		btn163.setBounds(322, 367, 51, 23);
		
		getContentPane().add(btn163);
		btn164.setToolTipText("A button.");
		btn164.setBounds(374, 367, 51, 23);
		
		getContentPane().add(btn164);
		btn165.setToolTipText("A button.");
		btn165.setBounds(426, 367, 51, 23);
		
		getContentPane().add(btn165);
		btn166.setToolTipText("A button.");
		btn166.setBounds(478, 367, 51, 23);
		
		getContentPane().add(btn166);
		btn167.setToolTipText("A button.");
		btn167.setBounds(530, 367, 51, 23);
		
		getContentPane().add(btn167);
		btn168.setToolTipText("A button.");
		btn168.setBounds(582, 367, 51, 23);
		
		getContentPane().add(btn168);
		btn169.setToolTipText("A button.");
		btn169.setBounds(634, 367, 51, 23);
		
		getContentPane().add(btn169);
		btn171.setToolTipText("A button.");
		btn171.setBounds(62, 391, 51, 23);
		
		getContentPane().add(btn171);
		btn172.setToolTipText("A button.");
		btn172.setBounds(114, 391, 51, 23);
		
		getContentPane().add(btn172);
		btn173.setToolTipText("A button.");
		btn173.setBounds(166, 391, 51, 23);
		
		getContentPane().add(btn173);
		btn174.setToolTipText("A button.");
		btn174.setBounds(218, 391, 51, 23);
		
		getContentPane().add(btn174);
		btn175.setToolTipText("A button.");
		btn175.setBounds(270, 391, 51, 23);
		
		getContentPane().add(btn175);
		btn176.setToolTipText("A button.");
		btn176.setBounds(322, 391, 51, 23);
		
		getContentPane().add(btn176);
		btn177.setToolTipText("A button.");
		btn177.setBounds(374, 391, 51, 23);
		
		getContentPane().add(btn177);
		btn178.setToolTipText("A button.");
		btn178.setBounds(426, 391, 51, 23);
		
		getContentPane().add(btn178);
		btn179.setToolTipText("A button.");
		btn179.setBounds(478, 391, 51, 23);
		
		getContentPane().add(btn179);
		btn180.setToolTipText("A button.");
		btn180.setBounds(530, 391, 51, 23);
		
		getContentPane().add(btn180);
		btn181.setToolTipText("A button.");
		btn181.setBounds(582, 391, 51, 23);
		
		getContentPane().add(btn181);
		btn182.setToolTipText("A button.");
		btn182.setBounds(634, 391, 51, 23);
		
		getContentPane().add(btn182);
		btn184.setToolTipText("A button.");
		btn184.setBounds(62, 415, 51, 23);
		
		getContentPane().add(btn184);
		btn185.setToolTipText("A button.");
		btn185.setBounds(114, 415, 51, 23);
		
		getContentPane().add(btn185);
		btn186.setToolTipText("A button.");
		btn186.setBounds(166, 415, 51, 23);
		
		getContentPane().add(btn186);
		btn187.setToolTipText("A button.");
		btn187.setBounds(218, 415, 51, 23);
		
		getContentPane().add(btn187);
		btn188.setToolTipText("A button.");
		btn188.setBounds(270, 415, 51, 23);
		
		getContentPane().add(btn188);
		btn189.setToolTipText("A button.");
		btn189.setBounds(322, 415, 51, 23);
		
		getContentPane().add(btn189);
		btn190.setToolTipText("A button.");
		btn190.setBounds(374, 415, 51, 23);
		
		getContentPane().add(btn190);
		btn191.setToolTipText("A button.");
		btn191.setBounds(426, 415, 51, 23);
		
		getContentPane().add(btn191);
		btn192.setToolTipText("A button.");
		btn192.setBounds(478, 415, 51, 23);
		
		getContentPane().add(btn192);
		btn193.setToolTipText("A button.");
		btn193.setBounds(530, 415, 51, 23);
		
		getContentPane().add(btn193);
		btn194.setToolTipText("A button.");
		btn194.setBounds(582, 415, 51, 23);
		
		getContentPane().add(btn194);
		btn195.setToolTipText("A button.");
		btn195.setBounds(634, 415, 51, 23);
		
		getContentPane().add(btn195);
		timerPanel.setToolTipText("A panel containing a timer.");
		timerPanel.setBorder(new TitledBorder(null, "Timer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		timerPanel.setBounds(109, 449, 256, 100);
		
		getContentPane().add(timerPanel);
		timerPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		timerTextField = new JTextField();
		timerTextField.setEditable(false);
		timerTextField.setHorizontalAlignment(SwingConstants.CENTER);
		timerTextField.setText("0:00");
		timerTextField.setFont(new Font("Tahoma", Font.PLAIN, 50));
		timerPanel.add(timerTextField);
		timerTextField.setColumns(10);
		gameRulesPanel.setToolTipText("Panel for the game rules.");
		gameRulesPanel.setBorder(new TitledBorder(null, "Game Rules", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		gameRulesPanel.setBounds(374, 449, 311, 100);
		
		getContentPane().add(gameRulesPanel);
		gameRulesPanel.setLayout(null);
		txtGameRules.setToolTipText("Game rules are listed here.");
		txtGameRules.setBackground(UIManager.getColor("Button.background"));
		txtGameRules.setText("1. Press a button at least once every 20 seconds.\n"
				+ "2. If the background turns green, you are safe.\n"
				+ "3. If the background turns red, you have been eliminated.\n"
				+ "4. Be the last remaining player to win the game.");
		txtGameRules.setBounds(10, 22, 292, 67);
		
		gameRulesPanel.add(txtGameRules);
		btnExitGame.setBackground(new Color(255, 0, 0));
		btnExitGame.setToolTipText("Button used to exit game when prompted.");
		btnExitGame.setBounds(10, 503, 89, 46);
		
		getContentPane().add(btnExitGame);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setBackground(new Color(0, 255, 255));
		btnStartGame.setToolTipText("Button that indicates the start of the game.");
		btnStartGame.setBounds(10, 449, 89, 46);
		getContentPane().add(btnStartGame);
		
	}

	/**
	 * Updates the time on the timer.
	 * @param second
	 */
	public void updateTimer(int second) {
		timerTextField.selectAll();
		timerTextField.replaceSelection(String.format("0:%02d", second));
	}
	
	
	/**
	 * Appends a string message.
	 * 	  
	 * @param msg
	 */
	public void append(String msg) {
		// TODO Auto-generated method stub

	}

	/**
	 * Displays components.
	 * 	  
	 * @param supplier the supplier of the component.
	 */
	public void displayComponent(Supplier<JComponent> supplier) {
		// TODO Auto-generated method stub

	}

	/**
	 * Displays the roster.
	 * 	  
	 * @param strRoster
	 */
	public void displayRoster(String strRoster) {
		// TODO Auto-generated method stub

	}

	/**
	 * Starts the micro view.
	 */
	public void start() {
		// TODO Auto-generated method stub
		initGUI();
	}

	/**
	 * Changes the panel color appropriately.
	 * @param buttonStatus
	 */
	public void changePanelColor(Boolean buttonStatus) {
		
		if (buttonStatus == true) {
			// change it to red
			getContentPane().setBackground(Color.RED);
			repaint();
			// repaint it black
			getContentPane().setBackground(new Color(0,0,0));
			repaint();
		}
		else {
			// change it to green
			getContentPane().setBackground(Color.GREEN);
			repaint();
			//repaint it black
			getContentPane().setBackground(new Color(0,0,0));
			repaint();
		}
		
	}

	/**
	 * Exits the game.
	 */
	public void exitGame() {
		// TODO Auto-generated method stub
		
	}

}
