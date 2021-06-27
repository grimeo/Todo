
package todo;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface ManipulateCSV {
    public void manipCSV();
}

class CreateCSVFile extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        File file = new File(getFilePath());
        
        if(file.exists() && file.isFile()){
            //do nothing
        } else {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(File.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

class ReadCSV extends Data implements ManipulateCSV{

    
    @Override
    public void manipCSV() {
        try {
            CSVReader reader = new CSVReader(new FileReader(getFilePath()));
            CSVData = reader.readAll();
            reader.close();
            
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
        try {
            @SuppressWarnings("deprecation")
            CSVWriter writer = new CSVWriter(new FileWriter(getFilePath(), true), ',');
            writer.writeNext(getTask());
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(WriteNextLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class WriteAll extends Data implements ManipulateCSV {

    @Override
    public void manipCSV() {
        try {
            CSVWriter writer =new CSVWriter(new FileWriter(getFilePath()));
            writer.writeAll(CSVData);
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(WriteAll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class DeleteRow extends Data implements ManipulateCSV{

    @Override
    public void manipCSV() {
        
    }
    
}