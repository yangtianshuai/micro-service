package com.example.demo.adapter.filter;

import api.config.SsoFilter;
import api.config.session.ServerSession;
import api.config.session.Session;
import api.config.sso.ISsoHandler;
import api.config.sso.SsoCookie;
import api.config.utility.StringUtil;
import jakarta.servlet.http.HttpServletRequest;

public class SsoFilterImpl extends SsoFilter {

    protected ServerSession _session;

    public SsoFilterImpl(ServerSession session,ISsoHandler ssoHandler) {
        super(ssoHandler);
        this._session = session;
    }


    @Override
    public void ValidateComplate(SsoCookie cookie) {
        //SSO登入
        if (_session.contain(cookie.ID)) {
            String id = GetCookieID(this.request);
            if (!StringUtil.isNullOrEmpty(id) && !id.equals(cookie.ID)) {
                this.setToken(cookie.ID);
            }
            return;
        }
        //返回Token
        this.setToken(cookie.ID);

        //如果你不希望频繁进行验证，就需要在这里保存下来令牌
        //保存令牌方式：Session、JWT
        //建议自定义Session继承实现
        Session user = new Session();
        user.token = cookie.ID;
        _session.set(user);
    }
    @Override
    public void LogoutComplate(SsoCookie cookie) {
        //SSO登出
        if (_session.contain(cookie.ID))        {
            //需要清除服务器中的Session（如果有）
            _session.remove(cookie.ID);
        }

    }

    @Override
    public String GetCookieID(HttpServletRequest httpServletRequest) {
        return this.getToken();
    }
}
