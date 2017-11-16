package staticFactoryMethod;

public class EmailRegister implements Register{

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}
