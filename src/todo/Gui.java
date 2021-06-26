package todo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Gui{
    
    JFrame frame;
    JPanel welcomePanel;
    MPanel panel;
    MButton longTermButton, shortTermButton, dailyButton,
            AddTask, RemoveTask, EditTask, AddToDone, Accomplished;
    JLabel titleLabel, welcomeLabel, headerCode, headerDescription, headerTime, headerDate;
    MLabel sentence1,sentence2,sentence3;
    JTextArea textArea;
    JScrollPane scroll;
    
    Data data = new Data();
    
    
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
        
        
        headerCode = new JLabel("Code");
        headerCode.setBounds(40, 170, 750, 20);
        headerCode.setFont(new Font("Calibri", Font.BOLD, 22));
        headerCode.setForeground(Color.WHITE);
        
        headerDescription = new JLabel("Description");
        headerDescription.setBounds(250, 170, 750, 20);
        headerDescription.setFont(new Font("Calibri", Font.BOLD, 22));
        headerDescription.setForeground(Color.WHITE);
        
        headerTime = new JLabel("Time");
        headerTime.setBounds(540, 170, 750, 20);
        headerTime.setFont(new Font("Calibri", Font.BOLD, 22));
        headerTime.setForeground(Color.WHITE);
        
        headerDate = new JLabel("Date");
        headerDate.setBounds(680, 170, 750, 20);
        headerDate.setFont(new Font("Calibri", Font.BOLD, 22));
        headerDate.setForeground(Color.WHITE);
        
        //code  + tab + description + tab + time + tab + data 
        
        textArea = new JTextArea("123456789012\tMMW TASK 1 TASK 2 HAKDOG aa\t2200\t10/20/21"
                + "\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx\nxx");
        textArea.setBounds(28, 200, 750, 280);
        textArea.setLineWrap(true);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
        textArea.setBackground(Color.BLACK);
        textArea.setColumns(3);
        textArea.setEditable(false);
        textArea.setVisible(true);
        
        scroll = new JScrollPane (textArea);
        scroll.setBounds(28, 200, 740, 280);
        scroll.setBackground(Color.BLACK);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        //welcome panel
        welcomePanel = new JPanel();
        welcomePanel.setBounds(0, 150, 800, 410);
        welcomePanel.setBackground(Color.decode("#000000"));
        welcomePanel.setLayout(null);
        
        sentence1 = new MLabel(190, 50, 550, 65, 30,Color.decode("#0000FF"), "Them: \"All you need is motivation.\"");
        welcomePanel.add(sentence1);
        
        sentence2 = new MLabel(350, 120, 100, 65,30,Color.decode("#FF0000") , "Wrong!");
        welcomePanel.add(sentence2);
        
        sentence3 = new MLabel(100, 190, 650, 65, 33, Color.decode("#00FF00"), "You need fear and an approaching deadline.");
        welcomePanel.add(sentence3);
        
        dailyButton = new MButton(35, 70, "Daily");
        dailyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                data.setTab(1);
                
                showTask();
                panel.remove(AddToDone);
                panel.remove(Accomplished);
                frame.repaint();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                
                dailyButton.setForeground(Color.decode("#80ff80"));
                shortTermButton.setForeground(Color.WHITE);
                longTermButton.setForeground(Color.WHITE);
            }
        });
        shortTermButton = new MButton(310, 70, "Short Term");
        shortTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                data.setTab(2);
                
                showTask();
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                
                dailyButton.setForeground(Color.WHITE);
                shortTermButton.setForeground(Color.decode("#80ff80"));
                longTermButton.setForeground(Color.WHITE);
            }
        });
        longTermButton = new MButton(600, 70, "Long Term");
        longTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                data.setTab(3);
                
                showTask();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                
                dailyButton.setForeground(Color.WHITE);
                shortTermButton.setForeground(Color.WHITE);
                longTermButton.setForeground(Color.decode("#80ff80"));
            }
        });
        
        
        AddTask = new MButton(35, 490, 130, 30, "Add Task") ;
        AddTask.addMouseListener(new MouseListener() {

            @Override public void mouseEntered(MouseEvent e) {
                if(e.getSource() == AddTask){
                    AddTask.setBorder(BorderFactory.createLineBorder(Color.decode("#80ff80"), 2, true));
                    AddTask.setForeground(Color.decode("#80ff80"));
                } 
            }
            @Override public void mouseExited(MouseEvent e) {
                if(e.getSource() == AddTask){
                    AddTask.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                    AddTask.setForeground(Color.WHITE);
                } 
            }
            
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
        });
        
        AddTask.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new AddTaskFrame();
            }
        });
        
        
        RemoveTask = new MButton(185, 490, 130, 30, "Remove Task");
        RemoveTask.addMouseListener(new MouseListener() {

            @Override public void mouseEntered(MouseEvent e) {
                if(e.getSource() == RemoveTask){
                    RemoveTask.setBorder(BorderFactory.createLineBorder(Color.decode("#80ff80"), 2, true));
                    RemoveTask.setForeground(Color.decode("#80ff80"));
                } 
            }
            @Override public void mouseExited(MouseEvent e) {
                if(e.getSource() == RemoveTask){
                    RemoveTask.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                    RemoveTask.setForeground(Color.WHITE);
                } 
            }
            
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
        });
        
        RemoveTask.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new RemoveTaskFrame();
            }
        });
        
        
        EditTask = new MButton(335, 490, 130, 30, "Edit Task");
        EditTask.addMouseListener(new MouseListener() {

            @Override public void mouseEntered(MouseEvent e) {
                if(e.getSource() == EditTask){
                    EditTask.setBorder(BorderFactory.createLineBorder(Color.decode("#80ff80"), 2, true));
                    EditTask.setForeground(Color.decode("#80ff80"));
                } 
            }
            @Override public void mouseExited(MouseEvent e) {
                if(e.getSource() == EditTask){
                    EditTask.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                    EditTask.setForeground(Color.WHITE);
                } 
            }
            
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
        });
        
        EditTask.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                new EditTaskFrame();
            }
        });
        
        AddToDone = new MButton(485, 490, 130, 30, "Add To Done");
        AddToDone.addMouseListener(new MouseListener() {

            @Override public void mouseEntered(MouseEvent e) {
                if(e.getSource() == AddToDone){
                    AddToDone.setBorder(BorderFactory.createLineBorder(Color.decode("#80ff80"), 2, true));
                    AddToDone.setForeground(Color.decode("#80ff80"));
                } 
            }
            @Override public void mouseExited(MouseEvent e) {
                if(e.getSource() == AddToDone){
                    AddToDone.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                    AddToDone.setForeground(Color.WHITE);
                } 
            }
            
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
        });
        AddToDone.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                new AddToDoneFrame();
            }
        });
        
        Accomplished = new MButton(635, 490, 130, 30, "Done");
        Accomplished.addMouseListener(new MouseListener() {

            @Override public void mouseEntered(MouseEvent e) {
                if(e.getSource() == Accomplished){
                    Accomplished.setBorder(BorderFactory.createLineBorder(Color.decode("#80ff80"), 2, true));
                    Accomplished.setForeground(Color.decode("#80ff80"));
                } 
            }
            @Override public void mouseExited(MouseEvent e) {
                if(e.getSource() == Accomplished){
                    Accomplished.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
                    Accomplished.setForeground(Color.WHITE);
                } 
            }
            
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseClicked(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
        });
        Accomplished.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e){
                new AccomplishedFrame();
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
    
        public void showTask(){
            
            panel.add(AddTask);
            panel.add(RemoveTask);
            panel.add(EditTask);
            panel.add(AddToDone);
            panel.add(Accomplished);
            
            panel.remove(welcomePanel);
            panel.add(scroll);
            panel.add(headerCode);
            panel.add(headerDescription);
            panel.add(headerTime);
            panel.add(headerDate);
            panel.repaint();
        }
}

