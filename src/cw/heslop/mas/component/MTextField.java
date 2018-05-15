package cw.heslop.mas.component;
import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;



@SuppressWarnings({ "serial", "unused" })
public class MTextField extends JTextField implements KeyListener, ActionListener, FocusListener, CaretListener  {
	
	private String placeholder; // = "put some here";
	private Color typingColor = Color.black;
	
	
	
	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.setText(placeholder);
		this.placeholder = placeholder;
	}

	public MTextField() {
		// TODO Auto-generated constructor stub
		super();
		Border lineBorder = new LineBorder(Color.gray,1,true);
		Border empty = new EmptyBorder(0, 5, 0, 5);
		setBorder(lineBorder);
		Border border = new CompoundBorder(lineBorder, empty);
		setBorder(border);
		addFocusListener(this);
		addCaretListener(this);
		addKeyListener(this);
		setCaretPosition(0);
		setForeground(Color.GRAY);
	}
	
	public boolean isValidated() {
		if(this.getPlaceholder().equals(this.getText())) {
			return false;
		}
		return true;
	}
	
	public boolean isPhone() {
		String regEx = "^\\((\\d{3})\\)[- ](\\d{3})[- ](\\d{4})$";
		Pattern p = Pattern.compile(regEx);
		if(p.matcher(this.getText().toString()).matches()) {
			return true;
		}
		return false;
	}
	
	public boolean isEmail() {
		String regEx = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher((CharSequence) this.getText().toString());
				
		if(matcher.find()) 
			return true;
		else
			return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(placeholder.toLowerCase().equals(this.getText().toLowerCase())) {
			this.setText("");
			this.setForeground(getTypingColor());
		}
	}

	public Color getTypingColor() {
		return typingColor;
	}

	public void setTypingColor(Color typingColor) {
		this.typingColor = typingColor;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(this.getText().isEmpty()) {
			this.setText(placeholder);
			this.setForeground(Color.GRAY);
		}
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		String inputValue = this.getText();

		if(inputValue.equals(placeholder)) {
			this.setCaretPosition(0);
			this.setForeground(Color.GRAY);
			
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		// TODO Auto-generated method stub
		
		if(this.getText().equals(placeholder) && this.getCaretPosition() !=0) {
			this.setCaretPosition(0);
			this.setForeground(Color.GRAY);
		}
	}
	
	

}
