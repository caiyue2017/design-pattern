package staticFactoryMethod;

public class RegisterFactory {
    public static Register factory(String type) {
        if (type.equals("phone"))
            return new PhoneRegister();
        else if (type.equals("email"))
            return new EmailRegister();
        else
            throw new RuntimeException("找不到该注册方式！");
    }
}
