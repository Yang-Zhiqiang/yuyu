package yuyu.app.workflow.accountkanri.syoruikengentouroku;

import static yuyu.app.workflow.accountkanri.syoruikengentouroku.GenSyoruiKengenTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;

/**
 * 書類権限登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/workflow/accountkanri/syoruikengentouroku/SyoruiKengenTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/workflow/accountkanri/syoruikengentouroku/syorui_kengen_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/workflow/accountkanri/syoruikengentouroku/syorui_kengen_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/workflow/accountkanri/syoruikengentouroku/syorui_kengen_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/workflow/accountkanri/syoruikengentouroku/syorui_kengen_touroku.jsp"),
})
@Input("/workflow/accountkanri/syoruikengentouroku/syorui_kengen_touroku.jsp")
@UIBean(beanClass=SyoruiKengenTourokuUiBean.class)
@Roles("syoruikengentouroku")
public class SyoruiKengenTourokuAction {

    @Inject
    private SyoruiKengenTourokuBizLogic bizLogic;

    public String init() {

        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    public String tojiruBtnOnClick() {
        return null;
    }

    public String ketteiBtnOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_INIT;
    }

    public String kakuninBtnOnClick() {
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuteiBtnOnClick() {
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
