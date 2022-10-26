package be.abvvfgtb.member.facade.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class BaliServiceInterceptorAppConfigFacade extends WebMvcConfigurerAdapter {
    @Autowired
    BaliServiceInterceptorFacade baliServiceInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baliServiceInterceptor);
    }
}
