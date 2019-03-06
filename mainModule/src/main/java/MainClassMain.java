

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by abhi on 6/3/19.
 */
public class MainClassMain {
    public static void main(String[] args) {
        java.lang.ClassLoader classLoader = MainClassMain.class.getClassLoader();
        InputStream resource = classLoader.getResourceAsStream("test1.txt");
            System.out.println("result is " + getStringFromInputStream(resource));
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
