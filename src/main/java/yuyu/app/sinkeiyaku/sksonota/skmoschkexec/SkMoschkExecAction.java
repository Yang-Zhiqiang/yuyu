package yuyu.app.sinkeiyaku.sksonota.skmoschkexec;

import static yuyu.app.sinkeiyaku.sksonota.skmoschkexec.GenSkMoschkExecConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppExceptionTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import jp.co.slcs.swak.web.conversation.annotations.MultiPostConstraints;

/**
 * 申込内容チェック実行 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,     page=PAGENO_INIT,     path="/sinkeiyaku/sksonota/skmoschkexec/SkMoschkExec.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY, page=PAGENO_INPUTKEY, path="/sinkeiyaku/sksonota/skmoschkexec/sk_moschk_exec.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,  page=PAGENO_CONFIRM,  path="/sinkeiyaku/sksonota/skmoschkexec/sk_moschk_exec.jsp"),
    @Forward(name=FORWARDNAME_RESULT,   page=PAGENO_RESULT,   path="/sinkeiyaku/sksonota/skmoschkexec/sk_moschk_exec.jsp"),
})
@Input("/sinkeiyaku/sksonota/skmoschkexec/sk_moschk_exec.jsp")
@UIBean(beanClass=SkMoschkExecUiBean.class)
@Roles("skmoschkexec")
public class SkMoschkExecAction {

    @Inject
    private SkMoschkExecBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        bizLogic.pushToziru();
        return null;
    }

    @Begin
    public String kakuninBtnOnClick() {
        bizLogic.pushKakunin();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String modorubtnOnClick() {
        bizLogic.pushModoru();
        return FORWARDNAME_INIT;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {
        bizLogic.pushKakutei();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {
        bizLogic.onClickFunctionName();
        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {
        bizLogic.appExceptionTerminate();
    }
}