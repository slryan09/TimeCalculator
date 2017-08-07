package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import TimeCalculator.Calculator;

/**
 * The Time Calculator project started when I was an online student who was
 * looking to find out quickly how long it would take to watch all of my
 * lectures for class. After finding lots of online calculators who offered to
 * tell me the the duration between Time A and Time B, I decided it might be
 * easier to build my own program that would read/ add the times as durations
 * and not actual "times" on a clock.
 * 
 * @author Samantha Ryan
 *
 */
public class TimeCalculatorGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JLabel lblOutput = new JLabel("Total Time: ");
	private JLabel lblTime = new JLabel("00:00:00");
	private JLabel lblHours = new JLabel("     HR");
	private JLabel lblMin = new JLabel("    MIN");
	private JLabel lblSeconds = new JLabel("    SEC");

	private JButton btnAdd = new JButton("Add");
	private JButton btnReset = new JButton("Reset");

	private JTextField txtHrs = new JTextField("00", 2);
	private JTextField txtMin = new JTextField("00", 2);
	private JTextField txtSec = new JTextField("00", 2);

	private JPanel c;
	private JPanel pnlInput;
	private JPanel pnlOutput;
	private JPanel pnlButtons;
	private Font customFont;

	private Calculator calc = Calculator.instanceOf();

	/**
	 * Constructs the TimeCalculator GUI
	 */
	public TimeCalculatorGUI() {

		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/Avenir.ttc")).deriveFont(18f);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}

		Container cp = getContentPane();
		setIconImage(null);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c = new JPanel();
		c.setBorder(BorderFactory.createTitledBorder(""));
		c.setLayout(new BorderLayout());
		c.setBackground(new Color(100, 149, 237));
		pnlInput = new JPanel();
		pnlInput.setBackground(new Color(100, 149, 237));
		pnlInput.setLayout(new GridLayout(2, 3));
		pnlInput.add(txtHrs);

		pnlInput.add(txtMin);
		pnlInput.add(txtSec);
		pnlInput.add(lblHours);
		pnlInput.add(lblMin);
		pnlInput.add(lblSeconds);

		format(lblHours);
		format(lblMin);
		format(lblSeconds);

		c.add(pnlInput, BorderLayout.NORTH);

		pnlButtons = new JPanel();
		pnlButtons.setBackground(new Color(100, 149, 237));

		pnlButtons.setLayout(new FlowLayout());
		pnlButtons.add(btnAdd);
		pnlButtons.add(btnReset);

		format(btnAdd);
		format(btnReset);

		c.add(pnlButtons, BorderLayout.CENTER);

		pnlOutput = new JPanel();
		pnlOutput.setBackground(new Color(100, 149, 237));

		pnlOutput.setLayout(new FlowLayout());
		pnlOutput.add(lblOutput);
		pnlOutput.add(lblTime);
		format(lblOutput);
		format(lblTime);
		c.add(pnlOutput, BorderLayout.SOUTH);

		txtHrs.addActionListener(this);
		txtMin.addActionListener(this);
		txtSec.addActionListener(this);
		btnAdd.addActionListener(this);
		btnReset.addActionListener(this);

		cp.add(c);
		setSize(250, 150);
		setLocation(100, 100);
		setTitle("Time Calculator");
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			int hr = Integer.parseInt(txtHrs.getText());
			int min = Integer.parseInt(txtMin.getText());
			int sec = Integer.parseInt(txtSec.getText());
			calc.addTime(hr, min, sec);
			lblTime.setText(calc.toString());
		} else if (e.getSource().equals(btnReset)) {
			calc.resetTime();
			lblTime.setText("00:00:00");
		}

	}

	/**
	 * Formats the JLabels with the correct color and font
	 * @param l JLabel to format
	 */
	private void format(JLabel l) {
		l.setForeground(Color.WHITE);
		l.setFont(customFont);
	}

	/**
	 * Formats the JButtons with the correct color and font
	 * @param b JButton to format
	 */
	private void format(JButton b) {
		b.setFont(customFont);
		b.setBackground(new Color(1, 1, 128));
	}

	/**
	 * Launches the GUI
	 * @param args
	 */
	public static void main(String[] args) {
		TimeCalculatorGUI tc = new TimeCalculatorGUI();
	}

}
