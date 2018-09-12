package test.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLIBProxy implements MethodInterceptor{
    /**
     * 获得代理对象
     * @param cls
     * @return
     */
    public Object getProxy(Class cls) {
        Enhancer ec = new Enhancer();
        ec.setSuperclass(cls);
        ec.setCallback(this);
        return ec.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("intercept：调用前");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("d调用完成");
        return result;
    }
}
