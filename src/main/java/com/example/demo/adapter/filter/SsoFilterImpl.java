package com.example.demo.adapter.filter;

import api.config.sso.ISsoHandler;
import api.config.sso.SsoCookie;
import com.honlivhp.api.config.SsoFilter;

public class SsoFilterImpl extends SsoFilter {

    public SsoFilterImpl(ISsoHandler ssoHandler) {
        super(ssoHandler);
    }


    @Override
    public void ValidateComplate(SsoCookie ssoCookie) {
        //SSO登入
        //令牌：ssoCookie.ID
        //如果你不希望频繁进行验证，就需要在这里保存下来令牌
        //保存令牌方式：Session、JWT
    }

    @Override
    public void LogoutComplate(SsoCookie ssoCookie) {
        //SSO登出
        //需要清除服务器中的Session（如果有）
    }
}
