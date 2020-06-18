package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

// Advice
@Aspect 
@Log4j 
@Component 
public class LogAdvice { 
   @Before( "execution(* org.zerock.service.SampleService*.*(..))") // pointCut : 여기서 결합이 일어남
   public void logBefore() { // advice 1이라 할 수 있음
      log.info("========================"); 
   } 
   
   //doAdd가 호출될 때는 밑의 advice를 꼭 하라는 말. 근데, 파라미터 있으면 인자로 넣어서 로깅해보려고 하는 것
   @Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)") 
   public void logBeforeWithParam(String str1, String str2) { 
      log.info("str1: " + str1); 
      log.info("str2: " + str2);
   }
   
   //sampleService클래스에서 실행되는 모든 메소드에 해당하는데 예외 발생하면 exception이라는 변수로 잡아서 그걸 인자로 넣어 로그에 찍힘.
   @AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
   public void logException(Exception exception) { 
      log.info("Exception....!!!!");
      log.info("exception: "+ exception); 
   }
   
   //대상 메소드 실행 전과 후의 현재 시간을 얻은 후 실행 시간을 계산함
   @Around("execution(* org.zerock.service.SampleService*.*(..))") 
   public Object logTime( ProceedingJoinPoint pjp) { //target의 현재 JoinPoint를 얻음
      long start = System.currentTimeMillis(); // 시작 시각
      log.info("Target: " + pjp.getTarget()); 
      log.info("Param: " + Arrays.toString(pjp.getArgs())); // 현재 JoinPoint에 전달된 파라미터들을 얻음
      
      //invoke method 
      Object result = null;
      
      try { 
         result = pjp.proceed(); // 이 함수를 이용해 실제 target의 현재 JoinPoint를 실행함
      } catch (Throwable e) { 
         e.printStackTrace(); 
      }
      long end = System.currentTimeMillis(); // 종료 시각 
      
      log.info("TIME: " + (end - start)); 
      return result; // 객체 반환
      }
}