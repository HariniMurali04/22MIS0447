public class Main {

    public static void main(String[] args) {

        Logger.Log(
                "backend",
                "info",
                "handler",
                "Application Started"
        );

        Logger.Log(
                "backend",
                "error",
                "db",
                "Database connection failed"
        );
    }
}