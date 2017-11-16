package staticFactoryMethod;

public class PhoneRegister implements Register{

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}
