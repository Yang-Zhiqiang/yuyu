package yuyu.app.workflow.imagekanri.qrsealsakusei;

import static yuyu.app.workflow.imagekanri.qrsealsakusei.GenQRSealSakuseiConstants.*;

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
 * QRシール用紙作成 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/workflow/imagekanri/qrsealsakusei/QRSealSakusei.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTCONDITION, page = PAGENO_INPUTCONDITION, path = "/workflow/imagekanri/qrsealsakusei/q_r_seal_sakusei.jsp"),
    @Forward(name = FORWARDNAME_INPUTCONTENTS, page = PAGENO_INPUTCONTENTS, path = "/workflow/imagekanri/qrsealsakusei/q_r_seal_sakusei.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/workflow/imagekanri/qrsealsakusei/q_r_seal_sakusei.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/workflow/imagekanri/qrsealsakusei/q_r_seal_sakusei.jsp"),
})
@Input("/workflow/imagekanri/qrsealsakusei/q_r_seal_sakusei.jsp")
@UIBean(beanClass = QRSealSakuseiUiBean.class)
@Roles("qrsealsakusei")
public class QRSealSakuseiAction {

    @Inject
    private QRSealSakuseiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTCONDITION;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String ketteiBtnOnClick() {

        bizLogic.nyrykKoumokuSettei();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String sakujyoLinkOnClick() {

        bizLogic.nyrykListDelete();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String addbtnOnClick() {

        bizLogic.nyrykListAdd();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByInputContentsOnClick() {

        bizLogic.resetInitUiBean();
        return FORWARDNAME_INPUTCONDITION;
    }

    public String modoruBtnByConfirmOnClick() {

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuninBtnOnClick() {

        bizLogic.nyrykNaiyouSettei();
        return FORWARDNAME_CONFIRM;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.createQRsealPre();
        return FORWARDNAME_RESULT;
    }

    @MultiPostConstraints
    public String torikomiyouhyousisakuseiBtnOnClick() {

        bizLogic.createTorikomihyousiPre();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public void print() {
        bizLogic.printReport();
    }
}
