import api.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

import static api.UsersAPIUtil.postUserAndGetId;

public class APISampleTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUsers() {
        GetUsersMethods getUsersMethods = new GetUsersMethods();
        getUsersMethods.setPage("1");
        getUsersMethods.setLimit("10");
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse();
        getUsersMethods.validateResponseAgainstSchema("api/users/_get_all/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUser() {
        GetUsersMethods getUsersMethods = new GetUsersMethods();
        Response response = getUsersMethods.callAPI();
        List<String> ids = response.jsonPath().getList("data.id");
        String id = ids.get(new Random().nextInt(ids.size()));
        GetUserByIdMethod getUserMethod = new GetUserByIdMethod(id);
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse();
        getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.schema");
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
        String id = postUserAndGetId();
        PutUserMethod putUserMethod = new PutUserMethod(id);
        putUserMethod.setProperties("api/users/user.properties");
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    @TestPriority(Priority.P1)
    public void testDeleteUsers() throws IOException {
        String deletePath = "src/test/resources/api/users/_delete/rs.json";
        String id = postUserAndGetId();
        DeleteUserByIdMethod deleteUserMethod = new DeleteUserByIdMethod(id);
        String.format(Files.readString(Path.of(deletePath)), id);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }
}
