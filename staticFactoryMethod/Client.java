package staticFactoryMethod;

public class Client {
    public static void main(String[] args) {
        String registerType = "email";
        String username = "123456789@qq.com";
        String password = "123456";

        Register register = RegisterFactory.factory(registerType);

        register.register(username,password);
    }
}
