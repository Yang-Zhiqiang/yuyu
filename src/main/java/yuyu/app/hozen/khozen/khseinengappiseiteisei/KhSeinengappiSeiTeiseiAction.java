package yuyu.app.hozen.khozen.khseinengappiseiteisei;

import static yuyu.app.hozen.khozen.khseinengappiseiteisei.GenKhSeinengappiSeiTeiseiConstants.*;

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
 * 被保険者生年月日・性訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khseinengappiseiteisei/KhSeinengappiSeiTeisei.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhSeinengappiSeiTeisei", redirect=true),
})
@Input("/hozen/khozen/khseinengappiseiteisei/kh_seinengappi_sei_teisei.jsp")
@UIBean(beanClass=KhSeinengappiSeiTeiseiUiBean.class)
public class KhSeinengappiSeiTeiseiAction {

    @Inject
    private KhSeinengappiSeiTeiseiBizLogic bizLogic;

    @Inject
    private KhSeinengappiSeiTeiseiUiBean uiBean;

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
        String forwardName = bizLogic.pushFunctionNameOnClickBL();
        return forwardName;
    }

    @End
    public String tojiruBtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
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
    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuryokuBL();
        return FORWARDNAME_INPUTCONTENTS;
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

    public String syoukaibtnbyinputcontentsOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, inputContentsBean);

        bizLogic.pushSyoukaiInputcontentsBL();
        return FORWARDNAME_REFERENCE;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {
        String forwardName = bizLogic.pushSyoukainomibtnOnClickBL();
        return forwardName;
    }

    public String sainyuuryokubtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode()) &&
            !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.continueLockProcessBL();
        }
        bizLogic.removeWarning();

        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String skssakuseibtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushSksConfirm();
        return FORWARDNAME_SKSCONFIRM;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushKakuninSyori();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruByConfirmBL();

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKakuteiUpdate();
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();
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

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        bizLogic.pushModorubtnbysksconfirmBL();
        return FORWARDNAME_REFERENCE;
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
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.pushUnlockProcessBL();
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
        bizLogic.pushUnlockProcessBL();
    }
}
