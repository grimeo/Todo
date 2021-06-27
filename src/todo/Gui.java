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
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Gui{
    
    JFrame frame;
    JPanel welcomePanel;
    MPanel panel;
    MButton longTermButton, shortTermButton, dailyButton,
            AddTask, RemoveTask, EditTask;
    JLabel titleLabel, welcomeLabel, headerCode, headerDescription, headerTime, headerDate;
    MLabel sentence1,sentence2,sentence3;
    JTextArea textArea;
    JTable table;
    JScrollPane scroll;
    
    Data data = new Data();
    ManipulateCSV manipCSV;
    ManipulateData manipData;
    
    private int secret;
    Gui(int n){
        secret = n;
        secret = secret+n;
    }
    
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
        headerTime.setBounds(570, 170, 750, 20);
        headerTime.setFont(new Font("Calibri", Font.BOLD, 22));
        headerTime.setForeground(Color.WHITE);
        
        headerDate = new JLabel("Date");
        headerDate.setBounds(680, 170, 750, 20);
        headerDate.setFont(new Font("Calibri", Font.BOLD, 22));
        headerDate.setForeground(Color.WHITE);
        
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
                
                manipCSV = new CreateCSVFile();
                manipCSV.manipCSV();
                
                manipCSV = new ReadCSV();
                manipCSV.manipCSV();
                
                showTask();
                frame.repaint();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                
                dailyButton.setForeground(Color.decode("#80ff80"));
                shortTermButton.setForeground(Color.WHITE);
                longTermButton.setForeground(Color.WHITE);
                
                table.repaint();
            }
        });
        shortTermButton = new MButton(310, 70, "Short Term");
        shortTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                data.setTab(2);
                
                manipCSV = new CreateCSVFile();
                manipCSV.manipCSV();
                
                manipCSV = new ReadCSV();
                manipCSV.manipCSV();
                
                showTask();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                
                dailyButton.setForeground(Color.WHITE);
                shortTermButton.setForeground(Color.decode("#80ff80"));
                longTermButton.setForeground(Color.WHITE);
                
                table.repaint();
            }
        });
        longTermButton = new MButton(600, 70, "Long Term");
        longTermButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                data.setTab(3);
                
                manipCSV = new CreateCSVFile();
                manipCSV.manipCSV();
                
                manipCSV = new ReadCSV();
                manipCSV.manipCSV();
                
                showTask();
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                
                dailyButton.setForeground(Color.WHITE);
                shortTermButton.setForeground(Color.WHITE);
                longTermButton.setForeground(Color.decode("#80ff80"));
                
                table.repaint();
            }
        });
        
        
        AddTask = new MButton(135, 490, 130, 30, "Add Task") ;
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
        
        
        RemoveTask = new MButton(535, 490, 130, 30, "Remove Task");
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
        
        
        panel.add(dailyButton);
        panel.add(shortTermButton);
        panel.add(longTermButton);
        panel.add(titleLabel);
        panel.add(welcomePanel);
        frame.add(panel);
        
        frame.setVisible(true);
    }
    
        public void showTask(){
            
            manipCSV = new CreateCSVFile();
            manipCSV.manipCSV();
            
            manipCSV = new ReadCSV();
            manipCSV.manipCSV();
            
            String[] columnName = {"m","m","m","m"};
            
            TableModel tableModel = new DefaultTableModel(data.getList().toArray(new Object[][] {}),columnName);
            
            table = new JTable(tableModel);
            
            DefaultTableCellRenderer  renderToCenter = new  DefaultTableCellRenderer();
            renderToCenter.setHorizontalAlignment(SwingConstants.CENTER);

            table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);

            table.getColumnModel().getColumn(1).setPreferredWidth(420);

            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setCellRenderer(renderToCenter);

            table.getColumnModel().getColumn(3).setPreferredWidth(102);
            table.getColumnModel().getColumn(3).setCellRenderer(renderToCenter);

            table.getTableHeader().setOpaque(false);

            table.getTableHeader().setForeground(Color.WHITE);
            table.getTableHeader().setBackground(Color.BLACK);
            table.getTableHeader().setUI(null); // this will not show the header

            table.setRowHeight(25);
            table.setFont(new Font("berlin sans fb", Font.PLAIN, 20));
            //table.setForeground(Color.WHITE);
            table.setCellSelectionEnabled(false);
            table.setEnabled(false);
            table.setGridColor(Color.WHITE);

            table.selectAll();
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);


            scroll = new JScrollPane (table);
            scroll.setBounds(28, 200, 740, 280);
            scroll.getViewport().setBackground(Color.BLACK);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            
            panel.add(AddTask);
            panel.add(RemoveTask);
            panel.add(EditTask);
            
            panel.remove(welcomePanel);
            panel.add(scroll);
            panel.add(headerCode);
            panel.add(headerDescription);
            panel.add(headerTime);
            panel.add(headerDate);
            table.repaint();
        }
        
}

