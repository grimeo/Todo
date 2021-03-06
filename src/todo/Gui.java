package todo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Gui{
    
    private static  JPanel welcomePanel;
    static MPanel panel;
    private static MButton longTermButton, shortTermButton, dailyButton,
            AddTask, RemoveTask, EditTask;
    private static JLabel titleLabel, welcomeLabel, headerCode, headerDescription, headerTime, headerDate;
    private static MLabel sentence1,sentence2,sentence3;
    private static JTextArea textArea;
    private static JTable table;
    private static JScrollPane scroll;
    
    private static Data data = new Data();
    private static ManipulateCSV manipCSV;
    private static ManipulateData manipData;
    
    private static boolean isTableShown = false;
    
    Gui(){
        
        panel = new MPanel();
        
        titleLabel = new JLabel("Task to do");
        titleLabel.setBounds(300, 0, 200, 65);
        titleLabel.setFont(new Font("berlin sans fb", Font.PLAIN, 40));
        titleLabel.setForeground(Color.WHITE);
        
        headerCode = new JLabel("Code");
        headerCode.setBounds(40, 180, 750, 22);
        headerCode.setFont(new Font("Calibri", Font.BOLD, 22));
        headerCode.setForeground(Color.WHITE);
        
        headerDescription = new JLabel("Description");
        headerDescription.setBounds(250, 180, 750, 22);
        headerDescription.setFont(new Font("Calibri", Font.BOLD, 22));
        headerDescription.setForeground(Color.WHITE);
        
        headerTime = new JLabel("Time");
        headerTime.setBounds(570, 180, 750, 22);
        headerTime.setFont(new Font("Calibri", Font.BOLD, 22));
        headerTime.setForeground(Color.WHITE);
        
        headerDate = new JLabel("Date");
        headerDate.setBounds(680, 180, 750, 22);
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
        
        String[] colHeadings = {"1","2","3","4"};
        int numRows = 20 ;
        DefaultTableModel model = new DefaultTableModel(numRows, colHeadings.length) ;
        JTable table = new JTable(model);
        
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
        
        dailyButton = new MButton(35, 70, "Daily");
        dailyButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ActionListener) {
                
                if(isTableShown){
                    panel.remove(scroll);
                    scroll.remove(table);
                    
                    data.setTab(1);
                    showTable();
                } else {
                    data.setTab(1);
                    showTable();
                }
                
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
                
                if(isTableShown){
                    panel.remove(scroll);
                    scroll.remove(table);
                    
                    data.setTab(2);
                    showTable();
                    
                } else {
                    data.setTab(2);
                    showTable();
                }
                
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
                
                if(isTableShown){
                    panel.remove(scroll);
                    scroll.remove(table);
                    
                    data.setTab(3);
                    showTable();
                    
                } else {
                    data.setTab(3);
                    showTable();
                }
                
                dailyButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                shortTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
                longTermButton.setBorder(BorderFactory.createMatteBorder(0, 0, 4, 0, Color.decode("#80ff80")));
                
                dailyButton.setForeground(Color.WHITE);
                shortTermButton.setForeground(Color.WHITE);
                longTermButton.setForeground(Color.decode("#80ff80"));
                
            }
        });
        
        AddTask = new MButton(135, 487, 130, 30, "Add Task") ;
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
        
        RemoveTask = new MButton(535, 487, 130, 30, "Remove Task");
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
        
        EditTask = new MButton(335, 487, 130, 30, "Edit Task");
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
        
    }
    
    public static void refresh(){
            panel.remove(scroll);
            scroll.remove(table);
            showTable();
        }
    
    public static void showTable(){
            
            updateTable();
            
            if(!isTableShown){
                panel.remove(welcomePanel);
                
                panel.add(headerCode);
                panel.add(headerDescription);
                panel.add(headerTime);
                panel.add(headerDate);
                
                panel.add(AddTask);
                panel.add(RemoveTask);
                panel.add(EditTask);
            } 
            panel.add(scroll);
            
            panel.repaint();
            scroll.repaint();
            table.repaint();
            
            
            isTableShown = true;
        }
        
        public static void updateTable(){
            
            manipCSV = new CreateCSVFile();
            manipCSV.manipCSV();
                
            manipCSV = new ReadCSV();
            manipCSV.manipCSV();
            
            String[] columnName = {"this","will","not","show"};
            
            TableModel tm = new DefaultTableModel(data.getList().toArray(new Object[][] {}),columnName);
            
            table = new JTable(tm);
            
            table.setModel(tm);
            
            createTableGui();
            
            scroll = new JScrollPane (table);
            scroll.setBounds(28, 200, 740, 280);
            scroll.getViewport().setBackground(Color.BLACK);
            scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
            panel.add(scroll);
            
        }
        
        public static void createTableGui(){
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
        }
        
        
}
