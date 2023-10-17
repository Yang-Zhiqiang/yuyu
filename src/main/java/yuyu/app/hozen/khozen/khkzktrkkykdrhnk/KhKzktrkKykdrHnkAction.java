package yuyu.app.hozen.khozen.khkzktrkkykdrhnk;

import static yuyu.app.hozen.khozen.khkzktrkkykdrhnk.GenKhKzktrkKykdrHnkConstants.*;

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
 * 家族登録／契約者代理特約変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,       path="/hozen/khozen/khkzktrkkykdrhnk/KhKzktrkKykdrHnk.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,   path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,  path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,    path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,     path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM, path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,  path="/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                         path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhKzktrkKykdrHnk", redirect=true),
})
@Input("/hozen/khozen/khkzktrkkykdrhnk/kh_kzktrk_kykdr_hnk.jsp")
@UIBean(beanClass=KhKzktrkKykdrHnkUiBean.class)
public class KhKzktrkKykdrHnkAction {

    @Inject
    private KhKzktrkKykdrHnkBizLogic bizLogic;

    @Inject
    private KhKzktrkKykdrHnkUiBean uiBean;

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
        bizLogic.pushUnlockProcessBL();

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushUnlockProcessBL();
        return null;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {
        bizLogic.pushUnlockProcessBL();

        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String skssakuseibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);

        bizLogic.pushSeikyusyoSakuseiBL();
        return FORWARDNAME_SKSCONFIRM;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukaibtnBL();
        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);

        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);

        bizLogic.pushModoruByConfirmBL();
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKakuteiBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
            throw  bizLogicException;
        }
        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbyresultOnClick() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
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

        bizLogic.pushKakuteiByskConfirmBL();
        return FORWARDNAME_SKSRESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbysksresultOnClick() {
        return FORWARDNAME_INIT;
    }

    public String hyoujilinkOnClick() {
        bizLogic.printHyoujiOut();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.printAllHyoujiOut();
        return null;
    }

    public String fromHozenWorkList() {

        try {
            bizLogic.iwfOpenBL();
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_REFERENCE;
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
