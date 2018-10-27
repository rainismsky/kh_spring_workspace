package spring.chap01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
		private Log log = LogFactory.getLog(getClass());

		public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
			log.info("기록 시작");
			StopWatch stopWatch = new StopWatch(); //스톱워치 객체를 생성하고
			try {
				stopWatch.start();//위에서 생성된 스톱워치 객체를 작동(시작)한다
				Object retValue = joinPoint.proceed();
				return retValue;
			} catch (Throwable e) {
				throw e;
			} finally {
				stopWatch.stop();
				log.info("기록 종료");
				log.info(joinPoint.getSignature().getName() + "메서드 실행 시간 : "
					+ stopWatch.getTotalTimeMillis()); //stopWatch.getTotalTimeMillis() start부터 end까지의 시간을 출력
			}
		}
}

