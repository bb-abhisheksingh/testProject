import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by abhi on 6/3/19.
 */
public class PropertiesReader {
    public static InputStream getProperties (String resourceName){
        InputStream systemConfigInputStream = PropertiesReader.class.getResourceAsStream("test1.txt");
        if(systemConfigInputStream != null ){
            String result = getStringFromInputStream(systemConfigInputStream);
            System.out.println("result is " + result);
        }
        return systemConfigInputStream;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
