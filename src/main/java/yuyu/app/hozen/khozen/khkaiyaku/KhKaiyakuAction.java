package yuyu.app.hozen.khozen.khkaiyaku;

import static yuyu.app.hozen.khozen.khkaiyaku.GenKhKaiyakuConstants.*;

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
 * 解約 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khkaiyaku/KhKaiyaku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhKaiyaku", redirect=true),
})
@Input("/hozen/khozen/khkaiyaku/kh_kaiyaku.jsp")
@UIBean(beanClass=KhKaiyakuUiBean.class)
public class KhKaiyakuAction {

    @Inject
    private KhKaiyakuBizLogic bizLogic;

    @Inject
    private KhKaiyakuUiBean uiBean;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private InputContentsCopyBean inputContentsCopyBean;

    @Inject
    private ReferenceCopyBean referenceCopyBean;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin(renew = true)
    public String fromKaiyakuFunctions() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {
        if (C_KhkinouModeIdKbn.INPUT.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.TENKEN.getValue().equals(kinouMode.getKinouMode()) ||
            C_KhkinouModeIdKbn.SYOUNIN.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    @End
    public String tojiruBtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.DEFAULT.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
        }
        return null;
    }

    @Begin(join = true)
    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuuryokuBL();
        return FORWARDNAME_INPUTCONTENTS;
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
    public String modoruBtnByInputContentsOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String syoukaibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, inputContentsCopyBean);

        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String sainyuuryokubtnOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, inputContentsCopyBean);

        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.continueLockProcessBL();
        }

        bizLogic.pushSainyuuryokubtnOnClickBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String skssakuseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);

        bizLogic.pushSeikyusyoSakuseiBL();
        return FORWARDNAME_SKSCONFIRM;
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
    public String kakuteiBtnOnClick() {
        try {
            bizLogic.pushKukakuteiBL();
        } catch (BizLogicException bizLogicException) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                bizLogic.pushUnlockProcessBL();
            }
            throw  bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String modorubtnbysksconfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);

        bizLogic.pushModoruBysksconfirm();
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

    public String fromHozenWorkList() {
        try {
            bizLogic.iwfOpenBL();
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INPUTCONTENTS;
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
