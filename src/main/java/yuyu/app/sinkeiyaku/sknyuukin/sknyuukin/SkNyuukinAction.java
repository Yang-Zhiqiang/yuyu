package yuyu.app.sinkeiyaku.sknyuukin.sknyuukin;

import static yuyu.app.sinkeiyaku.sknyuukin.sknyuukin.GenSkNyuukinConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 入金入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sknyuukin/sknyuukin/SkNyuukin.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sknyuukin/sknyuukin/sk_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sknyuukin/sknyuukin/sk_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sknyuukin/sknyuukin/sk_nyuukin.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sknyuukin/sknyuukin/sk_nyuukin.jsp"),
})
@Input("/sinkeiyaku/sknyuukin/sknyuukin/sk_nyuukin.jsp")
@UIBean(beanClass=SkNyuukinUiBean.class)
public class SkNyuukinAction {

    @Inject
    private SkNyuukinBizLogic bizLogic;

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
        bizLogic.checkRelationInputKey();
        bizLogic.pushTourokuBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    @Begin(nested=true)
    public String kakuninBtnOnClick() {
        bizLogic.pushKakuninBL();
        return FORWARDNAME_CONFIRM;
    }

    @End(nested=true)
    public String modoruBtnByConfirmOnClick() {
        bizLogic.pushModoruByConfirmBL();
        bizLogic.unlockProcess();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.continueLockProcess();
        bizLogic.pushKakuteiBL();
        bizLogic.unlockProcess();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End(nested=true)
    public String naiyounyuuryokugamenheBtnOnClick() {
        bizLogic.pushNaiyouNyuuryokuBL();
        return FORWARDNAME_INPUTCONTENTS;
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
