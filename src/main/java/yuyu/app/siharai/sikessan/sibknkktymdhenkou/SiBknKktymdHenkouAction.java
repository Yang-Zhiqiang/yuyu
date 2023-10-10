package yuyu.app.siharai.sikessan.sibknkktymdhenkou;

import static yuyu.app.siharai.sikessan.sibknkktymdhenkou.GenSiBknKktymdHenkouConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 備金確定日変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/siharai/sikessan/sibknkktymdhenkou/SiBknKktymdHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/siharai/sikessan/sibknkktymdhenkou/si_bkn_kktymd_henkou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/siharai/sikessan/sibknkktymdhenkou/si_bkn_kktymd_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/siharai/sikessan/sibknkktymdhenkou/si_bkn_kktymd_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/siharai/sikessan/sibknkktymdhenkou/si_bkn_kktymd_henkou.jsp"),
})
@Input("/siharai/sikessan/sibknkktymdhenkou/si_bkn_kktymd_henkou.jsp")
@UIBean(beanClass=SiBknKktymdHenkouUiBean.class)
@Roles("sibknkktymdhenkou")
public class SiBknKktymdHenkouAction {

    @Inject
    private SiBknKktymdHenkouBizLogic bizLogic;

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

    public String kakuninBtnOnClick() {

        String sForwardName = bizLogic.kakuninBtnOnClickBL();

        return sForwardName;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {

        String sForwardName = bizLogic.kakuteiBtnOnClickBL();

        return sForwardName;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        return FORWARDNAME_INIT;
    }
}
