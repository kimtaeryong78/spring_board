/*
 * package jmp.spring.aop;
 * 
 * import org.aspectj.lang.ProceedingJoinPoint; import
 * org.aspectj.lang.annotation.Around; import
 * org.aspectj.lang.annotation.Aspect; //import
 * org.aspectj.lang.annotation.Before; import
 * org.springframework.stereotype.Component;
 * 
 * import lombok.extern.log4j.Log4j;
 * 
 * @Aspect
 * 
 * @Component
 * 
 * @Log4j public class Aop_ex1 { // 띄어쓰기 조심
 * 
 * @Before("execution(* jmp.spring.service.BoardService.*(..))") public void
 * example1() { log.info("AOP===============================================");
 * }
 * 
 * 
 * @Around("execution(* jmp.spring.service.*.*(..))") public Object
 * logTime(ProceedingJoinPoint pjp) { log.info("============================"+
 * pjp.getTarget()); //start time long start = System.currentTimeMillis();
 * 
 * Object res = null; try { res = pjp.proceed();
 * 
 * } catch (Throwable e) { log.error("error"); e.printStackTrace(); } //end time
 * long end = System.currentTimeMillis();
 * 
 * double temp = (end - start)/1000.0; //proceeding time
 * log.info("============================ 실행 시간 : "+temp+"초");
 * 
 * return res; } }
 */