package todo;

import java.util.List;

public class Data {
    
    private static String CSVFilePath = "taskslist.csv";
    protected static List<String[]> CSVData;
    private static String[] task = {"","","","","","","","",""};
    
    Data(){
        
    }
    
    
    public String getCSVFile(){
        return CSVFilePath;
    }
    
}
