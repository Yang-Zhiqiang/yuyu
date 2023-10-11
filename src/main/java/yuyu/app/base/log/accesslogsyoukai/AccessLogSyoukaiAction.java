package yuyu.app.base.log.accesslogsyoukai;

import static yuyu.app.base.log.accesslogsyoukai.GenAccessLogSyoukaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * アクセスログ照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,    page=PAGENO_INIT,   path="/base/log/accesslogsyoukai/AccessLogSyoukai.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                     path="/base/log/accesslogsyoukai/access_log_syoukai.jsp"),
    @Forward(name=FORWARDNAME_SEARCH,  page=PAGENO_SEARCH, path="/base/log/accesslogsyoukai/access_log_syoukai.jsp"),
    @Forward(name=FORWARDNAME_DETAIL,  page=PAGENO_DETAIL, path="/base/log/accesslogsyoukai/access_log_syoukai.jsp"),
})
@Input("/base/log/accesslogsyoukai/access_log_syoukai.jsp")
@UIBean(beanClass=AccessLogSyoukaiUiBean.class)
@Roles("accesslogsyoukai")
public class AccessLogSyoukaiAction {

    @Inject
    private AccessLogSyoukaiBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_SEARCH;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.search();
        return FORWARDNAME_SEARCH;
    }


    public String syousaiLinkOnClick() {
        bizLogic.showSyousai();
        return FORWARDNAME_DETAIL;
    }

    public String modoruBtnBySyousaiOnClick() {
        bizLogic.clearEntity();
        bizLogic.chkAccessLogInfoCountExceed();
        return FORWARDNAME_SEARCH;
    }

    public String accessLogInfoListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    public String accessDetailLogInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
