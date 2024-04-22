package api;

import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/user", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/users/_get_all/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUsersMethods extends AbstractDummyApiMethod {

    private String pageNumber;
    private String pageLimit;

    public GetUsersMethods() {
       super();
    }

    public void setPage(String pageNumber) {
        this.addUrlParameter("page", pageNumber);
    }

    public void setLimit(String limit) {
        this.addUrlParameter("limit", limit);
    }
}
