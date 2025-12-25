package org.tugra.urlaccesstest;

import org.junit.jupiter.api.Test;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class UrlAccessTestApplicationTests {

    private static final String TEST_URL = "https://example.com";
    private static final int TIMEOUT = 5000;

    @Test
    public void testURLAccessibility() {
        System.out.println("URL erişim testi başlatılıyor: " + TEST_URL);

        try {
            URL url = new URL(TEST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(TIMEOUT);
            connection.setReadTimeout(TIMEOUT);
            connection.connect();

            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Yanıt Kodu: " + responseCode);

            assertTrue(responseCode == 200,
                    "URL erişilebilir değil! HTTP Kodu: " + responseCode);
            

            System.out.println("✓ URL başarıyla erişilebilir durumda!");
            connection.disconnect();

        } catch (Exception e) {
            System.err.println("✗ URL'ye erişim hatası: " + e.getMessage());
            fail("URL'ye erişilemedi: " + e.getMessage());
        }
    }
}