class AddTaskFrame{
    
    JFrame AddTaskFrame;
    MPanel AddTaskPanel;
    MLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel, TimeFormatLabel, DateFormatLabel, SearchResult;
    MTextField Code, Date, Time;
    JTextArea Description;
    MButton AddButton, CancelButton;
    
    Data data = new Data();
    ManipulateCSV manipCSV;
    ManipulateData manipData;
    
    AddTaskFrame(){
        AddTaskFrame = new JFrame("Add Task");
        AddTaskFrame.dispatchEvent(new WindowEvent(AddTaskFrame, WindowEvent.WINDOW_CLOSING));
        AddTaskFrame.setLayout(null);
        AddTaskFrame.getContentPane().setBackground(Color.BLACK);
        AddTaskFrame.setSize(500, 500);
        AddTaskFrame.setLocationRelativeTo(null);
        AddTaskFrame.setResizable(false);
        
        AddTaskPanel = new MPanel(50, 35, 400, 400, "Add Task");
        
        SearchResult = new MLabel(190, 65, 150, 20, 15, Color.decode("#ff8080"), "");
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
        AddButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                data.setResult(false);
                
                SearchResult.setText("");
                
                manipCSV = new CreateCSVFile();
                manipCSV.manipCSV();
                
                if(Code.getText().isEmpty()){
                    SearchResult.setText("Code cannot be empty.");
                } else {
                    manipCSV = new ReadCSV();
                    manipCSV.manipCSV();
                    
                    data.setSearch(Code.getText());
                    
                    manipData = new SearchInput();
                    manipData.manipData();
                    
                    if(data.getResult()){
                        SearchResult.setText("Code exists");
                    } else {
                        
                        data.setTaskData(Code.getText(), Description.getText(), Time.getText(), Date.getText());
                        
                        manipCSV = new WriteNextLine();
                        manipCSV.manipCSV();
                        
                        Code.setText("");
                        Time.setText("");
                        Date.setText("");
                        Description.setText("");
                        
                        
                        AddTaskFrame.dispatchEvent(new WindowEvent(AddTaskFrame, WindowEvent.WINDOW_CLOSING));
                    }
                }
                
            }
        });
        
        CancelButton = new MButton(250, 340, 100, 30, "Cancel");
        CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SearchResult.setText("");
                Code.setText("");
                Time.setText("");
                Date.setText("");
                Description.setText("");
                AddTaskFrame.dispatchEvent(new WindowEvent(AddTaskFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        
        AddTaskPanel.add(CodeLabel);
        AddTaskPanel.add(TimeLabel);
        AddTaskPanel.add(DateLabel);
        AddTaskPanel.add(TimeFormatLabel);
        AddTaskPanel.add(DateFormatLabel);
        AddTaskPanel.add(SearchResult);
        
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
class RemoveTaskFrame{
    
    JFrame RemoveFrame;
    MPanel RemoveTaskPanel;
    MLabel CodeLabel, NotifyLabel, SearchResult;
    JTextArea Code;
    MButton RemoveButton, CancelButton;
    
    Data data = new Data();
    ManipulateCSV manipCSV;
    ManipulateData manipData;
    
    RemoveTaskFrame(){
        
        RemoveFrame = new JFrame("Remove Task");
        RemoveFrame.dispatchEvent(new WindowEvent(RemoveFrame, WindowEvent.WINDOW_CLOSING));
        RemoveFrame.setLayout(null);
        RemoveFrame.getContentPane().setBackground(Color.BLACK);
        RemoveFrame.setSize(500, 500);
        RemoveFrame.setLocationRelativeTo(null);
        RemoveFrame.setResizable(false);
        
        RemoveTaskPanel = new MPanel(50, 25, 400, 400, "Remove Task");
        
        SearchResult = new MLabel(120, 110, 150, 20, 15, Color.decode("#ff8080"), "");
        //NotifyLabel = new MLabel(120, 50, 300, 25, 18, Color.decode("#80FF80"), "Use \" , \" to seperate Task ID");
        
        CodeLabel = new MLabel(50, 80, 70, 25, 20, Color.WHITE, "Code  :");
        
        Code = new JTextArea();
        Code.setBounds(120, 80, 230, 25);
        Code.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        Code.setLineWrap(true);
        Code.setForeground(Color.WHITE);
        Code.setFont(new Font("berlin sans fb", Font.PLAIN, 19));
        Code.setCaretColor(Color.decode("#80ff80"));
        Code.setBackground(Color.BLACK);
        Code.setEditable(true);
        Code.setVisible(true);
        
        RemoveButton = new MButton(50, 340, 100, 30, "Remove");
        RemoveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                data.setResult(false);
                
                SearchResult.setText("");
                
                data.setSearch(Code.getText());
                
                if(Code.getText().isEmpty()){
                    SearchResult.setText("Code is empty.");
                } else {
                    
                    manipCSV = new CreateCSVFile();
                    manipCSV.manipCSV();

                    manipCSV = new ReadCSV();
                    manipCSV.manipCSV();

                    manipData = new SearchInput();
                    manipData.manipData();
                    
                    if(data.getResult()==true){
                        
                        manipData = new RemoveTask();
                        manipData.manipData();

                        manipCSV = new WriteAll();
                        manipCSV.manipCSV();

                        SearchResult.setText("");
                        
                        RemoveFrame.dispatchEvent(new WindowEvent(RemoveFrame, WindowEvent.WINDOW_CLOSING));
                    
                    } else {
                        SearchResult.setText("Task does not exists.");
                    }
                }
            }
        });
        
        CancelButton = new MButton(250, 340, 100, 30, "Cancel");
        CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                SearchResult.setText("");
                Code.setText("");
                
                RemoveFrame.dispatchEvent(new WindowEvent(RemoveFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        RemoveTaskPanel.add(SearchResult);
        //RemoveTaskPanel.add(NotifyLabel);
        RemoveTaskPanel.add(CodeLabel);
        RemoveTaskPanel.add(Code);
        RemoveTaskPanel.add(RemoveButton);
        RemoveTaskPanel.add(CancelButton);
        
        RemoveFrame.add(RemoveTaskPanel);
        
        RemoveFrame.setVisible(true);
    }
}

class EditTaskFrame{
    
    JFrame EditTaskFrame;
    MPanel EditTaskPanel;
    MLabel CodeLabel, DescriptionLabel, DateLabel, TimeLabel, TimeFormatLabel, DateFormatLabel, SearchResult;
    MTextField Code, Date, Time;
    JTextArea Description;
    MButton SaveButton, CancelButton, Search;
    
    Data data = new Data();
    ManipulateCSV manipCSV;
    ManipulateData manipData;
    
    EditTaskFrame(){
        EditTaskFrame = new JFrame("Edit Task");
        EditTaskFrame.dispatchEvent(new WindowEvent(EditTaskFrame, WindowEvent.WINDOW_CLOSING));
        EditTaskFrame.setLayout(null);
        EditTaskFrame.getContentPane().setBackground(Color.BLACK);
        EditTaskFrame.setSize(500, 500);
        EditTaskFrame.setLocationRelativeTo(null);
        EditTaskFrame.setResizable(false);
        
        EditTaskPanel = new MPanel(50, 35, 400, 400, "Edit Task");
        
        SearchResult = new MLabel(120, 67, 150, 20, 15, Color.decode("#ff8080"), "");
        DateFormatLabel = new MLabel(120, 115, 100, 20, 15, Color.decode("#80ff80"), "DD/MM/YY");
        TimeFormatLabel = new MLabel(120, 165, 100, 20, 15, Color.decode("#80ff80"), "HHMM");
        
        CodeLabel = new MLabel(50, 40, 70, 25, 20, Color.WHITE, "Code  :");
        DateLabel = new MLabel(50, 90, 70, 25, 20, Color.WHITE, "Date  :");
        TimeLabel = new MLabel(50, 140, 70, 25, 20, Color.WHITE, "Time  :");
        
        Code = new MTextField(120, 40, 120, 25, 20);
        Date = new MTextField(120, 90, 120, 25, 20);
        Time = new MTextField(120, 140, 120, 25, 20);
        
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
        
        Search = new MButton(260, 40, 100, 25, "Search");
        Search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Description.setText("");
                Date.setText("");
                Time.setText("");
                
                data.setResult(false);
                
                data.setSearch(Code.getText());
                
                manipCSV = new CreateCSVFile();
                manipCSV.manipCSV();

                manipCSV = new ReadCSV();
                manipCSV.manipCSV();
                
                manipData = new SearchInput();
                manipData.manipData();
                
                if(Code.getText().isEmpty()){
                    SearchResult.setText("Inputfield is empty.");
                } else {
                    
                    if(data.getResult()){
                        Description.setText(data.getTask()[1]);
                        Date.setText(data.getTask()[3]);
                        Time.setText(data.getTask()[2]);
                        
                        SearchResult.setText("");
                        
                        data.setTaskData("","","","");
                        
                    } else {
                        SearchResult.setText("No task found.");
                    }
                }
                
            }
        });
        
        SaveButton = new MButton(50, 340, 100, 30, "Done");
        SaveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (data.getResult()){
                    data.setTaskData(Code.getText(),Description.getText(),Time.getText(),Date.getText());
                
                    manipCSV = new CreateCSVFile();
                    manipCSV.manipCSV();

                    manipCSV = new ReadCSV();
                    manipCSV.manipCSV();

                    manipData = new SaveTask();
                    manipData.manipData();

                    manipCSV = new WriteAll();
                    manipCSV.manipCSV();

                    Description.setText("");
                    Code.setText("");
                    Time.setText("");
                    Date.setText("");
                   
                    
                    EditTaskFrame.dispatchEvent(new WindowEvent(EditTaskFrame, WindowEvent.WINDOW_CLOSING));
                } else {
                    EditTaskFrame.dispatchEvent(new WindowEvent(EditTaskFrame, WindowEvent.WINDOW_CLOSING));
                }
            }
        });
        
        CancelButton = new MButton(250, 340, 100, 30, "Cancel");
        CancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Description.setText("");
                Code.setText("");
                Time.setText("");
                Date.setText("");
                
                EditTaskFrame.dispatchEvent(new WindowEvent(EditTaskFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        
        EditTaskPanel.add(SearchResult);
        EditTaskPanel.add(CodeLabel);
        EditTaskPanel.add(TimeLabel);
        EditTaskPanel.add(DateLabel);
        EditTaskPanel.add(TimeFormatLabel);
        EditTaskPanel.add(DateFormatLabel);
        
        EditTaskPanel.add(Code);
        EditTaskPanel.add(Description);
        EditTaskPanel.add(Time);
        EditTaskPanel.add(Date);
        
        EditTaskPanel.add(Search);
        EditTaskPanel.add(SaveButton);
        EditTaskPanel.add(CancelButton);
        
        EditTaskFrame.add(EditTaskPanel);
        
        EditTaskFrame.setVisible(true);
        
    }
}
