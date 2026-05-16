import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Logger {

    // PUT YOUR ACCESS TOKEN HERE
    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiYXVkIjoiaHR0cDovLzIwLjI0NC41Ni4xNDQvZXZhbHVhdGlvbi1zZXJ2aWNlIiwiZW1haWwiOiJoYXJpbmkucG0yMDIyQHZpdHN0dWRlbnQuYWMuaW4iLCJleHAiOjE3Nzg5MjkwNzYsImlhdCI6MTc3ODkyODE3NiwiaXNzIjoiQWZmb3JkIE1lZGljYWwgVGVjaG5vbG9naWVzIFByaXZhdGUgTGltaXRlZCIsImp0aSI6IjE5NmJmNWIxLTE3MmEtNDc0MS04ZTBjLTZjZTMxM2E4YmJmYSIsImxvY2FsZSI6ImVuLUlOIiwibmFtZSI6ImhhcmluaSBwbSIsInN1YiI6ImNjMTI5YjhiLTMwYmYtNDI3Zi1iMWI0LWYxZDgyZDE2Y2JkNCJ9LCJlbWFpbCI6ImhhcmluaS5wbTIwMjJAdml0c3R1ZGVudC5hYy5pbiIsIm5hbWUiOiJoYXJpbmkgcG0iLCJyb2xsTm8iOiIyMm1pczA0NDciLCJhY2Nlc3NDb2RlIjoiU2ZGdVdnIiwiY2xpZW50SUQiOiJjYzEyOWI4Yi0zMGJmLTQyN2YtYjFiNC1mMWQ4MmQxNmNiZDQiLCJjbGllbnRTZWNyZXQiOiJSaHJNV3NLakpoR2FVTVRIIn0.5N67uXl_MGreKIygF_YQcGCTiPKRjMvs9QH_EKiYSoY";

    public static void Log(String stack,
                           String level,
                           String packageName,
                           String message) {

        try {

            URL url = new URL(
                "http://4.224.186.213/evaluation-service/logs"
            );

            HttpURLConnection conn =
                (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");

            conn.setRequestProperty(
                "Authorization",
                "Bearer " + TOKEN
            );

            conn.setRequestProperty(
                "Content-Type",
                "application/json"
            );

            conn.setDoOutput(true);

            String jsonInput = "{"
                    + "\"stack\":\"" + stack + "\","
                    + "\"level\":\"" + level + "\","
                    + "\"package\":\"" + packageName + "\","
                    + "\"message\":\"" + message + "\""
                    + "}";

            OutputStream os = conn.getOutputStream();

            os.write(jsonInput.getBytes());

            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();

            System.out.println(
                "Log Sent Successfully. Response Code: "
                        + responseCode
            );

            conn.disconnect();

        } catch (Exception e) {

            System.out.println(
                "Logging Failed: " + e.getMessage()
            );
        }
    }
}