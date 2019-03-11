package com.perfect.jinbao.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StartEndLogAspect {
    private Log log = LogFactory.getLog(StartEndLogAspect.class);

    @Pointcut("@annotation(com.perfect.jinbao.aop.StartEndLog)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info(pjp.getSignature().getName() + " start");
        Object object = pjp.proceed();
        log.info(pjp.getSignature().getName() + " end");
        return object;
    }
}
