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

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

@SuppressWarnings({ "serial", "unused" })
public class MPasswordField extends JPasswordField implements KeyListener, ActionListener, FocusListener, CaretListener  {
	
	private String placeholder; //"put some here";
	private char defaultChar;
	
	
	
	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.setText(placeholder);
		this.placeholder = placeholder;
	}

	public MPasswordField() {
		// TODO Auto-generated constructor stub
		super();
		setForeground(Color.gray);
		Border lineBorder = new LineBorder(Color.gray,1,true);
		Border empty = new EmptyBorder(0, 5, 0, 5);
		setBorder(lineBorder);
		Border border = new CompoundBorder(lineBorder, empty);
		setBorder(border);
		addFocusListener(this);
		addCaretListener(this);
		addKeyListener(this);
		defaultChar = getEchoChar();
		setEchoChar((char) 0);
		
		
		
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
			this.setForeground(Color.black);
			this.setEchoChar(defaultChar);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(this.getText().isEmpty()) {
			this.setText(placeholder);
			this.setForeground(Color.GRAY);
			this.setEchoChar((char) 0);
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
