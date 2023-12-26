import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Lab3 {

	private JFrame frmTipCalculator;
	private JLabel lblAmount;
	private JTextField textFieldAmount;
	JLabel lblTip;
	JLabel lblTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab3 window = new Lab3();
					window.frmTipCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Lab3() {
		initialize();
	}
	
	private void setTipPercent(int tipPercent) {
		TipSettings settings = TipSettings.getInstance();
		settings.setTipPercent(tipPercent);
	}
	
	private void setTipStrategy(TipStrategy strategy) {
		TipSettings settings = TipSettings.getInstance();
		settings.setTipStrategy(strategy);
	}
	
	public void calculateTip() {
		try {
			TipSettings settings = TipSettings.getInstance();
			TipStrategy tipStrategy = settings.getTipStrategy();
			int tipPercent = settings.getTipPercent();
			double amount = Double.parseDouble(textFieldAmount.getText());
			double tip = tipStrategy.calculate(amount, tipPercent);
			double total = amount + tip;
			lblTip.setText(String.format("Tip: $%.2f", tip));
			lblTotal.setText(String.format("Total: $%.2f", total));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "<<< errors in tip calculation");
			return;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTipCalculator = new JFrame();
		frmTipCalculator.setTitle("Tip Calculator");
		frmTipCalculator.setBounds(100, 100, 583, 303);
		frmTipCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTipCalculator.getContentPane().setLayout(null);
		
		lblAmount = new JLabel("Amount $");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAmount.setBounds(20, 25, 70, 24);
		frmTipCalculator.getContentPane().add(lblAmount);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(90, 25, 60, 24);
		frmTipCalculator.getContentPane().add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		JLabel lblTipPercent = new JLabel("Tip Percent");
		lblTipPercent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipPercent.setBounds(20, 70, 84, 24);
		frmTipCalculator.getContentPane().add(lblTipPercent);
		
		JRadioButton rdbtnTipPercent1 = new JRadioButton("10 %");
		rdbtnTipPercent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipPercent(10);
			}
		});
		rdbtnTipPercent1.setBounds(120, 70, 60, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipPercent1);
		
		JRadioButton rdbtnTipPercent2 = new JRadioButton("15 %");
		rdbtnTipPercent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipPercent(15);
			}
		});
		rdbtnTipPercent2.setBounds(190, 70, 60, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipPercent2);
		
		JRadioButton rdbtnTipPercent3 = new JRadioButton("20 %");
		rdbtnTipPercent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipPercent(20);
			}
		});
		rdbtnTipPercent3.setBounds(260, 70, 60, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipPercent3);
		
		JRadioButton rdbtnTipPercent4 = new JRadioButton("25 %");
		rdbtnTipPercent4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipPercent(25);
			}
		});
		rdbtnTipPercent4.setBounds(330, 70, 60, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipPercent4);
		
		ButtonGroup bg1 = new ButtonGroup();
		bg1.add(rdbtnTipPercent1);
		bg1.add(rdbtnTipPercent2);
		bg1.add(rdbtnTipPercent3);
		bg1.add(rdbtnTipPercent4);
		rdbtnTipPercent3.setSelected(true);
		
		JLabel lblTipRound = new JLabel("Tip Rounding");
		lblTipRound.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTipRound.setBounds(20, 105, 100, 24);
		frmTipCalculator.getContentPane().add(lblTipRound);
		
		JRadioButton rdbtnTipRound1 = new JRadioButton("Default");
		rdbtnTipRound1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipStrategy(new TipStrategyDefault());
			}
		});
		rdbtnTipRound1.setBounds(120, 105, 70, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipRound1);
		
		JRadioButton rdbtnTipRound2 = new JRadioButton("Round Down");
		rdbtnTipRound2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipStrategy(new TipStrategyRoundDown());
			}
		});
		rdbtnTipRound2.setBounds(190, 105, 100, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipRound2);
		
		JRadioButton rdbtnTipRound3 = new JRadioButton("Round Up");
		rdbtnTipRound3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipStrategy(new TipStrategyRoundUp());
			}
		});
		rdbtnTipRound3.setBounds(290, 105, 90, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipRound3);
		
		JRadioButton rdbtnTipRound4 = new JRadioButton("Total Round Up");
		rdbtnTipRound4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTipStrategy(new TipStrategyTotalRoundUp());
			}
		});
		rdbtnTipRound4.setBounds(380, 105, 130, 24);
		frmTipCalculator.getContentPane().add(rdbtnTipRound4);
		
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(rdbtnTipRound1);
		bg2.add(rdbtnTipRound2);
		bg2.add(rdbtnTipRound3);
		bg2.add(rdbtnTipRound4);
		rdbtnTipRound1.setSelected(true);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateTip();
			}
		});
		btnCalculate.setBounds(20, 140, 100, 24);
		frmTipCalculator.getContentPane().add(btnCalculate);
		
		lblTip = new JLabel("Tip: $");
		lblTip.setHorizontalAlignment(SwingConstants.LEFT);
		lblTip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTip.setBounds(20, 175, 120, 24);
		frmTipCalculator.getContentPane().add(lblTip);
		
		lblTotal = new JLabel("Total: $");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(20, 210, 120, 24);
		frmTipCalculator.getContentPane().add(lblTotal);
		
	}
}
