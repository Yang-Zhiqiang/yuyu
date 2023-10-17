package yuyu.app.base.system.kadoutimetouroku;

import static yuyu.app.base.system.kadoutimetouroku.GenKadouTimeTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;

/**
 * 稼働時間登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/kadoutimetouroku/KadouTimeTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/base/system/kadoutimetouroku/kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTKEY,     page=PAGENO_SELECTKEY,     path="/base/system/kadoutimetouroku/kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/kadoutimetouroku/kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/kadoutimetouroku/kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/kadoutimetouroku/kadou_time_touroku.jsp"),
})
@Input("/base/system/kadoutimetouroku/kadou_time_touroku.jsp")
@UIBean(beanClass=KadouTimeTourokuUiBean.class)
@Roles("kadoutimetouroku")
public class KadouTimeTourokuAction {

    @Inject
    private KadouTimeTourokuBizLogic bizLogic;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    public String kadouTimeGroupCdOnClick() {
        bizLogic.chkReferenceKadouTimeGroup();
        bizLogic.getKadouTimeList();
        return FORWARDNAME_SELECTKEY;
    }

    @Begin(nested=true)
    public String henkouEigyoubiLinkOnClick() {
        bizLogic.setupEigyoubiUiBean();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(nested=true)
    public String henkouHieigyoubiLinkOnClick() {
        bizLogic.setupHieigyoubiUiBean();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String modoruBtnBySelectKeyOnClick() {
        bizLogic.clear();
        return FORWARDNAME_SELECTDATA;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        return FORWARDNAME_SELECTKEY;
    }

    public String kakuninBtnOnClick() {
        bizLogic.relationChk();
        bizLogic.setKadouTimeDisp();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.resetKadouTimeNyuuryou();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.updKadouTime();
        bizLogic.setKadouTimeDisp();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }
}
