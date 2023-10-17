package yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo;

import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.GenSkMousikomisyoConstants.*;
import static yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.*;

import java.io.IOException;

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
import yuyu.def.classification.C_KidougmKbn;

/**
 * 申込書入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,                      page=PAGENO_INIT,          path="/sinkeiyaku/skmousikomi/skmousikomisyo/SkMousikomisyo.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,                  page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skmousikomi/skmousikomisyo/sk_mousikomisyo.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,             page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skmousikomi/skmousikomisyo/sk_mousikomisyo.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,                   page=PAGENO_CONFIRM,       path="/sinkeiyaku/skmousikomi/skmousikomisyo/sk_mousikomisyo.jsp"),
    @Forward(name=FORWARDNAME_RESULT,                    page=PAGENO_RESULT,        path="/sinkeiyaku/skmousikomi/skmousikomisyo/sk_mousikomisyo.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                                       path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkMousikomisyo", redirect=true),
    @Forward(name=FORWARDNAME_NESTEDEND,                                            path="/sinkeiyaku/skmousikomi/skmousikomisyo/SkMousikomisyo.do?_eventHandler=nestedEnd", redirect=true),
})
@Input("/sinkeiyaku/skmousikomi/skmousikomisyo/sk_mousikomisyo.jsp")
@UIBean(beanClass=SkMousikomisyoUiBean.class)
public class SkMousikomisyoAction {

    @Inject
    private SkMousikomisyoBizLogic bizLogic;

    @Inject
    private SkMousikomisyoUiBean uiBean;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromSinkeiyakuWorkList() {
        try {
            bizLogic.iwfOpenBL();
        } catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.doUnlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.removeObj();

        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            bizLogic.doUnlockProcess();
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

    public String haneibtnOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        bizLogic.removeObj();

        if (PAGENO_INPUTCONTENTS == uiBean.getPageNo() || PAGENO_CONFIRM == uiBean.getPageNo()) {
            bizLogic.doUnlockProcess();
        }

        if (PAGENO_CONFIRM == uiBean.getPageNo() || PAGENO_RESULT == uiBean.getPageNo()) {
            return FORWARDNAME_NESTEDEND;
        }

        return getBackToForwardName();
    }

    public String sinkiitijibtnOnClick() {
        try {
            bizLogic.pushAddFstBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.doUnlockProcess();
            throw bizLogicException;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String sinkinijibtnOnClick() {
        try {
            bizLogic.pushAddSecBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.doUnlockProcess();
            throw bizLogicException;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String sinkisanjibtnOnClick() {
        try {
            bizLogic.pushAddThirdBL();
        } catch (BizLogicException bizLogicException) {
            bizLogic.doUnlockProcess();
            throw bizLogicException;
        }

        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkouteiseibtnOnClick() {
        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkoutsskbtnbyinputkeyOnClick() {
        bizLogic.pushUpdSyoukaiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String nyuuryokutsbtnbyinputkeyOnClick() {
        bizLogic.pushInputUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.removeObj();
        bizLogic.doUnlockProcess();

        return getBackToForwardName();
    }

    @Begin(nested=true)
    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(nested=true)
    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruBtnByConfirmBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.removeObj();
        bizLogic.pushKakuteiBL();
        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {
        bizLogic.removeObj();

        return FORWARDNAME_NESTEDEND;
    }

    @End(nested=true)
    public String henkoutsskbtnbyresultOnClick() {
        bizLogic.pushUpdSyoukaiBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String nyuuryokuteiseibtnbyresultOnClick() {
        if (!uiBean.isTaihyoumousikomiUmu() && uiBean.isAiteimousikomiUmu()) {
            uiBean.setMosno(uiBean.getAitemosno());
        }

        uiBean.setHubimsgData2(new String[0]);

        bizLogic.pushInputUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String nestedEnd() {
        return getBackToForwardName();
    }

    public void callAjaxCommon() throws IOException {
        bizLogic.callAjaxCommonBL();
    }

    private String getBackToForwardName() {
        if (C_KidougmKbn.WORKLIST.eq(uiBean.getBzWorkflowInfo().getKidougmKbn())) {
            return FORWARDNAME_BACKTOWORKLIST;
        }

        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.doUnlockProcess();
    }
}