package cw.heslop.mas.component;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import cw.heslop.mas.Helper;
import cw.heslop.mas.MainView;
import cw.heslop.mas.objects.TimeOfDay;

import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class AppointmentList extends JPanel {

		private DefaultListModel<JPanel> model;
		private MainView mainView;
	
		public AppointmentList(AppointmentItem[] aItems) {
		setBackground(Color.DARK_GRAY);
		this.setBounds(0, 0,273,435);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 273, 435);
		add(scrollPane);
		
		
		model = new DefaultListModel<JPanel>();
		
		class PanelRenderer implements ListCellRenderer<Object> {

		    @Override
		    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		    	AppointmentItem renderer = (AppointmentItem) value;
		        renderer.setBackground(isSelected ? Color.lightGray : list.getBackground());
		        return renderer;
		    }
		}
		
		for(AppointmentItem aItem : aItems) {
			aItem.setBackground(Color.WHITE);
			model.addElement(aItem);
		}

		
		final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
		 scrollBar.addAdjustmentListener(new AdjustmentListener() {
	            @Override
	            public void adjustmentValueChanged(AdjustmentEvent e) {
	            	
	            }
	        });
			 
		 JList<JPanel> list = new JList<JPanel>(model);
		 list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		 list.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		AppointmentItem obj = (AppointmentItem)(list.getSelectedValue());
		 		if(getMainView().isPatientViewer) {
		 			getMainView().closePatientViewer();
		 		}
		 		getMainView().activatePateintView(Integer.toString(obj.getPatientID()), obj.getAppointmentID());
		 		
		 	}
		 });
			scrollPane.setColumnHeaderView(list);
			list.setFixedCellHeight(70);
			list.setBorder(null);
			list.setBackground(Color.DARK_GRAY);
			list.setCellRenderer(new PanelRenderer());
				
	
	}

		public MainView getMainView() {
			return mainView;
		}

		public void setMainView(MainView mainView) {
			this.mainView = mainView;
		}
}