class AddTaskFrame {
    
    JFrame AddTaskFrame;
    MPanel AddTaskPanel;
    MLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel, TimeFormatLabel, DateFormatLabel;
    MTextField Code, Date, Time;
    JTextArea Description;
    MButton AddButton, CancelButton;
    
    
    AddTaskFrame(){
        AddTaskFrame = new JFrame();
        AddTaskFrame.dispatchEvent(new WindowEvent(AddTaskFrame, WindowEvent.WINDOW_CLOSING));
        AddTaskFrame.setLayout(null);
        AddTaskFrame.getContentPane().setBackground(Color.BLACK);
        AddTaskFrame.setSize(500, 500);
        AddTaskFrame.setLocationRelativeTo(null);
        AddTaskFrame.setResizable(false);
        
        AddTaskPanel = new MPanel(50, 35, 400, 400, "Add Task");
        
        DateFormatLabel = new MLabel(190, 115, 100, 20, 15, Color.decode("#80ff80"), "DD/MM/YY");
        TimeFormatLabel = new MLabel(190, 165, 100, 20, 15, Color.decode("#80ff80"), "HHMM");
        
        CodeLabel = new MLabel(120, 40, 70, 25, 20, Color.WHITE, "Code  :");
        DateLabel = new MLabel(120, 90, 70, 25, 20, Color.WHITE, "Date  :");
        TimeLabel = new MLabel(120, 140, 70, 25, 20, Color.WHITE, "Time  :");
        
        Code = new MTextField(190, 40, 120, 25, 20);
        Date = new MTextField(190, 90, 120, 25, 20);
        Time = new MTextField(190, 140, 120, 25, 20);
        
        Description = new JTextArea("");
        Description.setBounds(30, 200, 340, 100);
        Description.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), 
                "Description", 1 ,TitledBorder.DEFAULT_JUSTIFICATION ,new Font("Berlin sans fb", Font.PLAIN, 20) , Color.WHITE));
        Description.setLineWrap(true);
        Description.setForeground(Color.WHITE);
        Description.setFont(new Font("berlin sans fb", Font.PLAIN, 19));
        Description.setCaretColor(Color.decode("#80ff80"));
        Description.setBackground(Color.BLACK);
        Description.setEditable(true);
        Description.setVisible(true);
        
        AddButton = new MButton(50, 340, 100, 30, "Add");
        CancelButton = new MButton(250, 340, 100, 30, "Cancel");
        
        
        AddTaskPanel.add(CodeLabel);
        AddTaskPanel.add(TimeLabel);
        AddTaskPanel.add(DateLabel);
        AddTaskPanel.add(TimeFormatLabel);
        AddTaskPanel.add(DateFormatLabel);
        
        AddTaskPanel.add(Code);
        AddTaskPanel.add(Description);
        AddTaskPanel.add(Time);
        AddTaskPanel.add(Date);
        
        AddTaskPanel.add(AddButton);
        AddTaskPanel.add(CancelButton);
        
        AddTaskFrame.add(AddTaskPanel);
        
        AddTaskFrame.setVisible(true);
    }
    
}
class RemoveTaskFrame {
    
