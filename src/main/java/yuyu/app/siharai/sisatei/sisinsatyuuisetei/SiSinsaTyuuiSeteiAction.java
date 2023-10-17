package yuyu.app.siharai.sisatei.sisinsatyuuisetei;

import static yuyu.app.siharai.sisatei.sisinsatyuuisetei.GenSiSinsaTyuuiSeteiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 審査注意設定 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sisatei/sisinsatyuuisetei/SiSinsaTyuuiSetei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sisatei/sisinsatyuuisetei/si_sinsa_tyuui_setei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sisatei/sisinsatyuuisetei/si_sinsa_tyuui_setei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sisatei/sisinsatyuuisetei/si_sinsa_tyuui_setei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sisatei/sisinsatyuuisetei/si_sinsa_tyuui_setei.jsp"),
})
@Input("/siharai/sisatei/sisinsatyuuisetei/si_sinsa_tyuui_setei.jsp")
@UIBean(beanClass=SiSinsaTyuuiSeteiUiBean.class)
@Roles("sisinsatyuuisetei")
public class SiSinsaTyuuiSeteiAction {

    @Inject
    private SiSinsaTyuuiSeteiBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String ketteiBtnOnClick() {

        String forwardName = bizLogic.ketteiBtnOnClick();
        return forwardName;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {

        String forwardName = bizLogic.modoruBtnByInputContentsOnClickBL();
        return forwardName;
    }

    public String kakuninBtnOnClick() {

        String forwardName = bizLogic.kakuninBtnOnClickBL();
        return forwardName;
    }

    public String modoruBtnByConfirmOnClick() {

        String forwardName = bizLogic.modoruBtnByConfirmOnClickBL();
        return forwardName;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        String forwardName = bizLogic.kakuteiBtnOnClickBL();
        return forwardName;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
