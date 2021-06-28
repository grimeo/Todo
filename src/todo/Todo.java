package todo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Todo {
    
    JFrame frame;
    Gui Panel;
    
    Todo(){
        Panel = new Gui();
        
        frame = new JFrame("Task Master"); 
        frame.setIconImage(new ImageIcon(getClass().getResource("taskIcon.PNG")).getImage());

        frame.setLayout(null);
        frame.setSize(800,560);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        frame.add(Panel.panel);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Todo();
    }
    
}
