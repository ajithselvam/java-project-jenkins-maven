import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {

    @Test
    void testHelloWorldEndpoint() throws Exception {
        // Make request
        URL url = new URL("http://localhost:8080/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        // Validate status
        assertEquals(200, con.getResponseCode());

        // Read response
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        StringBuilder response = new StringBuilder();
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();

        // Validate response body
        String expected = "Hello World! Java HTTP Server is running on port 8080";
        assertEquals(expected, response.toString());
    }
}