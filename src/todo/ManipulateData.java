
package todo;

import java.util.Iterator;

public interface ManipulateData {
    public void manipData();
}

class CreateLogs extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class AddTask extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class RemoveTask extends Data implements ManipulateData {

    @Override
    public void manipData() {
        for(int i = 0; i < CSVData.size(); i++){
            String[] row = CSVData.get(i);
            for(int j = 0; j < row.length; j++){
                if(CSVData.get(i)[0].replace("\"","").equals(getSearch())){
                    CSVData.remove(i);
                    
                } 
            }
        }
    }
    
}

class EditTask extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class AddtoDoneTask extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class SearchInput extends Data implements ManipulateData {

    
    @Override
    public void manipData() {
        for(int i = 0; i < CSVData.size(); i++){
            String[] row = CSVData.get(i);
            for(int j = 0; j < row.length; j++){
                if(CSVData.get(i)[0].replace("\"","").trim().equals(getSearch())){
                    setResult(true);
                } else {
                    
                }
            }
        }
    }
    
    
}

class ParseInputToInt extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class InputLengthChecker extends Data implements ManipulateData {

    @Override
    public void manipData() {
        
    }
    
}

class TabAdder extends Data implements ManipulateData { // \t escape sequance tab!

    @Override
    public void manipData() {
        
    }
    
}