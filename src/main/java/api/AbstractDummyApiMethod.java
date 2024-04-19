package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;
import org.apache.http.HttpHeaders;

public abstract class AbstractDummyApiMethod extends AbstractApiMethodV2 {

    public AbstractDummyApiMethod() {
        super();
        setHeader("app-id", "6620cffacfa53cd7255caba0");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("dummyapi.api_url"));
    }
}



