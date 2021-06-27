package todo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ModifierGui {
    
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
