package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import static api.HttpParameter.API_ID;

public abstract class AbstractDummyApiMethod extends AbstractApiMethodV2 {

    public AbstractDummyApiMethod() {
        setHeader(API_ID.getName(), getAppId());
        replaceUrlPlaceholder("base_url", Configuration.getRequired("dummyapi.api_url"));
    }
    public AbstractDummyApiMethod(String rqPath, String rsPath, String propertiesPath) {
        super(rqPath, rsPath, propertiesPath);
        setHeader(API_ID.getName(), getAppId());
        replaceUrlPlaceholder("base_url", Configuration.getRequired("dummyapi.api_url"));
    }

    private String getAppId() {
        return R.CONFIG.getDecrypted("app_id");
    }
}