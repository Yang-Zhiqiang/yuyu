package yuyu.app.base.system.kadoutimegrouptouroku;

import static yuyu.app.base.system.kadoutimegrouptouroku.GenKadouTimeGroupTourokuConstants.*;

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
import yuyu.def.enumeration.E_HenkanKbn;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * 稼働時間グループ登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/kadoutimegrouptouroku/KadouTimeGroupTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_INPUTKEY,      page=PAGENO_INPUTKEY,      path="/base/system/kadoutimegrouptouroku/kadou_time_group_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/kadoutimegrouptouroku/kadou_time_group_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/kadoutimegrouptouroku/kadou_time_group_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/kadoutimegrouptouroku/kadou_time_group_touroku.jsp"),
})
@Input("/base/system/kadoutimegrouptouroku/kadou_time_group_touroku.jsp")
@UIBean(beanClass=KadouTimeGroupTourokuUiBean.class)
@Roles("kadoutimegrouptouroku")
public class KadouTimeGroupTourokuAction {

    @Inject
    private KadouTimeGroupTourokuBizLogic bizLogic;

    @Inject
    private ConversationStatus status;

    @Begin
    public String init() {
        bizLogic.init();
        return FORWARDNAME_INPUTKEY;
    }

    @End
    public String tojiruBtnOnClick() {
        return null;
    }

    @Begin(nested=true)
    public String tourokuBtnOnClick() {
        status.setSyoriKbn(E_SyoriKbn.NEW);
        bizLogic.setKadouTimeGroup();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkouLinkOnClick() {
        bizLogic.chkKadouTimeGroupExistence();
        status.setSyoriKbn(E_SyoriKbn.EDIT);
        bizLogic.setKadouTimeGroup();
        return FORWARDNAME_INPUTCONTENTS;
    }

    @Begin(join=true, mode=Mode.DELETE)
    public String sakujyoLinkOnClick() {
        bizLogic.chkKadouTimeGroupCdExistence();
        bizLogic.chkKadouTimeGroupExistence();
        status.setSyoriKbn(E_SyoriKbn.DELETE);
        bizLogic.setKadouTimeGroup();
        return FORWARDNAME_CONFIRM;
    }

    @End(nested=true)
    public String modoruBtnByInputContentsOnClick() {
        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {
            bizLogic.clear();
            return FORWARDNAME_INPUTKEY;
        }
        return FORWARDNAME_INIT;
    }

    @End(mode=Mode.DELETE)
    public String modoruBtnByConfirmOnClick() {
        bizLogic.convertHolidayGroupInfo(E_HenkanKbn.NYUURYOKU);
        return getConfirmBackwardName();

    }

    public String kakuninBtnOnClick() {
        bizLogic.chkReferenceMaster();
        bizLogic.setMessageConvertHolidayGroupInfo();
        return FORWARDNAME_CONFIRM;
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.chkReferenceMaster();

        if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {
            bizLogic.chkKadouTimeGroupCdExistence();

        }

        bizLogic.commitKadouTimeGroup();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    private String getConfirmBackwardName(){

        switch (status.getSyoriKbn()) {
            case NEW   : return FORWARDNAME_INPUTCONTENTS;
            case EDIT  : return FORWARDNAME_INPUTCONTENTS;
            case DELETE: return FORWARDNAME_INIT;
            default    : throw new UnknownForwardException();
        }
    }
}
