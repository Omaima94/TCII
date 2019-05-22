import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;


public class UserServiceImplTest {

    public static final String USER_PASSWORD = "PW";
    static final UserDAO userDAO = Mockito.mock(UserDAO.class);
    static final SecurityService securityService = Mockito.mock(SecurityService.class);
    UserServiceImpl userService = new UserServiceImpl(userDAO, securityService);

    User user = new User();

    @Test
    public void shouldAssignPasswordAndCallUpdateUser() throws Exception {
        user.setPassword(USER_PASSWORD);
        userService.assignPassword(user);
        Assert.assertNotEquals(user.getPassword(), USER_PASSWORD);
        verify(userDAO).updateUser(user);
    }

}