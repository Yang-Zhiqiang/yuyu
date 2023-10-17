package yuyu.app.base.system.holidaytouroku;

import static yuyu.app.base.system.holidaytouroku.GenHolidayTourokuConstants.*;

import javax.inject.Inject;

import jp.co.slcs.swak.web.auth.permission.Roles;
import jp.co.slcs.swak.web.config.annotations.Forward;
import jp.co.slcs.swak.web.config.annotations.Forwards;
import jp.co.slcs.swak.web.config.annotations.Input;
import jp.co.slcs.swak.web.config.annotations.UIBean;
import jp.co.slcs.swak.web.conversation.annotations.Begin;
import jp.co.slcs.swak.web.conversation.annotations.End;
import yuyu.common.base.ConversationStatus;
import yuyu.common.base.UnknownForwardException;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * 休日登録 機能のアクションクラスです。
 */
@Forwards
({
    @Forward(name=FORWARDNAME_INIT,          page=PAGENO_INIT,          path="/base/system/holidaytouroku/HolidayTouroku.do", redirect=true),
    @Forward(name=FORWARDNAME_CURRENT,                                  path="/base/system/holidaytouroku/holiday_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTDATA,    page=PAGENO_SELECTDATA,    path="/base/system/holidaytouroku/holiday_touroku.jsp"),
    @Forward(name=FORWARDNAME_SELECTKEY,     page=PAGENO_SELECTKEY,     path="/base/system/holidaytouroku/holiday_touroku.jsp"),
    @Forward(name=FORWARDNAME_INPUTCONTENTS, page=PAGENO_INPUTCONTENTS, path="/base/system/holidaytouroku/holiday_touroku.jsp"),
    @Forward(name=FORWARDNAME_CONFIRM,       page=PAGENO_CONFIRM,       path="/base/system/holidaytouroku/holiday_touroku.jsp"),
    @Forward(name=FORWARDNAME_RESULT,        page=PAGENO_RESULT,        path="/base/system/holidaytouroku/holiday_touroku.jsp"),
})
@Input("/base/system/holidaytouroku/holiday_touroku.jsp")
@UIBean(beanClass=HolidayTourokuUiBean.class)
@Roles("holidaytouroku")
public class HolidayTourokuAction {

    @Inject
    private HolidayTourokuBizLogic bizLogic;

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

    public String holidayGroupCdOnClick() {
        bizLogic.chkReferenceMaster();
        bizLogic.getHolidayInfo();
        return FORWARDNAME_SELECTKEY;
    }

    public String tourokuBtnOnClick() {
        status.setSyoriKbn(E_SyoriKbn.NEW);
        bizLogic.chkHolidayPatternNm();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String henkouLinkOnClick() {

        status.setSyoriKbn(E_SyoriKbn.EDIT);
        bizLogic.getEditInfo();
        return FORWARDNAME_INPUTCONTENTS;
    }

    public String sakujyoLinkOnClick() {

        status.setSyoriKbn(E_SyoriKbn.DELETE);
        bizLogic.getEditInfo();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnBySelectKeyOnClick() {
        bizLogic.clear();
        return FORWARDNAME_SELECTDATA;
    }

    public String modoruBtnByInputContentsOnClick() {
        bizLogic.backFromSelectData();
        return FORWARDNAME_SELECTKEY;
    }

    public String kakuninBtnOnClick() {
        bizLogic.chkExistHolidayGroupInfo();
        bizLogic.chkHolidayInfo();
        return FORWARDNAME_CONFIRM;
    }

    public String modoruBtnByConfirmOnClick() {
        bizLogic.backFromConfirm();
        return getConfirmBackwardName();
    }

    @End
    public String kakuteiBtnOnClick() {
        bizLogic.chkExistHolidayGroupInfo();
        bizLogic.updHolidayInfoYoyaku();
        return FORWARDNAME_RESULT;
    }

    public String syokigamenheBtnOnClick() {
        return FORWARDNAME_INIT;
    }

    public String holidayPatternInfoPagerOnClick() {
        return FORWARDNAME_CURRENT;
    }

    private String getConfirmBackwardName(){
        if (E_SyoriKbn.NEW.equals(status.getSyoriKbn())) {

            return FORWARDNAME_INPUTCONTENTS;
        }
        else if (E_SyoriKbn.EDIT.equals(status.getSyoriKbn())) {

            return FORWARDNAME_INPUTCONTENTS;
        }
        else if (E_SyoriKbn.DELETE.equals(status.getSyoriKbn())) {

            return FORWARDNAME_SELECTKEY;
        } else {
            throw new UnknownForwardException();
        }
    }
}
