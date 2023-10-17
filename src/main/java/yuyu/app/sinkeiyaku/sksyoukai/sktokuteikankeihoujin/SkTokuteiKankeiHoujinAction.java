package yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin;

import static yuyu.app.sinkeiyaku.sksyoukai.sktokuteikankeihoujin.GenSkTokuteiKankeiHoujinConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 特定関係法人照会 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/SkTokuteiKankeiHoujin.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/sk_tokutei_kankei_houjin.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/sk_tokutei_kankei_houjin.jsp"),
})
@Input("/sinkeiyaku/sksyoukai/sktokuteikankeihoujin/sk_tokutei_kankei_houjin.jsp")
@UIBean(beanClass=SkTokuteiKankeiHoujinUiBean.class)
@Roles("sktokuteikankeihoujin")
public class SkTokuteiKankeiHoujinAction {

    @Inject
    private SkTokuteiKankeiHoujinBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew=true)
    public String fromOtherFunctions() {

        bizLogic.initSeniyou();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin(join=true)
    public String searchBtnOnClick() {
        bizLogic.doSearchBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }
}
