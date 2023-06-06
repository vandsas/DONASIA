package homepagedonasia;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import Login.*;

public class SimpanData {
 
    public void simpanDataStok(ObservableList data, String namaFile){
        XStream xstream = new XStream(new StaxDriver());
        String dataKu = xstream.toXML(data);
        FileOutputStream xmlKu = null;
        
        try{
            xmlKu = new FileOutputStream(namaFile + ".xml");
            byte[] byteKu = dataKu.getBytes("UTF-8");
            xmlKu.write(byteKu);
            xmlKu.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
    public ObservableList ambilDataStok(String namaFile){
        XStream xstream = new XStream(new StaxDriver());
        FileInputStream xmlKu = null;
        ObservableList hasil = observableArrayList();
        
        try{
            xmlKu = new FileInputStream(namaFile + ".xml");
            int kodeKu;
            String pesanKu = "";
            
            while((kodeKu = xmlKu.read()) != -1){
                pesanKu += (char) kodeKu;
            }
            
            hasil = (ObservableList) xstream.fromXML(pesanKu);
            xmlKu.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        return hasil;
    }
    

}
