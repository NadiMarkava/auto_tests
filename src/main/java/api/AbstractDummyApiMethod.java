package api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.config.Configuration;
import static api.HttpParameter.API_ID;

public abstract class AbstractDummyApiMethod extends AbstractApiMethodV2 {

    public AbstractDummyApiMethod() {
        setParams();
    }
    public AbstractDummyApiMethod(String rqPath, String rsPath, String propertiesPath) {
        super(rqPath, rsPath, propertiesPath);
        setParams();
    }

    private void setParams(){
        setHeader(API_ID.getName(), R.CONFIG.getDecrypted("app_id"));
        replaceUrlPlaceholder("base_url", Configuration.getRequired("dummyapi.api_url"));
    }
}