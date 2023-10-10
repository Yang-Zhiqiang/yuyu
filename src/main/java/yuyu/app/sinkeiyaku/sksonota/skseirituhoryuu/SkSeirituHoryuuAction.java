package yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu;

import static yuyu.app.sinkeiyaku.sksonota.skseirituhoryuu.GenSkSeirituHoryuuConstants.*;

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
 * 成立保留処理 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/sinkeiyaku/sksonota/skseirituhoryuu/SkSeirituHoryuu.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/sinkeiyaku/sksonota/skseirituhoryuu/sk_seiritu_horyuu.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/sinkeiyaku/sksonota/skseirituhoryuu/sk_seiritu_horyuu.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/sinkeiyaku/sksonota/skseirituhoryuu/sk_seiritu_horyuu.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/sinkeiyaku/sksonota/skseirituhoryuu/sk_seiritu_horyuu.jsp"),
})
@Input("/sinkeiyaku/sksonota/skseirituhoryuu/sk_seiritu_horyuu.jsp")
@UIBean(beanClass=SkSeirituHoryuuUiBean.class)
@Roles("skseirituhoryuu")
public class SkSeirituHoryuuAction {

    @Inject
    private SkSeirituHoryuuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {

        bizLogic.pushUnlockProcessBL();

        return null;
    }

    @Begin
    public String tourokuBtnOnClick() {
        bizLogic.pushUpdBL();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String modoruBtnByInputContentsOnClick() {

        bizLogic.pushUnlockProcessBL();

        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {

        bizLogic.continueLockProcessBL();
        bizLogic.pushKakuninBL();

        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {

        bizLogic.continueLockProcessBL();
        bizLogic.setGmwarningId();

        return FORWARDNAME_INPUTCONTENTS;
    }

    @MultiPostConstraints
    public String kakuteiBtnOnClick() {

        bizLogic.continueLockProcessBL();
        bizLogic.pushKakuteiBL();
        bizLogic.pushUnlockProcessBL();

        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @End
    public String functionNameOnClick() {

        bizLogic.pushUnlockProcessBL();

        return FORWARDNAME_INIT;
    }

    @BizAppExceptionTerminate
    private void bizAppExceptionTerminate(Throwable e) {

        bizLogic.pushUnlockProcessBL();
    }
}
