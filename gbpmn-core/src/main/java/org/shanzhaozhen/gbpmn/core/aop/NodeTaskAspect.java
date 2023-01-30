package org.shanzhaozhen.gbpmn.core.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-30
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class NodeTaskAspect {

    /**
     * 切入点
     */
    @Pointcut("@annotation(NodeTask)")
    public void nodeTaskPointCut() {

    }

    /**
     * 前置通知
     *
     * @param joinPoint
     */
    @Before("nodeTaskPointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("我是一个前置通知");
    }


    @After("nodeTaskPointCut()")
    public void after() {
        log.info("After................通知");
    }

    @AfterReturning("nodeTaskPointCut()")
    public void afterReturning() {
        log.info("AfterReturning................通知");
    }

    //关于异常的通知
    @AfterThrowing("nodeTaskPointCut()")
    public void afterThrowing() {
        log.info("AfterThrowing................通知");
    }

    /**
     * 可控制目标函数是否执行
     */
    @Around("nodeTaskPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Around................通知");
        log.info("进入Around通知....");
        log.info("结束Around通知....");
        return null;
    }

}
