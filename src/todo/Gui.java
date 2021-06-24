package todo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui{
    
    JFrame frame;
    JPanel welcomePanel;
    MPanel panel;
    MButton longTermButton, shortTermButton, dailyButton;
    JLabel titleLabel, welcomeLabel;
    MLabel sentence1,sentence2,sentence3;
    JTextArea textArea;
    TaskType tasktype;
    
    Gui(){
        
        frame = new JFrame("Task Master"); 
        frame.setLayout(null);
        frame.setSize(800,560);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        panel = new MPanel();
        
        titleLabel = new JLabel("Task to do");
        titleLabel.setBounds(300, 0, 200, 65);
        titleLabel.setFont(new Font("berlin sans fb", Font.PLAIN, 40));
        titleLabel.setForeground(Color.WHITE);
        
        textArea = new JTextArea("nothing change");
        textArea.setBounds(20, 200, 755, 250);
        textArea.setLineWrap(true);
        textArea.setForeground(Color.red);
        textArea.setFont(new Font("berlin sans fb", Font.PLAIN, 30));
        textArea.setBackground(Color.GRAY);
        textArea.setColumns(3);
        textArea.setEditable(false);
        textArea.setVisible(true);
        
        //welcome panel
        welcomePanel = new JPanel();
        welcomePanel.setBounds(0, 150, 800, 410);
        welcomePanel.setBackground(Color.decode("#000000"));
        welcomePanel.setLayout(null);
        
        sentence1 = new MLabel(190, 50, 550, 65, 30,"#0000FF", "Them: \"All you need is motivation.\"");
        welcomePanel.add(sentence1);
        
        sentence2 = new MLabel(350, 120, 100, 65,30, "#FF0000", "Wrong!");
        welcomePanel.add(sentence2);
        
        sentence3 = new MLabel(100, 190, 650, 65, 33, "#00FF00", "You need fear and an approaching deadline.");
        welcomePanel.add(sentence3);
        
        dailyButton = new MButton(35, 70, "Daily");
        dailyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                
                
                setTextArea();
                
                Tasks task = new Tasks();
                String datas = task.getData();
                System.out.println(datas + "gui");
                textArea.setText(datas);
                
                
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
            }
        });
        shortTermButton = new MButton(310, 70, "Short Term");
        shortTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                setTextArea();
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
            }
        });
        longTermButton = new MButton(600, 70, "Long Term");
        longTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                setTextArea();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.WHITE));
            }
        });
        
        
        panel.add(dailyButton);
        panel.add(shortTermButton);
        panel.add(longTermButton);
        panel.add(titleLabel);
        panel.add(welcomePanel);
        frame.add(panel);
        
        frame.setVisible(true);
    }
    
        public void setTextArea(){
            panel.remove(welcomePanel);
            panel.add(textArea);
            panel.repaint();
        }
}
