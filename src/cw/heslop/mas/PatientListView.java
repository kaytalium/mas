package cw.heslop.mas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.ResultSetMetaData;

import cw.heslop.mas.component.ApplicationMenu;
import cw.heslop.mas.component.MTextField;
import cw.heslop.mas.objects.DatabaseConnection;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class PatientListView extends JPanel {


	private JTable table;
	private MTextField txt_search;
	private MainView parent;



	/**
	 * Create the panel.
	 */
	public PatientListView(){
			
//		setBackground(new Color(255, 0, 0));
		setBounds(0, 0, 616, 541);
				
		//create a database connection and get the data from the person table ready
		DatabaseConnection dc = new DatabaseConnection("mas");
		ResultSet rs = dc.executeStatementReturnResult("Select id as 'Patient ID', first_name, last_name, gender, contact from person");
		setLayout(null);
				
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 616, 71);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		add(panel);
		
		JLabel lbl_searchResult = new JLabel("We found 36 matches for your search");
		lbl_searchResult.setVisible(false);
		lbl_searchResult.setFont(new Font("Arial", Font.BOLD, 13));
		lbl_searchResult.setForeground(Color.BLACK);
		lbl_searchResult.setBounds(10, 39, 418, 32);
		panel.add(lbl_searchResult);
		
        txt_search = new MTextField();
        txt_search.setPlaceholder("Search all patient here....");
        txt_search.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		
        	}
        	@Override
        	public void keyPressed(KeyEvent e) {
        		
        	}
        	@Override
        	public void keyReleased(KeyEvent e) {
        		//capture the request from user and create query string and then update result with table
        		String userInput = (txt_search.getText().equals(txt_search.getPlaceholder())?"":txt_search.getText());
        		
        		String query = "Select id as 'Patient ID', first_name, last_name, gender, contact from person"
        				+ " where first_name LIKE '%"+userInput+"%'"
        				+ "OR last_name LIKE '%"+userInput+"%'"
        				+ "OR id LIKE '%"+userInput+"%'"
        				+ "OR gender LIKE '%"+userInput+"%'"
        				+ "OR contact LIKE '%"+userInput+"%'";
        		try {
        			ResultSet rs = dc.executeStatementReturnResult(query);
        			int resultCount = rowCount(rs);
        			
        			if(userInput.length() == 0) {
        				lbl_searchResult.setVisible(false);
        			}
        			
        			if(userInput.length() > 0 && resultCount == 0) {
        				lbl_searchResult.setText("No result was found matching your search term ");	
        				lbl_searchResult.setVisible(true);
        			}
        			
        			if(userInput.length() > 0 && resultCount > 0) {
        				String result = (resultCount>1?"results":"result");
        				lbl_searchResult.setText(resultCount+" "+result+" return for search term");	
        				lbl_searchResult.setVisible(true);
        			}
        			
					table.setModel(buildTableModel(rs));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        txt_search.setBorder(new CompoundBorder(new LineBorder(new Color(64, 64, 64)), new EmptyBorder(0, 5, 0, 0)));
		txt_search.setBounds(10, 11, 417, 32);
		Font fieldFont = new Font("Arial", Font.PLAIN, 20);
        txt_search.setFont(new Font("Arial", Font.PLAIN, 14));
        txt_search.setBackground(Color.white);
        txt_search.setForeground(Color.LIGHT_GRAY);
        txt_search.setColumns(30);
		panel.add(txt_search);
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 0));
		lblNewLabel_1.setIcon(new ImageIcon(PatientListView.class.getResource("/icons/icons8_Search_32px.png")));
		lblNewLabel_1.setBounds(425, 11, 54, 32);
		panel.add(lblNewLabel_1);
		
				
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 69, 616, 470);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 616, 470);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 616, 470);
		scrollPane.setColumnHeader(new JViewport() {
		      @Override public Dimension getPreferredSize() {
		          Dimension d = super.getPreferredSize();
		          d.height = 52;
		          return d;
		        }
		      });
		panel_4.add(scrollPane);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String patientID = (String) table.getModel().getValueAt(row, 0).toString();
//				System.out.println(P_id);
				setNavigation(patientID); 
			}
		});
		table.setRowMargin(5);
		table.setFillsViewportHeight(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(32);
		
		
		try {
			table.setModel(buildTableModel(rs));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(renderer);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(121);
		
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 20, 20));
		panel_2.setBounds(313, 5, 1, 1);
		add(panel_2);
		panel_2.setLayout(null);
		
				
		JLabel lblNewLabel = new JLabel("Copyright 2018 MAS Company Ltd. All Rights Reserved");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(273, 11, 300, 14);
		panel_2.add(lblNewLabel);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    java.sql.ResultSetMetaData metaData = rs.getMetaData();
	    String columnNameList[] = new String[]{"","Patient ID", "First Name", "Last Name", "Gender", "Mobile Number"};
	    
	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
//	    System.out.println(columnCount);
	    for (int column = 1; column <= columnCount; column++) {
//	        columnNames.add(metaData.getColumnName(column));
	    	columnNames.add(columnNameList[column]);
	    }
	    
	    

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }
//	    System.out.println(columnNames);
	    return new DefaultTableModel(data, columnNames){
			
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};

	}
	
	int rowCount(ResultSet rs) {
		int size = 0;
		try {
		    rs.last();
		    size = rs.getRow();
		    rs.beforeFirst();
		}
		catch(Exception ex) {
		    return 0;
		}
		return size;
	}
	
	public void setParent(MainView parent) {
		this.parent = parent;		
	}
	
	private void setNavigation(String patientID) {
		parent.activatePateintView(patientID, 0);
	}
}
