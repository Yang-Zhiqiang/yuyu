package yuyu.app.biz.bzkensaku.bztokuteikankeihoujin;

import static yuyu.app.biz.bzkensaku.bztokuteikankeihoujin.GenBzTokuteiKankeiHoujinConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 特定関係法人照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bztokuteikankeihoujin/BzTokuteiKankeiHoujin.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bztokuteikankeihoujin/bz_tokutei_kankei_houjin.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bztokuteikankeihoujin/bz_tokutei_kankei_houjin.jsp"),
})
@Input("/biz/bzkensaku/bztokuteikankeihoujin/bz_tokutei_kankei_houjin.jsp")
@UIBean(beanClass=BzTokuteiKankeiHoujinUiBean.class)
@Roles("bztokuteikankeihoujin")
public class BzTokuteiKankeiHoujinAction {

    @Inject
    private BzTokuteiKankeiHoujinBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
