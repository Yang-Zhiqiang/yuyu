package yuyu.app.workflow.processkanri.kouteitorikesi;

import static yuyu.app.workflow.processkanri.kouteitorikesi.GenKouteiTorikesiConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 工程取消 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/workflow/processkanri/kouteitorikesi/KouteiTorikesi.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/workflow/processkanri/kouteitorikesi/koutei_torikesi.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/workflow/processkanri/kouteitorikesi/koutei_torikesi.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/workflow/processkanri/kouteitorikesi/koutei_torikesi.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/workflow/processkanri/kouteitorikesi/koutei_torikesi.jsp"),
})
@Input("/workflow/processkanri/kouteitorikesi/koutei_torikesi.jsp")
@UIBean(beanClass=KouteiTorikesiUiBean.class)
@Roles("kouteitorikesi")
public class KouteiTorikesiAction {

    @Inject
    private KouteiTorikesiBizLogic bizLogic;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String searchBtnOnClick() {

        bizLogic.searchBtnOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String nyuuryokuLinkOnClick() {

        bizLogic.nyuuryokuLinkOnClick();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByInputContentsOnClick() {

        bizLogic.modoruBtnOnClick();
        return FORWARDNAME_SELECTDATA;
    }

    public String kakuninBtnOnClick() {
        bizLogic.kakuninBtnOnClick();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuteiBtnOnClick() {

        bizLogic.kakuteiBtnOnClick();
        return FORWARDNAME_RESULT;
    }

    @End
    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
