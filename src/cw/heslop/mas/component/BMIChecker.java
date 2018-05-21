package cw.heslop.mas.component;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BMIChecker extends JPanel {

	private JLabel lbl_height;
	private JLabel lbl_weight;
	private JLabel lblResult;
	private JLabel lbl_result_text;
	
	public BMIChecker() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblTestYourEyes = new JLabel("BMI Checker");
		lblTestYourEyes.setForeground(Color.WHITE);
		lblTestYourEyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblTestYourEyes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTestYourEyes.setBounds(0, 11, 273, 40);
		add(lblTestYourEyes);
		
		JLabel lblAge = new JLabel("Height");
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(24, 152, 46, 22);
		add(lblAge);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setForeground(Color.WHITE);
		lblWeight.setBounds(30, 230, 46, 20);
		add(lblWeight);
		
		JSlider slider_age = new JSlider();
		slider_age.setForeground(Color.WHITE);
		slider_age.setMajorTickSpacing(10);
		slider_age.setMinorTickSpacing(1);
		slider_age.setBackground(Color.DARK_GRAY);
		slider_age.setPaintLabels(true);
		slider_age.setPaintTicks(true);
		slider_age.setValue(0);
		slider_age.setMaximum(70);
		slider_age.setBounds(30, 175, 184, 47);
		slider_age.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider src = (JSlider) e.getSource();
				float h = (float) (src.getValue()/10.0);
				lbl_height.setText(""+h);
			}
			
		});
		add(slider_age);
		
		JSlider slider_weight = new JSlider();
		slider_weight.setForeground(Color.WHITE);
		slider_weight.setMinorTickSpacing(5);
		slider_weight.setMajorTickSpacing(30);
		slider_weight.setBackground(Color.DARK_GRAY);
		slider_weight.setSnapToTicks(true);
		slider_weight.setPaintLabels(true);
		slider_weight.setPaintTicks(true);
		slider_weight.setValue(0);
		slider_weight.setMinimum(70);
		slider_weight.setMaximum(300);
		slider_weight.setBounds(30, 254, 184, 44);
		slider_weight.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				JSlider src = (JSlider) e.getSource();
				lbl_weight.setText(""+src.getValue());
			}
			
		});
		add(slider_weight);
		
		
		
		JLabel lblAdultMan = new JLabel("Adult Man & Woman Only");
		lblAdultMan.setForeground(Color.WHITE);
		lblAdultMan.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdultMan.setBounds(0, 385, 273, 26);
		add(lblAdultMan);
		
		lblResult = new JLabel("0");
		lblResult.setForeground(Color.WHITE);
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 54));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(0, 51, 273, 64);
		add(lblResult);
		
		lbl_height = new JLabel("0");
		lbl_height.setForeground(Color.WHITE);
		lbl_height.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_height.setBounds(217, 175, 46, 26);
		add(lbl_height);
		
		lbl_weight = new JLabel("0");
		lbl_weight.setForeground(Color.WHITE);
		lbl_weight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_weight.setBounds(217, 249, 46, 26);
		add(lbl_weight);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculateBMI();
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(79, 336, 115, 38);
		add(btnNewButton);
		
		lbl_result_text = new JLabel("");
		lbl_result_text.setForeground(Color.WHITE);
		lbl_result_text.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result_text.setBounds(0, 118, 273, 22);
		add(lbl_result_text);

	}

	protected void calculateBMI() {
		// TODO Auto-generated method stub
		
		
		
		//Get the values for age and weight 
		float height = Float.parseFloat(lbl_height.getText());
		int weight = Integer.parseInt(lbl_weight.getText());
		
		if(height > 4.0 && height < 5.0 && weight < 123 ) {
			this.lbl_result_text.setText("Healthy Weight");
			lblResult.setText("21");
		}
		
		if(height > 4.0 && height < 5.0 && weight > 123 ) {
			this.lbl_result_text.setText("Overweight");
			lblResult.setText("27");
		}
		
		if(height > 4.0 && height < 5.0 && weight > 148 ) {
			this.lbl_result_text.setText("Obese");
			lblResult.setText("33");
		}
		
		

	}
}
