package todo;

import java.util.List;

public class Data {
    
    private final String DailyCSV = "DailyTaskList.csv";
    private final String STTask = "ShortTermTaskList.csv";
    private final String LTTask = "LongTermTaskList.csv";
    private final String LogPath = "Logs.csv";
    
    private static String filePath;
    
    protected static List<String[]> CSVData;
    private static String[] task = {"","","",""};
    private static int tab; //if 1 == daily tab, if 2 == short term tab, if 3 == long term tab
    
    private static String search;
    private static boolean result; // true if the result of search exists
    
    private static boolean doRefreshTable;
    Data(){
        
    }
    
    
    
    //setters
    
    public void setFilePath(String path){
        filePath = path;
    }
    
    public void  setTaskData(String Id, String todo, String time, String date){
        task[0] = Id;
        task[1] = todo;
        task[2] = time;
        task[3] = date;
    }
    
    public void setTab(int tabType){
        tab = tabType;
    }
    
    public void setSearch(String s){
        search = s;
    }
    
    public void setResult(boolean b){
        result = b;
    }
    
    public void setRefreshTableBool(boolean b){
        doRefreshTable = b;
    }
    
    //getters
    
    public boolean getRefreshTableBool(){
        return doRefreshTable;
    }
    
    
    public List<String[]> getList(){
        return CSVData;
    }
    
    public String getFilePath(){
        
        if(getTab()==1){
            setFilePath(DailyCSV);
        }else if(getTab()==2){
            setFilePath(STTask);
        } else if(getTab()==3){
            setFilePath(LTTask);
        }
        
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
    
    public String getSearch(){
        return search;
    }
    
    public boolean getResult(){
        return result;
    }
}
