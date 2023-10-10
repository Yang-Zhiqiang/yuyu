package yuyu.app.hozen.khozen.khkeiyakutorikesi;

import static yuyu.app.hozen.khozen.khkeiyakutorikesi.GenKhKeiyakuTorikesiConstants.*;

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
 * 契約取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/hozen/khozen/khkeiyakutorikesi/KhKeiyakuTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp"),
    @Forward(name=FORWARDNAME_REFERENCE,      page=PAGENO_REFERENCE,     path="/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/hozenworklist/HozenWorkList.do?_eventHandler=fromKhKeiyakuTorikesi", redirect=true),
})
@Input("/hozen/khozen/khkeiyakutorikesi/kh_keiyaku_torikesi.jsp")
@UIBean(beanClass = KhKeiyakuTorikesiUiBean.class)
public class KhKeiyakuTorikesiAction {

    @Inject
    private KhKeiyakuTorikesiBizLogic bizLogic;

    @Inject
    private KhKeiyakuTorikesiUiBean uiBean;

    @Inject
    private InputContentsCopyBean contentsCopyBean;

    @Inject
    private ReferenceCopyBean referenceBean;

    @Inject
    private KinouMode kinouMode;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End(nested = true)
    public String functionNameOnClick() {

        String path = bizLogic.pushFunctionNameBL();

        return path;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushTojiruBL();
        return null;
    }

    public String hyoujilinkOnClick() {

        bizLogic.pushPrintHyoujiOutBL();
        return null;
    }

    public String allhyoujibtnOnClick() {
        bizLogic.pushPrintAllHyoujiOutBL();
        return null;
    }

    @End(nested = true)
    public String syoukainomibtnOnClick() {

        String path = bizLogic.pushSyoukainomiBL();

        return path;
    }

    public String sainyuuryokubtnOnClick() {

        BizUiBeanBackupUtil.restore(uiBean,contentsCopyBean);

        bizLogic.pushSainyuuryokuBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin
    public String nyuuryokubtnOnClick() {
        bizLogic.pushNyuuryokubtnBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested = true)
    public String modoruBtnByInputContentsOnClick() {

        String path = bizLogic.pushModoruBtnByInputContentsBL();

        return path;
    }

    public String syoukaibtnOnClick() {
        BizUiBeanBackupUtil.backup(uiBean, contentsCopyBean);
        bizLogic.pushSyoukaiBL();
        return FORWARDNAME_REFERENCE;
    }

    public String kakuninBtnOnClick() {

        BizUiBeanBackupUtil.backup(uiBean,referenceBean);

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        BizUiBeanBackupUtil.restore(uiBean, referenceBean);

        bizLogic.pushModoruBtnByConfirmBL();

        return FORWARDNAME_REFERENCE;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        try {
            bizLogic.pushKakuteiBL();
        } catch (BizLogicException bizLogicException) {
            if (C_KhkinouModeIdKbn.INPUTKEY.getValue().equals(kinouMode.getKinouMode())) {
                bizLogic.pushUnlockProcessBL();
            }

            throw bizLogicException;
        }

        return FORWARDNAME_RESULT;
    }

    @End(nested = true)
    public String syokigamenheBtnOnClick() {
        String path = bizLogic.pushSyokigamenhebtnbyresultBL();
        return path;
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
        bizLogic.pushPrintOutBL();
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.pushUnlockProcessBL();
    }
}
