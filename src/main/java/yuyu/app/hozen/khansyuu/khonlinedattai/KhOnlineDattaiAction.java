package yuyu.app.hozen.khansyuu.khonlinedattai;

import static yuyu.app.hozen.khansyuu.khonlinedattai.GenKhOnlineDattaiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.base.CTIParamBean;

/**
 * オンライン脱退処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/hozen/khansyuu/khonlinedattai/KhOnlineDattai.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khonlinedattai/kh_online_dattai.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khonlinedattai/kh_online_dattai.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khonlinedattai/kh_online_dattai.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/hozen/khansyuu/khonlinedattai/kh_online_dattai.jsp"),
})
@Input("/hozen/khansyuu/khonlinedattai/kh_online_dattai.jsp")
@UIBean(beanClass=KhOnlineDattaiUiBean.class)
public class KhOnlineDattaiAction {

    @Inject
    private KhOnlineDattaiBizLogic bizLogic;

    @Inject
    private KhOnlineDattaiUiBean uiBean;

    @Inject
    private CTIParamBean ctiParamBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromCTI() {

        bizLogic.init();

        uiBean.setVkihnsyono(ctiParamBean.getSyono());

        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin
    public String setteibtnOnClick() {

        bizLogic.pushSetteiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(mode=Mode.DELETE)
    public String torikesiBtnOnClick() {

        bizLogic.pushTorikesiBL();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBtnBL();
        bizLogic.setMsgContents();

        return FORWARDNAME_CONFIRM;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {

        return bizLogic.getForwardName();
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
