package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/user/create", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/users/_post/rq.json")
@ResponseTemplatePath(path = "api/users/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostUserMethod extends AbstractApiMethodV2 {

    public PostUserMethod() {
        super("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
        setHeader("app-id", "6620cffacfa53cd7255caba0");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("dummyapi.api_url"));
    }
}
