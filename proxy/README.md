# 代理模式

所谓代理，就是一个人或者机构代表另一个人或者机构采取行动。代理模式提供了对目标对象另外的访问方式：即通过代理对象访问目标对象。这样做的好处是，可以在不修改源码的基础上，扩展目标对象的功能，以及实现核心业务与辅助业务的分离。

## 静态代理

![代理结构](http://img.blog.csdn.net/20171109121300193?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvTW9vbl9DYWk=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

- `AbstractObject`：抽象对象角色，目标对象和代理对象的共同接口
- `RealObject`：目标对象
- `ProxyObject`：静态代理对象

**缺点**

因为代理对象和目标对象实现一样的接口，所以导致有多少个目标对象就要多少个代理对象。同时，一旦接口增加方法，目标对象和代理对象都要做维护。

**代码示例**

```
/**
 * 抽象角色对象
 */
public interface AbstractObject {
    void operation();
}
/**
 * 目标对象
 */
public class RealObject implements AbstractObject{

    public void operation() {
        System.out.println("realObject method!");
    }
}
```

```
/**
 * 静态代理
 */
public class StaticProxy implements AbstractObject{

    private RealObject realObject = new RealObject();

    public void operation() {
        System.out.println("Before...");
        realObject.operation();
        System.out.println("After...");
    }
}
```

```
/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("------static proxy------");
        AbstractObject object = new StaticProxy();
        object.operation();
    }
}
```

## 动态代理

**特点**

1. 又叫`JDK`代理，接口代理
2. 代理对象不需要实现接口，但目标对象一定要实现接口（目标对象继承抽象类，采用静态代理），否则无法不能用动态代理
3. 代理对象的生成是利用`JDK`的`API`，动态的在内存中构建代理对象

**结构**

- `InvocationHandler`：动态代理类要实现的接口
- `Proxy`：用于创建动态代理类实例

**代码示例**

```
/**
 * 动态代理
 */
public class DynamicProxy implements InvocationHandler{

    // 目标对象
    private Object target;

    public Object getProxy(Object obj){
        this.target = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before...");
        Object result = method.invoke(target,args);
        System.out.println("After...");
        return result;
    }
}
```

```
/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("------dynamic proxy------");
        AbstractObject object = (AbstractObject) new DynamicProxy().getProxy(new RealObject());
        object.operation();
    }
}
```

## Cglib代理

**定义**

Cglib代理，也叫作子类代理，它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。主要用于解决动态代理的局限，就是使用动态代理的对象必须实现一个或多个接口。

> 在`Spring`的`AOP`编程中，
>
> 如果加入容器的目标对象有实现接口,用`JDK`代理。
>
> 如果目标对象没有实现接口,用`Cglib`代理。

**代码示例**

```
/**
 * 目标对象，没有实现任何接口
 */
public class CglibRealObject {

    public void operation(){
        System.out.println("CglibRealObject not implements interface!");
    }
}
```

```
/**
 * Cglib代理
 */
public class CglibProxy implements MethodInterceptor{

    // 目标对象
    private Object target;

    // 目标对象注入
    public CglibProxy(Object target){
        this.target = target;
    }

    /**
     * 创建代理对象
     * @return
     */
    public Object getProxyInstance(){
        // 1. 工具类
        Enhancer en = new Enhancer();
        // 2. 设置父类
        en.setSuperclass(target.getClass());
        // 3. 设置回调函数
        en.setCallback(this);
        // 4. 创建子类（代理对象）
        return en.create();
    }

    /**
     * 代理对象执行的拦截器方法
     * @param obj
     * @param method
     * @param args
     * @param proxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before...");
        Object result = method.invoke(target,args);
        System.out.println("After...");
        return result;
    }
}
```

## 总结

使用代理模式的好处有两种，一是可以在不修改源码的基础上，增强目标对象的功能，二是可以实现核心业务和辅助业务的分离。

静态代理和动态代理都要求目标对象实现了接口，但静态代理的局限在于它的代理类是具体依赖于目标类实现的接口，导致了有多少个目标类就要写多少个代理类。动态代理则通过`Java`的反射解决了这个问题。

动态代理的局限就是要求目标对象必须实现接口，不能是抽象类，或者不实现。若目标对象是继承抽象类，则采用静态代理。若目标对象没有实现任何接口，则采用Cglib代理，通过在内存中创建一个子类对象实现对目标对象功能的扩展。

