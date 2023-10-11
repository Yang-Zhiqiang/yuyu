package yuyu.app.hozen.khozen.khjyuusyohenkou;

import static yuyu.app.hozen.khozen.khjyuusyohenkou.GenKhJyuusyoHenkouConstants.*;

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
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 住所変更 機能のアクションクラスです。
 */
@Forwards({
    @Forward(name = FORWARDNAME_INIT, page = PAGENO_INIT, path = "/hozen/khozen/khjyuusyohenkou/KhJyuusyoHenkou.do", redirect = true),
    @Forward(name = FORWARDNAME_INPUTKEY, page = PAGENO_INPUTKEY, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE1, page = PAGENO_REFERENCE1, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_REFERENCE2, page = PAGENO_REFERENCE2, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_CONFIRM, page = PAGENO_CONFIRM, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_RESULT, page = PAGENO_RESULT, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_SKSCONFIRM, page = PAGENO_SKSCONFIRM, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_SKSRESULT, page = PAGENO_SKSRESULT, path = "/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp"),
    @Forward(name = FORWARDNAME_BACKTOWORKLIST, path = "/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhJyuusyoHenkou", redirect = true),
})
@Input("/hozen/khozen/khjyuusyohenkou/kh_jyuusyo_henkou.jsp")
@UIBean(beanClass = KhJyuusyoHenkouUiBean.class)
public class KhJyuusyoHenkouAction {

    @Inject
    private KhJyuusyoHenkouBizLogic bizLogic;

    @Inject
    private KhJyuusyoHenkouUiBean uiBean;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private ReferenceCopyBean referenceCopyBean;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {
        String rtnUrl = bizLogic.functionNameOnClickBL();
        return rtnUrl;
    }

    @End
    public String tojiruBtnOnClick() {
        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
        }
        return null;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        if (!uiBean.isInputMode()) {
            return FORWARDNAME_REFERENCE1;
        }
        return FORWARDNAME_REFERENCE2;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {
        String rtnUrl = bizLogic.syoukainomibtnbysyoukaiOnClickBL();
        return rtnUrl;
    }

    public String skssakuseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);

        bizLogic.pushsSeikyuusyoSakusei();
        return FORWARDNAME_SKSCONFIRM;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.pushModoruBtnByConfirm();

        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);

        if (!uiBean.isInputMode()) {
            return FORWARDNAME_REFERENCE1;
        }
        return FORWARDNAME_REFERENCE2;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKakuteiBL();
        } catch (BizLogicException e) {

            bizLogic.pushUnlockProcessBL();
            throw e;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbyresultOnClick() {
        if (!C_KhkinouModeIdKbn.SYORI.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String modorubtnbysksconfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);

        if (!uiBean.isInputMode()) {
            return FORWARDNAME_REFERENCE1;
        }
        return FORWARDNAME_REFERENCE2;

    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {
        bizLogic.pushKakuteiBySksconfirmBL();
        return FORWARDNAME_SKSRESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INIT;
    }

    public String fromHozenWorkList() {
        try {

            bizLogic.iwfOpenBL();
            if (!uiBean.isInputMode()) {
                return FORWARDNAME_REFERENCE1;
            }
            return FORWARDNAME_REFERENCE2;
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }

    }

    public String fromCTI() {
        bizLogic.ctiOpenBL();
        return FORWARDNAME_INPUTKEY;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
