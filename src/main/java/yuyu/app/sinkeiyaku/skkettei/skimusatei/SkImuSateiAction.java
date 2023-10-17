package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import static yuyu.app.sinkeiyaku.skkettei.skimusatei.GenSkImuSateiConstants.*;

import java.io.IOException;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;
import yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiUiBean;

/**
 * 医務査定 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/skkettei/skimusatei/SkImuSatei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skkettei/skimusatei/sk_imu_satei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skkettei/skimusatei/sk_imu_satei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/skkettei/skimusatei/sk_imu_satei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/skkettei/skimusatei/sk_imu_satei.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkImuSatei", redirect=true),
})
@Input("/sinkeiyaku/skkettei/skimusatei/sk_imu_satei.jsp")
@UIBean(beanClass=SkImuSateiUiBean.class)
public class SkImuSateiAction {

    @Inject
    private SkImuSateiBizLogic bizLogic;

    @Inject
    private SkKankyouSateiUiBean uiBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromSinkeiyakuWorkList() {
        try {
            bizLogic.iwfOpenBL();
            return FORWARDNAME_INPUTCONTENTS;
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.unlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.unlockProcess();
        return null;
    }

    @Begin
    public String sateibtnOnClick() {
        try {
            bizLogic.pushSateiBL();
            return FORWARDNAME_INPUTCONTENTS;
        } catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcess();
            throw bizLogicException;
        }
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        String seniSaki = bizLogic.modoruBtnByInputcontentsBL();
        return seniSaki;
    }

    public String kakuninBtnOnClick() {
        bizLogic.pushKakuNinBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushmodoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushOKBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {
        String seniSaki = bizLogic.syokiGamenhebtnOnClickBL();
        return seniSaki;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        String seniSaki = bizLogic.functionNameOnClickBL();

        return seniSaki;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    public String callAjaxSyoubyouMei() throws IOException {
        bizLogic.callAjaxSyoubyouMei();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String callAjaxKetteiRiyuuNaiyou() throws IOException {
        bizLogic.callAjaxKetteiRiyuuNaiyou();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcess();
    }
}
