package yuyu.app.siharai.sikensaku.sisrchbyoumei;

import static yuyu.app.siharai.sikensaku.sisrchbyoumei.GenSiSrchByoumeiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 病名検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/siharai/sikensaku/sisrchbyoumei/SiSrchByoumei.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/siharai/sikensaku/sisrchbyoumei/si_srch_byoumei.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/siharai/sikensaku/sisrchbyoumei/si_srch_byoumei.jsp"),
})
@Input("/siharai/sikensaku/sisrchbyoumei/si_srch_byoumei.jsp")
@UIBean(beanClass=SiSrchByoumeiUiBean.class)
@Roles("sisrchbyoumei")
public class SiSrchByoumeiAction {

    @Inject
    private SiSrchByoumeiBizLogic bizLogic;

    @Begin(nested=true)
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested=true)
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {
        bizLogic.doSearchBL();
        return FORWARDNAME_INPUTKEY;
    }

    public String searchResultsPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    @End(nested = true)
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