    JFrame RemoveFrame;
    MPanel RemoveTaskPanel;
    JLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel;
    JTextField Code, Description, Date, Time;
    MButton add, cancel;
    
    
    RemoveTaskFrame(){
        RemoveFrame = new JFrame();
        RemoveFrame.dispatchEvent(new WindowEvent(RemoveFrame, WindowEvent.WINDOW_CLOSING));
        RemoveFrame.setLayout(null);
        RemoveFrame.getContentPane().setBackground(Color.BLACK);
        RemoveFrame.setSize(500, 500);
        RemoveFrame.setLocationRelativeTo(null);
        RemoveFrame.setResizable(false);
        
        RemoveTaskPanel = new MPanel(50, 25, 400, 400, "Remove Task");
        
        
        RemoveFrame.add(RemoveTaskPanel);
        RemoveFrame.setVisible(true);
    }
}

class EditTaskFrame {
    
    JFrame EditTaskFrame;
    MPanel EditTaskPanel;
    JLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel;
    JTextField Code, Description, Date, Time;
    MButton add, cancel;
    
    
    EditTaskFrame(){
        EditTaskFrame = new JFrame();
        EditTaskFrame.dispatchEvent(new WindowEvent(EditTaskFrame, WindowEvent.WINDOW_CLOSING));
        EditTaskFrame.setLayout(null);
        EditTaskFrame.getContentPane().setBackground(Color.BLACK);
        EditTaskFrame.setSize(500, 500);
        EditTaskFrame.setLocationRelativeTo(null);
        EditTaskFrame.setResizable(false);
        
        EditTaskPanel = new MPanel(50, 25, 400, 400, "Edit Task");
        
        
        EditTaskFrame.add(EditTaskPanel);
        EditTaskFrame.setVisible(true);
        
    }
}

class AddToDoneFrame {
    
    JFrame AddToDoneFrame;
    MPanel AddToDonePanel;
    JLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel;
    JTextField Code, Description, Date, Time;
    MButton add, cancel;
    
    
    AddToDoneFrame(){
        AddToDoneFrame = new JFrame();
        AddToDoneFrame.dispatchEvent(new WindowEvent(AddToDoneFrame, WindowEvent.WINDOW_CLOSING));
        AddToDoneFrame.setLayout(null);
        AddToDoneFrame.getContentPane().setBackground(Color.BLACK);
        AddToDoneFrame.setSize(500, 500);
        AddToDoneFrame.setLocationRelativeTo(null);
        AddToDoneFrame.setResizable(false);
        
        AddToDonePanel = new MPanel(50, 25, 400, 400, "Add To Done");
        
        
        AddToDoneFrame.add(AddToDonePanel);
        AddToDoneFrame.setVisible(true);
        
    }
}

class AccomplishedFrame {
    
}