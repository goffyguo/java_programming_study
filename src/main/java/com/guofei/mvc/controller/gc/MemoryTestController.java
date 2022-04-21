package com.guofei.mvc.controller.gc;

import com.guofei.mvc.domain.TUser;
import com.guofei.mvc.service.TUserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/12/01/13:46
 * @Description: 内存测试
 */
@RestController
public class MemoryTestController {

    @Resource
    private TUserService tUserService;


    /**
     * 案例1 模拟线上环境 OOM
     * -XX:+PrintGCDetails 打印GC
     * -XX:MetaspaceSize=64m 设置元空间大小
     * -XX:+HeapDumpOnOutOfMemoryError 生成 dump 文件
     * -XX:HeapDumpPath=heap/heapdump.hprof 生成 dump 文件路径
     * -XX:+PrintGCDateStamps
     * -Xms200M 堆空间大小
     * -Xmx200M 堆空间大小
     * -Xloggc:log/gc.oomHeap.log gc日志
     * -XX:+PrintGCDetails -XX:MetaspaceSize=64m
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heap/heapdump.hprof
     * -XX:+PrintGCDateStamps -Xms200M -Xmx200M -Xloggc:log/gc.oomHeap.log
     */
    @RequestMapping("/add")
    public void addObjects(){
        System.err.println("add" + tUserService);
        ArrayList<TUser> objects = new ArrayList<>();
        while (true){
            objects.add(new TUser());
        }
    }

    /**
     * 案例2 元空间OOM
     * -XX:+PrintGCDetails -XX:MetaspaceSize=60m -XX:MaxMetaspaceSize=60m
     * -XSS512K -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=heap/heapdumpMeta.hprof -XX:SurvivorRatio=8
     * -XX:+TraceClassLoading -XX:+TraceClassUnloading -XX:+PrintGCDateStamps
     * -Xms60M -Xmx60M -Xloggc:log/gc-oomMeta.log
     * -XX:MetaspaceSize=60m -XX:MaxMetaspaceSize=60m 设置元空间大小
     * -Xss512K 设置栈空间大小
     * -XX:SurvivorRatio=8 设置新生代（Eden比例）比例
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=heap/heapdumpMeta.hprof 设置dump文件
     * -XX:+TraceClassLoading 加载的类的信息打印
     * -XX:+TraceClassUnloading 卸载的类的信息打印
     * -XX:+PrintGCDateStamps GC信息
     * -Xms60M -Xmx60M 设置堆空间大小
     * -Xloggc:log/gc-oomMeta.log log日志文件
     */
    @RequestMapping("/metaSpaceOom")
    public void metaSpaceOom(){
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TUser.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
                System.out.println("我是加强类，输出print之前的加强方法");
                return methodProxy.invokeSuper(o,objects);
            });
            TUser user = (TUser)enhancer.create();
            //people.print();
            System.out.println(user.getClass());
            System.out.println("totalClass:" + classLoadingMXBean.getTotalLoadedClassCount());
            System.out.println("activeClass:" + classLoadingMXBean.getLoadedClassCount());
            System.out.println("unloadedClass:" + classLoadingMXBean.getUnloadedClassCount());
        }
    }
}
