package test.test;

import java.lang.reflect.Proxy;

import org.junit.Test;

import test.proxy.CGLIBProxy;
import test.proxy.HelloWorld;
import test.proxy.HelloWorldImpl;
import test.proxy.HelloWorldImpl2;
import test.proxy.JDKProxy;


public class testJDKProxy {
    
    @Test
    public void testProxy(){
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        JDKProxy jdk = new JDKProxy();
        HelloWorld proxy = (HelloWorld) jdk.bind(new HelloWorldImpl());
        System.out.println("$Proxy0.test.proxy.HelloWorldImpl: "+Proxy.getProxyClass(HelloWorld.class.getClassLoader(), HelloWorld.class)); 
        proxy.sayHelloWorld();
    }
    @Test
    public void testCGLIB(){
        CGLIBProxy cp = new CGLIBProxy();
        HelloWorldImpl2 obj = (HelloWorldImpl2)cp.getProxy(HelloWorldImpl2.class);
        obj.sayHelloWorld2("aaaaa");
    }
}
