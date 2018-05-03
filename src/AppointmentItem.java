import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class AppointmentItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public JLabel dateLabel;  
	public AppointmentItem(String date) {
		setBorder(new LineBorder(new Color(192, 192, 192)));
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		dateLabel = new JLabel();
		dateLabel.setText("January 30 2018");
		
		if(date == null) {
			dateLabel.setText(Helper.getCurrentDate("MMM dd, yyyy"));
		}else {
			dateLabel.setText(date);
		}
		
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateLabel.setBounds(33, 11, 162, 22);
		add(dateLabel);

	}

}
