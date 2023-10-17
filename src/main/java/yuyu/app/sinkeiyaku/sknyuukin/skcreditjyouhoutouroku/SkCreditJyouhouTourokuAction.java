package yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku;

import static yuyu.app.sinkeiyaku.sknyuukin.skcreditjyouhoutouroku.GenSkCreditJyouhouTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * クレジットカード情報登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/SkCreditJyouhouTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/sk_credit_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/sk_credit_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/sk_credit_jyouhou_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/sk_credit_jyouhou_touroku.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/skcreditjyouhoutouroku/sk_credit_jyouhou_touroku.jsp")
@UIBean(beanClass=SkCreditJyouhouTourokuUiBean.class)
public class SkCreditJyouhouTourokuAction {

    @Inject
    private SkCreditJyouhouTourokuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.unlockProcess();
        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {
        String forwardName = bizLogic.pushTourokuBL();
        return forwardName;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        bizLogic.unlockProcess();
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruinputbtnbyconfirmOnClick() {
        bizLogic.pushModoruInputBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modorukeybtnbyconfirmOnClick() {
        bizLogic.pushModoruKeyBL();
        return FORWARDNAME_INIT;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushKakuteiBL();
        bizLogic.unlockProcess();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        bizLogic.unlockProcess();
        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.unlockProcess();
    }
}
