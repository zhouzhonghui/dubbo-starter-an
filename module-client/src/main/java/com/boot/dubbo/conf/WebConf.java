package com.boot.dubbo.conf;

import com.boot.dubbo.exceptions.errors.MainErrors;
import com.boot.dubbo.exceptions.errors.SubErrors;
import com.boot.dubbo.interceptors.HeaderInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;

@Configuration
public class WebConf extends WebMvcConfigurerAdapter {
    private static final String I18N_ROP_ERROR = "i18n/rop/error";
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        initMessageSource() ;
        registry.addInterceptor(new HeaderInterceptor()) ;
    }

    /**
     * 设置国际化资源信息
     */
    private void initMessageSource() {
        HashSet<String> baseNamesSet = new HashSet();
        baseNamesSet.add(I18N_ROP_ERROR);//ROP自动的资源


        String[] totalBaseNames = baseNamesSet.toArray(new String[0]);

//        if (logger.isInfoEnabled()) {
//            logger.info("加载错误码国际化资源：{}", totalBaseNames);
//        }
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setBasenames(totalBaseNames);
        MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(bundleMessageSource);
        MainErrors.setErrorMessageSourceAccessor(messageSourceAccessor);
        SubErrors.setErrorMessageSourceAccessor(messageSourceAccessor);
    }
}
