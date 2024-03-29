package MuliThread.AOP.cglib;

import com.sun.corba.se.spi.ior.ObjectKey;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DemoMethodInterceptor implements MethodInterceptor {

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before in cglib");
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
        } catch (Exception e) {
            System.out.println("ex : " + e.getMessage());
            throw e;
        } finally {
            System.out.println("after in cglib");
            return result;
        }
    }
}
