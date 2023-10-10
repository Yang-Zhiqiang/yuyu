package yuyu.app.base.system.kinouteigitouroku;

import static yuyu.app.base.system.kinouteigitouroku.GenKinouTeigiTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 機能定義登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/kinouteigitouroku/KinouTeigiTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/base/system/kinouteigitouroku/kinou_teigi_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/kinouteigitouroku/kinou_teigi_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/kinouteigitouroku/kinou_teigi_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/kinouteigitouroku/kinou_teigi_touroku.jsp"),
})
@Input("/base/system/kinouteigitouroku/kinou_teigi_touroku.jsp")
@UIBean(beanClass=KinouTeigiTourokuUiBean.class)
@Roles("kinouteigitouroku")
public class KinouTeigiTourokuAction {

    @Inject
    private KinouTeigiTourokuBizLogic bizLogic;

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
        bizLogic.filterKinouModelList();
        return FORWARDNAME_SELECTDATA;
    }

    public String henkouLinkOnClick() {
        bizLogic.setupUiBean();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnByInputContentsOnClick() {
        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.setRoleInfo();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String kakuninBtnOnClick() {
        bizLogic.chkReferenceMaster();
        bizLogic.chkRelation();
        bizLogic.setHaneiList();
        bizLogic.setConfirmMessage();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.chkReferenceMaster();
        bizLogic.commitKinou();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
