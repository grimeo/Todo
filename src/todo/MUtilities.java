package todo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MUtilities {
    
}
class MPanel extends JPanel {
    
    public MPanel(){
        this.setBounds(0, 0, 800, 560);
        this.setBackground(Color.decode("#000000"));
        this.setLayout(null);
        
    }
    
}

class MLabel extends JLabel {
    public MLabel(int x, int y, int w, int h, int size, String color, String text){
        this.setBounds(x, y, w, h);
        this.setFont(new Font("berlin sans fb", Font.PLAIN, size));
        this.setText(text);
        this.setForeground(Color.decode(color));
    }
}


class MTextField extends JTextField {
    
    public MTextField(int x, int y){
         
    }
}

class MButton extends JButton {
    
    public MButton(int x , int y, String text){
        this.setFocusable(false);
        this.setBounds(x, y, 150, 50);
        this.setBackground(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("berlin sans fb", Font.PLAIN, 30));
        this.setText(text);
        this.setCursor(Cursor.getPredefinedCursor(12));
        
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
        //this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "WHITE"));
    }
}