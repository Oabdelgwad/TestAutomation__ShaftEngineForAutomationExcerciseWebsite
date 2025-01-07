package automationExcercise.api;

import com.shaft.driver.SHAFT;

public class APIS {
    private static SHAFT.API api;
    public APIS(SHAFT.API api) {
        APIS.api = api;
    }
    /// Base URL \\\
    public static String baseUrl=System.getProperty("baseURL");
    /// Status codes \\\
    public static int SUCCESS = 200;
    public static int SUCCESS_DELETE = 201;
}
