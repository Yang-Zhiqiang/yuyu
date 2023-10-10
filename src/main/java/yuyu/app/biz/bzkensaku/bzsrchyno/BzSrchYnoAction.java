package yuyu.app.biz.bzkensaku.bzsrchyno;

import static yuyu.app.biz.bzkensaku.bzsrchyno.GenBzSrchYnoConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 郵便番号検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,       page=PAGENO_INIT,       path="/biz/bzkensaku/bzsrchyno/BzSrchYno.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                            path="/biz/bzkensaku/bzsrchyno/bz_srch_yno.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA, page=PAGENO_SELECTDATA, path="/biz/bzkensaku/bzsrchyno/bz_srch_yno.jsp"),
})
@Input("/biz/bzkensaku/bzsrchyno/bz_srch_yno.jsp")
@UIBean(beanClass=BzSrchYnoUiBean.class)
@Roles("bzsrchyno")
public class BzSrchYnoAction {

    @Inject
    private BzSrchYnoBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.searchAddress();
        return FORWARDNAME_SELECTDATA;
    }

    public String searchResultPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
