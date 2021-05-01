/*
 * package jmp.spring.aop;
 * 
 * import org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.Around; import
 * org.aspectj.lang.annotation.Aspect; import
 * org.springframework.stereotype.Component;
 * 
 * import lombok.extern.log4j.Log4j;
 * 
 * @Aspect
 * 
 * @Component
 * 
 * @Log4j public class LogAdvice{
 * 
 * @Around("execution(* jmp.spring.service.*.*(..))") public Object
 * logTime(ProceedingJoinPoint pjp){ Object res = null; long start =
 * System.currentTimeMillis(); try { res = pjp.proceed(); } catch (Throwable e)
 * { e.printStackTrace(); } long end = System.currentTimeMillis(); double time =
 * ( end - start )/1000.0;
 * log.info("실행 시간 ========================================" + time + "초");
 * 
 * return res; } }
 */