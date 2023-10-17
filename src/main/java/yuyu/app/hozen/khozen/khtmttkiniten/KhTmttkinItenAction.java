package yuyu.app.hozen.khozen.khtmttkiniten;

import static yuyu.app.hozen.khozen.khtmttkiniten.GenKhTmttkinItenConstants.*;

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
 * 積立金移転 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khtmttkiniten/KhTmttkinIten.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhTmttkinIten", redirect=true),
})
@Input("/hozen/khozen/khtmttkiniten/kh_tmttkin_iten.jsp")
@UIBean(beanClass=KhTmttkinItenUiBean.class)
public class KhTmttkinItenAction {

    @Inject
    private KhTmttkinItenBizLogic bizLogic;

    @Inject
    private KhTmttkinItenUiBean uiBean;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private InputContentsCopyBean inputContentsBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {
        return bizLogic.pushFunctionNameOnClickBL();
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushTojiruBtnOnClickBL();

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

    @End(nested = true)
    public String syoukainomibtnOnClick() {
        return bizLogic.pushSyoukaiNomi();

    }

    public String sainyuuryokubtnOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        bizLogic.pushSainyuuryokubtnOnClickBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String skssakuseibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushSeikyusyoSakuseiBL();

        return FORWARDNAME_SKSCONFIRM;
    }

    @Begin
    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {
        return bizLogic.pushModoruNaiyouNyuryoku();
    }

    public String syoukaibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, inputContentsBean);
        bizLogic.pushSyoukaiBL();

        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceBean);
        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceBean);
        bizLogic.pushModoruByConfirmBL();

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        try {
            bizLogic.pushKukakuteiBL();
        } catch (BizLogicException bizLogicException) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) ) {
                bizLogic.unlockProcessBL();
            }
            throw  bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {
        return bizLogic.pushSyokiGamenheKekka();
    }

    public String modorubtnbysksconfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceBean);
        bizLogic.pushModoruBySksConfirmBL();

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
            bizLogic.unlockProcessBL();

            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public void print() {
        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcessBL();
    }
}
