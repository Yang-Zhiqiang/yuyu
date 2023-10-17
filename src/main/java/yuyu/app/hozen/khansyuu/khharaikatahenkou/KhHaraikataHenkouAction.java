package yuyu.app.hozen.khansyuu.khharaikatahenkou;

import static yuyu.app.hozen.khansyuu.khharaikatahenkou.GenKhHaraikataHenkouConstants.*;

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
import yuyu.common.base.CTIParamBean;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.def.classification.C_KidougmKbn;

/**
 * 払方変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khansyuu/khharaikatahenkou/KhHaraikataHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhHaraikataHenkou", redirect=true),
})
@Input("/hozen/khansyuu/khharaikatahenkou/kh_haraikata_henkou.jsp")
@UIBean(beanClass=KhHaraikataHenkouUiBean.class)
public class KhHaraikataHenkouAction {

    @Inject
    private KhHaraikataHenkouBizLogic bizLogic;

    @Inject
    private KhHaraikataHenkouUiBean uiBean;

    @Inject
    private InputContentsCopyBean inputContentsBean;

    @Inject
    private ReferenceCopyBean referenceBean;

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

    @End(nested = true)
    public String functionNameOnClick() {
        return bizLogic.pushFunctionNameOnClickBL();
    }

    @End
    public String tojiruBtnOnClick() {
        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
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

    @End(nested = true)
    public String syoukainomibtnOnClick() {

        return bizLogic.pushSyoukaiNomi();
    }

    public String sainyuuryokubtnOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            bizLogic.continueLockProcessBL();
        }

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

    public String kakuninbtnbykabuOnClick() {
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
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKukakuteiBL();
        } catch (BizLogicException bizLogicException) {
            if (C_KidougmKbn.INPUTKEY.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
                bizLogic.pushUnlockProcessBL();
            }
            throw  bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenhebtnbyresultOnClick() {
        return bizLogic.pushSyokiGamenheKekka();
    }

    public String modorubtnbysksconfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {
        bizLogic.pushKakuteiByskConfirmBL();
        return FORWARDNAME_SKSRESULT;
    }

    @End
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
