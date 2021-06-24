
package todo;

import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface ManipulateCSV {
    public void manipCSV();
}

class CreateCSVFile extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        File file = new File(getCSVFile());
        
        if(file.exists()==true && file.isFile()==true){
            //do nothing
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}


class ReadCSV extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        try {
            CSVReader reader = new CSVReader(new FileReader(getCSVFile()));
            CSVData = reader.readAll();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class WriteNextLine extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        
    }
    
}

class DeleteCell extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        
    }
    
}