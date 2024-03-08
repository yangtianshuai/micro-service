package com.example.demo.adapter.config;

import api.config.SsoFilter;
import api.config.sso.EnableSSO;
import api.config.sso.IPMapping;
import api.config.sso.ISsoHandler;
import api.config.sso.SsoOptions;
import api.config.sso.cas.CasHandler;
import api.config.sso.oauth2.OAuth2Handler;
import api.config.sso.oauth2.OAuth2Mode;
import api.config.sso.oauth2.OAuth2Options;
import com.example.demo.adapter.filter.SsoFilterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@EnableSSO
@Configuration(proxyBeanMethods = false)
public class SsoConfiguration {

    private static SsoOptions options;
    private static OAuth2Options oAuth2Options = new OAuth2Options();

    private SsoOptions getOptions(){
        if(options == null){
            options = new SsoOptions();
            //建议从配置中加载
            options.AppID = "应用ID";
            options.BaseURL = "SSO服务器地址";
            options.IPMappings = new ArrayList<>();
            IPMapping maping = new IPMapping();
            maping.server_ip="当前应用IP";
            maping.base_url="http://SSO服务器IP:端口";//返回给前端浏览器，用于跳转
            maping.validate_url="http://SSO服务器IP:端口";//当前应用获取校验令牌和获取用户信息，ps:用于应用无法通过maping.base_url地址访问SSO服务器的场景
            options.IPMappings.add(maping);
        }
        return options;
    }


    /**
     * CAS方式接入
     * @return
     */
    @Bean
    public SsoFilter useCas() {
        ISsoHandler ssoHandler = new CasHandler(getOptions());
        return new SsoFilterImpl(ssoHandler);
    }

//    private OAuth2Options getOAuth2Options(){
//        if(oAuth2Options == null){
//            oAuth2Options = new OAuth2Options();
//            oAuth2Options.RedictUri = "回调地址";
//            oAuth2Options.Mode = OAuth2Mode.Simple;//使用简单模式，默认使用标准模式
//        }
//        return oAuth2Options;
//    }
//
//    /**
//     * OAuth2方式接入
//     * @return
//     */
//    @Bean
//    public SsoFilter useOAuth2() {
//
//        ISsoHandler ssoHandler = new OAuth2Handler(getOptions(),getOAuth2Options());
//        return new SsoFilterImpl(ssoHandler);
//    }
}
