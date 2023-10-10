package yuyu.app.base.system.tokuteibikadoutimetouroku;

import static yuyu.app.base.system.tokuteibikadoutimetouroku.GenTokuteibiKadouTimeTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.Begin.Mode;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * 特定日稼働時間登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/tokuteibikadoutimetouroku/TokuteibiKadouTimeTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                  path="/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp"),
})
@Input("/base/system/tokuteibikadoutimetouroku/tokuteibi_kadou_time_touroku.jsp")
@UIBean(beanClass=TokuteibiKadouTimeTourokuUiBean.class)
@Roles("tokuteibikadoutimetouroku")
public class TokuteibiKadouTimeTourokuAction {

    @Inject
    private TokuteibiKadouTimeTourokuBizLogic bizLogic;

    @Inject
    private ConversationStatus status;

    @Begin
    public String init() {

        bizLogic.init();
        return FORWARDNAME_SELECTDATA;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin(nested=true)
    public String tourokuBtnOnClick() {
        status.setSyoriKbn(E_SyoriKbn.NEW);
        bizLogic.chkReferenceKadouTimeGroup();
        bizLogic.setupUiBean();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkouLinkOnClick() {
        status.setSyoriKbn(E_SyoriKbn.EDIT);
        bizLogic.chkReferenceKadouTimeGroup();
        bizLogic.chkTokuteibiKadouTimeExistence();
        bizLogic.setupUiBean();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(join=true, mode=Mode.DELETE)
    public String sakujyoLinkOnClick() {
        status.setSyoriKbn(E_SyoriKbn.DELETE);
        bizLogic.chkReferenceKadouTimeGroup();
        bizLogic.chkTokuteibiKadouTimeExistence();
        bizLogic.setupUiBean();
        return FORWARDNAME_CONFIRM;
    }


    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {
            bizLogic.clear();
            bizLogic.setUiBean();
            bizLogic.clearInputData();
            return FORWARDNAME_SELECTDATA;
        }
        return FORWARDNAME_INIT;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {
        return getConfirmBackwardName();
    }

    public String kakuninBtnOnClick() {

        bizLogic.relationChk();
        bizLogic.setKadouTimeMoji();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String kakuteiBtnOnClick() {

        bizLogic.dataKousin();
        bizLogic.setKadouTimeMoji();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String tokuteibiKadouTimeSelectListPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }


    private String getConfirmBackwardName(){

        switch (status.getSyoriKbn()) {
            case NEW :
            case EDIT: bizLogic.resetKadouTime(); return FORWARDNAME_INPUTCONTENTS;
            case DELETE: bizLogic.resetInitUiBean();
            return FORWARDNAME_INIT;
            default    : throw new UnknownForwardException();
        }
    }
}
