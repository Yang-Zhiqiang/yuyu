package yuyu.app.sinkeiyaku.skkettei.skkankyousatei;

import static yuyu.app.sinkeiyaku.skkettei.skkankyousatei.SkKankyouSateiConstants.*;

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

/**
 * 環境査定 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,           page=PAGENO_INIT,          path="/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do", redirect=true),
    @Forward(name=FORWARDNAME_INIT_MOSTORIKESI,     page=PAGENO_INIT_MOSTORIKESI,    path="/sinkeiyaku/skkettei/skkankyousatei/SkKankyouSatei.do?_eventHandler=initMousikomitorikesi", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,       page=PAGENO_INPUTKEY,      path="/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS,  page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,        page=PAGENO_CONFIRM,       path="/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp"),
    @Forward(name=FORWARDNAME_RESULT,         page=PAGENO_RESULT,        path="/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp"),
    @Forward(name=FORWARDNAME_BACKTOWORKLIST,                            path="/workflow/processkanri/sinkeiyakuworklist/SinkeiyakuWorkList.do?_eventHandler=fromSkKankyouSatei", redirect=true),
    @Forward(name=FORWARDNAME_TASYAKANYUUJOUKYOU, page=PAGENO_TASYAKANYUUJOUKYOU, path="/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp"),
})
@Input("/sinkeiyaku/skkettei/skkankyousatei/sk_kankyou_satei.jsp")
@UIBean(beanClass=SkKankyouSateiUiBean.class)
public class SkKankyouSateiAction {

    @Inject
    private SkKankyouSateiBizLogic bizLogic;

    @Inject
    private SkKankyouSateiUiBean uiBean;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @Begin
    public String initMousikomitorikesi() {
        bizLogic.initMousikomitorikesi();
        return FORWARDNAME_INPUTKEY;
    }

    public String fromSinkeiyakuWorkList() {

        try {
            bizLogic.iwfOpenBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.unlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    public String fromSinkeiyakuWorkListMousikomitorikesi() {

        try {
            bizLogic.iwfOpenMosTorikesiBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bizLogicException) {
            uiBean.getBzWorkflowInfo().setExceptionToRenkeiInfo(bizLogicException);
            bizLogic.unlockProcess();

            return FORWARDNAME_BACKTOWORKLIST;
        }
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.removeObj();
        bizLogic.unlockProcess();

        return null;
    }

    public String tojirubtnbytsyknyjkOnClick() {
        bizLogic.pushTojirubtnbytsyknyjkBL();
        return null;
    }

    public String lincjkbtnOnClick() {
        bizLogic.pushLincjkbtnBL();
        return FORWARDNAME_TASYAKANYUUJOUKYOU;
    }

    @End(nested=true)
    public String functionNameOnClick() {

        bizLogic.removeObj();

        String forwardName = bizLogic.functionNameOnClickBL();

        return forwardName;
    }

    public String sateibtnOnClick() {

        try {
            bizLogic.pushSateiBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcess();
            throw bizLogicException;
        }
    }

    public String kakuninbtnbyjyoubuOnClick() {
        try {
            bizLogic.pushSateiBL();
            return FORWARDNAME_INPUTCONTENTS;
        }
        catch (BizLogicException bizLogicException) {
            bizLogic.unlockProcess();
            throw bizLogicException;
        }
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {

        String forwardName = bizLogic.modoruBtnByInputcontentsBL();

        return forwardName;
    }

    public String kakuninBtnOnClick() {

        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.pushmodoruBtnByConfirmBL();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.pushKakuteiBL();

        return FORWARDNAME_RESULT;
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
    public String syokigamenheBtnOnClick() {

        bizLogic.removeObj();

        String forwardName = bizLogic.syokiGamenhebtnOnClickBL();

        return forwardName;
    }

    public String haneibtnOnClick() {
        bizLogic.pushHaneibtnBL();
        return FORWARDNAME_TASYAKANYUUJOUKYOU;
    }

    public String tojiruBtnByPopupOnClick() {
        bizLogic.pushTojiruBtnByPopupBL();
        return null;
    }

    public void print(){
        bizLogic.printOut();
    }

    public String callAjaxKetteiRiyuuNaiyou() throws IOException {
        bizLogic.callAjaxKetteiRiyuuNaiyou();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.unlockProcess();
    }
}
