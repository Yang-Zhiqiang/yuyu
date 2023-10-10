package yuyu.app.biz.bzkensaku.bzsrchdairiten;

import static yuyu.app.biz.bzkensaku.bzsrchdairiten.GenBzSrchDairitenConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 代理店検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchdairiten/BzSrchDairiten.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchdairiten/bz_srch_dairiten.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchdairiten/bz_srch_dairiten.jsp"),
})
@Input("/biz/bzkensaku/bzsrchdairiten/bz_srch_dairiten.jsp")
@UIBean(beanClass=BzSrchDairitenUiBean.class)
@Roles("bzsrchdairiten")
public class BzSrchDairitenAction {

    @Inject
    private BzSrchDairitenBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
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
}
