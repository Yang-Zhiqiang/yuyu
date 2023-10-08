package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import static yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan.GenSiBunkatuSiharaiKeisanConstants.*;

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
 * 分割支払計算 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sisyoukai/sibunkatusiharaikeisan/SiBunkatuSiharaiKeisan.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sisyoukai/sibunkatusiharaikeisan/si_bunkatu_siharai_keisan.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sisyoukai/sibunkatusiharaikeisan/si_bunkatu_siharai_keisan.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sisyoukai/sibunkatusiharaikeisan/si_bunkatu_siharai_keisan.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sisyoukai/sibunkatusiharaikeisan/si_bunkatu_siharai_keisan.jsp"),
})
@Input("/siharai/sisyoukai/sibunkatusiharaikeisan/si_bunkatu_siharai_keisan.jsp")
@UIBean(beanClass=SiBunkatuSiharaiKeisanUiBean.class)
@Roles("sibunkatusiharaikeisan")
public class SiBunkatuSiharaiKeisanAction {

    @Inject
    private SiBunkatuSiharaiKeisanBizLogic bizLogic;

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
        return FORWARDNAME_INIT;
    }

    @Begin(nested=true)
    public String kakuninBtnOnClick() {

        String sForwardName = bizLogic.kakuninBtnOnClickBL();
        return sForwardName;
    }

    @End(nested=true)
    public String modoruBtnByConfirmOnClick() {

        bizLogic.modoruBtnByConfirmOnClickBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        String sForwardName = bizLogic.kakuteiBtnOnClickBL();
        return sForwardName;
    }

    @End(nested=true)
    public String naiyounyuuryokugamenheBtnOnClick() {

        bizLogic.naiyounyuuryokugamenheBtnOnClickBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.pushKakuteiPrintOutBL();
    }
}
