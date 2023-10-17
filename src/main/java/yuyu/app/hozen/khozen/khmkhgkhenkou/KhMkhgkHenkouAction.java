package yuyu.app.hozen.khozen.khmkhgkhenkou;

import static yuyu.app.hozen.khozen.khmkhgkhenkou.KhMkhgkHenkouConstants.*;

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

/**
 * 目標額変更 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khmkhgkhenkou/KhMkhgkHenkou.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSCONFIRM,     page=PAGENO_SKSCONFIRM,    path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_SKSRESULT,      page=PAGENO_SKSRESULT,     path="/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhMkhgkHenkou", redirect=true),
})
@Input("/hozen/khozen/khmkhgkhenkou/kh_mkhgk_henkou.jsp")
@UIBean(beanClass=KhMkhgkHenkouUiBean.class)
public class KhMkhgkHenkouAction {

    @Inject
    private KhMkhgkHenkouBizLogic bizLogic;

    @Inject
    private KhMkhgkHenkouUiBean uiBean;

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
        String forward = bizLogic.functionNameOnClickBL();
        return forward;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushTojiruBL();
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
        String forward = bizLogic.pushSyoukainomiBL();
        return forward;
    }

    public String sainyuuryokubtnOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, inputContentsBean);

        bizLogic.pushSainyuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String skssakuseibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, referenceBean);

        bizLogic.pushsSeikyuusyoSakusei();

        return FORWARDNAME_SKSCONFIRM;
    }

    @Begin
    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {
        String forward = bizLogic.pushModoruInputContentsBL();

        return forward;
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

        bizLogic.pushModoruBtnByConfirmBL();

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteibtnbyconfirmOnClick() {
        try {
            bizLogic.pushKakuteiBL();
            return FORWARDNAME_RESULT;
        }
        catch(BizLogicException e) {
            bizLogic.unlockProcessBL();
            throw e;
        }
    }

    @End(nested = true)
    public String syokigamenhebtnbyresultOnClick() {
        String forward = bizLogic.pushSyokigamenkkBL();
        return forward;
    }

    public String modorubtnbysksconfirmOnClick() {
        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

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
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch(BizLogicException e) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(e);
            bizLogic.unlockProcessBL();
            return FORWARDNAME_BACKTOWORKLIST;
        }
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
