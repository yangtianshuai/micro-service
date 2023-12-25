package com.example.demo.adapter.filter;

import api.config.sso.ISsoHandler;
import api.config.sso.SsoCookie;
import com.honlivhp.api.config.SsoFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SsoFilterImpl extends SsoFilter {

    public SsoFilterImpl(ISsoHandler ssoHandler) {
        super(ssoHandler);
    }


    @Override
    public void ValidateComplate(SsoCookie ssoCookie) {

    }

    @Override
    public void LogoutComplate(SsoCookie ssoCookie) {

    }
}
