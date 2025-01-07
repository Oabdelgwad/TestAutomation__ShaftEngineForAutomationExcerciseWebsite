package automationExcercise.api.userManagement;

import automationExcercise.api.APIS;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;

import java.util.Arrays;
import java.util.List;

public class LoginAPI {
    private  SHAFT.API api;

    public LoginAPI(SHAFT.API api) {
        this.api = api;
    }
    public void loginViaAPI(String email , String password)
    {
        List<List<Object>> parameters = Arrays.asList(Arrays.asList("email", email), Arrays.asList("password",password));
        api.post("/api/verifyLogin").setParameters(parameters, RestActions.ParametersType.FORM).setTargetStatusCode(APIS.SUCCESS).perform();
    }


}
