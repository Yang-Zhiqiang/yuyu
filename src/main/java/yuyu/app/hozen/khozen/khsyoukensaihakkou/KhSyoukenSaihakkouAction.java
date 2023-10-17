package yuyu.app.hozen.khozen.khsyoukensaihakkou;

import static yuyu.app.hozen.khozen.khsyoukensaihakkou.GenKhSyoukenSaihakkouConstants.*;

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
 * 証券再発行 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,       path="/hozen/khozen/khsyoukensaihakkou/KhSyoukenSaihakkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,   path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,  path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,    path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,     path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM, path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,  path="/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                         path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhSyoukenSaihakkou", redirect=true),
})
@Input("/hozen/khozen/khsyoukensaihakkou/kh_syouken_saihakkou.jsp")
@UIBean(beanClass=KhSyoukenSaihakkouUiBean.class)
public class KhSyoukenSaihakkouAction {

    @Inject
    private KhSyoukenSaihakkouBizLogic bizLogic;

    @Inject
    private KhSyoukenSaihakkouUiBean uiBean;

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

        String forwardName =bizLogic.functionNameOnClickBL();
        return forwardName;
    }

    @End
    public String tojiruBtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            && !C_KhkinouModeIdKbn.SYOUKAI.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            bizLogic.pushUnlockProcessBL();
        }
        return null;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End(nested=true)
    public String modorubtnbysyoukaiOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))
            && !C_KhkinouModeIdKbn.SYOUKAI.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);
        bizLogic.pushKakuninBtn();
        return FORWARDNAME_CONFIRM;
    }

    public String skssakuseibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);
        bizLogic.pushSeikyuushouBL();
        return FORWARDNAME_SKSCONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirm();
        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKakutei();
        } catch (BizLogicException bizLogicException) {

            bizLogic.pushUnlockProcessBL();

            throw bizLogicException;
        }
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenhebtnbyresultOnClick() {

        if (!C_KhkinouModeIdKbn.INPUTKEY.eq(C_KhkinouModeIdKbn.valueOf(kinouMode.getKinouMode()))) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String modorubtnbysksconfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {
        bizLogic.pushKakuteiBtn();
        return FORWARDNAME_SKSRESULT;
    }

    @End(nested=true)
    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INIT;
    }

    public String fromHozenWorkList() {
        try {
            bizLogic.iwfOpenBL();
            return FORWARDNAME_REFERENCE;

        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @MultiPostConstraints
    public void print(){
        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}

