package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool<T> {


        Collection<T> dataFiles;

        public void processDataFile( String filePath, Class<T> template){

            dataFiles = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            objectMapper.setDateFormat( dateFormat );
            try {
                T dataFromFile = objectMapper.readValue( new File( filePath ), template );
                dataFiles.add( dataFromFile );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Object[][] getData() {

            Object[][] data = new Object[ dataFiles.size() ][ 1 ];

            Iterator<T> it = dataFiles.iterator();

            int i = 0;
            while( it.hasNext() ) {
                data[ i ][ 0 ] = it.next();
                i++;
            }

            return data;
        }

}
