package todo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class MUtilities {
    
}
@SuppressWarnings("serial")
class MPanel extends JPanel {
    
    public MPanel(){
        this.setBounds(0, 0, 800, 560);
        this.setBackground(Color.decode("#000000"));
        this.setLayout(null);
    }
    
    MPanel(int x, int y, int w, int h, String titleName){
        this.setBounds(x, y, w, h);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE, 2)
                , titleName, 1, TitledBorder.DEFAULT_POSITION, new Font("berlin sans fb", Font.PLAIN, 22), Color.WHITE));
    }
    
}

@SuppressWarnings("serial")
class MLabel extends JLabel {
    public MLabel(int x, int y, int w, int h, int size, Color color, String text){
        this.setBounds(x, y, w, h);
        this.setFont(new Font("berlin sans fb", Font.PLAIN, size));
        this.setText(text);
        this.setForeground(color);
    }
}


@SuppressWarnings("serial")
class MTextField extends JTextField {
    
    public MTextField(int x, int y, int w, int h, int size){
         this.setBounds(x, y, w, h);
         this.setBackground(Color.BLACK);
         this.setForeground(Color.WHITE);
         this.setFont(new Font("berlin sans fb", Font.PLAIN, size));
         this.setCaretColor(Color.GREEN);
    }
}

@SuppressWarnings("serial")
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
    
    public MButton(int x, int y, int w, int h, String name){
        this.setBounds(x, y, w, h);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
        this.setText(name);
        this.setFocusable(false);
        this.setBackground(Color.BLACK);
        this.setCursor(Cursor.getPredefinedCursor(12));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    }
    
    public MButton(int x, int y, int w, int h, String name, int FontSize){
        this.setBounds(x, y, w, h);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("berlin sans fb", Font.PLAIN, FontSize));
        this.setText(name);
        this.setFocusable(false);
        this.setBackground(Color.BLACK);
        this.setCursor(Cursor.getPredefinedCursor(12));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
    }
}