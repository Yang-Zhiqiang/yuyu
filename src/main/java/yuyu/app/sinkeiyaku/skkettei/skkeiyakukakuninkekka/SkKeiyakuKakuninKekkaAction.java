package yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka;

import static yuyu.app.sinkeiyaku.skkettei.skkeiyakukakuninkekka.GenSkKeiyakuKakuninKekkaConstants.*;

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

/**
 * 契約確認結果入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/SkKeiyakuKakuninKekka.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/sk_keiyaku_kakunin_kekka.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/sk_keiyaku_kakunin_kekka.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/sk_keiyaku_kakunin_kekka.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/skkettei/skkeiyakukakuninkekka/sk_keiyaku_kakunin_kekka.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkKeiyakuKakuninKekka", redirect=true),
})
@Input("/sinkeiyaku/skkettei/skkeiyakukakuninkekka/sk_keiyaku_kakunin_kekka.jsp")
@UIBean(beanClass=SkKeiyakuKakuninKekkaUiBean.class)
public class SkKeiyakuKakuninKekkaAction {

    @Inject
    private SkKeiyakuKakuninKekkaBizLogic bizLogic;

    @Inject
    private SkKeiyakuKakuninKekkaUiBean uiBean;

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
        bizLogic.doUnlockProcess();

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
    public String tourokuBtnOnClick() {
        try {
            bizLogic.pushTourokuBL();

        } catch (BizLogicException bizLogicException) {

            bizLogic.doUnlockProcess();

            throw bizLogicException;
        }


        return FORWARDNAME_INPUTCONTENTS;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.doUnlockProcess();
        String forwardName = bizLogic.pushModoruBtnByInputcontentsBL();

        return forwardName;
    }

    public String kakuninBtnOnClick() {
        bizLogic.doContinueLockProcess();
        bizLogic.pushKakuNinBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.doContinueLockProcess();
        bizLogic.pushModoruBtnByConfirmBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.doContinueLockProcess();

        bizLogic.pushKakuTeiBL();

        bizLogic.doUnlockProcess();

        return FORWARDNAME_RESULT;
    }

    @End(nested=true)
    public String syokigamenheBtnOnClick() {

        String forwardName = bizLogic.syokigamenhebtnbyOnClickBL();

        return forwardName;
    }

    @End(nested=true)
    public String functionNameOnClick() {
        bizLogic.doUnlockProcess();

        String forward = bizLogic.functionNameOnClickBL();

        return forward;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.doUnlockProcess();
    }
}
