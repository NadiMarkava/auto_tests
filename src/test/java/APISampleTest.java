import api.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUsers() {
        GetUsersMethods getUsersMethods = new GetUsersMethods();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse();
        getUsersMethods.validateResponseAgainstSchema("api/users/_get_all/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUser() {
        GetUserMethods getUserMethods = new GetUserMethods("60d0fe4f5311236168a109ca");
        getUserMethods.callAPIExpectSuccess();
        getUserMethods.validateResponse();
        getUserMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testCreateUser() throws Exception {
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.setProperties("api/users/user.properties");
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    @TestPriority(Priority.P1)
    public void testUpdateUser() {
        PutUserMethod putUserMethod = new PutUserMethod("60d0fe4f5311236168a109ca");
        putUserMethod.setProperties("api/users/user.properties");
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod("6622173d5d8af9b278276061");
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }
}
