package yuyu.app.biz.bzkensaku.bzsrchketteisya;

import static yuyu.app.biz.bzkensaku.bzsrchketteisya.GenBzSrchKetteisyaConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 決定者検索 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/biz/bzkensaku/bzsrchketteisya/BzSrchKetteisya.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                        path="/biz/bzkensaku/bzsrchketteisya/bz_srch_ketteisya.jsp"),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/biz/bzkensaku/bzsrchketteisya/bz_srch_ketteisya.jsp"),
})
@Input("/biz/bzkensaku/bzsrchketteisya/bz_srch_ketteisya.jsp")
@UIBean(beanClass=BzSrchKetteisyaUiBean.class)
@Roles("bzsrchketteisya")
public class BzSrchKetteisyaAction {

    @Inject
    private BzSrchKetteisyaBizLogic bizLogic;

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
