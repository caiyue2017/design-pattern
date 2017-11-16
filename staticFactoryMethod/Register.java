package staticFactoryMethod;

/**
 * 注册接口
 */
public interface Register {
    /**
     * 注册
     * @param username
     * @param password
     * @return
     */
    boolean register(String username,String password);
}
