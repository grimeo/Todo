package todo;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui{
    
    JFrame frame;
    MPanel panel;
    MButton longTerm, shortTerm, daily;
    JLabel mainText;
            
     Gui(){
        
        frame = new JFrame("Task Master"); 
        frame.setLayout(null);
        frame.setSize(800,560);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        panel = new MPanel();
        frame.add(panel);
        
        daily = new MButton(35, 70, "Daily");
        panel.add(daily);
        shortTerm = new MButton(310, 70, "Short Term");
        panel.add(shortTerm);
        longTerm = new MButton(600, 70, "Long Term");
        panel.add(longTerm);
        
        mainText = new JLabel("Task to do");
        mainText.setBounds(300, 0, 200, 65);
        mainText.setFont(new Font("berlin sans fb", Font.PLAIN, 40));
        mainText.setForeground(Color.WHITE);
        panel.add(mainText);
        
        
        
        
        
        frame.setVisible(true);
    }
    
    
}

class MPanel extends JPanel {
    
    public MPanel(){
        this.setBounds(0, 0, 800, 560);
        this.setBackground(Color.decode("#000000"));
        this.setLayout(null);
        
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
        
        //this.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));
    }
}