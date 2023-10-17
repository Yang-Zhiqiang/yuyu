package yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku;

import static yuyu.app.workflow.processkanri.jimuyoucodenyuuryoku.GenJimuyouCodeNyuuryokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.annotation.BizAppTerminate;
import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 事務用コード入力 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/workflow/processkanri/jimuyoucodenyuuryoku/JimuyouCodeNyuuryoku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/workflow/processkanri/jimuyoucodenyuuryoku/jimuyou_code_nyuuryoku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/workflow/processkanri/jimuyoucodenyuuryoku/jimuyou_code_nyuuryoku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/workflow/processkanri/jimuyoucodenyuuryoku/jimuyou_code_nyuuryoku.jsp"),
})
@Input("/workflow/processkanri/jimuyoucodenyuuryoku/jimuyou_code_nyuuryoku.jsp")
@UIBean(beanClass=JimuyouCodeNyuuryokuUiBean.class)
@Roles("jimuyoucodenyuuryoku")
public class JimuyouCodeNyuuryokuAction {

    @Inject
    private JimuyouCodeNyuuryokuBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String ketteiBtnOnClick() {

        bizLogic.jimuyoucdNyuuryokuListCreate();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuninBtnOnClick() {

        bizLogic.getJimuyoucdNyuuryokuList();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuteiBtnOnClick() {

        bizLogic.jinuyoucdTouroku();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    @BizAppTerminate
    private void BizAppTerminate() {
        bizLogic.pushUnlockProcessBL();
    }

}
