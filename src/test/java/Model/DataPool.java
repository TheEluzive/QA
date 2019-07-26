package Model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import org.testng.ITestContext;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

@NoArgsConstructor
public class DataPool<T> {
    {
        dataCollection = new ArrayList<>();
    }

    public DataPool(String testParameterName, ITestContext testContext, Class<T> dataClass) {
        fillNewDataPool(testParameterName, testContext, dataClass);
    }

    private Collection<T> dataCollection;

    private void processDataFile(String filePath, Class<T> dataClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            T data = objectMapper.readValue(new File(filePath), dataClass);
            dataCollection.add(data);
            System.out.println("dataPool created");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getData() {
        Object[][] dataToGet = new Object[1][dataCollection.size()];
        Iterator<T> it = dataCollection.iterator();
        int i = 0;
        while (it.hasNext()) {
            dataToGet[0][i] = it.next();
            System.out.println(dataToGet[0][i].toString());
            i++;
        }
        return dataToGet;
    }

    public void fillNewDataPool(String testParameterName, ITestContext testContext, Class<T> dataClass) {
        HashMap<String, String> parameters = new HashMap<>(testContext.getCurrentXmlTest().getAllParameters());
        this.processDataFile(parameters.get(testParameterName), dataClass);
    }
}
