package automationExcercise.api.userManagement;

import automationExcercise.api.APIS;
import com.shaft.api.RestActions;
import com.shaft.driver.SHAFT;

import java.util.Arrays;
import java.util.List;

public class DeleteAccountAPI {
    private  SHAFT.API api;

    public DeleteAccountAPI(SHAFT.API api) {
        this.api = api;
    }
    public void DeleteAccountViaAPI(String email , String password) {
        List<List<Object>> parameters = Arrays.asList(Arrays.asList("email", email), Arrays.asList("password",password));
        api.delete("/api/deleteAccount").setParameters(parameters, RestActions.ParametersType.FORM).setTargetStatusCode(APIS.SUCCESS).perform();

    }
}
