import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class AppointmentItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public JLabel dateLabel;  
	public AppointmentItem(String date) {
		setLayout(null);
		
		dateLabel = new JLabel();
		
		if(date == null) {
			dateLabel.setText(Helper.getCurrentDate("MMM dd, yyyy"));
		}else {
			dateLabel.setText(date);
		}
		
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateLabel.setBounds(43, 11, 162, 22);
		add(dateLabel);

	}

}
