package MuliThread.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JDKProxySubject(RealSubject reslSubject) {
        this.realSubject = reslSubject;
    }

    @Override
    /*基于方法的反射*/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result = null;
        try {
          result  =method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("ex:" + e.getMessage());
            throw e;
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
