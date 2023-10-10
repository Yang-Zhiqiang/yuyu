package yuyu.app.biz.bzkensaku.bzsrchginkousiten;

import static yuyu.app.biz.bzkensaku.bzsrchginkousiten.GenBzSrchGinkouSitenConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 銀行支店検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchginkousiten/BzSrchGinkouSiten.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchginkousiten/bz_srch_ginkou_siten.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchginkousiten/bz_srch_ginkou_siten.jsp"),
})
@Input("/biz/bzkensaku/bzsrchginkousiten/bz_srch_ginkou_siten.jsp")
@UIBean(beanClass=BzSrchGinkouSitenUiBean.class)
@Roles("bzsrchginkousiten")
public class BzSrchGinkouSitenAction {

    @Inject
    private BzSrchGinkouSitenBizLogic bizLogic;

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
