package todo;

import java.util.List;

public class Data {
    
    private final String DailyCSV = "DailyTaskList.csv";
    private final String STTask = "ShortTermTaskList.csv";
    private final String LTTask = "LongTermTaskList.csv";
    
    private static String filePath;
    
    protected static List<String[]> CSVData;
    private static String[] task = {"","",""};
    private static int tab; //if 1 this is daily tab, if 2 this is short term tab, if 3 this is long term tab
    
    Data(){
        
    }
    
    
    
    
    
    
    
    //setters
    
    public void setPath(String path){
        filePath = path;
    }
    
    public void  setTaskData(String Id, String todo, String deadline){
        task[0] = Id;
        task[1] = todo;
        task[2] = deadline;
    }
    
    public void setTab(int tabType){
        tab = tabType;
    }
    
    
    //getters
    public String getFilePath(){
        return filePath;
    }
    
    public String getDailyCSV(){
        return DailyCSV;
    }
    
    public String getSTTask(){
        return STTask;
    }
    
    public String getLTTask(){
        return LTTask;
    }
    
    public String[] getTask(){
        return task;
    }
    
    public int getTab(){
        return tab;
    }
}
