package yuyu.app.hozen.khozen.khmeigihenkou;

import static yuyu.app.hozen.khozen.khmeigihenkou.GenKhMeigiHenkouConstants.*;

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
import jp.co.slcs.swak.web.message.MessageManager;
import yuyu.common.biz.bzcommon.BizUiBeanBackupUtil;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.infr.kinoumode.KinouMode;

/**
 * 名義変更／契約者等生年月日訂正 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,       path="/hozen/khozen/khmeigihenkou/KhMeigiHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,   path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,  path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,    path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,     path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM, path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,  path="/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                         path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhMeigiHenkou", redirect=true),
})
@Input("/hozen/khozen/khmeigihenkou/kh_meigi_henkou.jsp")
@UIBean(beanClass=KhMeigiHenkouUiBean.class)
public class KhMeigiHenkouAction {

    @Inject
    private KhMeigiHenkouBizLogic bizLogic;

    @Inject
    private KhMeigiHenkouUiBean uiBean;

    @Inject
    private ReferenceCopyBean referenceCopyBean;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private MessageManager messageManager;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {
        String forwardName = bizLogic.functionNameOnClickBL();
        return forwardName;
    }

    @End
    public String tojiruBtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
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

    @End(nested=true)
    public String syoukainomibtnOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            bizLogic.pushUnlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String skssakuseibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);
        bizLogic.setSksMsg();
        return FORWARDNAME_SKSCONFIRM;
    }

    @Begin
    public String syoukaibtnOnClick() {
        bizLogic.pushSyoukai();
        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceCopyBean);
        bizLogic.pushKakunin();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirm();
        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.doUpdate();
        } catch (BizLogicException bizLogicException) {
            bizLogic.pushUnlockProcessBL();

            throw bizLogicException;
        }
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenhebtnbyresultOnClick() {
        if (!C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())
            && !C_KhkinouModeIdKbn.SYOUKAI.getValue().equals(kinouMode.getKinouMode())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }
        return FORWARDNAME_INIT;
    }

    public String modorubtnbysksconfirmOnClick() {
        messageManager.removeConversationMessage(KhMessageGroupConstants.GROUP_WARNING2);

        BizUiBeanBackupUtil.restore(uiBean, referenceCopyBean);
        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbysksconfirmOnClick() {
        bizLogic.doSksConfirm();
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
    public void print() {
        bizLogic.printOut();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}
