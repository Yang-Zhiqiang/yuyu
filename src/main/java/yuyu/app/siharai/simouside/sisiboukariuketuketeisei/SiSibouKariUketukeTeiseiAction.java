package yuyu.app.siharai.simouside.sisiboukariuketuketeisei;

import static yuyu.app.siharai.simouside.sisiboukariuketuketeisei.GenSiSibouKariUketukeTeiseiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 死亡仮受付訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/simouside/sisiboukariuketuketeisei/SiSibouKariUketukeTeisei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/simouside/sisiboukariuketuketeisei/si_sibou_kari_uketuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/simouside/sisiboukariuketuketeisei/si_sibou_kari_uketuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/simouside/sisiboukariuketuketeisei/si_sibou_kari_uketuke_teisei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/simouside/sisiboukariuketuketeisei/si_sibou_kari_uketuke_teisei.jsp"),
})
@Input("/siharai/simouside/sisiboukariuketuketeisei/si_sibou_kari_uketuke_teisei.jsp")
@UIBean(beanClass=SiSibouKariUketukeTeiseiUiBean.class)
@Roles("sisiboukariuketuketeisei")
public class SiSibouKariUketukeTeiseiAction {

    @Inject
    private SiSibouKariUketukeTeiseiBizLogic bizLogic;

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

        String sForwardName = bizLogic.ketteiBtnOnClickBL();

        return sForwardName;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {

        String sForwardName = bizLogic.modoruBtnByInputContentsOnClickBL();

        return sForwardName;
    }

    public String kakuninBtnOnClick() {

        String sForwardName = bizLogic.kakuninBtnOnClickBL();

        return sForwardName;
    }

    public String modoruBtnByConfirmOnClick() {

        String sForwardName = bizLogic.modoruBtnByConfirmOnClickBL();

        return sForwardName;
    }

    @End
    public String kakuteiBtnOnClick() {

        String sForwardName = bizLogic.kakuteiBtnOnClickBL();

        return sForwardName;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

}
