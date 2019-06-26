package demoUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Double;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;

public class shareTradingUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shareTradingUI window = new shareTradingUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean judgeHungred(int n) {
		if(n % 100 == 0)
			return true;
		else 
			return false;
	}
	
	public double serviceCharge(double p, double q, int n) {
		if(p < 1000 && q < 14 && judgeHungred(n)) 
			return p*0.084 + p*0.084*0.05;
		if(p < 1000 && q < 14 && !judgeHungred(n))
			return p*0.084 + p*0.084*0.09;
		if(p < 1000 && q >= 14 && q <25 && judgeHungred(n))
			return p*0.084 + p*0.084*0.02;
		if(p < 1000 && q >= 14 && q <25 && !judgeHungred(n))
			return p*0.084 + p*0.084*0.06;
		if(p < 1000 && q >= 25 && judgeHungred(n)) 
			return p*0.084 + p*0.084*0.01;
		if(p < 1000 && q >= 25 && !judgeHungred(n)) 
			return p*0.084 + p*0.084*0.04;
		
		if(p >= 1000 && p < 10000 && q < 14 && judgeHungred(n)) 
			return (p*0.05 + 34) + (p*0.05 + 34)*0.05;
		if(p >= 1000 && p < 10000 && q < 14 && !judgeHungred(n)) 
			return (p*0.05 + 34) + (p*0.05 + 34)*0.09;
		if(p >= 1000 && p < 10000 && q >= 14 && q < 25 && judgeHungred(n)) 
			return (p*0.05 + 34) + (p*0.05 + 34)*0.02;
		if(p >= 1000 && p < 10000 && q >= 14 && q < 25 && !judgeHungred(n)) 
			return (p*0.05 + 34) + (p*0.05 + 34)*0.06;
		if(p >= 1000 && p < 10000 && q >= 25 && judgeHungred(n))
			return (p*0.05 + 34) + (p*0.05 + 34)*0.01;
		if(p >= 1000 && p < 10000 && q >= 25 && !judgeHungred(n))
			return (p*0.05 + 34) + (p*0.05 + 34)*0.04;
		
		if(p > 10000 && q < 14 && judgeHungred(n)) 
			return (p*0.04 + 134) + (p*0.04 + 134)*0.05;
		if(p > 10000 && q < 14 && !judgeHungred(n))
			return (p*0.04 + 134) + (p*0.04 + 134)*0.09;
		if(p > 10000 && q >= 14 && q <25 && judgeHungred(n))
			return (p*0.04 + 134) + (p*0.04 + 134)*0.02;
		if(p > 10000 && q >= 14 && q <25 && !judgeHungred(n))
			return (p*0.04 + 134) + (p*0.04 + 134)*0.06;
		if(p > 10000 && q >= 25 && judgeHungred(n)) 
			return (p*0.04 + 134) + (p*0.04 + 134)*0.01;
		if(p > 10000 && q >= 25 && !judgeHungred(n)) 
			return (p*0.04 + 134) + (p*0.04 + 134)*0.04;
		
		return -1;
	}

	/**
	 * Create the application.
	 */
	public shareTradingUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u80A1\u7968\u4EA4\u6613\u7CFB\u7EDF");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		
		JLabel label = new JLabel("\u4EA4\u6613\u603B\u91D1\u989D:");
		
		JLabel label_1 = new JLabel("\u6BCF\u80A1\u552E\u4EF7:");
		
		JLabel label_2 = new JLabel("\u80A1\u6570:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		
		JButton button = new JButton("\u63D0\u4EA4\u4EA4\u6613\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		JLabel label_3 = new JLabel("\u60A8\u9700\u8981\u63D0\u4EA4\u7684\u624B\u7EED\u8D39\u4E3A:");
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(3);
		textArea.setEditable(false);
		
//		double finalSum = 0;
//		if(totalSum != null && perShare != null && shareNUm != null)
//			finalSum = serviceCharge(Double.parseDouble(totalSum), Double.parseDouble(perShare), Integer.parseInt(shareNUm));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//String totalSum = textField.getText();
				String perShare = textField_1.getText();
				String shareNUm = textField_2.getText();
				double finalSum = 0;
				
//				if(totalSum == null || perShare == null || shareNUm==null) {
//					textArea.setText("输入项不应该有空");
//				}else {
				
//				if(totalSum != null && perShare != null && shareNUm != null)
				//Double.parseDouble(totalSum)>=0 && 
					try{
						if(Double.parseDouble(perShare)>=0 && Integer.parseInt(shareNUm)>=0 ) {
							double totalSum = Double.parseDouble(perShare) * Integer.parseInt(shareNUm);
							textField.setText(String.valueOf(totalSum));
							finalSum = serviceCharge(totalSum, Double.parseDouble(perShare), Integer.parseInt(shareNUm));
							String model = "共计: %f 元";
							//double t = 12;
							//double finalSum = serviceCharge(Double.parseDouble(totalSum), Double.parseDouble(perShare), Integer.parseInt(shareNUm));
							//String str = serviceCharge(Double.parseDouble(totalSum), Double.parseDouble(perShare), Integer.parseInt(shareNUm)) + "yuan";
							String str = String.format(model, finalSum);
							textArea.setText(" ");
							//textArea.setText(str);
							textArea.append(str);
						}else {
							textArea.setText("错误，\n各输入项不应存在负数值");
						}
					}catch(NumberFormatException e) {
						textArea.setText("错误，\n各输入项不应该有空\n");
					}
				
			}
		});
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.WEST, textField_2, 63, SpringLayout.EAST, label_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_2, -41, SpringLayout.WEST, textArea);
		springLayout.putConstraint(SpringLayout.NORTH, textField_1, -3, SpringLayout.NORTH, label_1);
		springLayout.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField_2);
		springLayout.putConstraint(SpringLayout.EAST, textField_1, -31, SpringLayout.WEST, label_3);
		springLayout.putConstraint(SpringLayout.WEST, label_2, 14, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_1, 50, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, label_2);
		springLayout.putConstraint(SpringLayout.WEST, textField, 304, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textField, -21, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.SOUTH, label_2, -26, SpringLayout.NORTH, button);
		springLayout.putConstraint(SpringLayout.NORTH, button, -4, SpringLayout.NORTH, label);
		springLayout.putConstraint(SpringLayout.WEST, button, 24, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textField, 37, SpringLayout.SOUTH, textArea);
		springLayout.putConstraint(SpringLayout.NORTH, label, 3, SpringLayout.NORTH, textField);
		springLayout.putConstraint(SpringLayout.EAST, label, -25, SpringLayout.WEST, textField);
		springLayout.putConstraint(SpringLayout.SOUTH, textArea, 128, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, label_3, 16, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, label_3, 253, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, textArea, 44, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, textArea, 263, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textArea, 411, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(label);
		frame.getContentPane().add(label_1);
		frame.getContentPane().add(label_2);
		frame.getContentPane().add(textField_2);
		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField_1);
		frame.getContentPane().add(textArea);
		frame.getContentPane().add(label_3);
		frame.getContentPane().add(button);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		frame.getContentPane().add(horizontalGlue);
	}
}
