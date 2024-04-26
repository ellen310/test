package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import spring.common.web.LogonCheckInterceptor;

//===================== 추가된 Class  ======================//
// Interceptor 등록하는 WebMvcCongigurer 구현 Bean
//=======================================================//
@Configuration
public class WebConfig implements WebMvcConfigurer {

	public WebConfig() {
		System.out.println("==> WebConfig default Constructor call.............");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// URL Pattern 을 확인하고. interceptor 적용유무 등록함.
		registry.addInterceptor( new LogonCheckInterceptor()).addPathPatterns("/user/**"); //("/user/*")로 하면 rest에서는 못받는다. 
		//RESTConteroller에서는 user/json/이런식으로 request가 들어가는데, user/**이면 user밑의 모~든게 연결되니까 컨트롤러가 연결 되지만,
		// user/*로 하면 user/json까지만 연결되니까 400에러가 뜬다.
		
	}

}
