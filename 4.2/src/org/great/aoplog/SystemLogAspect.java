package org.great.aoplog;


import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


/**
 * @author zx
 * @desc 切点类 
 */

@Aspect 		//自动代理，从配置文件获得
@Component				//用于注入，IOC反向控制生成类
public class SystemLogAspect {

    //注入Service用于把日志保存数据库  
//    @Resource  //这里我用resource注解
//    private SystemLogService systemLogService;  
    
    
  //这里的zxtest要和log4j.properties里的配置一致，否则写不到文件中
	private static Logger logger = Logger.getLogger("zxtest");  
    
    //Controller层切点  
	//第一个星代表包上层的包，第二个..*代表包下面不论多少层的类,第三个*(..)第二个条件中的任意方法任意参数
//    @Pointcut("execution (* org.great.aoplog..*.*(..))")  
    @Pointcut("execution (* MyUnitl..*.*(..))")  
    public  void controllerAspect() {  
    }  
    
    /** 
     * 前置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */ 
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("==========执行=改造老师=前置通知===============");
        
        if(logger.isInfoEnabled()){
            logger.info("before " + joinPoint);
        }
    }    
    
    /** 
     * 后置通知 用于拦截Controller层记录用户的操作 
     * 
     * @param joinPoint 切点 
     */  
    @After("controllerAspect()")  
    public  void after(JoinPoint joinPoint) throws Throwable{  
  
       /* HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();  
        HttpSession session = request.getSession();  */
        //读取session中的用户  
       // User user = (User) session.getAttribute("user");  
        //请求的IP  
        //String ip = request.getRemoteAddr();
        
         try {  
            
            String targetName = joinPoint.getTarget().getClass().getName();  
            String methodName = joinPoint.getSignature().getName();  
            Object[] arguments = joinPoint.getArgs();  
            Class targetClass = Class.forName(targetName);  
            Method[] methods = targetClass.getMethods();
            String operationType = "";
            String operationName = "";
            String abc = "";
             for (Method method : methods) {  
                 if (method.getName().equals(methodName)) {  
                    Class[] clazzs = method.getParameterTypes();  
                     if (clazzs.length == arguments.length) {  
                         operationType = method.getAnnotation(Log.class).operationType();
                         operationName = method.getAnnotation(Log.class).operationName();
                         abc = method.getAnnotation(Log.class).abc();
                         break;  
                    }  
                }  
            }
            //*========控制台输出=========*//  
            System.out.println("=====controller后置通知开始=====");  
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            System.out.println("方法描述:" + operationName); 
            System.out.println("abc:" + abc); 
            //*========数据库日志=========*//  
            SystemLog log = new SystemLog();  
            log.setId(UUID.randomUUID().toString());
            log.setDescription(operationName);  
            log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")+"."+operationType);  
            log.setLogType((long)0);  
//            log.setRequestIp(ip);  
            log.setExceptioncode( null);  
            log.setExceptionDetail( null);  
            log.setParams( null);  
//            log.setCreateBy(user.getName());  
            log.setCreateDate(new Date());  
            //保存数据库  
//            systemLogService.insert(log);  
            System.out.println("=====controller后置通知结束=====");  
        }  catch (Exception e) {  
            //记录本地异常日志  
            logger.error("==后置通知异常==");  
            logger.error("异常信息:{}------"+ e.getMessage());  
            
            
            throw e;
        }  
    } 

}