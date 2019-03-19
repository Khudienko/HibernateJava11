import models.Auto;
import models.User;
import services.UserService;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  throws SQLException{
        UserService userService = new UserService();
        User user = new User("Anton",35);
        Auto audi = new Auto("Audi","black");
        audi.setUser(user);
        user.addAuto(audi);

        Auto bmw = new Auto("BMW","white");
        bmw.setUser(user);
        user.addAuto(bmw);



        userService.saveUser(user);
        userService.updateUser(user);

    }
}
