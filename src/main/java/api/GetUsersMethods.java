package api;

import api.AbstractDummyApiMethod;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user?page=1&limit=10", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get_all/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUsersMethods extends AbstractDummyApiMethod {

    public GetUsersMethods() {
       super();
    }
}
