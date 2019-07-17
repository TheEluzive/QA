package Model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DataPool {


        Collection<NewUser> accounts;

        public void processDataFile( String filePath ){

            accounts = new ArrayList<NewUser>();

            ObjectMapper objectMapper = new ObjectMapper();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            objectMapper.setDateFormat( dateFormat );
            try {
                NewUser newUser = objectMapper.readValue( new File( filePath ), NewUser.class );
                accounts.add( newUser );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public Object[][] getData() {

            Object[][] data = new Object[ accounts.size() ][ 1 ];

            Iterator<NewUser> it = accounts.iterator();

            int i = 0;
            while( it.hasNext() ) {
                data[ i ][ 0 ] = it.next();
                i++;
            }

            return data;
        }

}
