package todo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui{
    
    JFrame frame;
    JPanel welcomePanel;
    MPanel panel;
    MButton longTerm, shortTerm, daily;
    JLabel titleLabel, welcomeLabel,sentence1,sentence2,sentence3;
    JTextArea lists;
            
     Gui(){
        
        frame = new JFrame("Task Master"); 
        frame.setLayout(null);
        frame.setSize(800,560);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        panel = new MPanel();
        
        daily = new MButton(35, 70, "Daily");
        shortTerm = new MButton(310, 70, "Short Term");
        longTerm = new MButton(600, 70, "Long Term");
        
        titleLabel = new JLabel("Task to do");
        titleLabel.setBounds(300, 0, 200, 65);
        titleLabel.setFont(new Font("berlin sans fb", Font.PLAIN, 40));
        titleLabel.setForeground(Color.WHITE);
        
        lists = new JTextArea("");
        lists.setBounds(20, 200, 755, 300);
        lists.setBackground(Color.WHITE);
        lists.setEditable(false);
        lists.setVisible(true);
        
        //welcome panel
        welcomePanel = new JPanel();
        welcomePanel.setBounds(0, 150, 800, 410);
        welcomePanel.setBackground(Color.decode("#000000"));
        welcomePanel.setLayout(null);
        
        sentence1 = new JLabel("Them: \"All you need is motivation.\"");
        sentence1.setBounds(190, 50, 550, 65);
        sentence1.setFont(new Font("berlin sans fb", Font.PLAIN, 30));
        sentence1.setForeground(Color.BLUE);
        welcomePanel.add(sentence1);
        
        sentence2 = new JLabel("Wrong!");
        sentence2.setBounds(350, 120, 100, 65);
        sentence2.setFont(new Font("berlin sans fb", Font.PLAIN, 30));
        sentence2.setForeground(Color.RED);
        welcomePanel.add(sentence2);
        
        sentence3 = new JLabel("You need fear and an approaching deadline.");
        sentence3.setBounds(100, 190, 650, 65);
        sentence3.setFont(new Font("berlin sans fb", Font.PLAIN, 33));
        sentence3.setForeground(Color.GREEN);
        welcomePanel.add(sentence3);
        
        // panel.add(lists);
        
        frame.add(panel);
        panel.add(daily);
        panel.add(shortTerm);
        panel.add(titleLabel);
        panel.add(longTerm);
        panel.add(welcomePanel);
        
        
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
        this.setCursor(Cursor.getPredefinedCursor(12));
        
        this.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.WHITE));
    }
}